package tech.reliab.course.toropchinda.bank.service.impl;

import tech.reliab.course.toropchinda.bank.entity.*;
import tech.reliab.course.toropchinda.bank.exceptions.*;
import tech.reliab.course.toropchinda.bank.service.*;
import tech.reliab.course.toropchinda.bank.utils.Utils;
import java.math.BigDecimal;
import java.util.*;

public class UserServiceImpl implements UserService {

    Map<Integer, User> tableUsers = new HashMap<Integer, User>();

    @Override
    public Bank chooseBestBank(BankService bankService, BigDecimal sum) {
        List<Bank> banks = bankService.getAllBanks();
        Bank res = Collections.max(banks);
        return res;
    }

    @Override
    public Boolean takeCredit(UserService userService, BankService bankService,
                              BankOfficeService bankOfficeService,
                              PaymentAccountService paymentAccountService,
                              CreditAccountService creditAccountService,
                              Integer userId, BigDecimal sum) {
        System.out.print("Запущена функция выдачи кредита\n");
        if (userService == null || bankService == null || userId == null || sum == null)
            throw new NullPointerException("В функцию takeCredit передан null");
        System.out.print("Пройдена null проверка\n");
        if (sum.doubleValue() < 0) {
            throw new NegativeCreditSum("Передано отрицательное значение для кредита " + sum.toString()
            + " в то время как ожидалось положительное значение");
        }
        System.out.print("Пройдена value проверка\n");
        User user = userService.getUserByHisId(userId);
        Bank bank = userService.chooseBestBank(bankService, sum);
        BankOffice bankOffice;
        try {
            bankOffice = chooseSuitableOffice(bankService.getLstOffices(bank), sum);
        } catch (CantFindGoodOffice e) {
            System.out.print("Невозможно найти офис, который мог бы дать кредит требуемой суммы\n");
            return false;
        }
        Employee employee = chooseSuitableEmployee(bankOfficeService.getWorkers(bankOffice));
        System.out.print(String.format("Получены банк - %s, юзер, офис и работник\n", bank.getName()));
        userService.addBank(user, bank);
        System.out.print("Банк добавлен к пользователю\n");
        PaymentAccount paymentAccount;
        try {
            paymentAccount = findAccount(user, bank);
        } catch (CantFindAccount e) {
            paymentAccount = paymentAccountService.create(user, bank, user.getSalary());
            userService.addPaymentAccount(user, paymentAccount);
            System.out.print("Денежный счет добавлен пользователю в выбранном банке\n");
        }
        try {
            System.out.print("Проверка рейтинга\n");
            checkRating(user, bank);
            System.out.print("Проверка рейтинга пройдена\n");
        } catch (DenyCreadit e) {
            System.out.print("Проверка рейтинга не пройдена, отказ в выдаче кредита\n");
            return false;
        }
        BankAtm bankAtm = null;
        System.out.print("Старт поиска банкомата для выдачи кредита\n");
        try {
            bankAtm = findAtm(bankOffice.getLstBankAtm(), sum);
        } catch (NoMoneyInAtm e) {
            System.out.print("Поиска банкомата в выбранном офисе не дал результата, проверяем другие офисы\n");
            for (BankOffice el : bankService.getLstOffices(bank)) {
                try {
                    if (el != bankOffice) {
                        bankAtm = findAtm(bankOffice.getLstBankAtm(), sum);
                    }
                } catch (NoMoneyInAtm e2) {
                    System.out.print("Поиска банкомата в i-том офисе не дал результата, проверяем другие офисы\n");
                }
            }
        }
        if (bankAtm == null) {
            System.out.print("Банкомат с нужным количеством наличности не обнаружен\n");
            return false;
        }
        System.out.print("Был обнаружен банкомат с требуемой наличностью, осуществляем процедуру списания и выдачи кредита\n");
        bank.setMoney(BigDecimal.valueOf(bank.getMoney().doubleValue() - sum.doubleValue()));
        bankAtm.setMoney(BigDecimal.valueOf(bankAtm.getMoney().doubleValue() - sum.doubleValue()));
        CreditAccount credAcc = creditAccountService.create(user, bank.getName(), new Date(), Utils.shift(new Date()),
                    sum, BigDecimal.valueOf(sum.doubleValue()/10),
                    bank.getInterestRate(),
                    employee, paymentAccount);
        userService.addCreditAccount(user, credAcc);


        return true;
    }

    public BankAtm findAtm(List<BankAtm> collection, BigDecimal sum) {
        int i = 0;
        while(collection.get(i).getMoney().doubleValue() <= sum.doubleValue())
            i++;
        if (i == collection.size())
            throw new NoMoneyInAtm("В банкоматах офиса не обнаружена требуемая сумма");
        return collection.get(i);
    }

    public void checkRating(User user, Bank bank) {
        if (user.getRating().doubleValue() < BigDecimal.valueOf(5000).doubleValue() && bank.getInterestRate().doubleValue() > 50)
            throw new DenyCreadit("Нарушено условие выдачи кредита");
        return;
    }

    public PaymentAccount findAccount(User user, Bank bank) {
        List <PaymentAccount>collection = user.getPaymentAccounts();
        int i = 0;
        while (i < collection.size()) {
            if (collection.get(i).getBank() == bank) {
                break;
            }
            i++;
        }
        if (i == collection.size()) {
            throw new CantFindAccount("У данного клиента нет счета данного банка\n");
        }
        return collection.get(i);
    }

    public Boolean check(BankOffice bankOffice, BigDecimal sum) {
        if (bankOffice.getWork() &&
                bankOffice.getGiveCredit() &&
                bankOffice.getMoney().doubleValue() >= sum.doubleValue())
            return true;
        return false;
    }

    @Override
    public BankOffice chooseSuitableOffice(List<BankOffice> collection, BigDecimal sum) {
        int i = 0;
        while (i < collection.size()) {
            if (check(collection.get(i), sum))
                break;
            i++;
        }
        if (i == collection.size()) {
            throw new CantFindGoodOffice("Не найден офис удовлетворяющий условиям");
        }
        return collection.get(i);
    }

    public Employee chooseSuitableEmployee(List<Employee> collection) {
        int i = 0;
        while (i < collection.size()) {
            if (collection.get(i).getCreditPossibility())
                break;
        }
        if (i == collection.size()) {
            throw new CantFindGoodEmployee("Не найден работник удовлетворяющий условиям");
        }
        return collection.get(i);
    }

    @Override
    public User getUserByHisId(Integer id) {
        return tableUsers.get(id);
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<User>(tableUsers.values());
    }

    @Override
    public Boolean addBank(User user, Bank bank) {
        if (user != null && bank != null) {
            user.getBanks().add(bank);
            return true;
        }
        return false;
    }

    @Override
    public User create(String fullName, Date birthday, String work, BigDecimal salary, BigDecimal rating) {
        User newUser = new User(fullName, birthday, work, salary,
                rating);
        tableUsers.put(newUser.getId(), newUser);
        return newUser;
    }

    @Override
    public Boolean addCreditAccount(User user, CreditAccount creditAccount) {
        if (user != null && creditAccount != null) {
            user.getCreditAccounts().add(creditAccount);
            return true;
        }
        return false;
    }

    @Override
    public Boolean addPaymentAccount(User user, PaymentAccount paymentAccount) {
        if (user != null && paymentAccount != null) {
            user.getPaymentAccounts().add(paymentAccount);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteBank(User user, Bank bank) {
        if (user != null && bank != null) {
            return user.getBanks().remove(bank);
        }
        return false;
    }

    @Override
    public Boolean deleteCreditAccount(User user, CreditAccount creditAccount) {
        if (user != null && creditAccount != null) {
            return user.getCreditAccounts().remove(creditAccount);
        }
        return false;
    }

    @Override
    public Boolean deletePaymentAccount(User user, PaymentAccount paymentAccount) {
        if (user != null && paymentAccount != null) {
            return user.getPaymentAccounts().remove(paymentAccount);
        }
        return false;
    }
}

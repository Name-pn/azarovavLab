package tech.reliab.course.toropchinda.bank;

import tech.reliab.course.toropchinda.bank.entity.*;
import tech.reliab.course.toropchinda.bank.service.BankOfficeService;
import tech.reliab.course.toropchinda.bank.service.*;
import tech.reliab.course.toropchinda.bank.service.impl.*;
import tech.reliab.course.toropchinda.bank.utils.AtmStatus;
import tech.reliab.course.toropchinda.bank.utils.Constants;
import tech.reliab.course.toropchinda.bank.utils.Utils;

import java.math.BigDecimal;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        new Constants();
        new Utils();

        BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();
        UserService userService = new UserServiceImpl();
        BankService bankService = new BankServiceImpl(bankOfficeService, userService);
        AtmService atmService = new AtmServiceImpl();
        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
        CreditAccountService creditAccountService = new CreditAccountServiceImpl();

        for (int i = 0; i < 5; i++) {
            Bank bank = bankService.create(Constants.BANK_NAMES.get(i));
        }

        List<Bank> banksArray = bankService.getAllBanks();
        for (int i = 0; i < Constants.NUMBER_OFFICES*Constants.NUMBER_BANKS; i++) {
            BankOffice office = bankOfficeService.create(Constants.OFFICE_ADDRESS.get(i), Boolean.TRUE, Boolean.TRUE,
                    0, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, BigDecimal.valueOf(Constants.RENTAL_OFFICE_MAX_PRICE),
                    BigDecimal.valueOf(banksArray.get(i / Constants.NUMBER_OFFICES).getMoney() / Constants.NUMBER_OFFICES));
            bankService.addOffice(banksArray.get(i / Constants.NUMBER_OFFICES), office);

            for (int j = 0; j < Constants.NUMBER_EMPLOYEES_IN_OFFICE; j++) {
                Employee employee = employeeService.create(Constants.FULLNAMES.get((int)
                        (Utils.rand() * Constants.NUMBER_FULLNAMES)), Utils.randomDate(), Constants.POSITIONS.get((int)
                        (Constants.NUMBER_POSITIONS * Utils.rand())), banksArray.get(i / 3), Boolean.TRUE, office, Boolean.TRUE,
                        BigDecimal.valueOf(10000));
                bankService.addEmployee(banksArray.get(i / 3), employee);
            }
            List<Employee> lst = employeeService.getWorkerList(banksArray.get(i / Constants.NUMBER_ATMS).getId());
            BankAtm atm = atmService.create(banksArray.get(i / Constants.NUMBER_ATMS), office,
                    lst.get(((int)(Constants.NUMBER_EMPLOYEES_IN_OFFICE * Utils.rand()))), AtmStatus.WORK,
                    true, true, BigDecimal.valueOf(Constants.MAINTENANCE_COST_OF_ATM));
            bankService.addAtm(banksArray.get(i / Constants.NUMBER_ATMS), atm);

        }
        List<Bank> lstBanks = bankService.getAllBanks();
        for (int i = 0; i < Constants.NUMBER_BANKS; i++) {
            for (int j = 0; j < Constants.NUMBER_USERS; j++) {
                User user = userService.create(
                        Constants.FULLNAMES.get((int)(Constants.NUMBER_FULLNAMES * Utils.rand())),
                        Utils.randomDate(),
                        Constants.POSITIONS.get((int)(Constants.NUMBER_POSITIONS * Utils.rand())),
                        BigDecimal.valueOf(Constants.SALARY_PATTERN*Utils.rand()),
                        BigDecimal.valueOf(0));
                bankService.addClient(lstBanks.get(i), user);
                userService.addBank(user, lstBanks.get(i));

                for (int k = 0; k < Constants.NUMBER_COUNTERS; k++) {
                    PaymentAccount pAccount = paymentAccountService.create(user, lstBanks.get(i),
                            BigDecimal.valueOf(Constants.PAYMENT_ACCOUNT_SUM_PATTERN*Utils.rand()));
                    userService.addPaymentAccount(user, pAccount);

                    Date startDate = Utils.randomDate();
                    Date finalDate = Utils.randomDate();
                    if (startDate.after(finalDate)) {
                        Date tmp = startDate;
                        startDate = finalDate;
                        finalDate = tmp;
                    }
                    CreditAccount account = creditAccountService.create(user, lstBanks.get(i).getName(),
                            startDate, finalDate, BigDecimal.valueOf(Utils.rand()*Constants.CREDIT_PATTERN),
                            BigDecimal.valueOf(15000), BigDecimal.valueOf(10),
                            employeeService.getWorkerList(lstBanks.get(i).getId()).get((int)(Utils.rand()*Constants.NUMBER_EMPLOYEES_IN_OFFICE)),
                            pAccount);
                    userService.addCreditAccount(user, account);
                }
            }
        }

        while (true) {
            System.out.print("Вас приветствует программа банкинга\n");
            System.out.print("Для того, чтобы получить информацию по банку введите b <id>\n");
            System.out.print("Для того, чтобы получить всю информацию о клиенте введите u <id>\n");
            System.out.print("->");
            Scanner in = new Scanner(System.in);
            String command = in.next();
            switch (command) {
                case ("b"):
                    Integer bankId = in.nextInt();
                    Map<Integer, Bank> map = bankService.getMap();
                    Bank bank = map.get(bankId);
                    System.out.print(bank);
                    break;
                case ("u"):
                    Integer userId = in.nextInt();
                    System.out.print(userService.getMap().get(userId));
                    break;
                default:
                    System.out.print("Не корректный ввод\n");
                    break;
            }

        }

    }
}
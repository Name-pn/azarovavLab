package tech.reliab.course.toropchinda.bank;

import tech.reliab.course.toropchinda.bank.entity.*;
import tech.reliab.course.toropchinda.bank.service.BankService;
import tech.reliab.course.toropchinda.bank.service.impl.*;
import tech.reliab.course.toropchinda.bank.utils.AtmStatus;

import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        BankServiceImpl bankService = new BankServiceImpl();
        Bank bank = bankService.create(new Bank("Можешь банк"));

        BankOfficeServiceImpl bankOfficeService = new BankOfficeServiceImpl();
        BankOffice bankOffice = bankOfficeService.create(new BankOffice("Первый офис", "Белгород, Костюкова, 46", true,
                true, 0, true, true, true, 0, 0));
        bankOfficeService.updateRandRentalCost(bankOffice);
        bankOfficeService.updateAllMoney(bankOffice, bank);
        bankService.addOffice(bank, bankOffice);

        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        Employee employee = employeeService.create(new Employee("Азаров А.В.", new Date(101, 12, 25),
                "Кредитный специалист", bank, false, bankOffice, true, 50000));
        bankService.addEmployee(bank, employee);

        AtmServiceImpl atmService = new AtmServiceImpl();
        BankAtm bankAtm = atmService.create(new BankAtm(bank, bankOffice, employee, "Atm1", AtmStatus.WORK, true, true,
                0, 0));
        atmService.updateRandMaintenceCost(bankAtm);
        bankService.addAtm(bank, bankAtm);
        atmService.updateChangeMoney(bankAtm);

        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.create(new User("Иван И.И.", new Date(110, 10, 24), "Комбинат питания", 24000,
                20));

        bankService.addClient(bank, user);

        PaymentAccountServiceImpl paymentAccountService = new PaymentAccountServiceImpl();
        PaymentAccount paymentAccount = paymentAccountService.create(new PaymentAccount(user, bank, 10000));

        CreditAccountServiceImpl creditAccountService = new CreditAccountServiceImpl();
        CreditAccount creditAccount = creditAccountService.create(new CreditAccount(user, bank, new Date(120, 10, 5),
                new Date(124, 5, 5), 20000, 1000, 15, employee, paymentAccount));

        userService.addBank(user, bank);
        userService.addCreditAccount(user, creditAccount);
        userService.addPaymentAccount(user, paymentAccount);

        System.out.print(bank);
        System.out.print(bankAtm);
        System.out.print(employee);
        System.out.print(bankOffice);
        System.out.print(user);
        System.out.print(paymentAccount);
        System.out.print(creditAccount);

    }
}
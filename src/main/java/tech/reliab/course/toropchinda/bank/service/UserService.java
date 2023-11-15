package tech.reliab.course.toropchinda.bank.service;

import tech.reliab.course.toropchinda.bank.entity.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UserService {
    public User create(String fullName, Date birthday, String work, BigDecimal salary, BigDecimal rating);

    public List<User> getUsers();

    public Boolean takeCredit(UserService userService, BankService bankService, BankOfficeService bankOfficeService,
                              PaymentAccountService paymentAccountService,
                              CreditAccountService creditAccountService,
                              Integer userId, BigDecimal sum);

    public Bank chooseBestBank(BankService bankService, BigDecimal sum);

    public BankOffice chooseSuitableOffice(List<BankOffice> collection, BigDecimal sum);

    public Employee chooseSuitableEmployee(List<Employee> collection);

    public User getUserByHisId(Integer id);

    public Boolean addBank(User user, Bank bank);
    public Boolean deleteBank(User user, Bank bank);

    public Boolean addCreditAccount(User user, CreditAccount creditAccount);
    public Boolean deleteCreditAccount(User user, CreditAccount creditAccount);

    public Boolean addPaymentAccount(User user, PaymentAccount paymentAccount);
    public Boolean deletePaymentAccount(User user, PaymentAccount paymentAccount);
}

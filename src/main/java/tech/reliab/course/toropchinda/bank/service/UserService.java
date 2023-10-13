package tech.reliab.course.toropchinda.bank.service;

import tech.reliab.course.toropchinda.bank.entity.Bank;
import tech.reliab.course.toropchinda.bank.entity.CreditAccount;
import tech.reliab.course.toropchinda.bank.entity.PaymentAccount;
import tech.reliab.course.toropchinda.bank.entity.User;

public interface UserService {
    public User create(User user);

    public Boolean addBank(User user, Bank bank);
    public Boolean deleteBank(User user, Bank bank);

    public Boolean addCreditAccount(User user, CreditAccount creditAccount);
    public Boolean deleteCreditAccount(User user, CreditAccount creditAccount);

    public Boolean addPaymentAccount(User user, PaymentAccount paymentAccount);
    public Boolean deletePaymentAccount(User user, PaymentAccount paymentAccount);
}

package tech.reliab.course.toropchinda.bank.service;

import tech.reliab.course.toropchinda.bank.entity.Bank;
import tech.reliab.course.toropchinda.bank.entity.CreditAccount;
import tech.reliab.course.toropchinda.bank.entity.PaymentAccount;

public interface CreditAccountService {
    public CreditAccount create(CreditAccount creditAccount);

    public Boolean updatePaymentAccount(CreditAccount creditAccount, PaymentAccount paymentAccount);

    public Boolean updateInterestRate(CreditAccount creditAccount, Bank bank);
}

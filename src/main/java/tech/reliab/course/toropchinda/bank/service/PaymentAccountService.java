package tech.reliab.course.toropchinda.bank.service;

import tech.reliab.course.toropchinda.bank.entity.PaymentAccount;

public interface PaymentAccountService {
    public PaymentAccount create(PaymentAccount paymentAccount);

    public Boolean updateSum(PaymentAccount paymentAccount, Integer add);
}

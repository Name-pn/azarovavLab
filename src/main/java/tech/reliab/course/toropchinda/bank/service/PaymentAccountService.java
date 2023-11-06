package tech.reliab.course.toropchinda.bank.service;

import tech.reliab.course.toropchinda.bank.entity.Bank;
import tech.reliab.course.toropchinda.bank.entity.PaymentAccount;
import tech.reliab.course.toropchinda.bank.entity.User;

import java.math.BigDecimal;

public interface PaymentAccountService {
    public PaymentAccount create(User user, Bank bank, BigDecimal sum);

    public Boolean updateSum(PaymentAccount paymentAccount, Integer add);
}

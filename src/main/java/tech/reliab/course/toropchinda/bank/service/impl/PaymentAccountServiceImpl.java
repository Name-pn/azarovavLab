package tech.reliab.course.toropchinda.bank.service.impl;

import tech.reliab.course.toropchinda.bank.entity.PaymentAccount;
import tech.reliab.course.toropchinda.bank.service.PaymentAccountService;

public class PaymentAccountServiceImpl implements PaymentAccountService {
    @Override
    public PaymentAccount create(PaymentAccount paymentAccount) {
        PaymentAccount newPaymentAccount = new PaymentAccount(paymentAccount.getId(), paymentAccount.getUser(), paymentAccount.getBank(), paymentAccount.getSum());
        return newPaymentAccount;
    }

    @Override
    public Boolean updateSum(PaymentAccount paymentAccount, Integer add) {
        if (paymentAccount != null && add != null) {
            if (paymentAccount.getSum() > -add) {
                paymentAccount.setSum(paymentAccount.getSum() + add);
                return true;
            }
        }
        return false;
    }
}

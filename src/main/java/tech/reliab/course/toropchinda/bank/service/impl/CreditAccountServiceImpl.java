package tech.reliab.course.toropchinda.bank.service.impl;

import tech.reliab.course.toropchinda.bank.Main;
import tech.reliab.course.toropchinda.bank.entity.Bank;
import tech.reliab.course.toropchinda.bank.entity.CreditAccount;
import tech.reliab.course.toropchinda.bank.entity.PaymentAccount;
import tech.reliab.course.toropchinda.bank.service.CreditAccountService;

public class CreditAccountServiceImpl implements CreditAccountService {
    @Override
    public CreditAccount create(CreditAccount creditAccount) {
        CreditAccount newCreditAccount = new CreditAccount(creditAccount.getId(), creditAccount.getUser(), creditAccount.getNameBank(), creditAccount.getDateStart(),
                creditAccount.getDateFinish(), creditAccount.getSum(), creditAccount.getEveryMonthPay(),
                creditAccount.getInterestRate(), creditAccount.getEmployee(), creditAccount.getPaymentAccount());
        return newCreditAccount;
    }

    @Override
    public Boolean updatePaymentAccount(CreditAccount creditAccount, PaymentAccount paymentAccount) {
        if (creditAccount != null && paymentAccount != null) {
            creditAccount.setPaymentAccount(paymentAccount);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateInterestRate(CreditAccount creditAccount, Bank bank) {
        if (creditAccount != null && bank != null) {
            creditAccount.setInterestRate((int)(bank.getInterestRate() * Math.random()));
            return true;
        }
        return false;
    }
}

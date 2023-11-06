package tech.reliab.course.toropchinda.bank.service.impl;

import tech.reliab.course.toropchinda.bank.entity.Bank;
import tech.reliab.course.toropchinda.bank.entity.CreditAccount;
import tech.reliab.course.toropchinda.bank.entity.PaymentAccount;
import tech.reliab.course.toropchinda.bank.entity.User;
import tech.reliab.course.toropchinda.bank.service.UserService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {

    Map<Integer, User> tableUsers = new HashMap<>();

    @Override
    public Map<Integer, User> getMap() {
        return tableUsers;
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

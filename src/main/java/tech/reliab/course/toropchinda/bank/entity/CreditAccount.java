package tech.reliab.course.toropchinda.bank.entity;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CreditAccount {
    static private Integer idCurrent = 0;
    private Integer id;
    private User user;
    private String nameBank;
    private Date dateStart;
    private Date dateFinish;
    private Integer months;
    private Integer sum;
    private Integer everyMonthPay;
    private Integer interestRate;
    private Employee employee;
    private PaymentAccount paymentAccount;

    public Employee getEmployee() {
        return employee;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public Integer getEveryMonthPay() {
        return everyMonthPay;
    }

    public Integer getInterestRate() {
        return interestRate;
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    public Integer getMonths() {
        return months;
    }

    public Integer getSum() {
        return sum;
    }

    public String getNameBank() {
        return nameBank;
    }

    public User getUser() {
        return user;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public void setInterestRate(Integer interestRate) {
        this.interestRate = interestRate;
    }

    public CreditAccount(Integer id, User user, String nameBank, Date dateStart, Date dateFinish,
                         Integer sum, Integer everyMonthPay, Integer interestRate, Employee employee, PaymentAccount paymentAccount) {
        this.id = id;
        this.user = user;
        this.nameBank = nameBank;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        long elapsedms = dateFinish.getTime() - dateStart.getTime();
        long diff = TimeUnit.DAYS.convert(elapsedms, TimeUnit.MILLISECONDS) / 30;
        this.months = (int)diff;
        this.sum = sum;
        this.everyMonthPay = everyMonthPay;
        this.interestRate = interestRate;
        this.employee = employee;
        this.paymentAccount = paymentAccount;

    }

    public CreditAccount(User user, Bank bank, Date dateStart, Date dateFinish,
                         Integer sum, Integer everyMonthPay, Integer interestRate, Employee employee, PaymentAccount paymentAccount) {
        this.id = idCurrent++;
        this.user = user;
        this.nameBank = bank.getName();
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        long elapsedms = dateFinish.getTime() - dateStart.getTime();
        long diff = TimeUnit.DAYS.convert(elapsedms, TimeUnit.MILLISECONDS) / 30;
        this.months = (int)diff;
        this.sum = sum;
        this.everyMonthPay = everyMonthPay;
        this.interestRate = interestRate;
        this.employee = employee;
        this.paymentAccount = paymentAccount;

    }

    public String toString() {
        return "Айди кредитного счета: " + this.id + "\n" +
                "Владелец счета: " + this.user.getFullName() + "\n" +
                "Банк счета: " + this.nameBank + "\n" +
                "Дата открытия счета: " + this.dateStart + "\n" +
                "Дата закрытия счета: " + this.dateFinish + "\n" +
                "Число месяцев на которое взят кредит: " + this.months + "\n" +
                "Сумма кредита: " + this.sum + "\n" +
                "Ежемесячный платеж: " + this.everyMonthPay + "\n" +
                "Процентная ставка: " + this.interestRate + "\n" +
                "Работник выдавший кредит: " + employee.getFullName() + "\n" +
                "Айди счета пользователя для оплаты: " + paymentAccount.getId() + "\n" +
                "-----------------------------------------------------------------";

    }

    public Integer getId() {
        return id;
    }
}

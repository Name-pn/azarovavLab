package tech.reliab.course.toropchinda.bank.entity;

import java.util.ArrayList;
import java.util.Date;

public class User {
    private static Integer idCurrent = 0;
    private Integer id;
    private String fullName;
    private Date birthday;
    private String work;
    private Integer salary;
    private ArrayList<Bank> banks;
    private ArrayList<CreditAccount> creditAccounts;
    private ArrayList<PaymentAccount> paymentAccounts;
    private Integer rating;

    public ArrayList<Bank> getBanks() {
        return banks;
    }

    public ArrayList<CreditAccount> getCreditAccounts() {
        return creditAccounts;
    }

    public ArrayList<PaymentAccount> getPaymentAccounts() {
        return paymentAccounts;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Integer getSalary() {
        return salary;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRating() {
        return rating;
    }

    public String getWork() {
        return work;
    }

    public User(Integer id, String fullName, Date birthday, String work, Integer salary, Integer rating) {
        this.id = id;
        this.fullName = fullName;
        this.birthday = birthday;
        this.work = work;
        this.salary = salary;
        this.rating = rating;
        this.banks = new ArrayList<Bank>();
        this.creditAccounts = new ArrayList<CreditAccount>();
        this.paymentAccounts = new ArrayList<PaymentAccount>();
    }

    public User(String fullName, Date birthday, String work, Integer salary, Integer rating) {
        id = idCurrent++;
        this.fullName = fullName;
        this.birthday = birthday;
        this.work = work;
        this.salary = salary;
        this.rating = rating;
        this.banks = new ArrayList<Bank>();
        this.creditAccounts = new ArrayList<CreditAccount>();
        this.paymentAccounts = new ArrayList<PaymentAccount>();
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        String res = "Айди пользователя: " + id + "\n" +
                "Имя пользователя: " + fullName + "\n" +
                "День рождения: " + birthday + "\n" +
                "Место работы: " + work + "\n" +
                "Зарплата: " + salary + "\n" +
                "Кредитный рейтинг: " + rating + "\n";
        res += "Пользуется банками: \n";
        for (int i = 0; i < banks.size(); i++) {
            res += "Название: " + banks.get(i).getName() + "\n";
        }
        if (banks.size() == 0)
            res += "Пользователь не пользуется банками\n";
        res += "Кредитные счета пользователя: \n";
        for (int i = 0; i < creditAccounts.size(); i++) {
            res += "Айди: " + creditAccounts.get(i).getId() + "\n";
        }
        if (creditAccounts.size() == 0)
            res += "Пользователь не имеет кредитных счетов\n";
        res += "Имеет банковские счета: \n";
        for (int i = 0; i < paymentAccounts.size(); i++) {
            res += "Айди: " + paymentAccounts.get(i).getId() + "\n";
        }
        if (paymentAccounts.size() == 0)
            res += "Пользователь не имеет денежных счетов в банках\n";
        return res + "------------------------------------------------\n";

    }
}

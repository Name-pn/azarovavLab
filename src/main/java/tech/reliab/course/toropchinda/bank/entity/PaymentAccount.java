package tech.reliab.course.toropchinda.bank.entity;

public class PaymentAccount {
    private static Integer idCurrent = 0;
    private Integer id;
    private User user;
    private Bank bank;
    private Integer sum;

    public Bank getBank() {
        return bank;
    }

    public User getUser() {
        return user;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public PaymentAccount(Integer id, User user, Bank bank, Integer sum) {
        this.id = id;
        this.user = user;
        this.bank = bank;
        this.sum = sum;
    }
    public PaymentAccount(User user, Bank bank, Integer sum) {
        id = idCurrent++;
        this.user = user;
        this.bank = bank;
        this.sum = sum;
    }

    public Integer getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Айди счета: " + id + "\n" +
                "Владелец: " + user.getFullName() + "\n" +
                "Банк: " + bank.getName() + "\n" +
                "Сумма на счете: " + sum + "\n" +
                "----------------------------------\n";
    }
}



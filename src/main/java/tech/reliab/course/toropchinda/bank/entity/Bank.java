package tech.reliab.course.toropchinda.bank.entity;

import tech.reliab.course.toropchinda.bank.Main;

import java.util.Random;

public class Bank {
    static private Integer idCurrent = 0;
    private Integer id;
    private String name;
    private Integer numberOffices;
    private Integer numberAtms;
    private Integer numberEmployees;
    private Integer numberClients;
    private Integer rating;
    private Integer money;
    private Double interestRate;

    public Bank(String name) {
        this.id = idCurrent++;
        this.name = name;
        this.numberOffices = 0;
        this.numberAtms = 0;
        this.numberEmployees = 0;
        this.numberClients = 0;
        this.rating = (int) (Math.random() * 101);
        this.money = (int) (Math.random() * 1000000);
        this.interestRate = ((int)(Math.random() * 21)) * (1 - this.rating.doubleValue() / 100);
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setNumberAtms(Integer numberAtms) {
        this.numberAtms = numberAtms;
    }

    public Integer getNumberAtms() {
        return numberAtms;
    }

    public Integer getNumberClients() {
        return numberClients;
    }

    public Integer getNumberEmployees() {
        return numberEmployees;
    }

    public Integer getNumberOffices() {
        return numberOffices;
    }

    public void setNumberClients(Integer numberClients) {
        this.numberClients = numberClients;
    }

    public void setNumberEmployees(Integer numberEmployees) {
        this.numberEmployees = numberEmployees;
    }

    public void setNumberOffices(Integer numberOffices) {
        this.numberOffices = numberOffices;
    }

    @Override
    public String toString() {
        return "Название банка: " + this.name + "\n" +
                "Айди банка: " + this.id + "\n" +
                "Число офисов: " + this.numberOffices + "\n" +
                "Число банкоматов: " + this.numberAtms + "\n" +
                "Число работников: " + this.numberEmployees + "\n" +
                "Число клиентов: " + this.numberClients + "\n" +
                "Рейтинг: " + this.rating + "\n" +
                "Деньги банка: " + this.money + "\n" +
                "Процентная ставка: " + this.interestRate + '\n' +
                "------------------------------------------------\n";
    }
}

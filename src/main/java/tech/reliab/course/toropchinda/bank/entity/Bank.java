package tech.reliab.course.toropchinda.bank.entity;

import tech.reliab.course.toropchinda.bank.Main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bank implements Comparable<Bank>{

    @Override
    public int compareTo(Bank o) {
        int sum1 = (int) (this.getNumberAtms()*10+this.getNumberEmployees()*5+this.getNumberOffices()*20+(100/this.getInterestRate()));
        int sum2 = (int) (o.getNumberAtms()*10+o.getNumberEmployees()*5+o.getNumberOffices()*20 + (100/o.getInterestRate()));
        return sum1 - sum2;
    }

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
    private List<BankOffice> lstOffices = new ArrayList<BankOffice>();

    private List<User> lstUsers = new ArrayList<User>();

    public List<User> getLstUsers() {
        return lstUsers;
    }

    public List<BankOffice> getLstOffices() {
        return lstOffices;
    }

    public Bank(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.numberOffices = 0;
        this.numberAtms = 0;
        this.numberEmployees = 0;
        this.numberClients = 0;
        this.rating = (int) (Math.random() * 101);
        this.money = (int) (Math.random() * 1000000);
        this.interestRate = ((int)(Math.random() * 21)) * (1 - this.rating.doubleValue() / 100);
    }

    public Bank(String name) {
        this.id = idCurrent++;
        this.name = name;
        this.numberOffices = 0;
        this.numberAtms = 0;
        this.numberEmployees = 0;
        this.numberClients = 0;
        this.rating = (int) (Math.random() * 101);
        this.money = (int) (Math.random() * 1000000);
        this.interestRate = ((int)(Math.random() * 21)) * (1 - this.rating.doubleValue() / 100) + 0.1;
    }

    public Integer getId() {
        return id;
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
        String officesStr = "Офисы по названиям и id \n";
        for (BankOffice office : this.getLstOffices()) {
            officesStr += "Название офиса = " + office.getName() + "\nид = " + office.getId().toString() + "\n";
        }
        return "Объект: банк\n" + "++++++++++++++++++++++++++++++++++++++\n" +
                "Название банка: " + this.name + "\n" +
                "Айди банка: " + this.id + "\n" +
                "Число офисов: " + this.numberOffices + "\n" +
                officesStr +
                "Число банкоматов: " + this.numberAtms + "\n" +
                "Число работников: " + this.numberEmployees + "\n" +
                "Число клиентов: " + this.numberClients + "\n" +
                "Рейтинг: " + String.format("%.2f", BigDecimal.valueOf(this.rating)) + "\n" +
                "Деньги банка: " + String.format("%.2f", BigDecimal.valueOf(this.money)) + "\n" +
                "Процентная ставка: " + String.format("%.2f", this.interestRate) + '\n' +
                "\nПривлекательность " + String.valueOf(this.getNumberAtms() * 10 + this.getNumberEmployees() * 5 + this.getNumberOffices() * 20 + (100 / this.getInterestRate()))
                +"\n------------------------------------------------\n";
    }
}

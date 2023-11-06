package tech.reliab.course.toropchinda.bank.entity;

import java.math.BigDecimal;

public class BankOffice {
    private static Integer idCurrent = 0;
    private Integer id;
    private String name;
    private String address;
    private Boolean work;
    private Boolean permissionAtm;
    private Integer numberAtm;
    private Boolean giveCredit;
    private Boolean giveMoney;
    private Boolean getMoney;
    private BigDecimal money;
    private BigDecimal rentalPrice;

    public BigDecimal getMoney() {
        return money;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getIsCashDeposit() {
        return getMoney;
    }

    public Boolean getGiveCredit() {
        return giveCredit;
    }

    public Boolean getGiveMoney() {
        return giveMoney;
    }

    public Boolean getPermissionAtm() {
        return permissionAtm;
    }

    public Boolean getWork() {
        return work;
    }

    public Integer getNumberAtm() {
        return numberAtm;
    }

    public BigDecimal getRentalPrice() {
        return rentalPrice;
    }

    public void setNumberAtm(Integer numberAtm) {
        this.numberAtm = numberAtm;
    }

    public BankOffice(Integer id, String name, String address, Boolean work, Boolean permissionAtm,
                      Integer numberAtm, Boolean giveCredit, Boolean giveMoney,
                      Boolean getMoney, BigDecimal money, BigDecimal rentalPrice) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.work = work;
        this.permissionAtm = permissionAtm;
        this.numberAtm = numberAtm;
        this.giveCredit = giveCredit;
        this.giveMoney = giveMoney;
        this.getMoney = getMoney;
        this.money = money;
        this.rentalPrice = rentalPrice;

    }

    public void setRentalPrice(BigDecimal rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BankOffice(String name, String address, Boolean work, Boolean permissionAtm,
                      Integer numberAtm, Boolean giveCredit, Boolean giveMoney,
                      Boolean getMoney, BigDecimal money, BigDecimal rentalPrice) {
        this.id = idCurrent++;
        this.name = name;
        this.address = address;
        this.work = work;
        this.permissionAtm = permissionAtm;
        this.numberAtm = numberAtm;
        this.giveCredit = giveCredit;
        this.giveMoney = giveMoney;
        this.getMoney = getMoney;
        this.money = money;
        this.rentalPrice = rentalPrice;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Объект: офис\n" + "++++++++++++++++++++++++++++++++++++++\n" +
                "Название офиса: " + this.name + "\n" +
                "Айди: " + this.id + "\n" +
                "Адрес офиса: " + this.address + "\n" +
                "Офис работает: " + this.work + "\n" +
                "В офисе разрешено размещение банкоматов: " + this.permissionAtm + "\n" +
                "Число банкоматов в офисе: " + this.numberAtm + "\n" +
                "Выдача кредитов: " + this.giveCredit + "\n" +
                "Выдача денег работает: " + this.giveMoney + "\n" +
                "Внесение денег работает: " + this.getMoney + "\n" +
                "Количество денег в банковском офисе: " + this.money + "\n" +
                "Аренда офиса: " + this.rentalPrice + "\n" +
                "---------------------------------------------\n";

    }

    public String getAddress() {
        return address;
    }
}

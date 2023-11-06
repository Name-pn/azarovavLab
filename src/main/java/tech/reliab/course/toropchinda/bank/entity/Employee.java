package tech.reliab.course.toropchinda.bank.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Employee {
    static private Integer idCurrent = 0;
    private Integer id;
    private String fullName;
    private Date birthday;
    private String position;
    private Bank bank;
    private Boolean remoteWork;
    private BankOffice office;
    private Boolean creditPossibility;
    private BigDecimal salary;

    public Integer getId() {
        return id;
    }

    public Boolean getCreditPossibility() {
        return creditPossibility;
    }

    public Bank getBank() {
        return bank;
    }

    public BankOffice getOffice() {
        return office;
    }

    public Boolean getRemoteWork() {
        return remoteWork;
    }

    public Date getBirthday() {
        return birthday;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(BigDecimal  salary) {
        this.salary = salary;
    }

    public void setOffice(BankOffice office) {
        this.office = office;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Employee(Integer id, String fullName, Date birthday, String position, Bank bank, Boolean remoteWork, BankOffice office,
                    Boolean giveCredit, BigDecimal  salary) {
        this.id = id;
        this.fullName = fullName;
        this.birthday = birthday;
        this.position = position;
        this.bank = bank;
        this.remoteWork = remoteWork;
        this.office = office;
        this.creditPossibility = giveCredit;
        this.salary = salary;
    }
    public Employee(String fullName, Date birthday, String position, Bank bank, Boolean remoteWork, BankOffice office,
                    Boolean giveCredit, BigDecimal  salary) {
        this.id = idCurrent++;
        this.fullName = fullName;
        this.birthday = birthday;
        this.position = position;
        this.bank = bank;
        this.remoteWork = remoteWork;
        this.office = office;
        this.creditPossibility = giveCredit;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }
    @Override
    public String toString() {
        return "Объект: работник\n" + "++++++++++++++++++++++++++++++++++++++\n" +
                "ФИО работника: " + fullName + "\n" +
                "Айди работника: " + id + "\n" +
                "День рождения: " + birthday + "\n" +
                "Должность: " + position + "\n" +
                "Банк: " + bank.getName() + "\n" +
                "Работает удаленно: " + remoteWork + "\n" +
                "Офис: " + office.getName() + "\n" +
                "Работник выдает кредиты: " + creditPossibility + "\n" +
                "Зарплата: " + salary + "\n" +
                "-----------------------------------\n";
    }
}

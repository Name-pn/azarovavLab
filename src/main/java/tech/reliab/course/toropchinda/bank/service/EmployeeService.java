package tech.reliab.course.toropchinda.bank.service;

import tech.reliab.course.toropchinda.bank.entity.Bank;
import tech.reliab.course.toropchinda.bank.entity.BankOffice;
import tech.reliab.course.toropchinda.bank.entity.Employee;

public interface EmployeeService {
    public Employee create(Employee employee);

    public Boolean updateWork(Employee employee, BankOffice bankOffice, Bank bank, String position, Integer salary);


}

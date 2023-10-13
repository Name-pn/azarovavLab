package tech.reliab.course.toropchinda.bank.service.impl;

import tech.reliab.course.toropchinda.bank.entity.Bank;
import tech.reliab.course.toropchinda.bank.entity.BankOffice;
import tech.reliab.course.toropchinda.bank.entity.Employee;
import tech.reliab.course.toropchinda.bank.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public Employee create(Employee employee) {
        Employee newEmployee = new Employee(employee.getId(), employee.getFullName(), employee.getBirthday(), employee.getPosition(),
                employee.getBank(), employee.getRemoteWork(), employee.getOffice(), employee.getGiveCredit(), employee.getSalary());
        return newEmployee;
    }

    @Override
    public Boolean updateWork(Employee employee, BankOffice bankOffice, Bank bank, String position, Integer salary) {
        if (employee != null && bankOffice != null && bank != null && position != null && salary != null) {
            employee.setBank(bank);
            employee.setPosition(position);
            employee.setSalary(salary);
            employee.setOffice(bankOffice);
            return true;
        }
        return false;
    }
}

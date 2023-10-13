package tech.reliab.course.toropchinda.bank.service.impl;

import tech.reliab.course.toropchinda.bank.entity.*;
import tech.reliab.course.toropchinda.bank.service.BankService;

public class BankServiceImpl implements BankService {
    @Override
    public Bank create(Bank bank) {
        return new Bank(bank.getName());
    }

    @Override
    public Boolean addAtm(Bank bank, BankAtm bankAtm) {
        if (bank != null && bankAtm != null) {
            bank.setNumberAtms(bank.getNumberAtms() + 1);
            return true;
        }
        return false;
    }

    @Override
    public Boolean addClient(Bank bank, User user) {
        if (bank != null && user != null) {
            bank.setNumberClients(bank.getNumberClients() + 1);
            return true;
        }
        return false;
    }

    @Override
    public Boolean addEmployee(Bank bank, Employee employee) {
        if (bank != null && employee != null) {
            bank.setNumberEmployees(bank.getNumberEmployees() + 1);
            return true;
        }
        return false;
    }

    @Override
    public Boolean addOffice(Bank bank, BankOffice bankOffice) {
        if (bank != null && bankOffice != null) {
            bank.setNumberOffices(bank.getNumberOffices() + 1);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteAtm(Bank bank, BankAtm bankAtm) {
        if (bank != null && bankAtm != null) {
            if (bank.getNumberAtms() > 0) {
                bank.setNumberAtms(bank.getNumberAtms() - 1);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public Boolean deleteClient(Bank bank, User user) {
        if (bank != null && user != null) {
            if (bank.getNumberClients() > 0) {
                bank.setNumberClients(bank.getNumberClients() - 1);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public Boolean deleteEmployee(Bank bank, Employee employee) {
        if (bank != null && employee != null) {
            if (bank.getNumberEmployees() > 0) {
                bank.setNumberEmployees(bank.getNumberEmployees() - 1);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public Boolean deleteOffice(Bank bank, BankOffice bankOffice) {
        if (bank != null && bankOffice != null) {
            if (bank.getNumberOffices() > 0) {
                bank.setNumberOffices(bank.getNumberOffices() - 1);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public Boolean putMoney(Bank bank, Integer sum) {
        if (bank != null && sum != null) {
            bank.setMoney(bank.getMoney() + sum);
            return true;
        }
        return false;
    }
}

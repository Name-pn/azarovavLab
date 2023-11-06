package tech.reliab.course.toropchinda.bank.service.impl;

import tech.reliab.course.toropchinda.bank.entity.*;
import tech.reliab.course.toropchinda.bank.service.BankOfficeService;
import tech.reliab.course.toropchinda.bank.service.BankService;
import tech.reliab.course.toropchinda.bank.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankServiceImpl implements BankService {
    private final Map<Integer, Bank> banksTable = new HashMap<>();
    private final Map<Integer, List<User>> usersByBankIdTable = new HashMap<>();
    private final Map<Integer, List<BankOffice>> officesByBankIdTable = new HashMap<>();
    private BankOfficeService bankOfficeService;
    private UserService userService;

    @Override
    public Map<Integer, Bank> getMap() {
        return banksTable;
    }

    @Override
    public List<Bank> getAllBanks() {
        return new ArrayList<Bank>(this.banksTable.values());
    }

    public BankServiceImpl (BankOfficeService bankOfficeService, UserService userService) {
        this.bankOfficeService = bankOfficeService;
        this.userService = userService;
    }

    @Override
    public Bank create(String name) {
        Bank varBank = new Bank(name);
        banksTable.put(varBank.getId(), varBank);
        return varBank;
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
            if (usersByBankIdTable.get(bank.getId()) == null) {
                usersByBankIdTable.put(bank.getId(), new ArrayList<>());
            }
            usersByBankIdTable.get(bank.getId()).add(user);
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
            if (officesByBankIdTable.get(bank.getId()) == null) {
                officesByBankIdTable.put(bank.getId(), new ArrayList<BankOffice>());
            }
            officesByBankIdTable.get(bank.getId()).add(bankOffice);
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
                usersByBankIdTable.get(bank.getId()).remove(user);
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
                officesByBankIdTable.get(bank.getId()).remove(bankOffice);
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

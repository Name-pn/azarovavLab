package tech.reliab.course.toropchinda.bank.service.impl;

import tech.reliab.course.toropchinda.bank.entity.Bank;
import tech.reliab.course.toropchinda.bank.entity.BankAtm;
import tech.reliab.course.toropchinda.bank.entity.BankOffice;
import tech.reliab.course.toropchinda.bank.service.BankOfficeService;
import tech.reliab.course.toropchinda.bank.utils.Constants;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankOfficeServiceImpl implements BankOfficeService {
    Map<Integer, BankOffice> offices = new HashMap<>();

    @Override
    public List<BankOffice> getAll() {
        return new ArrayList<BankOffice> (offices.values());
    }

    @Override
    public BankOffice create(String address, Boolean isWork,
                             Boolean permissionAtm, Integer numberAtm, Boolean isCreditPermission, Boolean isCashIssue,
                             Boolean isCashDeposit, BigDecimal money, BigDecimal rentalPrice
    ) {
        String[] wordsAddress = address.split(" ");
        String name = "Офис " + wordsAddress[0] + " " + wordsAddress[1] + " №";
        BankOffice newBankOffice = new BankOffice(name, address, isWork,
                permissionAtm, numberAtm, isCreditPermission, isCashIssue,
                isCashDeposit, money, rentalPrice);
        newBankOffice.setName(name + String.valueOf(newBankOffice.getId()));
        offices.put(newBankOffice.getId(), newBankOffice);
        return newBankOffice;
    }

    @Override
    public Boolean addAtm(BankOffice bankOffice, BankAtm bankAtm) {
        if (bankOffice != null && bankAtm != null) {
            bankOffice.setNumberAtm(bankOffice.getNumberAtm() + 1);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteAtm(BankOffice bankOffice, BankAtm bankAtm) {
        if (bankOffice != null && bankAtm != null) {
            if (bankOffice.getNumberAtm() > 0) {
                bankOffice.setNumberAtm(bankOffice.getNumberAtm() - 1);
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean updateAllMoney(BankOffice bankOffice, Bank bank) {
        if (bankOffice != null && bank != null) {
            bankOffice.setMoney(BigDecimal.valueOf(bank.getMoney()));
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateRandRentalCost(BankOffice bankOffice) {
        if (bankOffice != null) {
            bankOffice.setRentalPrice(BigDecimal.valueOf(Constants.RENTAL_OFFICE_MAX_PRICE * Math.random()));
            return true;
        }
        return false;
    }
}

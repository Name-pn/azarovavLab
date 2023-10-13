package tech.reliab.course.toropchinda.bank.service.impl;

import tech.reliab.course.toropchinda.bank.entity.Bank;
import tech.reliab.course.toropchinda.bank.entity.BankAtm;
import tech.reliab.course.toropchinda.bank.entity.BankOffice;
import tech.reliab.course.toropchinda.bank.service.BankOfficeService;
import tech.reliab.course.toropchinda.bank.utils.Constants;

public class BankOfficeServiceImpl implements BankOfficeService {
    @Override
    public BankOffice create(BankOffice bankOffice) {
        BankOffice newBankOffice = new BankOffice(bankOffice.getId(), bankOffice.getName(), bankOffice.getAddress(), bankOffice.getWork(),
                bankOffice.getPermissionAtm(), bankOffice.getNumberAtm(), bankOffice.getGiveCredit(), bankOffice.getGiveMoney(),
                bankOffice.getGetMoney(), bankOffice.getMoney(), bankOffice.getRentalPrice());
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
            bankOffice.setMoney(bank.getMoney());
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateRandRentalCost(BankOffice bankOffice) {
        if (bankOffice != null) {
            bankOffice.setRentalPrice((int)(Constants.RENTAL_OFFICE_MAX_PRICE * Math.random()));
            return true;
        }
        return false;
    }
}

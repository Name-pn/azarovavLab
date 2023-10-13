package tech.reliab.course.toropchinda.bank.service.impl;

import tech.reliab.course.toropchinda.bank.Main;
import tech.reliab.course.toropchinda.bank.entity.BankAtm;
import tech.reliab.course.toropchinda.bank.entity.BankOffice;
import tech.reliab.course.toropchinda.bank.service.AtmService;
import tech.reliab.course.toropchinda.bank.utils.AtmStatus;
import tech.reliab.course.toropchinda.bank.utils.Constants;

public class AtmServiceImpl implements AtmService {
    @Override
    public BankAtm create(BankAtm bankAtm) {
        BankAtm newBankAtm = new BankAtm(bankAtm.getId(), bankAtm.getBank(), bankAtm.getLocate(), bankAtm.getEmployee(), bankAtm.getName(),
                bankAtm.getStatus(), bankAtm.getGiveWork(), bankAtm.getGetWork(), bankAtm.getMoney(), bankAtm.getMaintenanceCost());
        return newBankAtm;
    }

    @Override
    public Boolean updateChangeMoney(BankAtm bankAtm) {
        if (bankAtm != null) {
            bankAtm.setMoney((int)(bankAtm.getLocate().getMoney() * Math.random()));
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateChangeOffice(BankAtm bankAtm, BankOffice bankOffice) {
        if (bankAtm != null && bankOffice != null) {
            bankAtm.setLocate(bankOffice);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateSetStatus(BankAtm bankAtm, AtmStatus atmStatus) {
        if (bankAtm != null && atmStatus != null) {
            bankAtm.setStatus(atmStatus);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateRandMaintenceCost(BankAtm bankAtm) {
        if (bankAtm != null) {
            bankAtm.setMaintenanceCost((int)(Constants.MAINTENANCE_COST_OF_ATM * Math.random()));
            return true;
        }
        return false;
    }
}

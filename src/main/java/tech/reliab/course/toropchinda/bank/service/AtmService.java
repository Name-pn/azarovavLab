package tech.reliab.course.toropchinda.bank.service;

import tech.reliab.course.toropchinda.bank.entity.BankAtm;
import tech.reliab.course.toropchinda.bank.entity.BankOffice;
import tech.reliab.course.toropchinda.bank.utils.AtmStatus;

public interface AtmService {
    public BankAtm create(BankAtm bankAtm);

    public Boolean updateChangeMoney(BankAtm bankAtm);
    public Boolean updateSetStatus(BankAtm bankAtm, AtmStatus atmStatus);
    public Boolean updateChangeOffice(BankAtm bankAtm, BankOffice bankOffice);

    public Boolean updateRandMaintenceCost(BankAtm bankAtm);

}

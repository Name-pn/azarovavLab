package tech.reliab.course.toropchinda.bank.service;

import tech.reliab.course.toropchinda.bank.entity.Bank;
import tech.reliab.course.toropchinda.bank.entity.BankAtm;
import tech.reliab.course.toropchinda.bank.entity.BankOffice;

public interface BankOfficeService {
    public BankOffice create(BankOffice bankOffice);

    public Boolean updateAllMoney(BankOffice bankOffice, Bank bank);

    public Boolean updateRandRentalCost(BankOffice bankOffice);

    public Boolean addAtm(BankOffice bankOffice, BankAtm bankAtm);
    public Boolean deleteAtm(BankOffice bankOffice, BankAtm bankAtm);

}

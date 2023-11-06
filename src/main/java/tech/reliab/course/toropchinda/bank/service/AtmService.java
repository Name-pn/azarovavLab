package tech.reliab.course.toropchinda.bank.service;

import tech.reliab.course.toropchinda.bank.entity.Bank;
import tech.reliab.course.toropchinda.bank.entity.BankAtm;
import tech.reliab.course.toropchinda.bank.entity.BankOffice;
import tech.reliab.course.toropchinda.bank.entity.Employee;
import tech.reliab.course.toropchinda.bank.utils.AtmStatus;

import java.math.BigDecimal;

public interface AtmService {
    public BankAtm create(Bank refBank, BankOffice locate, Employee employee, AtmStatus status,
                          Boolean isCashIssue, Boolean isCashDeposit, BigDecimal maintenanceCost);

    public Boolean updateChangeMoney(BankAtm bankAtm);
    public Boolean updateSetStatus(BankAtm bankAtm, AtmStatus atmStatus);
    public Boolean updateChangeOffice(BankAtm bankAtm, BankOffice bankOffice);

    public Boolean updateRandMaintenceCost(BankAtm bankAtm);

}

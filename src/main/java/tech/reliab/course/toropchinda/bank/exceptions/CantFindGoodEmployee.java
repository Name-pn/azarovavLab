package tech.reliab.course.toropchinda.bank.exceptions;

public class CantFindGoodEmployee extends RuntimeException{
    public CantFindGoodEmployee(String str) {
        super(str);
    }
}

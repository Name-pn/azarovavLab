package tech.reliab.course.toropchinda.bank.exceptions;

public class CantFindAccount extends RuntimeException{
    public CantFindAccount(String string) {
        super(string);
    }
}

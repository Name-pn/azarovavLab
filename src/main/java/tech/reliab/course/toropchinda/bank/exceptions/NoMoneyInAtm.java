package tech.reliab.course.toropchinda.bank.exceptions;

public class NoMoneyInAtm extends RuntimeException {
    public NoMoneyInAtm(String string) {
        super(string);
    }
}

package tech.reliab.course.toropchinda.bank.exceptions;

public class NegativeCreditSum extends IllegalArgumentException {
    public NegativeCreditSum(String str) {
        super(str);
    }
}

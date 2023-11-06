package tech.reliab.course.toropchinda.bank.utils;

import java.util.Date;
import java.util.Random;

public class Utils {
    static Random rnd = new Random(1);
    public static Date randomDate() {
        long ms = -946771200000L + (Math.abs(rnd.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));
        return new Date(ms);
    }

    public static double rand() {
        return rnd.nextDouble();
    }
}

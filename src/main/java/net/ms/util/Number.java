package net.ms.util;

public class Number {
    public static int roundDouble(double number) {
        int integer = (int) number;
        double decimal = number - integer;
        if (decimal > 0.5) {
            return integer + 1;
        }

        return integer;
    }
}

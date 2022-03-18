package app;

public class StringCalculator {

    public static int add(String numbers) {
        return Calculator.fromString(numbers).sum();
    }
}


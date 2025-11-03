package com.zipcodewilmington.scientificcalculator;

public class FactorialCalculator {

    private Display display;

    public FactorialCalculator(Display display) {
        this.display = display;
    }

    public void factorial() {
        double x = display.getDisplayValue();


        if (x < 0 || x != Math.floor(x) || display.isError()) {
            display.setError();
            return;
        }

        double result = 1;
        for (int i = 1; i <= (int) x; i++) {
            result *= i;

            if (Double.isInfinite(result)) {
                display.setError();
                return;
            }
        }

        display.setDisplayValue(result);
    }
}

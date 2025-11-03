package com.zipcodewilmington.scientificcalculator;

public class LogarithmicCalculator {

    private final Display display;

    public LogarithmicCalculator(Display display) {
        this.display = display;
    }

    public LogarithmicCalculator() {
        this(new Display());
    }

    public double getDisplayValue() {
        return display.getDisplayValue();
    }

    public void setDisplayValue(double value) {
        display.setDisplayValue(value);
    }

    public void log() {
        if (display.isError()) return;
        double x = display.getDisplayValue();
        if (x <= 0) {
            display.setError();
        } else {
            display.setDisplayValue(Math.log10(x));
        }
    }

    public void ln() {
        if (display.isError()) return;
        double x = display.getDisplayValue();
        if (x <= 0) {
            display.setError();
        } else {
            display.setDisplayValue(Math.log(x));
        }
    }

    public void tenPower() {
        if (display.isError()) return;
        double x = display.getDisplayValue();
        double result = Math.pow(10.0, x);
        display.setFromOperationResult(result);
    }

    public void ePower() {
        if (display.isError()) return;
        double x = display.getDisplayValue();
        double result = Math.exp(x);
        display.setFromOperationResult(result);
    }
}

package com.zipcodewilmington.scientificcalculator;

public class ArithmeticCalculator {
    private Display display;

    public ArithmeticCalculator(Display display) {
        this.display = display;
    }

    public ArithmeticCalculator() {
        this.display = new Display();
    }

    public double getDisplayValue() {
        return display.getDisplayValue();
    }

    public void setDisplayValue(double value) {
        display.setDisplayValue(value);
    }

    public void add(double value) {
        if (!display.isError()) {
            display.setDisplayValue(display.getDisplayValue() + value);
        }
    }

    public void subtract(double value) {
        if (!display.isError()) {
            display.setDisplayValue(display.getDisplayValue() - value);
        }
    }

    public void multiply(double value) {
        if (!display.isError()) {
            display.setDisplayValue(display.getDisplayValue() * value);
        }
    }

    public void divide(double value) {
        if (display.isError()) {
            return;
        }
        if (value == 0) {
            display.setError();
        } else {
            display.setDisplayValue(display.getDisplayValue() / value);
        }
    }

    public void square() {
        if (!display.isError()) {
            display.setDisplayValue(Math.pow(display.getDisplayValue(), 2));
        }
    }

    public void squareRoot() {
        if (display.isError()) {
            return;
        }
        double current = display.getDisplayValue();
        if (current < 0) {
            display.setError();
        } else {
            display.setDisplayValue(Math.sqrt(current));
        }
    }

    public void exponent(double exponentValue) {
        if (!display.isError()) {
            display.setDisplayValue(Math.pow(display.getDisplayValue(), exponentValue));
        }
    }

    public void inverse() {
        if (display.isError()) {
            return;
        }
        double current = display.getDisplayValue();
        if (current == 0) {
            display.setError();
        } else {
            display.setDisplayValue(1.0 / current);
        }
    }

    public void invertSign() {
        if (!display.isError()) {
            display.setDisplayValue(-display.getDisplayValue());
        }
    }

    public void clear() {
        display.clear();
    }
}
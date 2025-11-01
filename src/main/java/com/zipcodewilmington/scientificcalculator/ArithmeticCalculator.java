package com.zipcodewilmington.scientificcalculator;

public class ArithmeticCalculator {
    public double getDisplayValue() {
    return displayValue;
    }
    
    private double displayValue;
    public ArithmeticCalculator() {
        this.displayValue = 0;
    }
    public ArithmeticCalculator(double startingValue) {
        this.displayValue = startingValue;
    }
    public void setDisplayValue(double value) {
        this.displayValue = value;
    }
     public void add(double value) {
        displayValue += value;
    }
    public void subtract(double value) {
        displayValue -= value;
    }
    public void multiply(double value) {
        displayValue *= value;
    }
    public void divide(double value) {
        if (value == 0) {
            System.out.println("Error: Cannot divide by zero.");
            displayValue = Double.NaN; // sets display to "Err" (NaN)
        } else {
            displayValue /= value;
        }
    }

     public void square() {
        displayValue = Math.pow(displayValue, 2);
    }
    public void squareRoot() {
        if (displayValue < 0) {
            System.out.println("Error: Cannot take square root of a negative number.");
            displayValue = Double.NaN;
        } else {
            displayValue = Math.sqrt(displayValue);
        }
    }
    public void exponent(double exponentValue) {
        displayValue = Math.pow(displayValue, exponentValue);
    }
    public void inverse() {
        if (displayValue == 0) {
            System.out.println("Error: Cannot find inverse of zero.");
            displayValue = Double.NaN;
        } else {
            displayValue = 1 / displayValue;
        }

    }
    public void invertSign() {
        displayValue = -displayValue;
    }
    public void clear() {
        displayValue = 0.0;
    }
}


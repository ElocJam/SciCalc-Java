package com.zipcodewilmington.scientificcalculator;

/**
 * Handles trigonometric calculations (sine, cosine, tangent, and their inverses),
 * as well as unit mode switching between Degrees and Radians.
 */
public class TrigonometricCalculator {
    private double displayValue;
    private boolean isDegreeMode; // true = degrees, false = radians

    public TrigonometricCalculator() {
        this.displayValue = 0.0;
        this.isDegreeMode = true; // default to degrees
    }

    // --- Getter & Setter ---
    public double getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(double displayValue) {
        this.displayValue = displayValue;
    }

    public String getUnitsMode() {
        return isDegreeMode ? "Degrees" : "Radians";
    }

    // --- Switch Units Mode ---
    public void switchUnitsMode() {
        isDegreeMode = !isDegreeMode; // toggle between true and false
    }

    public void switchUnitsMode(String mode) {
        if (mode.equalsIgnoreCase("degrees")) {
            isDegreeMode = true;
        } else if (mode.equalsIgnoreCase("radians")) {
            isDegreeMode = false;
        } else {
            System.out.println("Invalid mode. Use 'Degrees' or 'Radians'.");
        }
    }

    // --- Utility for conversion ---
    private double toRadians(double value) {
        return isDegreeMode ? Math.toRadians(value) : value;
    }

    private double toDegrees(double value) {
        return isDegreeMode ? value : Math.toDegrees(value);
    }

    // --- Trigonometric Functions ---
    public void sine() {
        displayValue = Math.sin(toRadians(displayValue));
    }

    public void cosine() {
        displayValue = Math.cos(toRadians(displayValue));
    }

    public void tangent() {
        displayValue = Math.tan(toRadians(displayValue));
    }

    // --- Inverse Trig Functions ---
    public void inverseSine() {
        if (displayValue < -1 || displayValue > 1) {
            displayValue = Double.NaN; // undefined
        } else {
            double result = Math.asin(displayValue);
            displayValue = isDegreeMode ? Math.toDegrees(result) : result;
        }
    }

    public void inverseCosine() {
        if (displayValue < -1 || displayValue > 1) {
            displayValue = Double.NaN;
        } else {
            double result = Math.acos(displayValue);
            displayValue = isDegreeMode ? Math.toDegrees(result) : result;
        }
    }

    public void inverseTangent() {
        double result = Math.atan(displayValue);
        displayValue = isDegreeMode ? Math.toDegrees(result) : result;
    }
}

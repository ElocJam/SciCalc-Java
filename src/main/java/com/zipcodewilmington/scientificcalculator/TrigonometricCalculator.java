package com.zipcodewilmington.scientificcalculator;

public class TrigonometricCalculator {
    private final Display display;
    private boolean isDegreeMode;

    public TrigonometricCalculator(Display display) {
        this.display = display;
        this.isDegreeMode = true;
    }

    public TrigonometricCalculator() {
        this(new Display());
    }

    public double getDisplayValue() {
        return display.getDisplayValue();
    }

    public void setDisplayValue(double value) {
        display.setDisplayValue(value);
    }

    public String getUnitsMode() {
        return isDegreeMode ? "Degrees" : "Radians";
    }

    public void switchUnitsMode() {
        isDegreeMode = !isDegreeMode;
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

    private double toRadians(double value) {
        return isDegreeMode ? Math.toRadians(value) : value;
    }
    
    public void sine() {
        if (!display.isError()) {
            display.setDisplayValue(Math.sin(toRadians(display.getDisplayValue())));
        }
    }

    public void cosine() {
        if (!display.isError()) {
            display.setDisplayValue(Math.cos(toRadians(display.getDisplayValue())));
        }
    }

    public void tangent() {
        if (!display.isError()) {
            display.setDisplayValue(Math.tan(toRadians(display.getDisplayValue())));
        }
    }

    public void inverseSine() {
        if (display.isError()) return;
        double current = display.getDisplayValue();
        if (current < -1 || current > 1) {
            display.setError();
        } else {
            double result = Math.asin(current);
            display.setDisplayValue(isDegreeMode ? Math.toDegrees(result) : result);
        }
    }

    public void inverseCosine() {
        if (display.isError()) return;
        double current = display.getDisplayValue();
        if (current < -1 || current > 1) {
            display.setError();
        } else {
            double result = Math.acos(current);
            display.setDisplayValue(isDegreeMode ? Math.toDegrees(result) : result);
        }
    }

    public void inverseTangent() {
        if (!display.isError()) {
            double result = Math.atan(display.getDisplayValue());
            display.setDisplayValue(isDegreeMode ? Math.toDegrees(result) : result);
        }
    }
}
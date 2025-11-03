package com.zipcodewilmington.scientificcalculator;

public class DisplayModeCalculator {
    private Display display;
    private String mode; // Decimal, Binary, Octal, Hexadecimal

    // Constructor for CalculatorEngine
    public DisplayModeCalculator(Display display) {
        this.display = display;
        this.mode = "Decimal";
    }

    // Default constructor for testing
    public DisplayModeCalculator() {
        this(new Display());
    }

    public String getMode() {
        return mode;
    }

    public void switchDisplayMode() {
        switch (mode) {
            case "Decimal":
                mode = "Binary";
                break;
            case "Binary":
                mode = "Octal";
                break;
            case "Octal":
                mode = "Hexadecimal";
                break;
            case "Hexadecimal":
                mode = "Decimal";
                break;
        }
    }

    public void switchDisplayMode(String newMode) {
        if (newMode.equalsIgnoreCase("Decimal") ||
            newMode.equalsIgnoreCase("Binary") ||
            newMode.equalsIgnoreCase("Octal") ||
            newMode.equalsIgnoreCase("Hexadecimal")) {
            this.mode = capitalize(newMode);
        } else {
            System.out.println("Invalid display mode. Keeping current mode: " + mode);
        }
    }

    private String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    public String getDisplayValueString() {
        long intValue = (long) display.getValue();
        switch (mode) {
            case "Binary":
                return Long.toBinaryString(intValue);
            case "Octal":
                return Long.toOctalString(intValue);
            case "Hexadecimal":
                return Long.toHexString(intValue).toUpperCase();
            default:
                return String.valueOf(display.getValue());
        }
    }

    public void setDisplayValue(double value) {
        display.setValue(value);
    }

    public double getDisplayValue() {
        return display.getValue();
    }
}

package com.zipcodewilmington.scientificcalculator;

public class DisplayModeCalculator {

    private Display display;
    private String mode;

    public DisplayModeCalculator(Display display) {
        this.display = display;
        this.mode = "decimal";
    }

    public DisplayModeCalculator() {
        this(new Display());
    }

    public String getMode() {
        return mode;
    }

    public void switchDisplayMode() {
        switch (mode) {
            case "decimal":
                mode = "binary";
                break;
            case "binary":
                mode = "octal";
                break;
            case "octal":
                mode = "hexadecimal";
                break;
            default:
                mode = "decimal";
                break;
        }
        System.out.println("Display mode switched to: " + mode);
    }

    public void switchDisplayMode(String newMode) {
        if (newMode == null) {
            System.out.println("Invalid display mode (null).");
            return;
        }

        switch (newMode.toLowerCase()) {
            case "decimal":
            case "binary":
            case "octal":
            case "hexadecimal":
                mode = newMode.toLowerCase();
                System.out.println("Display mode set to: " + mode);
                break;
            default:
                System.out.println("Invalid display mode. Use decimal, binary, octal, or hexadecimal.");
        }
    }

    public String getDisplayString() {
        double value = display.getDisplayValue();

        switch (mode) {
            case "binary":
                return Long.toBinaryString((long) value);
            case "octal":
                return Long.toOctalString((long) value);
            case "hexadecimal":
                return Long.toHexString((long) value).toUpperCase();
            default:
                return String.valueOf(value);
        }
    }
}

package com.zipcodewilmington.scientificcalculator;

public class MemoryCalculator {

    private double memoryValue;
    private final Display display;

    public MemoryCalculator(Display display) {
        this.display = display;
        this.memoryValue = 0.0;
    }

    public MemoryCalculator() {
        this(new Display());
    }

    public double getMemoryValue() {
        return memoryValue;
    }

    public void addToMemory() {
        if (display.isError()) {
            return;
        }
        memoryValue += display.getDisplayValue();
        display.setDisplayValue(memoryValue);
    }

    public void clearMemory() {
        memoryValue = 0.0;
    }

    public void recallMemory() {
        display.setDisplayValue(memoryValue);
    }

    public double getDisplayValue() {
        return display.getDisplayValue();
    }

    public void setDisplayValue(double value) {
        display.setDisplayValue(value);
    }
}
package com.zipcodewilmington.scientificcalculator;

public class Display {

    private double displayValue;
    private boolean error;

    public Display() {
        this.displayValue = 0.0;
        this.error = false;
    }

    public Display(double startingValue) {
        this.displayValue = startingValue;
        this.error = Double.isNaN(startingValue);
    }

    public double getDisplayValue() {
        return error ? Double.NaN : displayValue;
    }

    public void setDisplayValue(double value) {
        this.displayValue = value;
        this.error = Double.isNaN(value);
    }

    public void clear() {
        this.displayValue = 0.0;
        this.error = false;
    }

    public void setError() {
        this.displayValue = Double.NaN;
        this.error = true;
    }

    public void clearError() {
        this.error = false;
        this.displayValue = 0.0;
    }

    public boolean isError() {
        return error || Double.isNaN(displayValue);
    }

    public void setFromOperationResult(double result) {
        if (Double.isNaN(result) || Double.isInfinite(result)) {
            setError();
        } else {
            setDisplayValue(result);
        }
    }

    public String getDisplayString() {
        return isError() ? "Err" : Double.toString(displayValue);
    }
    
public double getValue() {
    return getDisplayValue();
}

public void setValue(double value) {
    setDisplayValue(value);
}
}

package com.zipcodewilmington.scientificcalculator;

public class UnitConversion {
    private Display display;

    public UnitConversion(Display display) {
        this.display = display;
    }

    public void milesToKilometers() {
        double miles = display.getDisplayValue();
        double kilometers = miles * 1.60934;
        display.setDisplayValue(kilometers);
    }

    public void kilometersToMiles() {
        double kilometers = display.getDisplayValue();
        double miles = kilometers / 1.60934;
        display.setDisplayValue(miles);
    }

    public void inchesToCentimeters() {    
        double inches = display.getDisplayValue();
        double centimeters = inches * 2.54; display.setDisplayValue(centimeters);
    }
    
    public void centimetersToInches() {  
        double centimeters = display.getDisplayValue();
        double inches = centimeters / 2.54;  display.setDisplayValue(inches);}
}


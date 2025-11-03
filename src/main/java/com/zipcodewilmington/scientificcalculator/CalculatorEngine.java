package com.zipcodewilmington.scientificcalculator;

public class CalculatorEngine {

    private Display display;
    private ArithmeticCalculator arithmetic;
    private TrigonometricCalculator trig;
    private DisplayModeCalculator displayMode;
    private MemoryCalculator memory;
    private LogarithmicCalculator logarithmic;
    private FactorialCalculator factorial;
    private UnitConversion unitConversion;

    public CalculatorEngine() {
        this.display = new Display();
        this.arithmetic = new ArithmeticCalculator(display);
        this.trig = new TrigonometricCalculator(display);
        this.displayMode = new DisplayModeCalculator(display);
        this.memory = new MemoryCalculator(display);
        this.logarithmic = new LogarithmicCalculator(display);
        this.factorial = new FactorialCalculator(display);
        this.unitConversion = new UnitConversion(display);
    }

    public Display getDisplay() {
        return display;
    }

    public ArithmeticCalculator getArithmetic() {
        return arithmetic;
    }

    public TrigonometricCalculator getTrig() {
        return trig;
    }

    public DisplayModeCalculator getDisplayMode() {
        return displayMode;
    }

    public MemoryCalculator getMemory() {
        return memory;
    }

    public LogarithmicCalculator getLogarithmic() {
        return logarithmic;
    }

    public FactorialCalculator getFactorial() {
        return factorial;
    }

    public UnitConversion getUnitConversion() {
        return unitConversion;
    }
}

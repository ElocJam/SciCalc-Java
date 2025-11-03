package com.zipcodewilmington.scientificcalculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CalculatorEngineIntegrationTest {

    private CalculatorEngine engine;

    @Before
    public void setUp() {
        engine = new CalculatorEngine();
    }

    @Test
    public void testArithmeticIntegration() {
        engine.getArithmetic().setDisplayValue(10);
        engine.getArithmetic().add(5);
        Assert.assertEquals(15.0, engine.getDisplay().getDisplayValue(), 0.0001);
    }

    @Test
    public void testTrigIntegration() {
        engine.getTrig().setDisplayValue(90);
        engine.getTrig().switchUnitsMode("degrees");
        engine.getTrig().sine();
        Assert.assertEquals(1.0, engine.getDisplay().getDisplayValue(), 0.0001);
    }

    @Test
    public void testLogarithmicIntegration() {
        engine.getDisplay().setDisplayValue(100);
        engine.getLogarithmic().log();
        Assert.assertEquals(2.0, engine.getDisplay().getDisplayValue(), 0.0001);
    }

    @Test
    public void testMemoryIntegration() {
        engine.getDisplay().setDisplayValue(5);
        engine.getMemory().addToMemory();
        engine.getDisplay().setDisplayValue(0);
        engine.getMemory().recallMemory();
        Assert.assertEquals(5.0, engine.getDisplay().getDisplayValue(), 0.0001);
    }

    @Test
    public void testFactorialIntegration() {
        engine.getDisplay().setDisplayValue(4);
        engine.getFactorial().factorial();
        Assert.assertEquals(24.0, engine.getDisplay().getDisplayValue(), 0.0001);
    }

    @Test
    public void testDisplayModeIntegration() {
        engine.getDisplayMode().switchDisplayMode("binary");
        Assert.assertEquals("binary", engine.getDisplayMode().getMode());
    }
}

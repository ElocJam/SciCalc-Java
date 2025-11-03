package com.zipcodewilmington.scientificcalculator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TrigonometricCalculatorTest {

    private TrigonometricCalculator trigCalc;

    @Before
    public void setUp() {
        trigCalc = new TrigonometricCalculator();
    }

    // --- Mode Switching ---
    @Test
    public void testDefaultModeIsDegrees() {
        assertEquals("Degrees", trigCalc.getUnitsMode());
    }

    @Test
    public void testSwitchUnitsModeToggles() {
        trigCalc.switchUnitsMode();
        assertEquals("Radians", trigCalc.getUnitsMode());
        trigCalc.switchUnitsMode();
        assertEquals("Degrees", trigCalc.getUnitsMode());
    }

    @Test
    public void testSwitchUnitsModeString() {
        trigCalc.switchUnitsMode("radians");
        assertEquals("Radians", trigCalc.getUnitsMode());
        trigCalc.switchUnitsMode("degrees");
        assertEquals("Degrees", trigCalc.getUnitsMode());
    }

    // --- Sine ---
    @Test
    public void testSineDegrees() {
        trigCalc.setDisplayValue(30);
        trigCalc.sine();
        assertEquals(0.5, trigCalc.getDisplayValue(), 0.0001);
    }

    @Test
    public void testSineRadians() {
        trigCalc.switchUnitsMode("radians");
        trigCalc.setDisplayValue(Math.PI / 2);
        trigCalc.sine();
        assertEquals(1.0, trigCalc.getDisplayValue(), 0.0001);
    }

    // --- Cosine ---
    @Test
    public void testCosineDegrees() {
        trigCalc.setDisplayValue(60);
        trigCalc.cosine();
        assertEquals(0.5, trigCalc.getDisplayValue(), 0.0001);
    }

    @Test
    public void testCosineRadians() {
        trigCalc.switchUnitsMode("radians");
        trigCalc.setDisplayValue(Math.PI);
        trigCalc.cosine();
        assertEquals(-1.0, trigCalc.getDisplayValue(), 0.0001);
    }

    // --- Tangent ---
    @Test
    public void testTangentDegrees() {
        trigCalc.setDisplayValue(45);
        trigCalc.tangent();
        assertEquals(1.0, trigCalc.getDisplayValue(), 0.0001);
    }

    @Test
    public void testTangentRadians() {
        trigCalc.switchUnitsMode("radians");
        trigCalc.setDisplayValue(Math.PI / 4);
        trigCalc.tangent();
        assertEquals(1.0, trigCalc.getDisplayValue(), 0.0001);
    }

    // --- Inverse Sine ---
    @Test
    public void testInverseSineDegrees() {
        trigCalc.setDisplayValue(0.5);
        trigCalc.inverseSine();
        assertEquals(30.0, trigCalc.getDisplayValue(), 0.0001);
    }

    @Test
    public void testInverseSineRadians() {
        trigCalc.switchUnitsMode("radians");
        trigCalc.setDisplayValue(0.5);
        trigCalc.inverseSine();
        assertEquals(Math.PI / 6, trigCalc.getDisplayValue(), 0.0001);
    }

    // --- Inverse Cosine ---
    @Test
    public void testInverseCosineDegrees() {
        trigCalc.setDisplayValue(0.5);
        trigCalc.inverseCosine();
        assertEquals(60.0, trigCalc.getDisplayValue(), 0.0001);
    }

    @Test
    public void testInverseCosineRadians() {
        trigCalc.switchUnitsMode("radians");
        trigCalc.setDisplayValue(0.5);
        trigCalc.inverseCosine();
        assertEquals(Math.PI / 3, trigCalc.getDisplayValue(), 0.0001);
    }

    // --- Inverse Tangent ---
    @Test
    public void testInverseTangentDegrees() {
        trigCalc.setDisplayValue(1.0);
        trigCalc.inverseTangent();
        assertEquals(45.0, trigCalc.getDisplayValue(), 0.0001);
    }

    @Test
    public void testInverseTangentRadians() {
        trigCalc.switchUnitsMode("radians");
        trigCalc.setDisplayValue(1.0);
        trigCalc.inverseTangent();
        assertEquals(Math.PI / 4, trigCalc.getDisplayValue(), 0.0001);
    }

    // --- Edge / Error Handling ---
    @Test
    public void testInvalidInverseSine() {
        trigCalc.setDisplayValue(2.0); // invalid range for sin⁻¹
        trigCalc.inverseSine();
        assertTrue(Double.isNaN(trigCalc.getDisplayValue()));
    }

    @Test
    public void testInvalidInverseCosine() {
        trigCalc.setDisplayValue(-2.0); // invalid range for cos⁻¹
        trigCalc.inverseCosine();
        assertTrue(Double.isNaN(trigCalc.getDisplayValue()));
    }
}


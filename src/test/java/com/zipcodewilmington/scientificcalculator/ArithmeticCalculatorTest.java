package com.zipcodewilmington.scientificcalculator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for ArithmeticCalculator (JUnit 4)
 */

public class ArithmeticCalculatorTest {


    
    private ArithmeticCalculator calc;
    
    @Before
    public void setUp() {
        calc = new ArithmeticCalculator();
    }

    @Test
    public void testAdd() {
        calc.setDisplayValue(10);
        calc.add(5);
        assertEquals(15, calc.getDisplayValue(), 0.0001);
    }

    @Test
    public void testSubtract() {
        calc.setDisplayValue(10);
        calc.subtract(3);
        assertEquals(7, calc.getDisplayValue(), 0.0001);
    }

    @Test
    public void testMultiply() {
        calc.setDisplayValue(4);
        calc.multiply(2.5);
        assertEquals(10, calc.getDisplayValue(), 0.0001);
    }

    @Test
    public void testDivideNormal() {
        calc.setDisplayValue(10);
        calc.divide(2);
        assertEquals(5, calc.getDisplayValue(), 0.0001);
    }

    @Test
    public void testDivideByZero() {
        calc.setDisplayValue(10);
        calc.divide(0);
        assertTrue(Double.isNaN(calc.getDisplayValue()));
    }

    @Test
    public void testSquare() {
        calc.setDisplayValue(3);
        calc.square();
        assertEquals(9, calc.getDisplayValue(), 0.0001);
    }

    @Test
    public void testSquareRoot() {
        calc.setDisplayValue(16);
        calc.squareRoot();
        assertEquals(4, calc.getDisplayValue(), 0.0001);
    }

    @Test
    public void testExponent() {
        calc.setDisplayValue(2);
        calc.exponent(3);
        assertEquals(8, calc.getDisplayValue(), 0.0001);
    }

    @Test
    public void testInverse() {
        calc.setDisplayValue(4);
        calc.inverse();
        assertEquals(0.25, calc.getDisplayValue(), 0.0001);
    }

    @Test
    public void testInverseOfZero() {
        calc.setDisplayValue(0);
        calc.inverse();
        assertTrue(Double.isNaN(calc.getDisplayValue()));
    }

    @Test
    public void testInvertSign() {
        calc.setDisplayValue(5);
        calc.invertSign();
        assertEquals(-5, calc.getDisplayValue(), 0.0001);
    }
}


package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SqrtTest {

    @Test
    public void testSquareRootOfPerfectSquare() {
        Sqrt sqrt = new Sqrt(16.0);
        assertEquals(4.0, sqrt.calc(), 0.000001);
    }

    @Test
    public void testSquareRootOfZero() {
        Sqrt sqrt = new Sqrt(0.0);
        assertEquals(0.0, sqrt.calc(), 0.000001);
    }

    @Test
    public void testSquareRootOfOne() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(1.0, sqrt.calc(), 0.000001);
    }

    @Test
    public void testSquareRootOfSmallDecimal() {
        Sqrt sqrt = new Sqrt(0.25);
        assertEquals(0.5, sqrt.calc(), 0.000001);
    }

    @Test
    public void testSquareRootOfLargeNumber() {
        Sqrt sqrt = new Sqrt(1000000.0);
        assertEquals(1000.0, sqrt.calc(), 0.000001);
    }

    @Test
    public void testSquareRootOfTwo() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrt.calc(), 0.000001);
    }

    @Test
    public void testSquareRootOfNegativeNumber() {
        Sqrt sqrt = new Sqrt(-1.0);
        assertTrue(Double.isNaN(sqrt.calc()));
    }

    @Test
    public void testGoodMethodWithGoodGuess() {
        Sqrt sqrt = new Sqrt(9.0);
        assertTrue(sqrt.good(3.0, 9.0));
    }

    @Test
    public void testGoodMethodWithBadGuess() {
        Sqrt sqrt = new Sqrt(9.0);
        assertFalse(sqrt.good(2.9, 9.0));
    }

    @Test
    public void testImproveMethod() {
        Sqrt sqrt = new Sqrt(16.0);
        // Для guess=2.0 и x=10.0: (2 + 10/2)/2 = (2+5)/2 = 3.5
        assertEquals(3.5, sqrt.improve(2.0, 10.0), 0.000001);
    }

    @Test
    public void testAverageMethod() {
        Sqrt sqrt = new Sqrt(0.0);
        assertEquals(7.5, sqrt.average(5.0, 10.0), 0.000001);
    }

    @Test
    public void testSquareRootOfVerySmallNumber() {
        Sqrt sqrt = new Sqrt(0.000001);
        assertEquals(Math.sqrt(0.000001), sqrt.calc(), 0.000001);
    }

    @Test
    public void testSquareRootOfFractionalNumber() {
        Sqrt sqrt = new Sqrt(2.25);
        assertEquals(1.5, sqrt.calc(), 0.000001);
    }

    @Test
    public void testSquareRootWithCustomDelta() {
        Sqrt sqrt = new Sqrt(9.0);
        sqrt.delta = 0.1;
        assertEquals(3.0, sqrt.calc(), 0.1);
    }

    @Test
    public void testIterativeApproach() {
        Sqrt sqrt = new Sqrt(25.0);
        double result = sqrt.iter(5.1, 25.0);
        assertTrue(Math.abs(result - 5.0) < sqrt.delta);
    }
}
package com.example.kamil.calculator;

import com.example.kamil.calculator.util.SequenceCalculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private SequenceCalculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new SequenceCalculator();
    }

    @Test
    public void calculator_TrivialSequence_Zero() throws Exception {
        assertEquals(calculator.calculate("0"), 0);
    }

    @Test
    public void calculator_TrivialSequence_One() throws Exception {
        assertEquals(calculator.calculate("1"), 1);
    }

    @Test
    public void calculator_SimpleSequence_OnePlusOne() throws Exception {
        assertEquals(calculator.calculate("1 + 1"), 2);
    }

    @Test
    public void calculator_SequenceSizeThree() throws Exception {
        assertEquals(calculator.calculate("1 + 1 + 1"), 3);
    }

    @Test
    public void calculator_SequenceSizeFour() throws Exception {
        assertEquals(calculator.calculate("1 + 1 + 1 + 1"), 4);
    }

    @Test
    public void calculator_SequenceSizeFive() throws Exception {
        assertEquals(calculator.calculate("1 + 1 + 1 + 1 + 1"), 5);
    }

    @Test
    public void calculator_EmptySequence() throws Exception {
        assertEquals(calculator.calculate(""), 0);
    }

    @Test
    public void calculator_ComplicatedSequence1() throws Exception {
        assertEquals(calculator.calculate("1 + 2 * 3"), 7);
    }

    @Test
    public void calculator_ComplicatedSequence2() throws Exception {
        assertEquals(calculator.calculate("2 * 3 + 1"), 7);
    }

    @Test
    public void calculator_ComplicatedSequence3() throws Exception {
        assertEquals(calculator.calculate("2 * 3 + 4 / 2"), 8);
    }

    @Test
    public void calculator_ComplicatedSequence_ExcessSign() throws Exception {
        assertEquals(calculator.calculate("2 * 3 + 4 / 2 / "), 8);
    }

    @Test
    public void calculator_DivisionOneByZero() throws Exception {
        assertEquals(calculator.calculate("1 / 0"), 0);
    }

    @Test
    public void calculator_DivisionZeroByZero() throws Exception {
        assertEquals(calculator.calculate("0 / 0"), 0);
    }

    @Test
    public void calculator_TooBigNumber() throws Exception {
        assertEquals(calculator.calculate("99999999999999999999 + "), 0);
    }
}

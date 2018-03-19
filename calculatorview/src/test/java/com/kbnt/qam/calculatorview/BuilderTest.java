package com.kbnt.qam.calculatorview;

import com.kbnt.qam.calculatorview.util.SequenceBuilder;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuilderTest {

    private SequenceBuilder sequenceBuilder;

    @Before
    public void setUp() throws Exception {
        sequenceBuilder = new SequenceBuilder();
    }

    @Test
    public void empty_OnStart() throws Exception {
        assertEquals(sequenceBuilder.getSequence(), "");
    }

    @Test
    public void empty_OnClear() throws Exception {
        sequenceBuilder.appendNumber("1");
        String result = sequenceBuilder.clear();
        assertEquals(result, "");
        assertEquals(sequenceBuilder.getSequence(), "");
    }

    @Test
    public void appendNoneZeroNumber() throws Exception {
        String result = sequenceBuilder.appendNumber("1");
        assertEquals(result, "1");
        assertEquals(sequenceBuilder.getSequence(), "1");
    }

    @Test
    public void appendZeroNumber() throws Exception {
        String result = sequenceBuilder.appendNumber("0");
        assertEquals(result, "0");
        assertEquals(sequenceBuilder.getSequence(), "0");
    }

    @Test
    public void doNotAppendSecondZeroNumber() throws Exception {
        sequenceBuilder.appendNumber("0");
        String result = sequenceBuilder.appendNumber("0");
        assertEquals(result, "0");
        assertEquals(sequenceBuilder.getSequence(), "0");
    }

    @Test
    public void replaceZeroNumberWithNoneZero() throws Exception {
        sequenceBuilder.appendNumber("0");
        String result = sequenceBuilder.appendNumber("1");
        assertEquals(result, "1");
        assertEquals(sequenceBuilder.getSequence(), "1");
    }

    @Test
    public void appendTwoNoneZeroNumbers() throws Exception {
        sequenceBuilder.appendNumber("1");
        String result = sequenceBuilder.appendNumber("1");
        assertEquals(result, "11");
        assertEquals(sequenceBuilder.getSequence(), "11");
    }

    @Test
    public void appendZeroNumberToNoneZeroNumber() throws Exception {
        sequenceBuilder.appendNumber("1");
        String result = sequenceBuilder.appendNumber("0");
        assertEquals(result, "10");
        assertEquals(sequenceBuilder.getSequence(), "10");
    }

    @Test
    public void appendActionToNoneEmptySequence() throws Exception {
        sequenceBuilder.appendNumber("1");
        String result = sequenceBuilder.appendAction("+");
        assertEquals(result, "1 + ");
        assertEquals(sequenceBuilder.getSequence(), "1 + ");
    }

    @Test
    public void appendActionToEmptySequence() throws Exception {
        String result = sequenceBuilder.appendAction("+");
        assertEquals(result, "0 + ");
        assertEquals(sequenceBuilder.getSequence(), "0 + ");
    }

    @Test
    public void inputSimpleSequence() throws Exception {
        sequenceBuilder.appendNumber("1");
        sequenceBuilder.appendAction("+");
        String result = sequenceBuilder.appendNumber("1");
        assertEquals(result, "1 + 1");
        assertEquals(sequenceBuilder.getSequence(), "1 + 1");
    }


    @Test
    public void inputComplicatedSequence() throws Exception {
        sequenceBuilder.appendNumber("1");
        sequenceBuilder.appendAction("+");
        sequenceBuilder.appendNumber("2");
        sequenceBuilder.appendAction("-");
        sequenceBuilder.appendNumber("3");
        sequenceBuilder.appendAction("*");
        sequenceBuilder.appendNumber("4");
        sequenceBuilder.appendAction("/");
        String result = sequenceBuilder.appendNumber("5");
        assertEquals(result, "1 + 2 - 3 * 4 / 5");
        assertEquals(sequenceBuilder.getSequence(), "1 + 2 - 3 * 4 / 5");
    }


    @Test
    public void replaceLastActionWithNewOne() throws Exception {
        sequenceBuilder.appendNumber("1");
        sequenceBuilder.appendAction("+");
        String result = sequenceBuilder.appendAction("-");
        assertEquals(result, "1 - ");
        assertEquals(sequenceBuilder.getSequence(), "1 - ");
    }

}

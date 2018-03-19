package com.kbnt.qam.calculatorview.util;

public class SequenceBuilder {

    private static final String SPACE = " ";
    private static final String ZERO = "0";
    private static final String EMPTY = "";

    private StringBuilder sequence;

    public SequenceBuilder() {
        sequence = new StringBuilder();
    }

    public String getSequence() {
        return sequence.toString();
    }

    public String appendNumber(String number) {
        if (isNotZero()) {
            sequence.append(number);
        } else {
            sequence = new StringBuilder(number);
        }
        return getSequence();
    }

    public String appendAction(String action) {
        if (isNotEmpty()) {
            if (isNotEndsWithAction()) {
                sequence.append(SPACE).append(action).append(SPACE);
            } else {
                String leftPart = sequence.substring(0, sequence.length() - 3);
                sequence = new StringBuilder(leftPart);
                appendAction(action);
            }
        } else {
            sequence.append(ZERO);
            appendAction(action);
        }
        return getSequence();
    }

    public String clear() {
        sequence = new StringBuilder();
        return getSequence();
    }

    private boolean isNotEmpty() {
        return !EMPTY.equals(sequence.toString());
    }

    private boolean isNotZero() {
        return !ZERO.equals(sequence.toString());
    }

    public boolean isNotEndsWithAction() {
        return !sequence.toString().endsWith(SPACE);
    }
}

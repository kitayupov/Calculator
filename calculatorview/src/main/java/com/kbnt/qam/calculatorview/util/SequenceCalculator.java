package com.kbnt.qam.calculatorview.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SequenceCalculator {

    private static final String ADD = "+";
    private static final String SUB = "-";
    private static final String MUL = "*";
    private static final String DIV = "/";

    public int calculate(String s) {
        List<String> elements = getElements(s);
        return calculateByElements(elements);
    }

    private List<String> getElements(String s) {
        List<String> parts = Arrays.asList(s.split(" "));
        if (parts.size() % 2 == 0) {
            return parts.subList(0, parts.size() - 1);
        } else {
            return parts;
        }
    }

    private int calculateByElements(List<String> list) {
        if (list.size() == 1) {
            return parseNumber(list.get(0));
        }
        int index = getFirstPriorActionIndex(list);
        return calculateByElements(getPartiallyCalculatedElements(list, index));
    }

    private int getFirstPriorActionIndex(List<String> list) {
        int firstMultiSignIndex = list.indexOf(MUL);
        int firstDivideSignIndex = list.indexOf(DIV);
        if (firstMultiSignIndex > 0 && firstDivideSignIndex > 0) {
            return Math.min(firstMultiSignIndex, firstDivideSignIndex);
        } else {
            return Math.max(Math.max(1, firstMultiSignIndex), Math.max(1, firstDivideSignIndex));
        }
    }

    private List<String> getPartiallyCalculatedElements(List<String> list, int index) {
        int element = calculateSimpleSequence(list.get(index - 1), list.get(index), list.get(index + 1));
        List<String> beforeElement = list.subList(0, index - 1);
        List<String> afterElement = list.subList(index + 2, list.size());
        List<String> resultList = new ArrayList<>();
        resultList.addAll(beforeElement);
        resultList.add(String.valueOf(element));
        resultList.addAll(afterElement);
        return resultList;
    }

    private int calculateSimpleSequence(String first, String action, String second) {
        int i1 = parseNumber(first);
        int i2 = parseNumber(second);
        switch (action) {
            case ADD:
                return i1 + i2;
            case SUB:
                return i1 - i2;
            case MUL:
                return i1 * i2;
            case DIV:
                if (i2 == 0) {
                    return 0;
                } else {
                    return i1 / i2;
                }
            default:
                return 0;
        }
    }

    private Integer parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}

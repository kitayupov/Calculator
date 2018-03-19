package com.kbnt.qam.calculatorview.suite;

import com.kbnt.qam.calculatorview.ActionButtonsTest;
import com.kbnt.qam.calculatorview.ButtonsEnabledTest;
import com.kbnt.qam.calculatorview.CalculateSequenceTest;
import com.kbnt.qam.calculatorview.CopyResultToInputTest;
import com.kbnt.qam.calculatorview.NumericButtonsPrintTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ButtonsEnabledTest.class, NumericButtonsPrintTest.class,
        ActionButtonsTest.class, CalculateSequenceTest.class, CopyResultToInputTest.class})
public class CalculatorTestSuite {
}

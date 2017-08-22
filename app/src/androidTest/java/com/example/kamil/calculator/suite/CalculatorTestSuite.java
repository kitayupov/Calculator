package com.example.kamil.calculator.suite;

import com.example.kamil.calculator.ActionButtonsTest;
import com.example.kamil.calculator.ButtonsEnabledTest;
import com.example.kamil.calculator.CalculateSequenceTest;
import com.example.kamil.calculator.CopyResultToInputTest;
import com.example.kamil.calculator.NumericButtonsPrintTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ButtonsEnabledTest.class, NumericButtonsPrintTest.class,
        ActionButtonsTest.class, CalculateSequenceTest.class, CopyResultToInputTest.class})
public class CalculatorTestSuite {
}

package com.example.kamil.calculator;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class NumericButtonsPrintTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void onNumericButtonClick_ResultEqualsButtonValue_test() throws Exception {
        onView(withId(Ui.ONE)).perform(click());
        checkInputMatches("1");
        clickClearButtonAndCheckZeroResult();

        onView(withId(Ui.TWO)).perform(click());
        checkInputMatches("2");
        clickClearButtonAndCheckZeroResult();

        onView(withId(Ui.THREE)).perform(click());
        checkInputMatches("3");
        clickClearButtonAndCheckZeroResult();

        onView(withId(Ui.FOUR)).perform(click());
        checkInputMatches("4");
        clickClearButtonAndCheckZeroResult();

        onView(withId(Ui.FIVE)).perform(click());
        checkInputMatches("5");
        clickClearButtonAndCheckZeroResult();

        onView(withId(Ui.SIX)).perform(click());
        checkInputMatches("6");
        clickClearButtonAndCheckZeroResult();

        onView(withId(Ui.SEVEN)).perform(click());
        checkInputMatches("7");
        clickClearButtonAndCheckZeroResult();

        onView(withId(Ui.EIGHT)).perform(click());
        checkInputMatches("8");
        clickClearButtonAndCheckZeroResult();

        onView(withId(Ui.NINE)).perform(click());
        checkInputMatches("9");
        clickClearButtonAndCheckZeroResult();

        onView(withId(Ui.ZERO)).perform(click());
        checkInputMatches("0");
        clickClearButtonAndCheckZeroResult();
    }

    @Test
    public void onNumericButtonClick_ResultAppendsButtonValue_test() throws Exception {
        onView(withId(Ui.ONE)).perform(click());
        onView(withId(Ui.ONE)).perform(click());
        checkInputMatches("11");
        clickClearButtonAndCheckZeroResult();

        onView(withId(Ui.ONE)).perform(click());
        onView(withId(Ui.TWO)).perform(click());
        checkInputMatches("12");
        clickClearButtonAndCheckZeroResult();

        onView(withId(Ui.ONE)).perform(click());
        onView(withId(Ui.THREE)).perform(click());
        checkInputMatches("13");
        clickClearButtonAndCheckZeroResult();

        onView(withId(Ui.ONE)).perform(click());
        onView(withId(Ui.FOUR)).perform(click());
        checkInputMatches("14");
        clickClearButtonAndCheckZeroResult();

        onView(withId(Ui.ONE)).perform(click());
        onView(withId(Ui.FIVE)).perform(click());
        checkInputMatches("15");
        clickClearButtonAndCheckZeroResult();

        onView(withId(Ui.ONE)).perform(click());
        onView(withId(Ui.SIX)).perform(click());
        checkInputMatches("16");
        clickClearButtonAndCheckZeroResult();

        onView(withId(Ui.ONE)).perform(click());
        onView(withId(Ui.SEVEN)).perform(click());
        checkInputMatches("17");
        clickClearButtonAndCheckZeroResult();

        onView(withId(Ui.ONE)).perform(click());
        onView(withId(Ui.EIGHT)).perform(click());
        checkInputMatches("18");
        clickClearButtonAndCheckZeroResult();

        onView(withId(Ui.ONE)).perform(click());
        onView(withId(Ui.NINE)).perform(click());
        checkInputMatches("19");
        clickClearButtonAndCheckZeroResult();

        onView(withId(Ui.ONE)).perform(click());
        onView(withId(Ui.ZERO)).perform(click());
        checkInputMatches("10");
        clickClearButtonAndCheckZeroResult();
    }

    @Test
    public void replaceZeroWithNumber() throws Exception {
        onView(withId(Ui.ZERO)).perform(click());
        onView(withId(Ui.ONE)).perform(click());
        checkInputMatches("1");
        clickClearButtonAndCheckZeroResult();
    }

    private void checkInputMatches(String text) {
        onView(withId(Ui.INPUT)).check(matches(withText(text)));
    }

    private void clickClearButtonAndCheckZeroResult() {
        onView(withId(Ui.CLEAR)).perform(click());
        checkInputMatches(Ui.EMPTY_INPUT);
    }
}

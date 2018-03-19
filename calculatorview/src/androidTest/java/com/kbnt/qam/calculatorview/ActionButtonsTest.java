package com.kbnt.qam.calculatorview;

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
public class ActionButtonsTest {

    @Rule
    public ActivityTestRule<TestActivity> activityTestRule = new ActivityTestRule<>(TestActivity.class);

    @Test
    public void onActionButtonClick_withoutInputNumber() throws Exception {
        onView(withId(Ui.PLUS)).perform(click());
        checkInputMatches("0 + ");
        checkResultMatches("0");

        onView(withId(Ui.MINUS)).perform(click());
        checkInputMatches("0 - ");
        checkResultMatches("0");

        onView(withId(Ui.MULTIPLY)).perform(click());
        checkInputMatches("0 * ");
        checkResultMatches("0");

        onView(withId(Ui.DIVIDE)).perform(click());
        checkInputMatches("0 / ");
        checkResultMatches("0");

        onView(withId(Ui.CLEAR)).perform(click());
        checkEmptyInput();
        checkEmptyResult();
    }

    @Test
    public void onActionButtonClick_withInputTwoNumbers() throws Exception {
        onView(withId(Ui.ONE)).perform(click());
        onView(withId(Ui.PLUS)).perform(click());
        checkInputMatches("1 + ");
        checkResultMatches("1");
        onView(withId(Ui.TWO)).perform(click());
        checkInputMatches("1 + 2");
        checkResultMatches("1");
        clickClearButtonAndCheckEmptyFields();

        onView(withId(Ui.ONE)).perform(click());
        onView(withId(Ui.MINUS)).perform(click());
        checkInputMatches("1 - ");
        checkResultMatches("1");
        onView(withId(Ui.TWO)).perform(click());
        checkInputMatches("1 - 2");
        checkResultMatches("1");
        clickClearButtonAndCheckEmptyFields();

        onView(withId(Ui.ONE)).perform(click());
        onView(withId(Ui.MULTIPLY)).perform(click());
        checkInputMatches("1 * ");
        checkResultMatches("1");
        onView(withId(Ui.TWO)).perform(click());
        checkInputMatches("1 * 2");
        checkResultMatches("1");
        clickClearButtonAndCheckEmptyFields();

        onView(withId(Ui.ONE)).perform(click());
        onView(withId(Ui.DIVIDE)).perform(click());
        checkInputMatches("1 / ");
        checkResultMatches("1");
        onView(withId(Ui.TWO)).perform(click());
        checkInputMatches("1 / 2");
        checkResultMatches("1");
        clickClearButtonAndCheckEmptyFields();

        onView(withId(Ui.ONE)).perform(click());
        onView(withId(Ui.EQUAL)).perform(click());
        checkInputMatches("1");
        checkResultMatches("1");
        onView(withId(Ui.TWO)).perform(click());
        checkInputMatches("12");
        checkResultMatches("1");
        clickClearButtonAndCheckEmptyFields();
    }

    private void clickClearButtonAndCheckEmptyFields() {
        onView(withId(Ui.CLEAR)).perform(click());
        checkEmptyInput();
        checkEmptyResult();
    }

    private void checkEmptyInput() {
        checkInputMatches(Ui.EMPTY_INPUT);
    }

    private void checkEmptyResult() {
        checkResultMatches(Ui.EMPTY_RESULT);
    }

    private void checkInputMatches(String text) {
        onView(withId(Ui.INPUT)).check(matches(withText(text)));
    }

    private void checkResultMatches(String text) {
        onView(withId(Ui.RESULT)).check(matches(withText(text)));
    }
}

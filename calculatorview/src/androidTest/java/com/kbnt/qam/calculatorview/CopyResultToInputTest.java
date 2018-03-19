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
public class CopyResultToInputTest {

    @Rule
    public ActivityTestRule<TestActivity> activityTestRule = new ActivityTestRule<>(TestActivity.class);

    @Test
    public void copyEmptyResult() throws Exception {
        checkEmptyInput();
        checkEmptyResult();
        onView(withId(Ui.RESULT)).perform(click());
        checkEmptyInput();
        checkEmptyResult();
    }

    @Test
    public void copyNoneEmptyResult() throws Exception {
        onView(withId(Ui.ONE)).perform(click());
        onView(withId(Ui.PLUS)).perform(click());
        onView(withId(Ui.TWO)).perform(click());
        onView(withId(Ui.EQUAL)).perform(click());
        checkInputMatches("1 + 2");
        checkResultMatches("3");

        onView(withId(Ui.RESULT)).perform(click());
        checkInputMatches("3");
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

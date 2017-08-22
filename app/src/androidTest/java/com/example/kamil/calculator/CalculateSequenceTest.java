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
public class CalculateSequenceTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void calculate_SimpleSequence() throws Exception {
        checkEmptyInput();
        onView(withId(Ui.ONE)).perform(click());
        checkInputMatches("1");
        checkEmptyResult();
        onView(withId(Ui.PLUS)).perform(click());
        checkInputMatches("1 + ");
        checkResultMatches("1");
        onView(withId(Ui.TWO)).perform(click());
        checkInputMatches("1 + 2");
        checkResultMatches("1");
        onView(withId(Ui.EQUAL)).perform(click());
        checkInputMatches("1 + 2");
        checkResultMatches("3");
    }

    @Test
    public void calculate_DoubleSequenceSimple() throws Exception {
        checkEmptyInput();
        onView(withId(Ui.ONE)).perform(click());
        checkInputMatches("1");
        checkEmptyResult();
        onView(withId(Ui.PLUS)).perform(click());
        checkInputMatches("1 + ");
        checkResultMatches("1");
        onView(withId(Ui.TWO)).perform(click());
        checkInputMatches("1 + 2");
        checkResultMatches("1");
        onView(withId(Ui.PLUS)).perform(click());
        checkInputMatches("1 + 2 + ");
        checkResultMatches("3");
        onView(withId(Ui.THREE)).perform(click());
        checkInputMatches("1 + 2 + 3");
        checkResultMatches("3");
        onView(withId(Ui.EQUAL)).perform(click());
        checkInputMatches("1 + 2 + 3");
        checkResultMatches("6");
    }

    @Test
    public void calculate_DoubleSequenceWithPrior() throws Exception {
        checkEmptyInput();
        onView(withId(Ui.ONE)).perform(click());
        checkInputMatches("1");
        checkEmptyResult();
        onView(withId(Ui.PLUS)).perform(click());
        checkInputMatches("1 + ");
        checkResultMatches("1");
        onView(withId(Ui.TWO)).perform(click());
        checkInputMatches("1 + 2");
        checkResultMatches("1");
        onView(withId(Ui.MULTIPLY)).perform(click());
        checkInputMatches("1 + 2 * ");
        checkResultMatches("3");
        onView(withId(Ui.THREE)).perform(click());
        checkInputMatches("1 + 2 * 3");
        checkResultMatches("3");
        onView(withId(Ui.EQUAL)).perform(click());
        checkInputMatches("1 + 2 * 3");
        checkResultMatches("7");
    }

    @Test
    public void calculate_TripleSequenceWithSinglePrior() throws Exception {
        checkEmptyInput();
        onView(withId(Ui.ONE)).perform(click());
        checkInputMatches("1");
        checkEmptyResult();
        onView(withId(Ui.PLUS)).perform(click());
        checkInputMatches("1 + ");
        checkResultMatches("1");
        onView(withId(Ui.TWO)).perform(click());
        checkInputMatches("1 + 2");
        checkResultMatches("1");
        onView(withId(Ui.MULTIPLY)).perform(click());
        checkInputMatches("1 + 2 * ");
        checkResultMatches("3");
        onView(withId(Ui.THREE)).perform(click());
        checkInputMatches("1 + 2 * 3");
        checkResultMatches("3");
        onView(withId(Ui.PLUS)).perform(click());
        checkInputMatches("1 + 2 * 3 + ");
        checkResultMatches("7");
        onView(withId(Ui.FOUR)).perform(click());
        checkInputMatches("1 + 2 * 3 + 4");
        checkResultMatches("7");
        onView(withId(Ui.EQUAL)).perform(click());
        checkInputMatches("1 + 2 * 3 + 4");
        checkResultMatches("11");
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

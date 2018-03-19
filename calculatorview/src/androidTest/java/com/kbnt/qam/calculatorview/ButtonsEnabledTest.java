package com.kbnt.qam.calculatorview;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class ButtonsEnabledTest {

    @Rule
    public ActivityTestRule<TestActivity> activityTestRule = new ActivityTestRule<>(TestActivity.class);

    @Test
    public void Buttons_Active_test() throws Exception {
        onView(withId(Ui.ONE)).check(matches(isEnabled()));
        onView(withId(Ui.TWO)).check(matches(isEnabled()));
        onView(withId(Ui.THREE)).check(matches(isEnabled()));
        onView(withId(Ui.FOUR)).check(matches(isEnabled()));
        onView(withId(Ui.FIVE)).check(matches(isEnabled()));
        onView(withId(Ui.SIX)).check(matches(isEnabled()));
        onView(withId(Ui.SEVEN)).check(matches(isEnabled()));
        onView(withId(Ui.EIGHT)).check(matches(isEnabled()));
        onView(withId(Ui.NINE)).check(matches(isEnabled()));
        onView(withId(Ui.ZERO)).check(matches(isEnabled()));
        onView(withId(Ui.PLUS)).check(matches(isEnabled()));
        onView(withId(Ui.MINUS)).check(matches(isEnabled()));
        onView(withId(Ui.MULTIPLY)).check(matches(isEnabled()));
        onView(withId(Ui.DIVIDE)).check(matches(isEnabled()));
        onView(withId(Ui.EQUAL)).check(matches(isEnabled()));
        onView(withId(Ui.CLEAR)).check(matches(isEnabled()));
        onView(withId(Ui.INPUT)).check(matches(isEnabled()));
        onView(withId(Ui.RESULT)).check(matches(isEnabled()));
    }

    @Test
    public void zeroInput_onStart_test() throws Exception {
        onView(withId(Ui.INPUT)).check(matches(withText(Ui.EMPTY_INPUT)));
    }

    @Test
    public void zeroResult_onStart_test() throws Exception {
        onView(withId(Ui.RESULT)).check(matches(withText(Ui.EMPTY_RESULT)));
    }
}

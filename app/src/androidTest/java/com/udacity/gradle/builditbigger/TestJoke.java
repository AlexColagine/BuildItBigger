package com.udacity.gradle.builditbigger;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.BundleMatchers.hasEntry;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtras;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.example.android.displayjoke.DisplayJoke.EXTRA_INTENT;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(AndroidJUnit4.class)
public class TestJoke {

    @Rule
    public IntentsTestRule<MainActivity> mIntentTestRule = new IntentsTestRule<>(MainActivity.class);

    @Test
    public void clickJoke(){

        ViewInteraction buttonJoke = onView(withId(R.id.tell_joke_btn));
        buttonJoke.perform(click());

        intended(hasExtras(hasEntry(equalTo(EXTRA_INTENT), notNullValue())));
    }

}
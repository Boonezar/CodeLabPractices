package com.example.codelabpractices

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withSpinnerText
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CodeLab4Dot1Test {
    @get : Rule
    var mActivityRule = ActivityScenarioRule(CodeLab4Dot1Activity::class.java)

    @Test
    fun spinnerOptions() {
        onView(withId(R.id.fab)).perform(click())

        var options: Array<String> = arrayOf()
        mActivityRule.scenario.onActivity {
            options = it.resources.getStringArray(R.array.labels_array)


        }

        for (option in options) {
            onView(withId(R.id.label_spinner)).perform(click())
            onView(withText(option)).perform(click())
            onView(withId(R.id.label_spinner)).check(matches(withSpinnerText(option)))
        }

    }
}
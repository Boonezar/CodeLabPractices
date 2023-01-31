package com.example.codelabpractices

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.assertEquals
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CodeLab2Dot1Test {
    @get : Rule
    var mActivityRule = ActivityScenarioRule(CodeLab2Dot1Activity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.codelabpractices", appContext.packageName)
    }

    @Test
    fun activityLaunch() {
        onView(withId(R.id.button_main)).perform(click())
        onView(withId(R.id.text_header)).check(matches(isDisplayed()))
        onView(withId(R.id.button_second)).perform(click())
        onView(withId(R.id.text_header_reply)).check(matches(isDisplayed()))
    }

    @Test
    fun textInputOutput() {
        val text = "This is a test."
        onView(withId(R.id.editText_main)).perform(typeText(text))
        onView(withId(R.id.button_main)).perform(click())
        onView(withId(R.id.text_message)).check(matches(withText(text)))
    }
}
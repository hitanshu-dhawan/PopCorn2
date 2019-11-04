package com.hitanshudhawan.popcorn2.ui

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.hitanshudhawan.popcorn2.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoviesFragmentTest {

    @Test
    fun testMoviesFragmentTest() {
        val scenario = launchFragmentInContainer<MoviesFragment>()

        onView(withId(R.id.now_showing_text_view)).check(matches(withText("Now Showing")))
        onView(withId(R.id.popular_text_view)).check(matches(withText("Popular")))
        onView(withId(R.id.upcoming_text_view)).check(matches(withText("Upcoming")))
        onView(withId(R.id.top_rated_text_view)).check(matches(withText("Top Rated")))
    }

}
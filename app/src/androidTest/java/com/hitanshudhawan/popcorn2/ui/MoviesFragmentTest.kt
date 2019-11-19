package com.hitanshudhawan.popcorn2.ui

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.hitanshudhawan.popcorn2.AT_Utils
import com.hitanshudhawan.popcorn2.R
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.KoinTest
import org.koin.test.inject


// link : https://developer.android.com/training/basics/fragments/testing
// link : https://github.com/square/okhttp/issues/3184
@RunWith(AndroidJUnit4::class)
class MoviesFragmentTest : KoinTest {

    val testMockWebServer: MockWebServer by inject()

    @Before
    fun setUp() {
        testMockWebServer.apply {
            dispatcher = object : Dispatcher() {
                override fun dispatch(request: RecordedRequest): MockResponse {
                    when {
                        request.path?.startsWith("/movie/now_playing") == true -> return MockResponse().setResponseCode(200).setBody(AT_Utils.getJson("movies.json"))
                        request.path?.startsWith("/movie/popular") == true -> return MockResponse().setResponseCode(200).setBody(AT_Utils.getJson("movies.json"))
                        request.path?.startsWith("/movie/upcoming") == true -> return MockResponse().setResponseCode(200).setBody(AT_Utils.getJson("movies.json"))
                        request.path?.startsWith("/movie/top_rated") == true -> return MockResponse().setResponseCode(200).setBody(AT_Utils.getJson("movies.json"))
                    }
                    return MockResponse().setResponseCode(404)
                }
            }
            start()
        }
    }

    @After
    fun tearDown() {
        // testMockWebServer.shutdown() // hitanshu : why?
    }

    @Test
    fun testMoviesFragmentTest() {
        val scenario = launchFragmentInContainer<MoviesFragment>()

        onView(withId(R.id.now_showing_text_view)).check(matches(withText("Now Showing")))
        onView(withId(R.id.popular_text_view)).check(matches(withText("Popular")))
        onView(withId(R.id.upcoming_text_view)).check(matches(withText("Upcoming")))
        onView(withId(R.id.top_rated_text_view)).check(matches(withText("Top Rated")))

    }

}
package com.hitanshudhawan.popcorn2.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import com.hitanshudhawan.popcorn2.TestLifecycleOwner
import com.hitanshudhawan.popcorn2.Utils
import com.hitanshudhawan.popcorn2.testModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import java.util.concurrent.Executors

// link : https://github.com/square/okhttp/tree/master/mockwebserver
// link : https://www.reddit.com/r/androiddev/comments/9tux6h/how_to_unit_test_livedata_values_in_our_viewmodels/
// link : https://medium.com/@hanru.yeh/unit-test-retrofit-and-mockwebserver-a3e4e81fd2a2
// link : https://proandroiddev.com/fix-kotlin-and-new-activitytestrule-the-rule-must-be-public-f0c5c583a865
// link : https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-test/
// link : https://medium.com/@hanru.yeh/unit-test-retrofit-and-mockwebserver-a3e4e81fd2a2
// link : https://android.jlelse.eu/unit-test-api-calls-with-mockwebserver-d4fab11de847
// link : https://medium.com/exploring-android/android-architecture-components-testing-your-viewmodel-livedata-70177af89c6e
@RunWith(JUnit4::class)
class MoviesViewModelTest : KoinTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    val testMockWebServer: MockWebServer by inject()

    val testLifecycleOwner: TestLifecycleOwner = TestLifecycleOwner()
    val testMoviesViewModel: MoviesViewModel by inject()

    @Before
    fun setUp() {
        startKoin {
            modules(testModule)
        }

        Dispatchers.setMain(Executors.newSingleThreadExecutor().asCoroutineDispatcher())

        testMockWebServer.apply {
            dispatcher = object : Dispatcher() {
                override fun dispatch(request: RecordedRequest): MockResponse {
                    when {
                        request.path?.startsWith("/movie/now_playing") == true -> return MockResponse().setResponseCode(200).setBody(Utils.getJson("movies.json"))
                        request.path?.startsWith("/movie/popular") == true -> return MockResponse().setResponseCode(200).setBody(Utils.getJson("movies.json"))
                        request.path?.startsWith("/movie/upcoming") == true -> return MockResponse().setResponseCode(200).setBody(Utils.getJson("movies.json"))
                        request.path?.startsWith("/movie/top_rated") == true -> return MockResponse().setResponseCode(200).setBody(Utils.getJson("movies.json"))
                    }
                    return MockResponse().setResponseCode(404)
                }
            }
            start()
        }
    }

    @After
    fun tearDown() {
        stopKoin()

        Dispatchers.resetMain()

        testMockWebServer.shutdown()
    }

    @Test
    fun testMoviesViewModel() {

        testLifecycleOwner.handleEvent(Lifecycle.Event.ON_CREATE)
        testLifecycleOwner.handleEvent(Lifecycle.Event.ON_START)
        testLifecycleOwner.handleEvent(Lifecycle.Event.ON_RESUME)

        testMoviesViewModel.nowShowingMovies.observe(testLifecycleOwner, Observer {})
        // testMoviesViewModel.nowShowingMovies.observeForever {}
        testMoviesViewModel.popularMovies.observe(testLifecycleOwner, Observer {})
        // testMoviesViewModel.popularMovies.observeForever {}
        testMoviesViewModel.upcomingMovies.observe(testLifecycleOwner, Observer {})
        // testMoviesViewModel.upcomingMovies.observeForever {}
        testMoviesViewModel.topRatedMovies.observe(testLifecycleOwner, Observer {})
        // testMoviesViewModel.topRatedMovies.observeForever {}

        while (testMoviesViewModel.nowShowingMovies.value == null);
        while (testMoviesViewModel.popularMovies.value == null);
        while (testMoviesViewModel.upcomingMovies.value == null);
        while (testMoviesViewModel.topRatedMovies.value == null);

        assertEquals(testMoviesViewModel.nowShowingMovies.value?.size, 5)
        assertEquals(testMoviesViewModel.popularMovies.value?.size, 5)
        assertEquals(testMoviesViewModel.upcomingMovies.value?.size, 5)
        assertEquals(testMoviesViewModel.topRatedMovies.value?.size, 5)

    }
}
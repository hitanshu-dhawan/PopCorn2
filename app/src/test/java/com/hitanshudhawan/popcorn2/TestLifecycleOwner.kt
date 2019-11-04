package com.hitanshudhawan.popcorn2

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

// link : https://android.googlesource.com/platform/frameworks/support/+/androidx-master-dev/room/integration-tests/testapp/src/androidTest/java/androidx/room/integration/testapp/test/TestLifecycleOwner.java
// link : https://android.googlesource.com/platform/frameworks/support/+/androidx-master-dev/room/integration-tests/testapp/src/androidTest/java/androidx/room/integration/testapp/test/LiveDataQueryTest.java
class TestLifecycleOwner : LifecycleOwner {

    private val mLifecycle: LifecycleRegistry = LifecycleRegistry(this)

    override fun getLifecycle(): Lifecycle {
        return mLifecycle
    }

    fun handleEvent(event: Lifecycle.Event) {
        mLifecycle.handleLifecycleEvent(event)
    }
}
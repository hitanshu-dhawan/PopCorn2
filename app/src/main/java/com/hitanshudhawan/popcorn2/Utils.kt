package com.hitanshudhawan.popcorn2

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.liveData

// hitanshu : use kotlin libraries available for this
fun Int.toDp(): Int = (this / Resources.getSystem().displayMetrics.density).toInt()

// hitanshu : use kotlin libraries available for this
fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()

// Lives : // link : https://github.com/adibfara/Lives

fun <A, B, Z> zip(first: LiveData<A>, second: LiveData<B>, zipFunction: (A, B) -> Z): LiveData<Z> {
    val finalLiveData: MediatorLiveData<Z> = MediatorLiveData()

    var firstValue: A? = null
    var firstEmitted = false

    var secondValue: B? = null
    var secondEmitted = false

    finalLiveData.addSource(first) { value ->
        firstValue = value
        firstEmitted = true
        if (firstEmitted && secondEmitted) {
            finalLiveData.value = zipFunction(firstValue!!, secondValue!!)
            firstEmitted = false
            secondEmitted = false
        }
    }
    finalLiveData.addSource(second) { value ->
        secondValue = value
        secondEmitted = true
        if (firstEmitted && secondEmitted) {
            finalLiveData.value = zipFunction(firstValue!!, secondValue!!)
            firstEmitted = false
            secondEmitted = false
        }
    }

    return finalLiveData
}

fun <A, B, C, Z> zip(first: LiveData<A>, second: LiveData<B>, third: LiveData<C>, zipFunction: (A, B, C) -> Z): LiveData<Z> {
    val finalLiveData: MediatorLiveData<Z> = MediatorLiveData()

    var firstValue: A? = null
    var firstEmitted = false

    var secondValue: B? = null
    var secondEmitted = false

    var thirdValue: C? = null
    var thirdEmitted = false

    finalLiveData.addSource(first) { value ->
        firstValue = value
        firstEmitted = true
        if (firstEmitted && secondEmitted && thirdEmitted) {
            finalLiveData.value = zipFunction(firstValue!!, secondValue!!, thirdValue!!)
            firstEmitted = false
            secondEmitted = false
            thirdEmitted = false
        }
    }
    finalLiveData.addSource(second) { value ->
        secondValue = value
        secondEmitted = true
        if (firstEmitted && secondEmitted && thirdEmitted) {
            finalLiveData.value = zipFunction(firstValue!!, secondValue!!, thirdValue!!)
            firstEmitted = false
            secondEmitted = false
            thirdEmitted = false
        }
    }
    finalLiveData.addSource(third) { value ->
        thirdValue = value
        thirdEmitted = true
        if (firstEmitted && secondEmitted && thirdEmitted) {
            finalLiveData.value = zipFunction(firstValue!!, secondValue!!, thirdValue!!)
            firstEmitted = false
            secondEmitted = false
            thirdEmitted = false
        }
    }

    return finalLiveData
}

fun <A, B, C, D, Z> zip(first: LiveData<A>, second: LiveData<B>, third: LiveData<C>, fourth: LiveData<D>, zipFunction: (A, B, C, D) -> Z): LiveData<Z> {
    val finalLiveData: MediatorLiveData<Z> = MediatorLiveData()

    var firstValue: A? = null
    var firstEmitted = false

    var secondValue: B? = null
    var secondEmitted = false

    var thirdValue: C? = null
    var thirdEmitted = false

    var fourthValue: D? = null
    var fourthEmitted = false

    finalLiveData.addSource(first) { value ->
        firstValue = value
        firstEmitted = true
        if (firstEmitted && secondEmitted && thirdEmitted && fourthEmitted) {
            finalLiveData.value = zipFunction(firstValue!!, secondValue!!, thirdValue!!, fourthValue!!)
            firstEmitted = false
            secondEmitted = false
            thirdEmitted = false
            fourthEmitted = false
        }
    }
    finalLiveData.addSource(second) { value ->
        secondValue = value
        secondEmitted = true
        if (firstEmitted && secondEmitted && thirdEmitted && fourthEmitted) {
            finalLiveData.value = zipFunction(firstValue!!, secondValue!!, thirdValue!!, fourthValue!!)
            firstEmitted = false
            secondEmitted = false
            thirdEmitted = false
            fourthEmitted = false
        }
    }
    finalLiveData.addSource(third) { value ->
        thirdValue = value
        thirdEmitted = true
        if (firstEmitted && secondEmitted && thirdEmitted && fourthEmitted) {
            finalLiveData.value = zipFunction(firstValue!!, secondValue!!, thirdValue!!, fourthValue!!)
            firstEmitted = false
            secondEmitted = false
            thirdEmitted = false
            fourthEmitted = false
        }
    }
    finalLiveData.addSource(fourth) { value ->
        fourthValue = value
        fourthEmitted = true
        if (firstEmitted && secondEmitted && thirdEmitted && fourthEmitted) {
            finalLiveData.value = zipFunction(firstValue!!, secondValue!!, thirdValue!!, fourthValue!!)
            firstEmitted = false
            secondEmitted = false
            thirdEmitted = false
            fourthEmitted = false
        }
    }

    return finalLiveData
}

// hitanshu : write documentation
suspend fun <T> safe(call: suspend () -> T): T? {
    return try {
        call()
    } catch (e: Exception) {
        null
    }
}

fun <T> resource(
    network: suspend () -> Resource<T> = { Resource.Error() },
    database: suspend () -> Resource<T> = { Resource.Error() },
    save: suspend (T) -> Unit = {}
) = liveData {

    emit(Resource.Loading())

    val resource = network()
    if (resource is Resource.Success) {
        emit(resource)
        save(resource.data)
    } else {
        emit(database())
    }

}

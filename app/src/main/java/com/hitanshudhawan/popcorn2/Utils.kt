package com.hitanshudhawan.popcorn2

import android.content.res.Resources

// hitanshu : use kotlin libraries available for this
fun Int.toDp(): Int = (this / Resources.getSystem().displayMetrics.density).toInt()
fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()
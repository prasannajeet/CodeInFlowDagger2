package com.praszapps.codeinflowdagger2.car

import android.util.Log
import javax.inject.Inject

class Remote @Inject constructor() {

    private companion object val TAG = "Car"

    fun setListener(car: Car) {
        Log.d(TAG, "Remote Connected");
    }
}
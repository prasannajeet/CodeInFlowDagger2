package com.praszapps.codeinflowdagger2.car

import android.util.Log
import javax.inject.Inject

class DieselEngine @Inject constructor(private val horsePower : Int) :
    IEngine {
    override fun start() {
        Log.d("Car", "Diesel Engine started, horsepower: $horsePower")
    }
}
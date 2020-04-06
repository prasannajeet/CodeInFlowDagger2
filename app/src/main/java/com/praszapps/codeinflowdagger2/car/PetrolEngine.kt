package com.praszapps.codeinflowdagger2.car

import android.util.Log
import javax.inject.Inject
import javax.inject.Named

class PetrolEngine @Inject constructor(@Named("horse power") private val horsePower: Int,
                                       @Named("engine capacity") private val engineCapacity: Int) :
    IEngine {
    override fun start() {
        Log.d("Car", "Petrol Engine started, horsepower: $horsePower with capacity $engineCapacity")
    }
}
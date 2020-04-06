package com.praszapps.codeinflowdagger2.car

import android.util.Log
import com.praszapps.codeinflowdagger2.dagger.PerActivity
import javax.inject.Inject
import javax.inject.Named

// If you use all injection types in a class (Constructor, Field, Method). Dagger calls as follows:
// 1. Constructor
// 2. Field
// 3. Method
// In reality you wont combine these 3
@PerActivity
class Car @Inject constructor(private val driver: Driver, private val engine: IEngine) { // Part 6 video - Replaced Engine with IEngine to explain interface injection
    private companion object val TAG: String = "Car"

    @Inject lateinit var wheels: Wheels // Automatically executed unlike in Activity since we do a const injection so rest
    // are automatically injected. If you do field the method is injected automatically.

    // METHOD INJECTION - probably the only good use-case where this can be used.
    // When you pass the injected objected itself to the dependency since we can't do it
    // inside a constructor as instantiation is not yet done
    // Method has to be public for Dagger to call it
    // Usually you dont do method injection in activity
    @Inject
    fun enableRemote(remote: Remote) {
        remote.setListener(this)
    }

    fun drive() {
        engine.start()
        Log.d(TAG, "${driver.getDriverName()} drives $this")
    }
}
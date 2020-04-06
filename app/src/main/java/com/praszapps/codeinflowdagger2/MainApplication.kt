package com.praszapps.codeinflowdagger2

import android.app.Application
import com.praszapps.codeinflowdagger2.dagger.AppComponent
import com.praszapps.codeinflowdagger2.dagger.DaggerAppComponent
import com.praszapps.codeinflowdagger2.dagger.DriverModule

class MainApplication : Application() {

    private lateinit var component : AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.factory().create(DriverModule("Khhhuuuu"))
    }

    // Cannot have get() for lateinit :(
    fun getComponent() : AppComponent = component
}
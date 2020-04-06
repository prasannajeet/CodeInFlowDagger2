package com.praszapps.codeinflowdagger2.dagger

import com.praszapps.codeinflowdagger2.car.Driver
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DriverModule constructor(private val driverName: String) {

    @Singleton
    @Provides
    fun providesDriver() = Driver(driverName)
}
package com.praszapps.codeinflowdagger2.dagger

import com.praszapps.codeinflowdagger2.car.DieselEngine
import com.praszapps.codeinflowdagger2.car.IEngine
import dagger.Module
import dagger.Provides

@Module
class DieselEngineModule (private val horsePower : Int) {

    @Provides
    fun provideHorsePower() = horsePower


    @Provides
    fun provideEngine(engine: DieselEngine) : IEngine = engine
}
package com.praszapps.codeinflowdagger2.dagger

import com.praszapps.codeinflowdagger2.car.IEngine
import com.praszapps.codeinflowdagger2.car.PetrolEngine
import dagger.Binds
import dagger.Module

@Module
abstract class PetrolEngineModule {

    // Optimization for using interface Binds take single arg, the impl for the interface
    // Prefer BindsInstance over @Provides whenever possible
    @Binds
    abstract fun bindEngine(engine: PetrolEngine) : IEngine
}
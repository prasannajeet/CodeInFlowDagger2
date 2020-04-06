package com.praszapps.codeinflowdagger2.dagger

import com.praszapps.codeinflowdagger2.car.Driver
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DriverModule::class])
interface AppComponent {

    // Pass any classes without default constructor Disel
    //fun getActivityComponent(dieselEngineModule: DieselEngineModule) : ActivityComponent

    // For PetrolEngineModule only
    //fun getActivityComponentBuilder() : ActivityComponent.Builder

    fun getActivityComponentFactory() : ActivityComponent.Factory

    // Need to add driver name
    @Component.Factory
    interface Factory {
        fun create(driverModule: DriverModule) : AppComponent
    }
}
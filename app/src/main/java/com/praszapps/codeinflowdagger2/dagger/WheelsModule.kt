package com.praszapps.codeinflowdagger2.dagger

import com.praszapps.codeinflowdagger2.car.Rims
import com.praszapps.codeinflowdagger2.car.Tires
import com.praszapps.codeinflowdagger2.car.Wheels
import dagger.Module
import dagger.Provides

/*
* Modules add objects to the dependency graph if we can't annotate their constructors with @Inject
* or if we need to do config after instantiation
**/
@Module
object WheelsModule {

    @JvmStatic // If Module class doesn't need an instance then call static for performance
    @Provides
    fun provideRims() = Rims()

    @JvmStatic
    @Provides
    fun provideTires() : Tires {
        val tires = Tires()
        tires.inflate() // As no tire is ready without inflation ;)
        return tires
    }

    @JvmStatic
    @Provides
    fun provideWheels(rims: Rims, tires: Tires) =
        Wheels(rims, tires)
}
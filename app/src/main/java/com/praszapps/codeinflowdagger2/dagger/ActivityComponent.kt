package com.praszapps.codeinflowdagger2.dagger

import com.praszapps.codeinflowdagger2.car.Car
import com.praszapps.codeinflowdagger2.MainActivity
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import javax.inject.Named

// Backbone of dagger. Called as injector. Inject in member variables or via a getter
@PerActivity
//@Component(//dependencies = [AppComponent::class],
   // modules = [WheelsModule::class, PetrolEngineModule::class]) // Can't have both engine modules
@Subcomponent(modules = [WheelsModule::class, PetrolEngineModule::class])
// If you use PetrolEngineModule, you need subcomponent builder since PEM doesn't need any runtime args
interface ActivityComponent {
    fun getCar() : Car

    fun inject(activity: MainActivity)

    /*@Subcomponent.Builder // This is a user-defined car component builder
    interface Builder {

        // Good practice is to name all primitive types since we use of a lot of them
        @BindsInstance
        fun horsePower(@Named("horse power")horsePower : Int) : Builder

        @BindsInstance
        fun engineCapacity(@Named("engine capacity") engineCapacity: Int): Builder

        // Not needed for subcomponent builder only dependency
        //fun appComponent(component: AppComponent) : Builder

        fun build() : ActivityComponent // Since we are overriding the builder for component we need to define all method
    }*/

    // Using factory instead of Builder is more concise and adds compile time safety

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance @Named("horse power") horsePower : Int,
                   @BindsInstance @Named("engine capacity") engineCapacity: Int) : ActivityComponent
    }
}
package com.praszapps.codeinflowdagger2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.praszapps.codeinflowdagger2.car.Car
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var car: Car
    // Field injection, can have multiple such fields with one inject() method, fields cannot be private
    // Field injection is for framework types that Android systems instantiates like Activity or Fragments
    // We cant do Constructor injection in Activity/Fragment

    @Inject lateinit var car1: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Constructor injection
        /*val component = DaggerCarComponent.create()
        component.getCar().drive()*/

        // 2. Field Injection.
        //DaggerCarComponent.create().inject(this) // You cannot pass AppCompatActivity or super classes

        // 3. Injecting runtime values like context etc
        // Moving the component class to application class means rotation doesn't destroy objects.
        // Application wide singletons are made this way
        val component = (application as MainApplication).getComponent()
            .getActivityComponentFactory().create(100, 350)
        component.inject(this)
        car.drive()
        car1.drive()
    }
}
/*
* Dependencies mean one class uses object of another class. Class User has Address object, then Address is a
* dependency of User. Picasso uses HTTP class to perform, so HTTP is dependency of Picasso.
*
* Injection means passing dependency from outside, class should not be creating or searching for dependencies.
*
* Passing dependencies in constructor means using class doesn't worry about how they are created, just use it
* as passed. Helps in unit tests as well as it will be easily mocked. Also helps devs work in parallel.
*
* Calling setAdapter on RecyclerView is also a form of adding dependency.
*
*
* */
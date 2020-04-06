package com.praszapps.codeinflowdagger2.car

// Same driver drives multiple cars. Single instance FOR EACH COMPONENT also instance changes during screen rotation
// Assume library class
class Driver constructor(private val name : String) {

    fun getDriverName() = name
}
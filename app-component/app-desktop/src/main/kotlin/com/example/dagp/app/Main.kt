package com.example.dagp.app

import com.example.dagp.library.Greeter
import com.example.dagp.library2.GreeterModel

/**
 * Entry point for the JVM "Desktop" application module.
 * Run it via: ./gradlew :app-component:app-desktop:run
 */
fun main() {
    println(Greeter().greet(GreeterModel.EVENING))
}


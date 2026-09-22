package com.example.dagp.library

/**
 * Platform-specific implementation, provided per Kotlin Multiplatform target
 * (see Platform.android.kt and Platform.desktop.kt).
 */
expect fun platformName(): String

class Greeter {
    fun greet(): String = "Hello from ${platformName()}!"
}


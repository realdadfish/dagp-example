plugins {
    // Applied without a version: the root project's `buildscript` classpath
    // (added for ":app-android"/DAGP, see root build script) already brings
    // Kotlin Gradle Plugin classes onto this project's parent classloader
    // (AGP 9 bundles Kotlin support); requesting an explicit version here
    // would conflict with that. Plain Kotlin/JVM application, no Android/AGP
    // APIs are used in this module.
    id("org.jetbrains.kotlin.jvm")
    application
    // DAGP no longer auto-applies to subprojects (since 2.x); apply explicitly
    // here so this module is analysed as part of ':app-component:buildHealth'.
    alias(libs.plugins.dependencyAnalysis)
}

group = "com.example.dagp"
version = "1.0.0"

kotlin {
    jvmToolchain(21)
}

application {
    mainClass.set("com.example.dagp.app.MainKt")
}

dependencies {
    // Resolved against the "library" module of the "library-component" build
    // via Gradle's composite-build dependency substitution (JVM/"desktop"
    // variant is selected automatically through Gradle attribute matching).
    implementation("com.example.dagp:library:1.0.0")
}



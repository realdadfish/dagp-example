plugins {
    // Applied without a version: the root project's `buildscript` classpath
    // already brings Kotlin Gradle Plugin classes onto the parent
    // classloader (AGP 9 bundles Kotlin support); requesting an explicit
    // version here would conflict with that.
    id("org.jetbrains.kotlin.multiplatform")
    // Applied without a version: resolved via the root project's
    // `buildscript` classpath, so it shares a classloader with DAGP.
    // Dedicated AGP 9.x plugin for KMP library modules with an Android
    // target; replaces 'com.android.library' + 'kotlin.multiplatform' in
    // the same module (which AGP 9 no longer allows).
    id("com.android.kotlin.multiplatform.library")
    // DAGP no longer auto-applies to subprojects (since 2.x); apply explicitly
    // here so this module is analysed as part of ':library-component:buildHealth'.
    alias(libs.plugins.dependencyAnalysis)
}

group = "com.example.dagp"
version = "1.0.0"

kotlin {
    jvmToolchain(21)

    android {
        namespace = "com.example.dagp.library"
        compileSdk = libs.versions.androidCompileSdk.get().toInt()
        minSdk = libs.versions.androidMinSdk.get().toInt()

        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
        }
    }

    jvm("desktop")

    sourceSets {
        getByName("commonMain")
        getByName("androidMain")
        getByName("desktopMain")
    }
}




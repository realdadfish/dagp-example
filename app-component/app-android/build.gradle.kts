plugins {
    // Applied without a version: resolved via the root project's
    // `buildscript` classpath, so it shares a classloader with DAGP.
    // AGP 9's 'com.android.application' plugin has Kotlin support built in;
    // do NOT apply 'org.jetbrains.kotlin.android' separately (conflicts) and
    // do NOT combine with 'org.jetbrains.kotlin.multiplatform' (unsupported
    // since AGP 9.0). This module is therefore a plain Android app.
    id("com.android.application")
    // DAGP no longer auto-applies to subprojects (since 2.x); apply explicitly
    // here so this module is analysed as part of ':app-component:buildHealth'.
    alias(libs.plugins.dependencyAnalysis)
}

group = "com.example.dagp"
version = "1.0.0"

android {
    namespace = "com.example.dagp.app"
    compileSdk = libs.versions.androidCompileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.example.dagp.app"
        minSdk = libs.versions.androidMinSdk.get().toInt()
        targetSdk = libs.versions.androidTargetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
        }
    }
}

dependencies {
    // Resolved against the "library" module of the "library-component" build
    // via Gradle's composite-build dependency substitution.
    implementation("com.example.dagp:library:1.0.0")
  runtimeOnly("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
}





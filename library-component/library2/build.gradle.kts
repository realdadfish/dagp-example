plugins {
    // Applied without a version: see ":library" build script for why.
    id("org.jetbrains.kotlin.multiplatform")
    alias(libs.plugins.androidKmpLibrary)
    alias(libs.plugins.dependencyAnalysis)
}

group = "com.example.dagp"
version = "1.0.0"

kotlin {
    jvmToolchain(21)

    android {
        namespace = "com.example.dagp.library2"
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




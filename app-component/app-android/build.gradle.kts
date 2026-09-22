plugins {
    alias(libs.plugins.androidApplication)
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
    implementation(libs.library)
    runtimeOnly(libs.kotlinx.coroutines.android)
}





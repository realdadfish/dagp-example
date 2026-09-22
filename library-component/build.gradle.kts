buildscript {
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    alias(libs.plugins.androidKmpLibrary) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.dependencyAnalysis)
}

dependencyAnalysis {
    reporting {
        printBuildHealth(true)
    }
    usage {
        analysis {
            checkSuperClasses(shouldCheck = true)
        }
    }
}







plugins {
    alias(libs.plugins.androidApplication) apply false
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




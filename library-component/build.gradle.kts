// Root build script of the "library-component" Gradle build.
//
// AGP is put on the root project's *buildscript* classpath (legacy style),
// rather than resolved via the `plugins { }` DSL in the ":library" module.
// This ensures AGP's classes end up in a classloader that is shared with (a
// parent of) the Dependency Analysis Gradle Plugin (DAGP) below. Without
// this, DAGP fails with "AGP not found on classpath" when it tries to
// analyse an Android module, because plugins resolved independently via the
// `plugins { }` DSL are not guaranteed to share a classloader.
// See: https://github.com/autonomousapps/dependency-analysis-gradle-plugin/issues/93
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${libs.versions.androidGradle.get()}")
    }
}

plugins {
    alias(libs.plugins.dependencyAnalysis)
}







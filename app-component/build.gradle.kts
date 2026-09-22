// Root build script of the "app-component" Gradle build.
//
// AGP is put on the root project's *buildscript* classpath (legacy style),
// rather than resolved via the `plugins { }` DSL in the subprojects. This
// ensures AGP's classes end up in a classloader that is shared with (a
// parent of) the Dependency Analysis Gradle Plugin (DAGP) below. Without
// this, DAGP fails with "AGP not found on classpath" when it tries to
// analyse the ":app-android" module, because plugins resolved independently
// via the `plugins { }` DSL are not guaranteed to share a classloader.
// See: https://github.com/autonomousapps/dependency-analysis-gradle-plugin/issues/93
//
// NOTE: this classpath addition is visible to every subproject of this
// build, including ":app-desktop" (a plain Kotlin/JVM module unrelated to
// Android). ":app-desktop" therefore also applies its Kotlin plugin without
// an explicit version (see its build script) to avoid a "plugin already on
// classpath with unknown version" conflict.
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







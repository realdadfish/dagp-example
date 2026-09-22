plugins {
    id("org.jetbrains.kotlin.jvm")
    application
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
    implementation(libs.library)
}



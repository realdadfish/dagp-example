/*
 * "dagp-example" is a composite build that stitches together two independent
 * Gradle build components:
 *
 *  - app-component      -> contains the ":app" module (Kotlin Multiplatform, Android + JVM Desktop)
 *  - library-component  -> contains the ":library" module (Kotlin Multiplatform, Android + JVM Desktop)
 *
 * Both components apply the Dependency Analysis Gradle Plugin (DAGP) individually.
 * Run `./gradlew :app-component:buildHealth` or `./gradlew :library-component:buildHealth`
 * from this directory to analyse each component's dependencies.
 */
rootProject.name = "dagp-example"

includeBuild("app-component")
includeBuild("library-component")


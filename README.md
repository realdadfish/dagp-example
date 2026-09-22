Some trials to reproduce issues for https://github.com/autonomousapps/dependency-analysis-gradle-plugin/issues/1897

`gradlew -p app-component buildHealth` should list `library2` as transitive dependency that should be declared directly, which it does not.

`gradlew -p library-component buildHealth` lists `library2` as missing transitive dependency for `desktopMain`, even though its part of `commonMain` already.

// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    extra["kotlin_version"] = "1.3.50"
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.5.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${extra["kotlin_version"] as String}")
        classpath("com.dicedmelon.gradle:jacoco-android:0.1.4")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

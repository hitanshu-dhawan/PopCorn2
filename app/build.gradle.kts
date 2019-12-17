import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")

    id("jacoco-android")
}

android {
    compileSdkVersion(29)

    defaultConfig {
        applicationId = "com.hitanshudhawan.popcorn2"
        minSdkVersion(26)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }

    signingConfigs {
        getByName("debug") {
            keyAlias = project.property("keyAlias") as String
            keyPassword = project.property("keyPassword") as String
            storeFile = rootProject.file(project.property("storeFile") as String)
            storePassword = project.property("storePassword") as String
        }
    }

    buildTypes {
        getByName("debug") {
            buildConfigField("String", "API_KEY", project.property("MOVIE_DB_API_KEY") as String)
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    (kotlinOptions as KotlinJvmOptions).apply {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    // dataBinding {
    //     isEnabled = true
    // }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${rootProject.extra["kotlin_version"] as String}")

    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")

    implementation("androidx.navigation:navigation-fragment-ktx:2.1.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.1.0")

    implementation("com.squareup.retrofit2:retrofit:2.6.2")
    implementation("com.squareup.retrofit2:converter-moshi:2.6.2")

    implementation("com.squareup.moshi:moshi:1.9.2")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.9.2")
    implementation("com.squareup.moshi:moshi-adapters:1.8.0")

    // implementation("org.koin:koin-core:2.0.1")
    implementation("org.koin:koin-android:2.0.1")
    implementation("org.koin:koin-android-viewmodel:2.0.1")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0-rc03")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0-rc03")

    // implementation("com.snakydesign.livedataextensions:lives:1.3.0")

    implementation("com.afollestad:recyclical:1.1.1")

    implementation("io.coil-kt:coil:0.8.0")

    testImplementation("junit:junit:4.12")
}

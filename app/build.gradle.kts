plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "com.hitanshudhawan.popcorn2"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "com.hitanshudhawan.popcorn2.MyTestRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    dataBinding {
        isEnabled = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${rootProject.extra["kotlin_version"] as String}")
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.core:core-ktx:1.1.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("androidx.recyclerview:recyclerview:1.0.0")
    implementation("androidx.cardview:cardview:1.0.0")

    implementation("com.squareup.retrofit2:retrofit:2.6.2")
    implementation("com.squareup.retrofit2:converter-moshi:2.6.2")
    implementation("com.squareup.moshi:moshi-kotlin:1.9.1")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.9.1")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.1.0")

    implementation("androidx.lifecycle:lifecycle-extensions:2.1.0")

    implementation("com.github.bumptech.glide:glide:4.10.0")

    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0-rc02")

    debugImplementation("junit:junit:4.12")
    debugImplementation("android.arch.core:core-testing:1.1.1")
    debugImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.2")
    debugImplementation("com.squareup.okhttp3:mockwebserver:4.2.1")

    implementation("org.koin:koin-android:2.0.1")
    implementation("org.koin:koin-android-viewmodel:2.0.1")
    debugImplementation("org.koin:koin-test:2.0.1")

    debugImplementation("androidx.test:runner:1.2.0")
    debugImplementation("androidx.test.espresso:espresso-core:3.2.0")
    debugImplementation("androidx.test.espresso:espresso-contrib:3.2.0")
    debugImplementation("androidx.fragment:fragment-testing:1.1.0")
    debugImplementation("androidx.test.ext:junit:1.1.1")
}

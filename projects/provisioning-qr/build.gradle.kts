plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.androidsamples.provisioningqr"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.androidsamples.provisioningqr"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")

    // ZXing QR Code generator
    implementation("com.google.zxing:core:3.5.2")
    implementation("com.journeyapps:zxing-android-embedded:4.3.0")
}

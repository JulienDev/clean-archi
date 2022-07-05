plugins {
    //can't use constants here
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

addAppVersion()
android {
    defaultConfig {
        vectorDrawables.useSupportLibrary = true
        minSdk = Android.min_sdk
        targetSdk = Android.target_sdk
    }
    compileSdk = Android.compile_sdk
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(Libraries.AndroidX.fragment)
}


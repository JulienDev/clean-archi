plugins {
    //can't use constants here
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

addAppVersion()
android {
    defaultConfig {
        vectorDrawables.useSupportLibrary = true
    }
    compileSdk = Android.compile_sdk
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(Libraries.AndroidX.fragment)
}


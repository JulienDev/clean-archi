plugins {
    id(GradlePlugins.core_android_application)
}

android {
    compileSdk = Android.compile_sdk

    defaultConfig {
        applicationId = "julien.vermet.techtest"
        minSdk = Android.min_sdk
        targetSdk = Android.target_sdk
        multiDexEnabled = true
        resourceConfigurations.addAll(listOf("en"))
    }


    signingConfigs {
        getByName(SigningConfig.debug) {
            storeFile = file(SigningConfig.debug_store_file)
            storePassword = SigningConfig.debug_store_password
            keyAlias = SigningConfig.debug_key_alias
            keyPassword = SigningConfig.debug_key_password
        }
        create(SigningConfig.release)
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard/proguard.pro")
            versionNameSuffix = "-DEBUG}"
            applicationIdSuffix = ".debug"
            signingConfig = signingConfigs.getByName(SigningConfig.debug)
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard/proguard.pro")
            signingConfig = signingConfigs.getByName(SigningConfig.debug)
        }
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }

}

dependencies {
    implementation(project(Modules.presentation))
    implementation(project(Modules.domain))
    implementation(project(Modules.remote))
    implementation(project(Modules.data))
    implementation(project(Modules.designsystem))
    implementation(project(Modules.cache))

    implementation(Libraries.DependencyInjection.koin_android)
}
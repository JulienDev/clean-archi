object Libraries {

    object Language {
        const val kotlin_version = "1.6.21"
        const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
    }

    object AndroidX {
        const val activity = "androidx.activity:activity-ktx:1.4.0"
        const val app_compat = "androidx.appcompat:appcompat:1.4.1"
        const val fragment = "androidx.fragment:fragment-ktx:1.4.1"
        const val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:2.4.2"
        const val navigation_ui = "androidx.navigation:navigation-ui-ktx:2.3.5"
    }

    object Google {
        const val material = "com.google.android.material:material:1.6.1"
    }

    object DependencyInjection {
        private const val koin_version = "3.2.0"
        const val koin_core = "io.insert-koin:koin-core:$koin_version"
        const val koin_android = "io.insert-koin:koin-android:$koin_version"
        const val koin_test = "io.insert-koin:koin-test:$koin_version"
    }

    object Network {
        const val okhttp_bom = "com.squareup.okhttp3:okhttp-bom:4.9.3"
        const val okhttp = "com.squareup.okhttp3:okhttp"
        const val okhttp_logging_interceptor = "com.squareup.okhttp3:logging-interceptor"

        private const val retrofit_version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofit_version"
        const val retrofit_moshi = "com.squareup.retrofit2:converter-moshi:$retrofit_version"
        const val retrofit_rxjava3 = "com.squareup.retrofit2:adapter-rxjava3:$retrofit_version"
    }

    object Reactive {
        const val rxjava3 = "io.reactivex.rxjava3:rxjava:3.1.4"
        const val rxkotlin3 = "io.reactivex.rxjava3:rxkotlin:3.0.1"
        const val rxandroid3 = "io.reactivex.rxjava3:rxandroid:3.0.0"
    }

    object UI {
        const val fragmentviewbindingdelegate = "com.github.Zhuinden:fragmentviewbindingdelegate-kt:1.0.0"
    }

    object Testing {
    }
}

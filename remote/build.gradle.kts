plugins {
    id(GradlePlugins.core_android_library)
}

dependencies {
//    implementation(project(Modules.domain))
//    implementation(Libraries.AndroidX.app_compat)
//    implementation(Libraries.AndroidX.fragment)
//    implementation(Libraries.AndroidX.navigation_fragment)
//    implementation(Libraries.AndroidX.navigation_ui)
//    implementation(Libraries.AndroidX.recyclerview)
//    implementation(Libraries.Google.material)
//    implementation(Libraries.Reactive.rxkotlin3)
//    implementation(Libraries.Reactive.rxandroid3)
//    implementation(Libraries.UI.fragmentviewbindingdelegate)
//    implementation(Libraries.UI.coil)
    implementation(Libraries.DependencyInjection.koin_android)
    implementation(platform(Libraries.Network.okhttp_bom))
    implementation(Libraries.Network.okhttp)
    implementation(Libraries.Network.okhttp_logging_interceptor)
    implementation(Libraries.Network.retrofit)
    implementation(Libraries.Network.retrofit_moshi)
    implementation(Libraries.Network.retrofit_rxjava3)
}
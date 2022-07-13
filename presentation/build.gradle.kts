plugins {
    id(GradlePlugins.core_android_library)
    id(GradlePlugins.navigation_safeargs)
}

dependencies {
    implementation(project(Modules.domain))
    implementation(project(Modules.designsystem))
    implementation(Libraries.AndroidX.app_compat)
    implementation(Libraries.AndroidX.fragment)
    implementation(Libraries.AndroidX.navigation_fragment)
    implementation(Libraries.AndroidX.navigation_ui)
    implementation(Libraries.AndroidX.recyclerview)
    implementation(Libraries.Google.material)
    implementation(Libraries.Reactive.rxkotlin3)
    implementation(Libraries.Reactive.rxandroid3)
    implementation(Libraries.UI.fragmentviewbindingdelegate)
    implementation(Libraries.UI.coil)
    implementation(Libraries.DependencyInjection.koin_android)
}
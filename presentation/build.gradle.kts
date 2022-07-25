plugins {
    id(GradlePlugins.core_android_library)
    id(GradlePlugins.navigation_safeargs)
    id(GradlePlugins.kotlin_parcelize)
}

dependencies {
    implementation(project(Modules.domain))
    implementation(project(Modules.designsystem))
    implementation(Libraries.Language.kotlin_coroutines_core)
    implementation(Libraries.Language.kotlin_coroutines_android)
    implementation(Libraries.AndroidX.app_compat)
    implementation(Libraries.AndroidX.fragment)
    implementation(Libraries.AndroidX.navigation_fragment)
    implementation(Libraries.AndroidX.navigation_ui)
    implementation(Libraries.AndroidX.recyclerview)
    implementation(Libraries.Google.material)
    implementation(Libraries.UI.fragmentviewbindingdelegate)
    implementation(Libraries.UI.coil)
    implementation(Libraries.DependencyInjection.koin_android)

    testImplementation(project(Modules.testing))
    testImplementation(Libraries.Language.kotlin_coroutines_test)
}
plugins {
    id(GradlePlugins.core_android_library)
}

dependencies {
    implementation(Libraries.DependencyInjection.koin_android)
    implementation(Libraries.Language.kotlin_coroutines_core)

    testImplementation(Libraries.Testing.junit)
    testImplementation(Libraries.Testing.mockk)
    testImplementation(Libraries.Language.kotlin_coroutines_test)
}
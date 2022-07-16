plugins {
    id(GradlePlugins.core_android_library)
}

dependencies {
    implementation(Libraries.DependencyInjection.koin_android)
    implementation(Libraries.Reactive.rxjava3)

    testImplementation(Libraries.Testing.junit)
    testImplementation(Libraries.Testing.mockk)
}
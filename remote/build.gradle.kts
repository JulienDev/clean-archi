plugins {
    id(GradlePlugins.core_android_library)
}

dependencies {
    implementation(project(Modules.data))
    implementation(Libraries.DependencyInjection.koin_android)
    implementation(platform(Libraries.Network.okhttp_bom))
    implementation(Libraries.Network.okhttp)
    implementation(Libraries.Network.okhttp_logging_interceptor)
    implementation(Libraries.Network.retrofit)
    implementation(Libraries.Network.retrofit_moshi)
    implementation(Libraries.Network.retrofit_rxjava3)

    testImplementation(Libraries.Testing.junit)
    testImplementation(Libraries.Testing.mockk)
}
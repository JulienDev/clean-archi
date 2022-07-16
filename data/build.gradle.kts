plugins {
    id(GradlePlugins.core_android_library)
}

dependencies {
    implementation(project(Modules.domain))
    implementation(Libraries.DependencyInjection.koin_android)
    implementation(Libraries.Reactive.rxjava3)

    testImplementation(Libraries.Testing.junit)
}
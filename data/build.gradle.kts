plugins {
    id(GradlePlugins.core_android_library)
}

dependencies {
    implementation(project(Modules.domain))
    implementation(project(Modules.common))
    implementation(Libraries.DependencyInjection.koin_android)
    implementation(Libraries.Reactive.rxjava3)

    testImplementation(project(Modules.testing))
}
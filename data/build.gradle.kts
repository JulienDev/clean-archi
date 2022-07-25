plugins {
    id(GradlePlugins.core_android_library)
}

dependencies {
    implementation(project(Modules.domain))
    implementation(Libraries.DependencyInjection.koin_android)
    implementation(Libraries.Language.kotlin_coroutines_core)

    testImplementation(project(Modules.testing))
    testImplementation(Libraries.Language.kotlin_coroutines_test)
}
plugins {
    id(GradlePlugins.core_android_library)
    id(GradlePlugins.kotlin_kapt)
}

dependencies {
    implementation(project(Modules.data))
    implementation(Libraries.DependencyInjection.koin_android)
    implementation(Libraries.AndroidX.room_runtime)
    annotationProcessor(Libraries.AndroidX.room_compiler)
    kapt(Libraries.AndroidX.room_compiler)
    implementation(Libraries.AndroidX.room_coroutines)

    testImplementation(Libraries.Testing.junit)
}
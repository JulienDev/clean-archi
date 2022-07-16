import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id(GradlePlugins.core_android_library)
    id(GradlePlugins.kotlin_kapt)
}

dependencies {
    implementation(project(Modules.data))
    implementation(Libraries.DependencyInjection.koin_android)
    implementation(Libraries.Reactive.rxjava3)
    implementation(Libraries.AndroidX.room_runtime)
    annotationProcessor(Libraries.AndroidX.room_compiler)
    kapt(Libraries.AndroidX.room_compiler)
    implementation(Libraries.AndroidX.room_rxjava3)

    testImplementation(Libraries.Testing.junit)
}
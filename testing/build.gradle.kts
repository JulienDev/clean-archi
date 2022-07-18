plugins {
    id(GradlePlugins.core_android_library)
}

dependencies {
    api(Libraries.AndroidX.lifecycle_runtime_testing)
    api(Libraries.AndroidX.arch_core_testing)
    api(Libraries.Testing.junit)
    api(Libraries.Testing.mockk)
}
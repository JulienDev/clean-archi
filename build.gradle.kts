//// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id(GradlePlugins.core_kotlin_library)
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(GradlePlugins.android_tools_build_with_version)
        classpath(GradlePlugins.kotlin_gradle_plugin_with_version)
        classpath(GradlePlugins.navigation_safeargs_gradle_plugin_with_version)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

dependencies {
    implementation(Libraries.Language.kotlin_stdlib)
}
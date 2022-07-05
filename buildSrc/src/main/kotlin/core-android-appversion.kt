import org.gradle.api.Project

fun Project.addAppVersion() {
    val majorVersion = 1
    val minorVersion = 0
    val patchVersion = 0
    val baseVersionName = "${majorVersion}.${minorVersion}.${patchVersion}"
    val currentVersion = majorVersion * 10000 + minorVersion * 100 + patchVersion

    androidDsl.run {
        defaultConfig {
            versionCode = currentVersion
            versionName = baseVersionName
        }
    }
}
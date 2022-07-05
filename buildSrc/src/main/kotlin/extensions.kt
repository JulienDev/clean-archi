import com.android.build.gradle.BaseExtension
import org.gradle.api.Project

val Project.androidDsl: BaseExtension
    get() = extensions.findByName("android") as? BaseExtension
            ?: error("Not an Android module: $name")
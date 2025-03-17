import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidRetrofitConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("kotlinx-serialization")
            }

            dependencies {
                add("implementation", libs.findBundle("retrofit").get())
                add("implementation", libs.findLibrary("kotlin.serialization.json").get())
            }
        }
    }
} 
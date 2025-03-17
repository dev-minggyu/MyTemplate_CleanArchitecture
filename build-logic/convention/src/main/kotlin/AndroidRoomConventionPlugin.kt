import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidRoomConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("kotlin-kapt")
            }

            dependencies {
                add("implementation", libs.findBundle("room").get())
                add("kapt", libs.findLibrary("room.compiler").get())
                add("annotationProcessor", libs.findLibrary("room.compiler").get())
            }
        }
    }
} 
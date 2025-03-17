import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

/**
 * Configure common android settings for all modules
 */
fun Project.configureAndroid() {
    val android = extensions.getByType<BaseExtension>()
    
    android.apply {
        compileSdkVersion(32)
        
        defaultConfig {
            minSdk = 21
            targetSdk = 32
            
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            consumerProguardFiles("consumer-rules.pro")
        }
        
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
        
        // Kotlin DSL
        (this as org.gradle.api.plugins.ExtensionAware).extensions.configure<org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions>("kotlinOptions") {
            jvmTarget = "1.8"
        }
    }
} 
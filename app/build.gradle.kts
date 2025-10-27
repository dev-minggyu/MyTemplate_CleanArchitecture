plugins {
    id("template.android.application")
}

android {
    namespace = "com.template.app"

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":core:repository"))
    implementation(project(":core:database"))
    implementation(project(":core:network"))
}
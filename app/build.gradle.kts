plugins {
    id("android-application")
    id("mytemplate.android.hilt")
}

android {
    defaultConfig {
        applicationId = "com.example.mytemplate"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

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

    implementation(libs.bundles.androidx.ui)
    implementation(libs.bundles.androidx.ktx)

    // Splash Screen
    implementation(libs.androidx.splash.screen)

    // Leak Canary
    debugImplementation(libs.leakcanary)

    testImplementation(libs.bundles.test.implementation)
    androidTestImplementation(libs.bundles.test.android.implementation)
} 
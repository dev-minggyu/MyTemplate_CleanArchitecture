plugins {
    id("android-library")
    id("mytemplate.android.hilt")
}

android {
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":core:database"))
    implementation(project(":core:network"))
} 
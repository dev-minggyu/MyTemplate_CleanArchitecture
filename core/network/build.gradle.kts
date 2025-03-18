plugins {
    id("mytemplate.android.library")
    id("mytemplate.android.retrofit.plugin")
}

android {
    namespace = "com.example.network"
}

dependencies {
    implementation(project(":domain"))
} 
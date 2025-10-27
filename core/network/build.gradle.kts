plugins {
    id("template.android.library")
    id("template.android.retrofit.plugin")
}

android {
    namespace = "com.template.network"
}

dependencies {
    implementation(project(":domain"))
} 
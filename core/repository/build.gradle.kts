plugins {
    id("mytemplate.android.library")
}

android {
    namespace = "com.example.repository"
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":core:database"))
    implementation(project(":core:network"))
} 
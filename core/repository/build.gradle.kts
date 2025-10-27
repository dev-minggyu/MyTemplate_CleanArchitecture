plugins {
    id("template.android.library")
}

android {
    namespace = "com.template.repository"
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":core:database"))
    implementation(project(":core:network"))
} 
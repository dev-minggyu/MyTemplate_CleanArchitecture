plugins {
    id("template.android.library")
    id("template.android.room.plugin")
}

android {
    namespace = "com.template.database"
}

dependencies {
    implementation(project(":domain"))
} 
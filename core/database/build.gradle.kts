plugins {
    id("mytemplate.android.library")
    id("mytemplate.android.room.plugin")
}

android {
    namespace = "com.example.database"
}

dependencies {
    implementation(project(":domain"))
} 
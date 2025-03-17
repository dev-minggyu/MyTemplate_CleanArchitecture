plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(libs.android.gradle.plugin)
    implementation(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "mytemplate.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "mytemplate.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidHilt") {
            id = "mytemplate.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidRoom") {
            id = "mytemplate.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }
        register("androidRetrofit") {
            id = "mytemplate.android.retrofit"
            implementationClass = "AndroidRetrofitConventionPlugin"
        }
    }
}
plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

dependencies {
    implementation(libs.android.gradle.plugin)
    implementation(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidRoom") {
            id = "template.android.room.plugin"
            implementationClass = "com.template.convention.AndroidRoomPlugin"
        }
        register("androidRetrofit") {
            id = "template.android.retrofit.plugin"
            implementationClass = "com.template.convention.AndroidRetrofitPlugin"
        }
    }
}
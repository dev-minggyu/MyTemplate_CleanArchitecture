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
        register("androidCompose") {
            id = "mytemplate.android.compose.plugin"
            implementationClass = "com.mytemplate.convention.AndroidComposePlugin"
        }
        register("androidHilt") {
            id = "mytemplate.android.hilt.plugin"
            implementationClass = "com.mytemplate.convention.AndroidHiltPlugin"
        }
        register("androidRoom") {
            id = "mytemplate.android.room.plugin"
            implementationClass = "com.mytemplate.convention.AndroidRoomPlugin"
        }
        register("androidRetrofit") {
            id = "mytemplate.android.retrofit.plugin"
            implementationClass = "com.mytemplate.convention.AndroidRetrofitPlugin"
        }
    }
}
plugins {
    `kotlin-dsl`
}

group = "com.example.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
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

// Precompiled script plugins
// 이 부분을 추가하여 precompiled script 플러그인을 등록합니다.
// 이렇게 하면 buildSrc 모듈의 기능을 build-logic 모듈로 통합할 수 있습니다.
kotlin {
    sourceSets.getByName("main").kotlin.srcDir("src/main/kotlin")
} 
pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            from(files("gradle/libs/libs.versions.toml"))
        }
    }
}
rootProject.name = "MyTemplate_CleanArchitecture"
include(":app")
include(":domain")
include(":core")
include(":core:repository")
include(":core:database")
include(":core:network") 
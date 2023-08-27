pluginManagement {
    listOf(repositories, dependencyResolutionManagement.repositories).forEach {
        it.apply {
            google()
            gradlePluginPortal()
            mavenCentral()
            maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
            maven("https://maven.pkg.jetbrains.space/kotlin/p/wasm/experimental")
            maven("https://androidx.dev/storage/compose-compiler/repository")
            maven(url = "https://maven.pkg.jetbrains.space/kotlin/p/kotlin/bootstrap")
        }
    }
}

rootProject.name = "aw-united-talk"

include(":androidApp")
include(":jsApp")
include(":wasmApp")
include(":backendMn")
include(":libShared")

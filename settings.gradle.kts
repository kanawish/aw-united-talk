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

/**
 * Some of the usual 'check android tools versioning' basic links.
 *
 * https://developer.android.com/tools/releases/platforms
 * For the 'upgrade plugin vs minimum gradle version'
 * https://developer.android.com/build/releases/gradle-plugin
 *
 * (All the same but still linking them.)
 * https://mvnrepository.com/artifact/com.android.tools.build/gradle?repo=google
 * https://mvnrepository.com/artifact/com.android.application/com.android.application.gradle.plugin?repo=google
 * https://mvnrepository.com/artifact/com.android.library/com.android.library.gradle.plugin?repo=google
 */
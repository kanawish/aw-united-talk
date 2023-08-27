plugins {
    kotlin("multiplatform")
}

group = "com.kanastruk.united.wasm"
version = "1.0-SNAPSHOT"

// @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
kotlin {
    wasm {
        binaries.executable()
        browser {
        }
    }

    sourceSets {
        val commonMain by getting
        val wasmMain by getting
    }
}

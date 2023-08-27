plugins {
    kotlin("multiplatform")
    id("kotlinx-serialization")
    id("com.android.library")
    id("com.google.devtools.ksp")
}

android {
    compileSdk = AndroidConfig.compileSdkVersion
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = AndroidConfig.minSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
    namespace = "com.kanastruk.united.libShared"
}

kotlin {
    androidTarget()
    jvm()
    js(IR) {
        useCommonJs()
        browser()
    }
    // wasm { browser() } // NOTE: Not yet functional.
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinx.serialization)
                implementation(libs.kotlin.coroutines)
            }
        }
        val androidMain by getting {
            dependencies {
                // ANDROID
                implementation(libs.kotlin.coroutinesPlayServices)

                // Square Networking
                api(libs.google.gson)
                api(libs.square.okhttp3)
                api(libs.square.okhttp3.loggingInterceptor)
                api(libs.square.retrofit)
                api(libs.square.retrofit.converterGson)

                api(libs.timber)

                api(platform("com.google.firebase:firebase-bom:32.2.3"))
                api(libs.firebase.auth)
                api(libs.firebase.analytics)
                api(libs.firebase.crashlytics)
                api(libs.firebase.database)
                api(libs.firebase.firestore)
                api(libs.firebase.perf)
            }
        }
        val jvmMain by getting {
            dependencies {
            }
        }
        val jsMain by getting {
            dependencies {
                // JS
                implementation(libs.kotlinx.html) // "org.jetbrains.kotlinx:kotlinx-html-js:0.8.0")

                implementation(npm("firebase", version = "9.20.0"))
                implementation(devNpm("file-loader", "^6.1.0"))

                implementation(npm("bootstrap", "5.1.3"))
                implementation(npm("bootstrap-icons", "1.7.0"))

                api(libs.jquery.kotlin)

                implementation(npm("jquery", "^3.5.1"))
                implementation(npm("@popperjs/core", "^2.10.2"))

                implementation(libs.font.awesome)
            }
        }


    }
}


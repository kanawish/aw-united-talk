plugins {
    id("com.android.application")

    kotlin("android")
    id("kotlinx-serialization")

    id("com.github.ben-manes.versions")

//    id("com.google.firebase.crashlytics")
//    id("com.google.gms.google-services")
}

kotlin {
    jvmToolchain(17)
}
android {
    namespace = "com.kanastruk.united"

    compileSdk = AndroidConfig.compileSdkVersion

    defaultConfig {
        minSdk = AndroidConfig.minSdkVersion
        targetSdk = AndroidConfig.targetSdkVersion
        versionCode = 1
        versionName = "1.0.0"
        applicationId = "com.kanastruk.united.android"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.androidxComposeCompiler.get()
//        kotlinCompilerExtensionVersion = "1.5.3"
    }
}

dependencies {
    implementation(project(":libShared"))

    implementation(libs.androidx.compose.runtime)

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity.activityKtx)
    debugImplementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.coreKtx)
    implementation(libs.androidx.compose.activity)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.animation)
    implementation(libs.androidx.lifecycle.runtime)

    implementation(libs.kotlinx.serialization)

    implementation(libs.accompanist.permissions)

}

plugins {
    kotlin("js")
    kotlin("plugin.serialization")
}

/*
repositories {
    maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
}
*/

dependencies {
    implementation(kotlin("stdlib-js"))

    implementation(libs.kotlinx.html)
    implementation(libs.kotlinx.serialization)
    implementation(libs.kotlin.coroutines)

    implementation(project.dependencies.enforcedPlatform(libs.kotlin.wrappers.bom))
    implementation(libs.kotlin.wrappers.extensions)

    // Web UI deps
    implementation(npm("bootstrap", "5.1.3"))
    implementation(npm("bootstrap-icons", "1.7.0"))
    api(libs.jquery.kotlin)
    implementation(npm("jquery", "^3.5.1"))
    implementation(npm("@popperjs/core", "^2.10.2"))
    implementation(npm("firebase", version = "9.20.0"))

    implementation(project(":libShared"))
}

kotlin {
    js(IR) {
        browser()
        binaries.executable()
    }
}

//val firebaseHomeDir = "../firebase"
//tasks.register("copyAssemblyToFirebaseHosting", Copy::class){
//    dependsOn("assemble")
//    this.group = "firebase"
//    from("build/distributions") {
//        include("*.js", "*.map", "*.html", "**/*.css", "images/**/*", "json/**/*.json")
//    }
//    into("$firebaseHomeDir/public")
//    doLast {
//        println("Copy is done.")
//    }
//}
//
//tasks.register("firebaseProjectList", Exec::class) {
//    this.group = "firebase"
//    workingDir = File(firebaseHomeDir)
//    commandLine = "firebase projects:list".split(" ")
//}
//
//tasks.register("firebasePublish", Exec::class) {
//    dependsOn("copyAssemblyToFirebaseHosting")
//    this.group = "firebase"
//    workingDir = File(firebaseHomeDir)
//    commandLine = "firebase deploy --only hosting".split(" ")
//}

plugins {
    id("org.jetbrains.kotlin.jvm") // version "1.8.22"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.9.10"
    id("com.google.devtools.ksp") version "1.9.10-1.0.13"
    id("com.github.johnrengelman.shadow")//  version "8.1.1"
    id("io.micronaut.application") version "4.0.2"
    id("io.micronaut.aot") version "4.0.2"
}

version = "0.1"
group = "example.micronaut"

repositories {
    mavenCentral()
}

//kotlinVersion=1.9.10

dependencies {
    ksp("io.micronaut.serde:micronaut-serde-processor")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    implementation(libs.kotlinx.coroutines.reactive)

//    implementation(libs.kotlinx.html)
    implementation(libs.kotlinx.serialization)
    implementation(libs.kotlin.coroutines)
    implementation(libs.kotlin.reflect)
    implementation(libs.kotlin.stdlib.jdk8)

    implementation(project(":libShared"))

    compileOnly("org.graalvm.nativeimage:svm")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
    testImplementation("io.micronaut:micronaut-http-client")
}

application {
    mainClass.set("example.micronaut.ApplicationKt")
}

//java {
//    sourceCompatibility = JavaVersion.toVersion("17")
//}

/*
tasks {
    compileTestKotlin {
        compilerOptions {
            jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17
        }
    }
}
graalvmNative.toolchainDetection = false
*/

micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("example.micronaut.*")
    }
/*
    aot {
        // Please review carefully the optimizations enabled below
        // Check https://micronaut-projects.github.io/micronaut-aot/latest/guide/ for more details
        optimizeServiceLoading = false
        convertYamlToJava = false
        precomputeOperations = true
        cacheEnvironment = true
        optimizeClassLoading = true
        deduceEnvironment = true
        optimizeNetty = true
    }
*/
}

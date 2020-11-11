import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.72" apply true
    kotlin("plugin.serialization") version "1.3.72"
}

group = "io.kraftsman"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
    maven(url = "https://kotlin.bintray.com/kotlinx/")
}

dependencies {
    implementation("com.github.javafaker:javafaker:1.0.2")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.1.0")
    testImplementation(kotlin("test-junit"))
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}
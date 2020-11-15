import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import io.kotless.plugin.gradle.dsl.Webapp.Route53
import io.kotless.plugin.gradle.dsl.kotless

plugins {
    kotlin("jvm") version "1.3.72" apply true
    kotlin("plugin.serialization") version "1.3.72"
    id("io.kotless") version "0.1.6" apply true
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
    implementation("io.kotless", "kotless-lang", "0.1.6")
    testImplementation(kotlin("test-junit"))
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

kotless {
    config {
        bucket = "..."

        terraform {
            profile = "..."
            region = "..."
        }
    }
}

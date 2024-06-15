plugins {
    alias(libs.plugins.kotlin.multiplatform)
    id("org.jetbrains.kotlinx.benchmark") version "0.4.11"
    id("org.jetbrains.kotlin.plugin.allopen") version "2.0.0"
}

allOpen {
    annotation("org.openjdk.jmh.annotations.State")
}

kotlin {
    jvmToolchain(8)
    jvm()
    linuxX64()

    applyDefaultHierarchyTemplate()

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":kotlin-codepoints-deluxe"))
                implementation("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:0.4.11")
            }
        }
    }
}

benchmark {
    targets {
        register("jvm")
        register("linuxX64")
    }
}
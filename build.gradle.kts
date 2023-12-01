import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.20"
}

repositories {
    mavenCentral()
}

dependencies {
    testApi("org.junit.jupiter:junit-jupiter-engine:5.9.1")
    testImplementation("org.assertj:assertj-core:3.23.1")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks {

    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "17"
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }

    test {
        useJUnitPlatform()
    }

    wrapper {
        gradleVersion = "8.5"
    }
}

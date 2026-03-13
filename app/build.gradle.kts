plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    checkstyle
    `maven-publish`
    id("org.sonarqube") version "7.2.3.7755"
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "hexlet.code"
            artifactId = "app"
            version = "1.0"
            from(components["java"])
        }
    }
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // This dependency is used by the application.
    implementation(libs.guava)

    implementation("info.picocli:picocli:4.7.7")

    implementation("com.fasterxml.jackson.core:jackson-databind:2.21.1")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.21.1")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    // Define the main class for the application.
    mainClass = "hexlet.code.App"
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

checkstyle {
    configFile = file("config/checkstyle/checkstyle.xml")
}

sonar {
    properties {
        property("sonar.projectKey", "nnsquik_java-project-71")
        property("sonar.organization", "nesquik")
    }
}

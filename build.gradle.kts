plugins {
    id("java")
    id("io.qameta.allure") version "3.0.2"
}

group = "ru.depedence"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // JUnit 5
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // Selenide
    testImplementation("com.codeborne:selenide:7.14.0")

    // Allure
    testImplementation("io.qameta.allure:allure-selenide:2.33.0")
    testImplementation("io.qameta.allure:allure-junit5:2.33.0")

    // DB for tests
    testImplementation("com.h2database:h2:2.4.240")
}

tasks.test {
    useJUnitPlatform()
}
plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.maven.publish)
}

group = "io.github.ilyadreamix.gapi.core"
version = libs.versions.gapi.get()

repositories {
    mavenCentral()
}

dependencies {
    api(libs.kotlinLogging)
    api(libs.kotlinx.serialization.json)
    api(libs.ktor.client.core)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.client.contentNegotiation)
    implementation(libs.ktor.client.json)
    implementation(libs.ktor.client.logging)
}

afterEvaluate {
    publishing {
        publications.create<MavenPublication>("mavenJava") {
            from(components.findByName("java"))
            groupId = "com.github.ilyadreamix.gapi"
            artifactId = "core"
            version = libs.versions.gapi.get()
        }
    }
}

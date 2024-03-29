plugins {
    id("java-library")
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    implementation(projects.network)
    implementation(projects.features.auth.data)
    implementation(libs.javax.inject)
}
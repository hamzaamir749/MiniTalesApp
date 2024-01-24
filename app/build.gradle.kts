plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    alias(libs.plugins.protobuf)
    kotlin("kapt")
}

android {
    namespace = "dev.belalkhan.minitales"
    defaultConfig {
        applicationId = "dev.belalkhan.minitales"
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String","MINI_TALES_HOST","NOT_AVAILABLE")
        }
        debug {
            buildConfigField("String","MINI_TALES_HOST","\"192.168.80.239\"")
        }
    }

    buildFeatures {
        compose = true
        buildConfig=true
    }
}

dependencies {


    implementation(projects.theme)
    implementation(projects.network)
    implementation(projects.features.auth)
    implementation(projects.features.auth.data)
    implementation(projects.features.auth.domain)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.material3)

    implementation(libs.androidx.compose.navigation)
    implementation(libs.androidx.hilt.compose.navigation)

    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    implementation(libs.ktor.client.core)

    implementation(libs.datastore)
    implementation(libs.protobuf.javalite)

    implementation(libs.timber)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
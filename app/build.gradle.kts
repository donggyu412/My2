import org.jetbrains.kotlin.gradle.internal.Kapt3GradleSubplugin.Companion.isIncludeCompileClasspath

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.android.libraries.mapsplatform.secrets.gradle.plugin)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.checkid"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.checkid"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        javaCompileOptions {
            annotationProcessorOptions {
                isIncludeCompileClasspath()
            }
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    //
    viewBinding  {
        enable = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.runtime.saved.instance.state)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.coordinatorlayout)
    implementation(libs.material)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.preference.ktx)
    implementation(libs.firebase.firestore)
    implementation(libs.play.services.location)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Fragment 관련 dependency
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.fragment.ktx)

    // BottomAppBar 관련 dependency
    implementation(libs.androidx.material3)

    // MPAndroidChart 관련 dependency
    implementation(libs.mpandroidchart)

    // Google Maps 관련 dependency
    // implementation(libs.google.maps)
    implementation(libs.androidx.preference)
    implementation(libs.google.play.services.maps)

    // FireBase 관련 dependency
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.firebase.firestore.ktx)
    implementation(libs.firebase.database)

    // Preferences DataStore 관련 dependency
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.androidx.datastore.preferences.rxjava2)
    implementation(libs.androidx.datastore.preferences.rxjava3)
}

// build.gradle.kts (프로젝트 레벨)

buildscript {
    repositories {
        google()
        mavenCentral()
    }
}




import me.androidbox.buildsrc.Libraries
import me.androidbox.buildsrc.TestLibraries
import me.androidbox.buildsrc.Versions

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Versions.compileSdkVersion)
    buildToolsVersion(Versions.buildToolsVersion)

    defaultConfig {
        applicationId = "me.androidbox.presentation"
        minSdkVersion(Versions.minSdkVersion)
        targetSdkVersion(Versions.targetSdkVersion)
        versionCode = Versions.versionCode
        versionName = Versions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(Libraries.kotlinStdlib)
    implementation(Libraries.coreKtx)
    implementation(Libraries.appCompat)
    implementation(Libraries.constraintLayout)

    /** Third party */
    implementation(Libraries.mapboxAndroidSdk)

    /** Unit testing */
    testImplementation(TestLibraries.junit)

    /** Android testing */
    androidTestImplementation(TestLibraries.espressoCore)
    androidTestImplementation(TestLibraries.androidxJunit)
}

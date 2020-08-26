import me.androidbox.buildsrc.Libraries
import me.androidbox.buildsrc.TestLibraries
import me.androidbox.buildsrc.Versions
import me.androidbox.buildsrc.daggerHilt

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
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

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation(Libraries.kotlinStdlib)
    implementation(Libraries.coreKtx)
    implementation(Libraries.appCompat)
    implementation(Libraries.constraintLayout)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.0")
    implementation("com.google.android.gms:play-services-location:17.0.0")

    /** Third party */
    implementation(Libraries.mapboxAndroidSdk)
    daggerHilt()
    implementation(Libraries.rxPermissions)
    implementation(Libraries.rxjava)
    implementation(Libraries.rxkotlin)
    implementation(Libraries.rxAndroid)
    implementation(Libraries.androidReactiveLocation)

    /** Unit testing */
    testImplementation(TestLibraries.junit)

    /** Android testing */
    androidTestImplementation(TestLibraries.espressoCore)
    androidTestImplementation(TestLibraries.androidxJunit)
}

kapt {
    correctErrorTypes = true
}
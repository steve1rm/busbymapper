package me.androidbox.buildsrc

import me.androidbox.buildsrc.Configuration.IMPLEMENTATION
import me.androidbox.buildsrc.Configuration.KAPT
import org.gradle.api.artifacts.dsl.DependencyHandler

object Plugins {
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.gradleVersion}"
    const val hiltAndroidGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.daggerHiltVersion}"
}

object Configuration {
    const val IMPLEMENTATION = "implementation"
    const val KAPT = "kapt"
}

object Libraries {
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.corektxVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompatVersion}"
    const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.converterGsonVersion}"
    const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val adapterRxjava2 = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofitVersion}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.daggerAndroidVersion}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerAndroidVersion}"
    const val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.daggerAndroidVersion}"
    const val daggerSupport = "com.google.dagger:dagger-android-support:${Versions.daggerAndroidVersion}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpVersion}"
    const val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxjavaVersion}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroidVersion}"
    const val rxkotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxkotlinVersion}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerViewVersion}"
    const val paraceler = "org.parceler:parceler:${Versions.parcelerVersion}"
    const val paracelerApi = "org.parceler:parceler-api:${Versions.parcelerVersion}"
    const val supportTransition = "com.android.support:transition:${Versions.androidLibraryVersion}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleVersion}"
    const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics:${Versions.firebaseCrashlyticsVersion}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomRxJava = "androidx.room:room-rxjava2:${Versions.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timberVersion}"
    const val mapboxAndroidSdk = "com.mapbox.mapboxsdk:mapbox-android-sdk:${Versions.mapboxAndroidSdkVersion}"
    const val daggerHilt = "com.google.dagger:hilt-android:${Versions.daggerHiltVersion}"
    const val daggerHiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerHiltVersion}"
    const val rxPermissions = "com.github.tbruyelle:rxpermissions:${Versions.rxpermissionsVersion}"
    const val androidReactiveLocation = "pl.charmas.android:android-reactive-location2:${Versions.androidReactiveLocation2Version}"
}

fun DependencyHandler.daggerHilt() {
    implementation(Libraries.daggerHilt)
    kapt(Libraries.daggerHiltCompiler)
}

object TestLibraries {
    const val junit = "junit:junit:${Versions.jUnitVersion}"
    const val assertJ = "org.assertj:assertj-core:${Versions.assertJVersion}"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlinVersion}"
    const val mockitoAndroid = "org.mockito:mockito-android:${Versions.mockitoAndroidVersion}"
    const val runner = "androidx.test:runner:${Versions.runnerVersion}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
    const val espressoIntents = "androidx.test.espresso:espresso-intents:${Versions.espressoCoreVersion}"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.mockWebServerVersion}"
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectricVersion}"
    const val androidxJunit = "androidx.test.ext:junit:${Versions.androidxJunitVersion}"
    const val androidxTruth = "androidx.test.ext:truth:${Versions.androidxTruthVersion}"
    const val androidxCore = "androidx.test:core:${Versions.androidxCoreVersion}"
    const val androidxRules = "androidx.test:rules:${Versions.androidxRulesVersion}"
    const val espressoContrib = "com.android.support.test.espresso:espresso-contrib:${Versions.espressoContribVersion}"
    const val okhttp3IdlingResource = "com.jakewharton.espresso:okhttp3-idling-resource:${Versions.okhttp3IdlingResourceVersion}"
    const val idlingConcurrent = "com.android.support.test.espresso.idling:idling-concurrent:${Versions.idlingConcurrentVersion}"
    const val espressoIdlingResource = "androidx.test.espresso:espresso-idling-resource:${Versions.espressoIdlingResourceVersion}"
    const val fragmentTesting = "androidx.fragment:fragment-testing:${Versions.fragmentTestingVersion}"
    const val kakao = "com.agoda.kakao:kakao:${Versions.kakaoVersion}"
    const val coreTesting = "androidx.arch.core:core-testing:${Versions.coreTestingVersion}"
}

private fun DependencyHandler.implementation(dependencyName: String) {
    add(IMPLEMENTATION, dependencyName)
}

private fun DependencyHandler.kapt(dependencyName: String) {
    add(KAPT, dependencyName)
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(me.androidbox.buildsrc.Plugins.androidGradlePlugin)
        classpath(me.androidbox.buildsrc.Plugins.kotlinGradlePlugin)
        classpath(me.androidbox.buildsrc.Plugins.hiltAndroidGradlePlugin)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven {
            url = uri("https://api.mapbox.com/downloads/v2/releases/maven")

            credentials {
                username = "mapbox"
                password = "sk.eyJ1Ijoic3RldmVraXRrYXQiLCJhIjoiY2tjd3c0Zjh6MGk0MDJxcWxybTN0MXhibyJ9.29jyQWgr4XhBMNxRHb1SKg"
            }

            authentication {
                create<BasicAuthentication>("Basic")
            }
        }
        maven {
            url = uri("https://jitpack.io")
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

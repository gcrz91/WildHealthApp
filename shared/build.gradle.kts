import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("com.codingfeline.buildkonfig")
    id("kotlinx-serialization")
}

version = "1.0"

kotlin {
    android()

    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget = when {
        System.getenv("SDK_NAME")?.startsWith("iphoneos") == true -> ::iosArm64
        else -> ::iosX64
    }

    iosTarget("ios") {}

    cocoapods {
        summary = "Handles common MVVM logic to make network requests"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        frameworkName = "shared"
        podfile = project.file("../iosApp/Podfile")
    }
    
    sourceSets {
        all {
            languageSettings.apply {
                optIn("kotlin.RequiresOptIn")
                optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
            }
        }

        val commonMain by getting {
            dependencies {
                with(libs) {
                    implementation(koin.core)
                    implementation(coroutines.core)
                    implementation(bundles.ktor.common)
                }
            }
        }
        val commonTest by getting {
            dependencies {
                with(libs) {
                    implementation(bundles.shared.commonTest)
                }
            }
        }
        val androidMain by getting {
            dependencies {
                with(libs) {
                    implementation(ktor.client.okHttp)
                }
            }
        }

        val androidTest by getting {
            dependencies {
                with(libs) {
                    implementation(libs.bundles.shared.androidTest)
                }
            }
        }
        val iosMain by getting
        val iosTest by getting
    }
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = libs.versions.mindSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

buildkonfig {
    packageName = "com.example.wildhealthapp"
    exposeObjectWithName = "BuildKonfig"
    defaultConfigs {
        buildConfigField(STRING, "apiKey", "Add Api Key")
    }
}
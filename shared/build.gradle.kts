plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
}

version = ConfigData.versionCode

kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }
    
    sourceSets {


        val commonMain by getting {
            dependencies{
                implementation(Ktor.ktorCore)
                implementation(Ktor.ktorOkHttp)
                implementation(Ktor.clientJson)
                implementation(Ktor.clientLogging)
                implementation(Ktor.contentNegotiation)
                implementation(Ktor.json)

                implementation(Koin.koinCore)
                implementation(Koin.koinAndroid)
                implementation(Koin.koinTest)
                implementation(Koin.koinCompose)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies{
                implementation(Ktor.ktorDarwin)
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = ConfigData.compileSdkVersion
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
    }
}
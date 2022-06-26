plugins {
    id("com.android.application")
    kotlin("android")
}



android {
    compileSdk = ConfigData.compileSdkVersion
    defaultConfig {
        applicationId = "com.example.multiplatformapp.android"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_16
        targetCompatibility = JavaVersion.VERSION_16
    }
    kotlinOptions {
        jvmTarget = ConfigData.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = ConfigData.kotlinCompilerExtVersion
    }
}

dependencies {


    implementation(project(":shared"))
    implementation(Compose.composeUi)
    implementation(Compose.composeActivity)
    implementation(Compose.composeMaterial)
    implementation(Compose.composeUiTooling)
    androidTestImplementation(Compose.composeUiTest)
    debugImplementation(Compose.composeDebugUiTooling)

    implementation(Deps.appCompat)
    implementation(Deps.constraint)
   // implementation(Deps.material)

    implementation(Deps.Kotlinx.coroutineCore)
    implementation(Deps.Kotlinx.coroutineAndroid)

    implementation(Koin.koinCore)
    implementation(Koin.koinAndroid)
    implementation(Koin.koinTest)
    implementation(Koin.koinCompose)



}
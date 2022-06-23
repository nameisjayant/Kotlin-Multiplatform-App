object Versions {

    const val composeVersion = "1.1.1"
    const val coroutines = "1.6.1"
    const val material = "1.6.1"
    const val appCompact = "1.4.2"
    const val constraint = "2.1.4"
    const val activityCompose = "1.4.0"
    const val ktorVersion = "2.0.2"
    const val koin = "3.2.0"
    const val kotlin = "1.7.0"
    const val gradle = "7.2.1"
}

object ConfigData{

    const val compileSdkVersion = 32
    const val buildToolsVersion = "30.0.3"
    const val minSdkVersion = 21
    const val targetSdkVersion = 32
    const val versionCode = 1
    const val versionName = "1.0"
    const val jvmTarget = "1.8"
    const val kotlinCompilerExtVersion = "1.0.0-alpha08"

}

object Deps {

    const val material = "com.google.android.material:${Versions.material}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompact}"
    const val constraint = "androidx.constraint's:constraint's:${Versions.constraint}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"

    object Kotlinx {
        val coroutineCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}" }
        val coroutineAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}" }
    }

}

object Compose {


    const val composeUi = "androidx.compose.ui:ui:${Versions.composeVersion}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.composeVersion}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.composeVersion}"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val composeUiTest = "androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}"
    const val composeDebugUiTooling = "androidx.compose.ui:ui-tooling:${Versions.composeVersion}"

}

object Ktor {

    const val ktorCore = "io.ktor:ktor-client-core:${Versions.ktorVersion}"
    const val ktorOkHttp = "io.ktor:ktor-client-okhttp:${Versions.ktorVersion}"
    const val ktorDarwin = "io.ktor:ktor-client-darwin:${Versions.ktorVersion}"
}

object Koin {

    const val koinCore = "io.insert-koin:koin-core:${Versions.koin}"
    const val koinTest = "io.insert-koin:koin-test:${Versions.koin}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koin}"
    const val koinCompose = "io.insert-koin:koin-androidx-compose:${Versions.koin}"

}
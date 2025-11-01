plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.androidx.navigation.safeargs.kotlin) // <-- AÑADIDO
}

android {
    namespace = "com.example.datacash"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.datacash"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    // AÑADIDO: Habilitar ViewBinding
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    // Dependencias base (las que tenías)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.splashscreen)

    // --- DEPENDENCIAS NUEVAS AÑADIDAS ---

    // Arquitectura (ViewModel)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.fragment.ktx)

    // Navegación (Fragments)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // Corrutinas
    implementation(libs.kotlinx.coroutines.android)

    // Networking (Retrofit)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)

    // --- FIN DE DEPENDENCIAS NUEVAS ---

    // Dependencias de Test (las que tenías)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
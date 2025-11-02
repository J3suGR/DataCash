plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.androidx.navigation.safeargs.kotlin)

    // --- AÑADIDO: PLUGIN DE GOOGLE SERVICES (para Firebase) ---
    alias(libs.plugins.google.gms.services)
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
    // Habilitar ViewBinding
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

    // Arquitectura (ViewModel)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.fragment.ktx)

    // Navegación (Fragments)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // Corrutinas
    implementation(libs.kotlinx.coroutines.android)

    // --- (RETROFIT ELIMINADO) ---
    // implementation(libs.retrofit)
    // implementation(libs.retrofit.converter.gson)

    // --- AÑADIDO: LIBRERÍAS DE FIREBASE ---
    // Importa el "BoM" (Bill of Materials) para gestionar las versiones
    implementation(platform(libs.firebase.bom))
    // Dependencia de Autenticación (Login/Registro)
    implementation(libs.firebase.auth.ktx)
    // Dependencia de Base de Datos (Firestore)
    implementation(libs.firebase.firestore.ktx)

    // Dependencias de Test (las que tenías)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
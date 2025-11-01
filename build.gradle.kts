// Top-level build file where you can add configuration options common to all sub-projects/modules.
// En: build.gradle.kts (Project: DataCash)
// NO es el archivo (Module :app)

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.androidx.navigation.safeargs.kotlin) apply false // <-- ¡`apply false` es la clave!
}
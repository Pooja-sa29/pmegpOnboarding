plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.trust.pmegpcustomeronboardingapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.trust.pmegpcustomeronboardingapp"
        minSdk = 29
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildFeatures {
            buildConfig = true
        }
        val encryptionKey: String = providers.gradleProperty("ENCRYPTION_KEY").get()
        buildConfigField("String", "ENCRYPTION_KEY", "\"$encryptionKey\"")
    }

    buildTypes {
        debug {
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
            buildConfigField ("String", "RD_ENV", "\"PP\"")
            buildConfigField ("String", "RD_PACKAGE", "\"in.gov.uidai.facerd.nonprod\"")
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        release {
            isMinifyEnabled = false
            buildConfigField ("String", "RD_ENV", "\"P\"")
            buildConfigField ("String", "RD_PACKAGE", "\"in.gov.uidai.facerd\"")
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
    packagingOptions {
        exclude ("META-INF/DEPENDENCIES")
        exclude ("META-INF/LICENSE")
        exclude ("META-INF/LICENSE.txt")
        exclude ("META-INF/NOTICE")
        exclude ("META-INF/NOTICE.txt")
        exclude ("META-INF/services/javax.xml.parsers.SAXParserFactory")
        exclude ("META-INF/services/javax.xml.parsers.DocumentBuilderFactory")
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.espresso.core)
    implementation(libs.room.external.antlr)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation ("com.squareup.retrofit2:retrofit:2.11.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation ("com.google.mlkit:face-detection:16.1.5")
    implementation ("org.simpleframework:simple-xml:2.7.1")
    implementation ("com.squareup.retrofit2:converter-simplexml:2.9.0")
}
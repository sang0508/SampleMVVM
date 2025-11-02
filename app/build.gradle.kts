plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.sang.mvvmtemplate"
    compileSdk = 36

    buildFeatures {
        viewBinding = true
    }

    defaultConfig {
        applicationId = "com.sang.mvvmtemplate"
        minSdk = 28
        targetSdk = 35
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation("com.squareup.retrofit2:retrofit:2.11.0") // Đồng bộ phiên bản
    implementation("com.google.code.gson:gson:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.squareup.okhttp3:okhttp:4.9.3")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.0")

    //Glide
    implementation("com.github.bumptech.glide:glide:5.0.4")

    // Swipe
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("com.google.android.material:material:1.12.0")

    // Circle indicator
    implementation("me.relex:circleindicator:2.1.6")

    //Lottie
    val lottieVersion = "6.1.0"
    implementation("com.airbnb.android:lottie:$lottieVersion")

    // Navigation
    val nav_version = "2.7.1"
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")

    // ExoPlayer
    implementation ("com.google.android.exoplayer:exoplayer:2.18.7")


    implementation ("com.pierfrancescosoffritti.androidyoutubeplayer:core:13.0.0")

    // Room DB
    val room_version = "2.8.0"
    implementation ("androidx.room:room-runtime:$room_version")
    annotationProcessor ("androidx.room:room-compiler:$room_version") // Cho Java
    implementation ("androidx.room:room-ktx:$room_version") // Hỗ trợ Coroutines
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.0") // Cho viewModelScope

    // RxJava
    implementation ("io.reactivex.rxjava3:rxjava:3.1.8") // RxJava core
    implementation ("io.reactivex.rxjava3:rxandroid:3.0.2") // RxAndroid cho main thread
    implementation ("androidx.room:room-rxjava3:2.6.1")
    implementation ("androidx.room:room-runtime:2.6.1")
    annotationProcessor ("androidx.room:room-compiler:2.6.1")

    // Google Map
    implementation ("com.google.android.gms:play-services-maps:18.2.0")
    implementation ("com.google.android.gms:play-services-location:21.3.0")
    implementation ("com.google.android.libraries.places:places:3.0.0")

    // Firebase
    implementation(platform("com.google.firebase:firebase-bom:34.4.0"))
    implementation("com.google.firebase:firebase-auth") // Không cần version
    implementation("com.google.firebase:firebase-firestore")      // Lưu user
    implementation("com.google.firebase:firebase-storage")

    //Google Sign in
    implementation("androidx.credentials:credentials:1.3.0")
    implementation("androidx.credentials:credentials-play-services-auth:1.3.0")
    implementation("com.google.android.libraries.identity.googleid:googleid:1.1.1")
}
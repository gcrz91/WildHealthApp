buildscript {
    val kotlinVersion = "1.5.30"
    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }

    dependencies {
        val libs = project.extensions.getByType<VersionCatalogsExtension>()
            .named("libs") as org.gradle.accessors.dm.LibrariesForLibs
        classpath(libs.bundles.gradlePlugins)
        classpath(kotlin("gradle-plugin", libs.versions.kotlin.get()))
        classpath(libs.build.konfig)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
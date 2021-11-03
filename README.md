## About

The goal of this application is to be able to get details of your favorite food items nutrition.
It was built with KMM for the shared layer (Api/Network layer, Repository, Response Object, Dependency Injection)

The ViewModel layer and UI were built in Native Android code.
The UI code was written in jetpack Compose.

## Libraries Used

BuildKonfig - create a BuildConfig file in KMM layer for adding build time constants
Koin - Dependency Injection - handles the dependencies needed by our classes without the need of us
tracking it
Ktor Client - Http Client for making network requests
Kotlin Serialization - for parsing Json to data classes
Compose - Dynamically typed UI that uses a new View Tree instead of the legacy xml implementation
Coroutines - For concurrency allowing us to make intensive calls without blocking the main thread


##Special Instruction
Add you api key to the ":shared" build.gradle.kts file inside of the buildKonfig tag


# Jikanime

Jikanime is an Android application that allows users to browse and explore anime details, including trailers, ratings, and descriptions. The app fetches data from the MyAnimeList API using Retrofit and presents it in an intuitive user interface built with traditional Android Views and Activities.

## Features
- View a list of top-rated anime.
- Fetch and display detailed information about selected anime.
- Play anime trailers directly within the app.
- Modern UI using XML-based layouts and Activities.
- Dependency injection using Hilt.
- Kotlin Coroutines for asynchronous operations.
- MVVM architecture pattern.

## Tech Stack
- **Language:** Kotlin
- **UI Framework:** XML-based Views & Activities
- **Networking:** Retrofit + OkHttp
- **Dependency Injection:** Hilt
- **Architecture:** MVVM (Model-View-ViewModel)
- **State Management:** StateFlow

## API Used
The app utilizes the [Jikan API](https://jikan.moe/) to fetch anime data.

## Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/sai-surya-velaga/Jikanime.git
   ```
2. Open the project in Android Studio.
3. Build and run the project on an emulator or a real device.

## How It Works
1. The app fetches a list of top anime using `AnimeRepositoryImpl`.
2. When an anime is selected, details are fetched via the `getAnimeDetails(animeId)` function.
3. The `AnimeDetailsViewModel` processes the data and updates the UI.
4. The trailer is embedded via YouTube WebView.

## Future To-Do's
- Implement a search feature with debounced API calls for efficiency.
- Introduce dark mode with dynamic theming.
- Enhance UI with Material 3 components while keeping performance optimized.
- Improve offline support using WorkManager and local caching.
- Optimize API requests with pagination and efficient data handling.
- Integrate Room Database for caching and local data persistence.
- Implement Jetpack Compose UI for improved maintainability.

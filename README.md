# Jikanime

A native Android application designed for anime discovery, built with a focus on modern architectural patterns and robust data handling. Jikanime interfaces with the MyAnimeList API (via Jikan) to provide a performant, scalable experience for browsing anime metadata and media.

## 🏗️ Architecture & Technical Stack

The project follows **Clean Architecture** principles and the **MVVM** pattern to ensure a separation of concerns and testability.

* **Language:** Kotlin
* **UI Layer:** XML-based Views & Activities with a transition plan toward Jetpack Compose.
* **Asynchronous Logic:** Kotlin Coroutines & StateFlow for reactive, non-blocking data streams.
* **Dependency Injection:** Hilt (Dagger) for modular, maintainable code.
* **Networking:** Retrofit + OkHttp with custom interceptors for API reliability.
* **Media:** YouTube WebView integration for seamless trailer playback.

## 🚀 Key Engineering Features

* **Reactive State Management:** Leverages `StateFlow` to manage UI states, ensuring consistency across configuration changes.
* **Modular Networking:** Centralized API handling using Retrofit, optimized for efficient JSON parsing and error handling.
* **Dependency Injection:** Full Hilt implementation to decouple components and simplify unit testing.
* **Performance Optimization:** Efficient handling of image loading and network requests to minimize memory footprint.

## 🛠️ Installation & Setup

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/sai-surya-velaga/Jikanime.git](https://github.com/sai-surya-velaga/Jikanime.git)
    ```
2.  **Open in Android Studio:** Ensure you are using the latest stable version.
3.  **Sync & Build:** The project uses Kotlin DSL for Gradle. Sync the project to download dependencies.

## 📈 Roadmap

* [ ] **Jetpack Compose Migration:** Modernizing the UI layer for better maintainability.
* [ ] **Local Persistence:** Implementing Room Database for offline-first capabilities.
* [ ] **Advanced Search:** Adding debounced search queries and complex filtering logic.
* [ ] **Pagination:** Implementing the Paging 3 library to handle large datasets efficiently.

---
**[Sai Surya Velaga](https://github.com/sai-surya-velaga)** | Software Engineer III @ Google

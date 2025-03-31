# 🚀 Jetpack Compose + Paging 3 + MVI + Koin

An Android application built with **Jetpack Compose**, **Paging 3**, and **MVI architecture**, featuring **Koin for Dependency Injection** and **Coil for image loading**. This project demonstrates best practices for implementing infinite scrolling with multiple states such as empty list, end of list, and error handling.

---

## 🏗 Tech Stack

- **Language:** Kotlin
- **UI Toolkit:** Jetpack Compose
- **Architecture:** MVI (Model-View-Intent)
- **State Management:** StateFlow, Flow
- **Networking:** Retrofit & Gson
- **Dependency Injection:** Koin
- **Paging:** Paging 3 with Compose integration
- **Image Loading:** Coil
- **Build System:** Gradle with Version Catalog (libs.versions.toml)

---

## 🎯 Features

✅ Jetpack Compose UI with Material Design 3
✅ Paging 3 Implementation for infinite scrolling
✅ Handles various UI states:
- Loading next page
- End of list reached
- Empty list state
- Pagination error handling with retry
  ✅ Uses **Koin** for dependency injection
  ✅ Uses **Coil** for efficient image loading
  ✅ Clean Architecture with **separation of concerns**
  ✅ Implements **MVI Pattern** for better state management

---

## 📸 Screenshots

> Add relevant screenshots here

---

## 🛠️ Setup & Installation

### 1️⃣ Clone the repository
```sh
git clone https://github.com/yourusername/your-repo-name.git
```

### 2️⃣ Open in Android Studio
- Open Android Studio 🏗
- Select **File → Open** and choose the cloned project
- Let Gradle sync the dependencies

### 3️⃣ Run the app 🚀
- Select a device/emulator
- Click **Run ▶**

---

## ⚙️ Project Structure

```
📂 app/
 ├── 📂 di/                   # Koin dependency injection module
 ├── 📂 data/
 │    ├── network/            # Retrofit API Service
 │    ├── models/             # Data models
 │    ├── paging/             # Paging 3 impl
 │    ├── repository/         # Data repository (PagingSource)
 ├── 📂 ui/
 │    ├── components/         # Reusable Compose UI components
 │    ├── screens/            # Main screen with paging implementation
 │    ├── theme/              # Main screen with paging implementation
 ├── 📄 MainActivity.kt       # Entry point of the app
 ├── 📄 App.kt       # Main App class
```

---

## 🔗 API Reference

This project uses the **Rick and Morty API** for fetching character data.

- Base URL: [https://rickandmortyapi.com/api/](https://rickandmortyapi.com/api/)
- Endpoint Example: `/character?page=1`

---

## 📜 License

This project is released under the **MIT License**. Feel free to modify and use it as per your needs.

---

## 🙌 Contribution

🔹 Fork the repo
🔹 Create a new branch (`feature-branch`)
🔹 Commit your changes
🔹 Push to your branch
🔹 Open a **Pull Request** 🚀

---

## ✨ Credits

Developed by **[Your Name](https://github.com/yourusername)** 😊


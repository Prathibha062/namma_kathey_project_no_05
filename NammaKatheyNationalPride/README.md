# 📖 Namma Kathey – Karnataka Heritage App

## 🌟 About the Project

Namma Kathey is an Android application created to make learning Karnataka’s history more interesting and interactive. Instead of reading long textbook paragraphs, users can explore stories of kings, freedom fighters, poets, saints, and cultural icons in a simple and engaging way.

The app focuses on district-wise historical personalities of Karnataka and presents their stories in both English and Kannada. Along with stories, users can attempt quizzes, earn badges, listen to audio narrations, and explore heritage-related information.

The main idea behind this project is to preserve Karnataka’s cultural heritage digitally and encourage students and young users to learn regional history through technology.

---

# ✨ Features

## 🏛️ Hero Exploration

* Browse heroes district-wise across Karnataka.
* View hero images, descriptions, and detailed stories.
* Separate pages for long stories.

## 🌐 Bilingual Support

* English and Kannada language support.
* Dynamic language switching.

## 🧠 Interactive Quizzes

* Multiple-choice quiz for every hero.
* Score calculation after quiz completion.
* Badge reward system.

## 🏅 Badge System

* Earn badges after successfully completing quizzes.
* Badge count visible in profile section.

## 👤 User Profile

* Stores user name and phone number.
* Displays earned badges.

## 🔊 Audio Support

* Hero narration audio support.
* Audio automatically stops when user exits screen.

## 📍 Statue Location

* Statue/place information for each hero.
* Coordinates available for future location-based features.

---

# 🛠️ Technologies Used

* Kotlin
* Jetpack Compose
* Android Studio
* JSON-based local storage
* Material 3 UI

---

# 📂 Project Structure

```
app
 ┣ src
 ┃ ┣ main
 ┃ ┃ ┣ assets
 ┃ ┃ ┃ ┣ hero.json
 ┃ ┃ ┃ ┗ quiz.json
 ┃ ┃
 ┃ ┃ ┣ java
 ┃ ┃ ┃ ┗ com.kathey.nammakathey
 ┃ ┃ ┃
 ┃ ┃ ┃ ┣ data
 ┃ ┃ ┃ ┃ ┣ heroBadgeManager.kt
 ┃ ┃ ┃ ┃ ┣ HeroJsonHelper.kt
 ┃ ┃ ┃ ┃ ┣ PreferenceManager.kt
 ┃ ┃ ┃ ┃ ┣ QuizJsonHelper.kt
 ┃ ┃ ┃ ┃ ┗ UserManager.kt
 ┃ ┃ ┃
 ┃ ┃ ┃ ┣ frontend
 ┃ ┃ ┃ ┃ ┣ DistrictHeroesScreen.kt
 ┃ ┃ ┃ ┃ ┣ heroBadgeScreen.kt
 ┃ ┃ ┃ ┃ ┣ heroQuizScreen.kt
 ┃ ┃ ┃ ┃ ┣ heroStoryScreen.kt
 ┃ ┃ ┃ ┃ ┣ homePage.kt
 ┃ ┃ ┃ ┃ ┣ loginPage.kt
 ┃ ┃ ┃ ┃ ┣ MainAppScreen.kt
 ┃ ┃ ┃ ┃ ┣ statueLocatorScreen.kt
 ┃ ┃ ┃ ┃ ┗ userProfileScreen.kt
 ┃ ┃ ┃
 ┃ ┃ ┃ ┣ model
 ┃ ┃ ┃ ┃ ┣ Hero.kt
 ┃ ┃ ┃ ┃ ┗ QuizQuestion.kt
 ┃ ┃ ┃
 ┃ ┃ ┃ ┣ ui.theme
 ┃ ┃ ┃ ┃ ┣ Color.kt
 ┃ ┃ ┃ ┃ ┣ Theme.kt
 ┃ ┃ ┃ ┃ ┗ Type.kt
 ┃ ┃ ┃
 ┃ ┃ ┃ ┗ MainActivity.kt
 ┃ ┃
 ┃ ┃ ┣ res
 ┃ ┃ ┃ ┣ drawable
 ┃ ┃ ┃ ┣ mipmap
 ┃ ┃ ┃ ┗ values
 ┃ ┃
 ┃ ┃ ┗ AndroidManifest.xml
 ┗ ui.theme
```

---

# 📱 Main Screens

## 🏠 Home Screen

* District selection
* Language toggle
* Hero cards

## 📖 Hero Detail Screen

* Hero image
* Story pages
* Audio playback
* Statue details

## ❓ Quiz Screen

* Multiple-choice questions
* Score tracking
* Next button navigation

## 🏅 Badge Screen

* Displays earned badge
* Shows quiz score
* Badge count

## 👤 Profile Screen

* User information
* Earned badges list
* Back navigation

---

# 📦 JSON Structure

## Hero JSON Example

```json
{
  "nameEnglish": "Rani Abbakka",
  "districtEnglish": "Mangaluru",
  "storyEnglishPage1": "...",
  "storyEnglishPage2": "..."
}
```

## Quiz JSON Example

```json
{
  "heroName": "Rani Abbakka",
  "questionEnglish": "Who did Rani Abbakka fight against?",
  "optionsEnglish": ["Portuguese", "British"],
  "correctAnswerEnglish": "Portuguese"
}
```

---

# 🔍 Application Workflow

1. User opens the application.
2. Login/Profile information is collected.
3. User selects preferred language.
4. District-wise heroes are displayed.
5. User opens hero detail page.
6. Story content is shown page-wise.
7. Audio narration can be played.
8. User attends quiz related to the hero.
9. Score is calculated after quiz completion.
10. Badge is awarded for successful completion.
11. Earned badges are visible in profile section.

---

# 🎨 User Interface Design

The application uses a modern and colorful Material 3 based user interface designed using Jetpack Compose.

### UI Highlights

* Rounded cards and buttons
* Vibrant purple-themed color palette
* Smooth layout structure
* Simple navigation flow
* Bilingual text rendering
* Mobile-friendly responsive design

The design was intentionally kept simple and engaging so that users from different age groups can use the app comfortably.

---

# 📚 Educational Importance

Karnataka has a rich cultural and historical background, but many students and young users are not fully aware of regional heroes and historical personalities. This application attempts to solve that problem by presenting information in a digital and interactive format.

Instead of traditional learning methods, the app combines storytelling, quizzes, and rewards to create a more engaging educational experience.

The project also helps promote:

* Regional history awareness
* Kannada language appreciation
* Digital learning methods
* Interactive education
* Heritage preservation

---

# ⚙️ Core Functionalities

## Language Switching

Users can instantly switch between English and Kannada throughout the application.

## Local JSON Storage

All hero and quiz data are stored locally using JSON files inside the assets folder, allowing the application to work offline.

## Badge Tracking

The application maintains a badge system where completed quizzes reward the user with achievement badges.

## Story Navigation

Long stories are divided into multiple pages for better readability.

## Audio Narration

Users can listen to hero stories through audio narration support.

## Navigation System

The application uses screen-based navigation and bottom navigation components for a smooth user experience.

---

# 🧪 Testing and Debugging

The application was tested on Android Studio emulator as well as physical Android devices.

Testing included:

* UI responsiveness
* Quiz functionality
* Language switching
* Audio playback
* Badge generation
* Navigation flow
* JSON data loading

Errors related to Gradle sync, resource linking, and package refactoring were identified and resolved during development.

---

# 📈 Advantages of the Project

* Firebase Authentication
* User progress sync
* GPS-based nearest statue feature
* Leaderboard system
* Achievement animations
* Dark mode support
* Offline downloadable audio

---

# ▶️ How to Run the Project

1. Open project in Android Studio.
2. Allow Gradle Sync.
3. Connect emulator or Android device.
4. Click Run ▶️.
5. App launches successfully.

---

# 🎯 Educational Objective

The objective of this project is to digitally preserve and promote Karnataka’s cultural heritage using modern Android development technologies. The app encourages students and users to learn regional history interactively through storytelling and quizzes.

---

# 👩‍💻 Developed Using

* Android Studio
* Kotlin
* Jetpack Compose
* Material 3

---

# 📜 License

This project is developed for educational and learning purposes.

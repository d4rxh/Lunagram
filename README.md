<p align="center">
  <img src="icon.png" alt="Lunagram Logo" width="128" height="128" style="border-radius: 28px; box-shadow: 0 10px 30px rgba(215, 25, 32, 0.35);" />
</p>

<h1 align="center">Lunagram</h1>

<p align="center">
  <b>A modern, high-performance, and privacy-hardened Telegram client for Android.</b><br>
  <i>Infused with Nothing OS 3.0 industrial minimalism, authentic Nothing Glyph Interface hardware lighting, and tactile micro-haptics.</i>
</p>

<p align="center">
  <a href="https://github.com/d4rxh/Lunagram/releases/latest"><img src="https://img.shields.io/github/v/release/d4rxh/Lunagram?style=for-the-badge&color=D71920&logo=android&logoColor=white" alt="Latest Version"></a>
  <a href="https://github.com/d4rxh/Lunagram/actions/workflows/build.yml"><img src="https://img.shields.io/github/actions/workflow/status/d4rxh/Lunagram/build.yml?style=for-the-badge&label=CI%20Build&color=00c853&logo=githubactions&logoColor=white" alt="CI Status"></a>
  <a href="https://github.com/d4rxh/Lunagram/blob/main/LICENSE"><img src="https://img.shields.io/badge/License-GPLv2-0070F3?style=for-the-badge" alt="License"></a>
  <a href="https://t.me/LunaGram_Updates"><img src="https://img.shields.io/badge/Telegram-@LunaGram__Updates-2CA5E0?style=for-the-badge&logo=telegram&logoColor=white" alt="Telegram Channel"></a>
  <a href="https://android.com"><img src="https://img.shields.io/badge/Android-7.0%2B%20(API%2024%2B)-3DDC84?style=for-the-badge&logo=android&logoColor=white" alt="Android MinSdk"></a>
</p>

<p align="center">
  <a href="#-download-lunagram"><b>📥 Download APK</b></a> •
  <a href="#-key-features"><b>✨ Features</b></a> •
  <a href="#-feature-comparison"><b>📊 Comparison</b></a> •
  <a href="#-architecture--core-engine"><b>🏗️ Architecture</b></a> •
  <a href="#-building-from-source"><b>🛠️ Build</b></a>
</p>

---

## 📖 Overview

**Lunagram** is an advanced open-source Android messaging client engineered on top of official Telegram MTProto protocols. Tailored for power users and design enthusiasts, Lunagram merges **Nothing OS 2.5 / 3.0 industrial aesthetics** with native C++ multi-core speed, zero telemetry, and rigorous privacy enforcement.

Whether you're rocking a Nothing Phone with rear LED Glyph strips or any other Android smartphone, Lunagram transforms your everyday messaging into a tactile, distraction-free, and visually striking experience.

> [!TIP]
> **Ready to install?** Jump straight to the [Download Section](#-download-lunagram) to get signed, reproducible APKs ready for seamless 1-tap updates.

---

## ✨ Key Features

### 💡 Nothing Glyph Interface (Hardware SDK)
* **Real Rear LED Control:** Directly controls rear Glyph LED illumination on **Nothing Phone (1), Phone (2), Phone (2a), Phone (2a Plus), and Phone (3a)** using the official Nothing Ketchum SDK.
* **Message Pulse Cadence:** Distinct double-pulse Glyph illumination pattern on incoming messages, keeping you informed even when your phone is screen-down on silent.
* **Incoming Call Strobe:** Synchronized, rhythmic breathing strobe animation during voice and video calls that stops as soon as the call connects or disconnects.
* **Universal Camera Flash Fallback:** Don't have a Nothing Phone? Toggle on the Flashlight Fallback to enjoy the exact same rhythmic lighting patterns using your phone's rear camera LED.
* **Interactive LED Diagnostics:** Dedicated *Test Glyph Light* button in settings to test and verify hardware illumination on the fly.

### 🔤 Nothing Signature Typography (NDot57)
* **Dot-Matrix Aesthetics:** Authentic Nothing **NDot57** typography engine for App Bar Titles, Dialog Headers, Unread Counter Badges, and Chat List Timestamps.
* **Live Customization:** Fully toggleable under **Lunagram Settings ➔ Nothing OS & Glyph** with instant live UI updates without requiring an app restart.

### 📳 Nothing Tactile Haptics Engine
* **Message Send "Pop":** Physical, satisfying tactile pop feedback as soon as any text, media, or voice note is dispatched.
* **Mechanical Switch "Tick":** Calibrated micro-vibration ticks whenever any toggle switch, checkbox, or tab is selected.
* **Selection "Thump":** Heavy tactile feedback when long-pressing messages for multi-selection.
* **Test Haptics Suite:** Built-in haptic diagnostics tool in settings to experience the tick, pop, and thump vibrations.

### 🎨 Stark Monochrome & OLED Pitch Black
* **OLED Pure Black (`#000000`):** Pitch-black canvas engineered for maximum power efficiency on AMOLED panels.
* **Nothing Crimson Red (`#D71920`):** High-contrast signature red accents across unread badges, active states, and verified markers.
* **Ergonomic Squircle Bubbles:** Modernized message cells with an ergonomic `19dp` squircle corner radius for enhanced reading flow.
* **Client-Side Premium Emojis:** Custom animated Telegram emojis persist permanently in chats without reverting.
* **Pixel-Perfect Settings Alignment:** Custom 24dp Nothing Glyph vector iconography aligned seamlessly with system preferences.

### 🛡️ Privacy & Protocol Hardening
* **Ghost Mode Engine:** Suppress read receipts, hide typing indicators, and mask online status at the protocol level.
* **Message & Channel Deletion Fix:** Non-outgoing DM messages and channel posts can be deleted cleanly without restrictions.
* **Zero Telemetry & Ad-Free:** Third-party trackers, proprietary analytics, and sponsored channel ads are completely stripped out.
* **Multi-Engine In-Line Translation:** Real-time translation of incoming and outgoing messages directly in the conversation stream.
* **Built-in Proxy Hub:** Integrated MTProxy and Socks5 management with real-time ping latency diagnostics and auto-rotation.

### 🔑 Permanent Keystore & Seamless Updates
* **Reproducible Cryptographic Key:** All releases are signed with a permanent, committed release keystore.
* **Zero Uninstall Hassle:** Every new release installs directly as an in-place update over previous versions without signature conflicts or data loss.

---

## 📊 Feature Comparison

| Feature | Official Telegram | Nekogram | Lunagram |
| :--- | :---: | :---: | :---: |
| **Nothing Glyph LED Hardware Control** | ❌ | ❌ | **✅ Full SDK (1, 2, 2a, 3a)** |
| **Universal Camera Flash Fallback** | ❌ | ❌ | **✅ Built-in** |
| **Nothing NDot57 Typography Engine** | ❌ | ❌ | **✅ Built-in** |
| **Nothing Tactile Haptics (Tick/Pop/Thump)** | ❌ | ❌ | **✅ Built-in** |
| **Ghost Mode (Hide Read & Typing)** | ❌ | ✅ | **✅ Enhanced** |
| **Client-Side Animated Emojis** | Premium Only | Partial | **✅ 100% Persistent** |
| **Zero Trackers & Sponsored Ads** | ❌ (Sponsored Ads) | ✅ | **✅ Completely Stripped** |
| **OLED Pure Black & Nothing Red UI** | ❌ | ❌ | **✅ Native Theme** |
| **Permanent Keystore (1-Tap Updates)** | Play Store Only | ❌ | **✅ Built into CI/CD** |

---

## 📥 Download Lunagram

Grab the latest verified, signed APKs from our [GitHub Releases](https://github.com/d4rxh/Lunagram/releases/latest):

| Package Architecture | Target Devices | Typical Size | Download Link |
| :--- | :--- | :---: | :---: |
| 📱 **arm64-v8a** *(Recommended)* | Modern 64-bit Android smartphones & Nothing Phones | ~39.4 MB | [**Download arm64 APK**](https://github.com/d4rxh/Lunagram/releases/latest) |
| 🌐 **Universal APK** | Runs on all Android devices (arm64, armv7, x86, x86_64) | ~69.8 MB | [**Download Universal APK**](https://github.com/d4rxh/Lunagram/releases/latest) |
| 📲 **ARMeabi-v7a** | Older 32-bit Android smartphones | ~38.4 MB | [**Download armv7 APK**](https://github.com/d4rxh/Lunagram/releases/latest) |
| 💻 **x86_64 / x86** | Android Emulators, Chromebooks & PCs | ~39.8 MB | [**Download x86 APK**](https://github.com/d4rxh/Lunagram/releases/latest) |

---

## 🏗️ Architecture & Core Engine

Lunagram's codebase couples sub-millisecond UI responsiveness with heavy native cryptographic and networking workloads:

```
┌────────────────────────────────────────────────────────┐
│                   Presentation Layer                   │
│   Nothing NDot Typography  •  Haptic Engine  •  Theme  │
└───────────────────────────┬────────────────────────────┘
                            │
┌───────────────────────────▼────────────────────────────┐
│                  Application & UI Logic                │
│    MessagesController  •  NotificationCenter  •  Auth   │
└───────────────────────────┬────────────────────────────┘
                            │
┌───────────────────────────▼────────────────────────────┐
│             Hardware & Protocol Extensions             │
│   Nothing Ketchum SDK  •  Torch Fallback  • Ghost Mode │
└───────────────────────────┬────────────────────────────┘
                            │
┌───────────────────────────▼────────────────────────────┐
│                Native Core (C++ / NDK)                 │
│    libtmessages.so  •  BoringSSL  •  WebRTC  •  FFmpeg │
└────────────────────────────────────────────────────────┘
```

---

## 🛠️ Building From Source

Lunagram builds using Gradle with the Android NDK compiling both native C++ libraries and Java/Kotlin components.

### Prerequisites
* **Java Development Kit:** OpenJDK 21
* **Android SDK:** Platform 35 / Build-Tools 35.0.0
* **Android NDK:** NDK 26+ (`26.1.10909125`)
* **CMake:** 3.22.1+

### Step-by-Step Build Instructions

1. **Clone the repository:**
   ```bash
   git clone https://github.com/d4rxh/Lunagram.git
   cd Lunagram
   ```

2. **Configure local environment credentials:**
   Create a `local.properties` file in the root directory:
   ```properties
   sdk.dir=/path/to/android-sdk
   ndk.dir=/path/to/android-sdk/ndk/26.1.10909125
   apiId=YOUR_TELEGRAM_API_ID
   apiHash=YOUR_TELEGRAM_API_HASH
   ```

3. **Assemble release APKs:**
   ```bash
   chmod +x ./gradlew
   ./gradlew assembleRelease --no-daemon -x test -x lint
   ```

4. **Locate built binaries:**
   Signed APKs will be generated under:
   ```
   TMessagesProj_App/build/outputs/apk/release/
   ```

---

## 🔒 Security & Bug Reports

If you discover any security vulnerabilities or unexpected behavior, please open an issue in the [GitHub Issue Tracker](https://github.com/d4rxh/Lunagram/issues) or submit a pull request.

---

## 📜 License & Acknowledgements

* Lunagram is free and open-source software licensed under the **[GNU General Public License v2.0 (GPLv2)](LICENSE)**.
* Built upon open-source contributions from [Telegram for Android](https://github.com/DrKLO/Telegram) and [Nekogram](https://github.com/Nekogram/Nekogram).
* Hardware lighting powered by the official [Nothing Ketchum Glyph SDK](https://github.com/NothingOSS).

<p align="center">
  Crafted with ❤️ by <a href="https://github.com/d4rxh"><b>@d4rxh</b></a>
</p>

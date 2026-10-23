<p align="center">
  <img src="icon.png" alt="Lunagram Logo" width="130" height="130" style="border-radius: 28px; box-shadow: 0 10px 30px rgba(215, 25, 32, 0.4);" />
</p>

<h1 align="center">Lunagram</h1>

<p align="center">
  <b>A modern, high-performance, and privacy-hardened Telegram client for Android.</b><br>
  <i>Infused with Nothing OS 3.0 industrial minimalism, native C++ acceleration, and deep protocol-level privacy controls.</i>
</p>

<p align="center">
  <a href="https://github.com/d4rxh/Lunagram/releases/latest"><img src="https://img.shields.io/github/v/release/d4rxh/Lunagram?style=for-the-badge&color=D71920&logo=android&logoColor=white" alt="Latest Version"></a>
  <a href="https://github.com/d4rxh/Lunagram/actions/workflows/build.yml"><img src="https://img.shields.io/github/actions/workflow/status/d4rxh/Lunagram/build.yml?style=for-the-badge&label=CI%20Build&color=00c853&logo=githubactions&logoColor=white" alt="CI Status"></a>
  <a href="https://github.com/d4rxh/Lunagram/blob/main/LICENSE"><img src="https://img.shields.io/badge/License-GPLv3-0070F3?style=for-the-badge" alt="License"></a>
  <a href="https://t.me/LunaGram_Updates"><img src="https://img.shields.io/badge/Telegram-@LunaGram__Updates-2CA5E0?style=for-the-badge&logo=telegram&logoColor=white" alt="Telegram Channel"></a>
  <a href="https://android.com"><img src="https://img.shields.io/badge/Android-7.0%2B%20(API%2024%2B)-3DDC84?style=for-the-badge&logo=android&logoColor=white" alt="Android MinSdk"></a>
</p>

---

## 📖 Overview

**Lunagram** is an advanced open-source Android messaging client engineered on top of official Telegram MTProto protocols. Tailored for power users and design enthusiasts, Lunagram pairs the iconic **Nothing OS 2.5 / 3.0 industrial design language** with native C++ multi-core speed, zero telemetry, and rigorous privacy enforcement.

> [!TIP]
> **Looking for the latest stable APK?** Jump straight to the [Download Section](#-download-lunagram) to get signed, multi-architecture binaries.

---

## ✨ Key Highlights & Features

### 🔴 Nothing OS Industrial Revamp
* **Signature Crimson Floating Dockbar:** Ergonomically compacted `240dp` floating navigation bar finished in signature Nothing Crimson (`#D71920`) with pure white glyphs.
* **Mechanical Tactile Haptics:** Calibrated physical keyboard tap feedback (`HapticFeedbackConstants.KEYBOARD_TAP`) on dockbar navigation.
* **Full Dot-Matrix Typography System:** Chat list timestamps, unread counter badges, and action bar subtitles rendered in authentic **NDot 57**.
* **On-Screen Glyph Pulse Effect:** Subtle glowing Nothing Glyph light strip pulse outline around focused message bubbles.
* **OLED Monochrome Settings:** Rainbow clutter completely eliminated; settings squircle icons styled in deep graphite (`#1E1E1E`) with crisp `#FFFFFF` glyphs.
* **Crisp Verified Badges:** Official verified channel badges rendered with a vivid crimson red background and a high-contrast white checkmark.
* **Persistent Client-Side Premium Emojis:** Native animated custom emojis persist seamlessly across chat reloads and syncs.

### 🎨 Modern Visual Polish & UI Architecture
* **Squircle Chat Message Bubbles:** Modernized message cells with an ergonomic `19dp` squircle corner radius for enhanced reading ergonomics.
* **Material 3 Grouped Settings:** Elevated rounded cards grouping preferences systematically across all settings screens.
* **Monet Dynamic Theming:** Adapts interface accents dynamically to your Android wallpaper and system palette.
* **Clean Dark Canvas:** True OLED pitch-black backdrop tuned for battery efficiency and high-contrast readability.

### 🛡️ Privacy & Stealth Engineering
* **Ghost Mode Engine:** Suppress read receipts, hide typing indicators, and mask online presence at the protocol layer.
* **Zero Telemetry & Ad-Free:** Proprietary analytics, background telemetry trackers, and sponsored channel ads are completely stripped.
* **Self-Destruct & Secret Chats:** Full MTProto end-to-end encrypted chats with configurable timer self-destruction.
* **Integrated Proxy Hub:** Built-in MTProxy and Socks5 manager with real-time ping latency diagnostics and auto-rotation.

### ⚡ Native Performance & Multi-Core Engine
* **Native C++ Acceleration:** Core networking, cryptographic handshakes, and media processing powered by native C++ (`libtmessages.so`, BoringSSL, WebRTC, and FFmpeg).
* **High-Throughput MTProto Cloud Sync:** Connects directly to global Telegram distributed datacenters with zero synthetic throttling.
* **Multi-Architecture Matrix:** Fully optimized native builds for `arm64-v8a`, `armeabi-v7a`, `x86_64`, and `x86`.

### 🌐 Multi-Engine Real-Time Translation
* In-line, instant translation of incoming and outgoing messages directly in the chat stream.
* Multi-provider engine support: **Google Translate, DeepL, Yandex, and Cloudflare AI**.

---

## 📥 Download Lunagram

Verified and signed release binaries are distributed through [GitHub Releases](https://github.com/d4rxh/Lunagram/releases/latest).

| Build Architecture | Target Hardware | Package Size | Download Link |
| :--- | :--- | :--- | :--- |
| ⚡ **ARM64-v8a** *(Recommended)* | Modern 64-bit Android phones & tablets (Nothing Phone, Pixel, Samsung, etc.) | ~39.8 MB | [**Download APK**](https://github.com/d4rxh/Lunagram/releases/latest) |
| 🌐 **Universal APK** | Any Android device (combined native libs) | ~70.2 MB | [**Download APK**](https://github.com/d4rxh/Lunagram/releases/latest) |
| 📱 **ARMeabi-v7a** | Legacy 32-bit Android phones | ~38.8 MB | [**Download APK**](https://github.com/d4rxh/Lunagram/releases/latest) |
| 💻 **x86_64 / x86** | Android Emulators & ChromeOS | ~40.2 MB | [**Download APK**](https://github.com/d4rxh/Lunagram/releases/latest) |

---

## 🏗️ Architecture & Engineering

Lunagram's codebase is architected across multiple layers to deliver sub-millisecond UI responsiveness alongside heavy native cryptographic workloads:

```
┌────────────────────────────────────────────────────────┐
│                   Presentation Layer                   │
│   Floating Dockbar  •  Squircle Cells  •  NDot Types   │
└───────────────────────────┬────────────────────────────┘
                            │
┌───────────────────────────▼────────────────────────────┐
│                  Application & UI Logic                │
│    MessagesController  •  NotificationCenter  •  Auth   │
└───────────────────────────┬────────────────────────────┘
                            │
┌───────────────────────────▼────────────────────────────┐
│             Protocol & Privacy Interceptors            │
│         GhostMode Manager  •  MTProto Datacenter       │
└───────────────────────────┬────────────────────────────┘
                            │
┌───────────────────────────▼────────────────────────────┐
│                Native Core (C++ / NDK)                 │
│    libtmessages.so  •  BoringSSL  •  WebRTC  •  FFmpeg │
└────────────────────────────────────────────────────────┘
```

### Technical Highlights
1. **Protocol Interception:** Privacy toggles (like Ghost Mode) are implemented by intercepting `TLRPC` request pipelines prior to network serialization, preventing read receipt packets from ever leaving the device.
2. **Automated CI/CD:** Continuous builds compile C++ and Java/Kotlin code inside an isolated Ubuntu runner, automatically signing artifacts using a reproducible keystore pipeline.
3. **Secret Isolation:** API tokens, Firebase descriptors, and signing credentials are bound at build time through GitHub Secrets without committing private keys to source control.

---

## 🛠️ Building From Source

Lunagram uses Gradle with Android NDK to compile both native and managed layers.

### Prerequisites
* **Java Development Kit:** OpenJDK 21
* **Android SDK:** Platform 35 / Build-Tools 35.0.0
* **Android NDK:** NDK 26+ (`26.1.10909125`)
* **CMake:** 3.22.1+

### Step-by-Step Compilation

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

* Lunagram is free and open-source software licensed under the **[GNU General Public License v3.0 (GPLv3)](LICENSE)**.
* Built upon open-source contributions from [Telegram for Android](https://github.com/DrKLO/Telegram) and [Nekogram](https://github.com/Nekogram/Nekogram).

<p align="center">
  Crafted with ❤️ by <a href="https://github.com/d4rxh"><b>@d4rxh</b></a>
</p>
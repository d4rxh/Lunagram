<p align="center">
  <img src="logo.png" alt="Lunagram Logo" width="140" height="140" style="border-radius: 32px; box-shadow: 0 8px 24px rgba(0,0,0,0.3);" />
</p>

<h1 align="center">Lunagram</h1>

<p align="center">
  <b>A modern, high-performance, and feature-rich Telegram client for Android.</b><br>
  <i>Crafted for speed, deep customization, and absolute privacy.</i>
</p>

<p align="center">
  <a href="https://t.me/LunaGram_Updates"><img src="https://img.shields.io/badge/Telegram-@LunaGram__Updates-2CA5E0?style=for-the-badge&logo=telegram&logoColor=white" alt="Telegram Channel"></a>
  <a href="https://lunagram.app"><img src="https://img.shields.io/badge/Website-lunagram.app-8A2BE2?style=for-the-badge&logo=googlechrome&logoColor=white" alt="Official Website"></a>
  <a href="https://github.com/d4rxh/Lunagram/releases/latest"><img src="https://img.shields.io/github/v/release/d4rxh/Lunagram?style=for-the-badge&color=7928CA&logo=android&logoColor=white" alt="Latest Version"></a>
  <a href="https://github.com/d4rxh/Lunagram/blob/main/LICENSE"><img src="https://img.shields.io/badge/License-GPLv3-0070F3?style=for-the-badge" alt="License"></a>
  <a href="https://github.com/d4rxh/Lunagram/actions/workflows/release.yml"><img src="https://img.shields.io/github/actions/workflow/status/d4rxh/Lunagram/release.yml?style=for-the-badge&label=CI%20Build&color=00c853" alt="CI Status"></a>
</p>

---

## 📌 Table of Contents
- [📥 Download Lunagram](#-download-lunagram)
- [✨ Key Highlights & Features](#-key-highlights--features)
  - [🚀 Performance & MTProto](#-performance--mtproto)
  - [🎨 Deep Customization & Theming](#-deep-customization--theming)
  - [🔒 Privacy & Zero Telemetry](#-privacy--zero-telemetry)
  - [🌐 Multi-Engine Real-time Translation](#-multi-engine-real-time-translation)
  - [🛠️ Power-User Controls](#️-power-user-controls)
- [📲 Installation Guide](#-installation-guide)
- [🛠️ Building From Source](#️-building-from-source)
- [💬 Community & Updates](#-community--updates)
- [📜 License & Acknowledgements](#-license--acknowledgements)

---

## 📥 Download Lunagram

Always get official, verified, and signed APKs from our [GitHub Releases](https://github.com/d4rxh/Lunagram/releases/latest).

| Architecture | Description | Download Link |
| :--- | :--- | :--- |
| 🌐 **Universal APK** | **Recommended.** Works on any Android device (ARM & x86). | [**Download Universal**](https://github.com/d4rxh/Lunagram/releases/latest) |
| ⚡ **ARM64-v8a** | Optimized for modern 64-bit phones (smaller package size). | [**Download ARM64**](https://github.com/d4rxh/Lunagram/releases/latest) |
| 📦 **All Releases** | Browse full release changelog and historical releases. | [**View All Versions**](https://github.com/d4rxh/Lunagram/releases) |

---

## ✨ Key Highlights & Features

### 🚀 Performance & MTProto
- **Native C++ Engine:** Full native acceleration (`libtmessages.so`) with zero artificial bottlenecks or rate-limiting.
- **Ultra-Fast Cloud Sync:** Leverages official Telegram MTProto datacenters across the globe for instant message delivery and media streaming.
- **Optimized Battery Life:** Efficient background push service powered by official Firebase Cloud Messaging (FCM).

### 🎨 Deep Customization & Theming
- **Lunar Cosmic Aesthetics:** Sleek, modern visual polish inspired by nocturnal aesthetics.
- **Material You Dynamic Theming:** Automatically adapts accent colors based on your Android system wallpaper.
- **Custom Fonts & Emoji Sets:** Switch between Apple, Google, Twitter, or system emojis, and apply custom TTF/OTF typography.
- **Custom App Icons:** Change launcher icons on the fly without restarting the app.

### 🔒 Privacy & Zero Telemetry
- **Tracker-Free:** Proprietary analytics, ad tracking, and background telemetry have been completely stripped.
- **End-to-End Encryption:** Full support for Telegram Secret Chats with self-destruct timers.
- **No Ads:** Enjoy a clean chat stream without sponsored channel ads.
- **Custom Proxy Management:** Integrated proxy checker with ping latency measurement and automatic rotation.

### 🌐 Multi-Engine Real-time Translation
- Instant in-chat message and post translation without switching apps.
- Supports **Google Translate, DeepL, Yandex, and Cloudflare AI**.
- Customizable target and source languages with one-tap toggle.

### 🛠️ Power-User Controls
- **Unlimited Pinned Chats:** Pin as many important conversations and channels as you want.
- **Tab & Folder Organizing:** Filter chats by Channels, Groups, Bots, and Unread with custom navigation bar styling.
- **Advanced Media Player:** Picture-in-Picture (PiP), speed pitch controls, and full-resolution background playback.

---

## 📲 Installation Guide

1. Download the latest **Universal APK** from the [Releases section](https://github.com/d4rxh/Lunagram/releases/latest).
2. If updating from a different Telegram client or older version, **uninstall the previous APK** to prevent signature and cache conflicts.
3. Tap the downloaded `.apk` file and grant *"Install unknown apps"* permission if prompted by Android.
4. Open **Lunagram**, enter your phone number, and verify with your Telegram login code.

---

## 🛠️ Building From Source

Lunagram is completely reproducible and automated through continuous integration.

### Prerequisites
- **JDK:** Java Development Kit 21
- **Android SDK:** Platform 35 / Build Tools 35.0.0
- **Android NDK:** NDK 26+
- **CMake:** 3.22.1+

### Local Compilation Steps
```bash
# 1. Clone the repository
git clone https://github.com/d4rxh/Lunagram.git
cd Lunagram

# 2. Configure Telegram API credentials in local.properties
cat <<EOF > local.properties
sdk.dir=/path/to/android-sdk
ndk.dir=/path/to/android-sdk/ndk/26.1.10909125
apiId=YOUR_TELEGRAM_API_ID
apiHash=YOUR_TELEGRAM_API_HASH
EOF

# 3. Compile the Universal Release APK
./gradlew assembleAfatRelease
```

Generated APKs will be located at:
`TMessagesProj/build/outputs/apk/afat/release/`

---

## 💬 Community & Updates

Stay connected with new feature updates, build announcements, and support:

- 📢 **Official Channel:** [@LunaGram_Updates](https://t.me/LunaGram_Updates)
- 🌐 **Official Website:** [lunagram.app](https://lunagram.app)
- 🐛 **Issue Tracker:** [GitHub Issues](https://github.com/d4rxh/Lunagram/issues)
- 💻 **Source Code:** [github.com/d4rxh/Lunagram](https://github.com/d4rxh/Lunagram)

---

## 📜 License & Acknowledgements

Lunagram is free and open-source software licensed under the **[GNU General Public License v3.0 (GPLv3)](LICENSE)**.

Lunagram is proudly based on the open-source [Telegram for Android](https://github.com/DrKLO/Telegram) and [Nekogram](https://github.com/Nekogram/Nekogram) projects.

<p align="center">
  Made with 💜 by <a href="https://github.com/d4rxh"><b>@d4rxh</b></a>
</p>

# 🌙 Lunagram

<p align="center">
  <img src="aec052a48687e175c7e578ad423f71f3.jpg" alt="Lunagram Logo" width="128" height="128" style="border-radius: 28px;" />
</p>

<p align="center">
  <b>A sleek, fast, and feature-packed Telegram client for Android.</b>
</p>

<p align="center">
  <a href="https://github.com/d4rxh/Lunagram/releases"><img src="https://img.shields.io/github/v/release/d4rxh/Lunagram?style=for-the-badge&color=8A2BE2" alt="Latest Release"></a>
  <a href="https://github.com/d4rxh/Lunagram/blob/main/LICENSE"><img src="https://img.shields.io/badge/license-GPLv3-blue?style=for-the-badge" alt="License"></a>
  <a href="https://github.com/d4rxh/Lunagram/actions"><img src="https://img.shields.io/badge/build-passing-brightgreen?style=for-the-badge" alt="Build Status"></a>
  <img src="https://img.shields.io/badge/Platform-Android%206.0+-blue?style=for-the-badge&logo=android" alt="Android">
</p>

---

## 📥 Download APK

Get the latest build of **Lunagram** directly from GitHub Releases:

<p align="center">
  <a href="https://github.com/d4rxh/Lunagram/releases/latest">
    <img src="https://img.shields.io/badge/DOWNLOAD-LUNAGRAM%20APK-8A2BE2?style=for-the-badge&logo=android&logoColor=white" height="48" />
  </a>
</p>

*Or browse all versions on the [Releases page](https://github.com/d4rxh/Lunagram/releases).*

---

## ✨ Features

- 🌙 **Celestial Lunar Theme:** Elegant deep cosmic aesthetics and customizable UI styling.
- ⚡ **Pure MTProto Speed:** Official Telegram protocol integration with low-latency messaging.
- 🛡️ **Enhanced Privacy:** No telemetry, tracker-free, secure end-to-end secret chats.
- 📁 **Advanced Chat Management:** Custom tabs, folder customization, and unlimited pinned chats.
- 🎬 **Integrated Media Player:** Smooth full-screen, landscape, and picture-in-picture video playback.
- ⚙️ **Automated Builds:** Powered by GitHub Actions CI/CD to compile and publish fresh signed APKs on every release.

---

## 🛠️ Building From Source

### Prerequisites
- Android Studio Ladybug (or newer)
- Android SDK 35 & NDK 26+
- JDK 17 / 21

### Build Commands
```bash
# Clone repository
git clone https://github.com/d4rxh/Lunagram.git
cd Lunagram

# Configure API credentials in local.properties
echo "apiId=YOUR_API_ID" >> local.properties
echo "apiHash=YOUR_API_HASH" >> local.properties

# Build universal APK
./gradlew assembleRelease
```

---

## 📜 License
Lunagram is based on the [Nekogram](https://github.com/Nekogram/Nekogram) project and licensed under the GNU General Public License v3 (GPLv3).

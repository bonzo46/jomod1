# Johann's First Minecraft Mod

## Getting Started

### 1. Setup
Runs this command to download Minecraft assets and setting up the environment:
- **Windows**: `gradlew.bat genSources eclipse` (or stuck with VS Code/IntelliJ commands)
- **Mac/Linux**: `./gradlew genSources eclipse`

### 2. Run the Game
- **Windows**: `gradlew.bat runClient`

### 3. Build the Mod
To create the mod file to put in your `mods` folder:
- **Windows**: `gradlew.bat build`
- The file will be in `build/libs/`.

## Folder Structure
- `src/main/java`: Your code (Java files).
- `src/main/resources`: Your assets (JSONs, textures, sounds).

## Collaboration
- This folder is synced via Dropbox.
- `git status` to see what changed.

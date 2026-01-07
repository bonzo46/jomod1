# JohannMod - Better TNT

A Minecraft mod that adds **Better TNT** - an explosive block that creates epic chain reactions!

## Features

### Better TNT Block
- **Punch to Ignite**: Left-click (attack) the block to light it - no flint and steel needed!
- **4 Second Fuse**: Gives you time to run away!
- **Recursive Chain Explosion**: When it explodes, it splits into 8 TNT pieces, and each of those splits into 8 more, creating a massive expanding explosion pattern!
- **Configurable**: Adjust explosion size, fuse time, and more in `BetterTntConfig.java`

### Crafting Recipe
```
T T T
T N T
T T T
```
Where:
- T = TNT
- N = Netherite Ingot

(8 TNT + 1 Netherite Ingot = 1 Better TNT)

### How It Works
1. Place the Better TNT block (found in Creative Redstone tab)
2. Punch it (left-click) to ignite
3. Run! (4 second fuse)
4. Watch the amazing chain reaction:
   - Level 0: Main block explodes → spawns 8 pieces
   - Level 1: 8 pieces explode → spawn 64 pieces
   - Level 2: 64 pieces explode → spawn 512 pieces
   - Level 3: 512 pieces explode → spawn 4,096 pieces
   - Level 4: 4,096 pieces explode → spawn 32,768 pieces
   - Level 5: 32,768 final explosions!

**Warning**: This creates a MASSIVE explosion! Use in a safe area!

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

## Configuration

You can customize Better TNT by editing `BetterTntConfig.java`:

- `MAX_RECURSION_DEPTH`: How many times TNT splits (default: 5)
- `MAIN_FUSE_TICKS`: Fuse time for main block in ticks (default: 80 = 4 seconds)
- `SPLIT_FUSE_TICKS`: Fuse time for split pieces (default: 10 = 0.5 seconds)
- `PIECES_PER_EXPLOSION`: How many pieces spawn per explosion (default: 8)
- `SPAWN_RADIUS`: Starting radius for spawned TNT (default: 2.0 blocks)
- `RADIUS_INCREASE_PER_LEVEL`: How much radius grows per level (default: 0.5)

## Next Steps

### For Johann
1. **Create the Texture**: Follow `TEXTURE_GUIDE.md` to create the Better TNT texture
2. **Test the Mod**: Build and run in IntelliJ IDEA
3. **Record a Video**: Show off the chain reaction!
4. **Publish to CurseForge**: Share your mod with the world!

### Texture Required
The mod needs a **16x16 pixel PNG texture** at:
```
src/main/resources/assets/johannmod/textures/block/better_tnt.png
```
See `TEXTURE_GUIDE.md` for details on creating this.

## Collaboration
- This folder is synced via Dropbox.
- GitHub repository: https://github.com/bonzo46/jomod1
- `git status` to see what changed.
- `git pull` before starting work.
- `git push` after committing changes.

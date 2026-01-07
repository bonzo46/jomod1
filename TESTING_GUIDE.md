# How to Test Better TNT - Quick Guide for Johann

Hey Johann! Here's how to test your awesome Better TNT mod!

## Step 1: Create the Texture (Do This First!)

You need to create a 16x16 pixel image. Here's the easy way:

### Option A: Use Paint.NET (Recommended)
1. Download Paint.NET (free): https://www.getpaint.net/
2. Create a new image: 16 width × 16 height pixels
3. Find a TNT texture online (search "minecraft tnt texture")
4. Copy it into your image
5. Add 4 small red squares in the corners (these are the small TNT pieces)
6. Save as PNG to: `src\main\resources\assets\johannmod\textures\block\better_tnt.png`

### Option B: Quick Temporary Solution
1. Download any Minecraft TNT texture from online
2. Save it to: `src\main\resources\assets\johannmod\textures\block\better_tnt.png`
3. Test the mod with this
4. Create your custom version later

## Step 2: Build the Mod in IntelliJ IDEA

1. **Open the project** in IntelliJ IDEA
   - File → Open → Select the MinecraftMods folder

2. **Wait for Gradle to sync**
   - Bottom right corner will show "Gradle sync in progress"
   - This might take a few minutes the first time
   - It's downloading Minecraft!

3. **Build the mod**
   - Open the Gradle tab (usually on the right side)
   - Expand: Tasks → build
   - Double-click "build"
   - Wait for it to finish (will say "BUILD SUCCESSFUL")

## Step 3: Run Minecraft with Your Mod

1. **Find the run configuration**
   - Top right corner, next to the green play button
   - Select "Minecraft Client" from the dropdown

2. **Click the green play button** ▶️
   - Minecraft will launch with your mod!
   - This takes a minute or two

3. **Wait for Minecraft to load**
   - You'll see the Minecraft main menu

## Step 4: Test in Creative Mode

1. **Create a new world**
   - Single Player → Create New World
   - Game Mode: Creative
   - Create New World

2. **Find Better TNT**
   - Press `E` to open inventory
   - Click the Redstone tab (looks like a redstone torch)
   - Scroll down - you should see "Better TNT"!

3. **Place Better TNT**
   - Select it in your hotbar
   - Right-click to place it on the ground

4. **Ignite it!**
   - **Left-click (punch) the Better TNT block**
   - You should hear the TNT hissing sound
   - **RUN AWAY!** (You have 4 seconds)

5. **Watch the EPIC explosion!**
   - Main block explodes
   - 8 pieces fly out in a circle
   - Each of those explodes into 8 more
   - Each of those into 8 more
   - And again, and again!
   - BOOM! MASSIVE EXPLOSION!

## Step 5: Test the Crafting Recipe (Survival Mode)

1. Create a new world in **Survival mode**

2. Give yourself items with commands:
   ```
   /give @s minecraft:tnt 8
   /give @s minecraft:netherite_ingot 1
   ```

3. Open crafting table and try the recipe:
   ```
   T T T
   T N T
   T T T
   ```
   Where T = TNT and N = Netherite Ingot

4. You should get 1 Better TNT!

## Troubleshooting

### "Better TNT not in Creative menu"
- Make sure you created the texture file
- Check the console for errors (bottom of IntelliJ)
- Try rebuilding (Gradle → Tasks → build → clean, then build again)

### "Mod won't build"
- Check for red underlines in the code files
- Look at the "Build" tab at the bottom for error messages
- Make sure Java 21 is installed

### "Minecraft crashes when I punch the TNT"
- Check the console for error messages
- Try reducing MAX_RECURSION_DEPTH in BetterTntConfig.java to 3

### "The explosion is too laggy"
- Open `src/main/java/net/johann/firstmod/BetterTntConfig.java`
- Change this line:
  ```java
  public static int MAX_RECURSION_DEPTH = 3;  // Changed from 5
  ```
- Rebuild and test again

## Recording Your Success!

Once it works:
1. **Record a video** of the explosion (Windows Game Bar: Win+G)
2. **Take screenshots** (F2 in Minecraft)
3. Screenshots are saved in: `.minecraft/screenshots/`
4. Share with Dad!
5. These will be perfect for CurseForge!

## Expected Results

✅ **What should happen:**
- Better TNT block appears in Creative Redstone tab
- You can place it
- Punching it makes it start smoking/hissing
- After 4 seconds, BOOM!
- 8 TNT fly out in a circle
- Each explodes into 8 more
- Creates a MASSIVE expanding explosion pattern
- Lots of blocks destroyed!
- Super cool to watch!

❌ **What should NOT happen:**
- Minecraft crashes
- No explosion
- Only one explosion (no chain reaction)
- Error messages in console

## Have Fun!

This is YOUR mod that YOU designed! The recursive explosion pattern was YOUR idea. How cool is that?!

Test it, record it, show your friends, and get ready to publish it to CurseForge so other Minecraft players can use it!

---

**Remember**: Always test in a safe area (away from important builds) because this TNT is POWERFUL! 💥

Good luck, Johann! 🚀

package net.johann.firstmod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

/**
 * Better TNT Entity - The explosive projectile that creates chain reactions!
 *
 * How it works:
 * 1. Spawned with a fuse timer (default 4 seconds = 80 ticks)
 * 2. Has a recursion level (0 = main block, 1-5 = split pieces)
 * 3. When it explodes, spawns 8 new TNT entities in a circle
 * 4. Each new TNT has recursion level + 1
 * 5. Stops spawning at level 5 to prevent crashes
 */
public class BetterTntEntity extends TntEntity {
    // How many times this TNT has split (0 = original, 1-5 = split pieces)
    private int recursionLevel = 0;

    /**
     * Constructor for creating a Better TNT entity
     *
     * @param world The Minecraft world
     * @param x X position
     * @param y Y position
     * @param z Z position
     * @param igniter The player/entity that ignited it (can be null)
     * @param fuse Fuse time in ticks (20 ticks = 1 second)
     * @param recursionLevel How many times this has split (0-5)
     */
    public BetterTntEntity(World world, double x, double y, double z,
                          LivingEntity igniter, int fuse, int recursionLevel) {
        super(EntityType.TNT, world);
        this.setPosition(x, y, z);
        this.setFuse(fuse);
        this.recursionLevel = recursionLevel;

        // Add some random velocity so the TNT pieces fly outward
        double velocityX = (Math.random() - 0.5) * 0.3;
        double velocityY = 0.2;
        double velocityZ = (Math.random() - 0.5) * 0.3;
        this.setVelocity(velocityX, velocityY, velocityZ);
    }

    public BetterTntEntity(EntityType<? extends TntEntity> type, World world) {
        super(type, world);
    }

    /**
     * Called every game tick (20 times per second)
     * This is where we handle the explosion and recursion
     */
    @Override
    public void tick() {
        // Do the normal TNT tick behavior (countdown, particles, etc.)
        super.tick();

        // Check if the TNT just exploded (fuse reached 0)
        if (this.getFuse() <= 0 && !this.getWorld().isClient) {
            // Only spawn more TNT if we haven't reached max recursion
            if (recursionLevel < BetterTntConfig.MAX_RECURSION_DEPTH) {
                spawnSplitTnt();
            }
        }
    }

    /**
     * Spawns 8 TNT entities in a circle pattern around this explosion
     * Each new TNT has a shorter fuse and higher recursion level
     */
    private void spawnSplitTnt() {
        World world = this.getWorld();

        // Number of TNT pieces to spawn (from config)
        int pieces = BetterTntConfig.PIECES_PER_EXPLOSION;

        // Calculate angle between each piece (360 degrees / pieces)
        double angleStep = (2 * Math.PI) / pieces;

        // Distance from center for the spawned TNT
        // Gets bigger with each recursion level so the circle expands
        double radius = BetterTntConfig.SPAWN_RADIUS +
                       (recursionLevel * BetterTntConfig.RADIUS_INCREASE_PER_LEVEL);

        // Spawn 8 TNT entities in a circle
        for (int i = 0; i < pieces; i++) {
            // Calculate position using circle math (trigonometry!)
            double angle = angleStep * i;
            double offsetX = Math.cos(angle) * radius;
            double offsetZ = Math.sin(angle) * radius;

            // New position for this TNT piece
            double newX = this.getX() + offsetX;
            double newY = this.getY();
            double newZ = this.getZ() + offsetZ;

            // Shorter fuse for split pieces (from config, default 0.5 seconds = 10 ticks)
            // This makes the chain reaction faster and more exciting!
            int newFuse = BetterTntConfig.SPLIT_FUSE_TICKS;

            // Create the new Better TNT entity
            BetterTntEntity splitTnt = new BetterTntEntity(
                world,
                newX, newY, newZ,
                null,
                newFuse,
                recursionLevel + 1  // Increase recursion level
            );

            // Give it some velocity to fly outward
            double velocityX = Math.cos(angle) * 0.4;
            double velocityY = 0.3;
            double velocityZ = Math.sin(angle) * 0.4;
            splitTnt.setVelocity(velocityX, velocityY, velocityZ);

            // Spawn it in the world!
            world.spawnEntity(splitTnt);
        }
    }

    /**
     * Save the recursion level when the entity is saved to disk
     */
    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("RecursionLevel", this.recursionLevel);
    }

    /**
     * Load the recursion level when the entity is loaded from disk
     */
    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.recursionLevel = nbt.getInt("RecursionLevel");
    }

    public int getRecursionLevel() {
        return this.recursionLevel;
    }
}

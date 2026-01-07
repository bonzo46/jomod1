package net.johann.firstmod;

/**
 * Configuration for Better TNT
 *
 * This class stores settings that control how the Better TNT works.
 * In the future, this could be loaded from a config file that players can edit.
 */
public class BetterTntConfig {

    /**
     * Maximum recursion depth for TNT splitting
     *
     * How many times the TNT will split:
     * - 0 = Just the main explosion (no splits)
     * - 1 = Main explosion + 8 pieces
     * - 2 = Main + 8 + 64 pieces
     * - 3 = Main + 8 + 64 + 512 pieces
     * - 4 = Main + 8 + 64 + 512 + 4,096 pieces
     * - 5 = Main + 8 + 64 + 512 + 4,096 + 32,768 pieces (MASSIVE!)
     *
     * Default is 5 for an epic explosion chain.
     * You can lower this if it's too laggy, or increase it if you want more chaos!
     */
    public static int MAX_RECURSION_DEPTH = 5;

    /**
     * Fuse time for the main TNT block (in ticks)
     * 20 ticks = 1 second
     * Default: 80 ticks = 4 seconds
     */
    public static int MAIN_FUSE_TICKS = 80;

    /**
     * Fuse time for split TNT pieces (in ticks)
     * 20 ticks = 1 second
     * Default: 10 ticks = 0.5 seconds (makes the chain reaction faster!)
     */
    public static int SPLIT_FUSE_TICKS = 10;

    /**
     * Number of TNT pieces spawned when one explodes
     * Default: 8 (creates a circle pattern)
     */
    public static int PIECES_PER_EXPLOSION = 8;

    /**
     * Starting radius for spawned TNT pieces
     * Default: 2.0 blocks
     * This gets bigger with each recursion level
     */
    public static double SPAWN_RADIUS = 2.0;

    /**
     * How much the radius increases per recursion level
     * Default: 0.5 blocks
     * This makes the explosion pattern grow outward
     */
    public static double RADIUS_INCREASE_PER_LEVEL = 0.5;

    // Future: Add methods to load/save these settings from a config file
    // For now, players can change these values by editing this file and rebuilding the mod
}

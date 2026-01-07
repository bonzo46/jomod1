package net.johann.firstmod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Better TNT Block - Johann's Custom TNT
 *
 * Features:
 * - Punch (left-click) to ignite
 * - 4-second fuse
 * - Explodes into 8 pieces that each explode into 8 more (recursive chain reaction)
 * - Maximum 5 recursion levels to prevent lag
 */
public class BetterTntBlock extends Block {

    public BetterTntBlock(Settings settings) {
        super(settings);
    }

    /**
     * Called when a player punches (left-clicks/attacks) the block
     * This is how we ignite the Better TNT!
     */
    @Override
    public void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        // Don't do anything on the client side - only on the server
        if (!world.isClient) {
            // Play the TNT ignite sound
            world.playSound(null, pos, SoundEvents.ENTITY_TNT_PRIMED,
                          SoundCategory.BLOCKS, 1.0F, 1.0F);

            // Remove the block from the world
            world.removeBlock(pos, false);

            // Spawn the Better TNT entity with:
            // - Fuse time from config (default 4 seconds = 80 ticks)
            // - Recursion level 0 (this is the main block)
            BetterTntEntity tntEntity = new BetterTntEntity(world,
                pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5,
                null, BetterTntConfig.MAIN_FUSE_TICKS, 0);

            world.spawnEntity(tntEntity);
        }

        // Call the parent method
        super.onBlockBreakStart(state, world, pos, player);
    }
}

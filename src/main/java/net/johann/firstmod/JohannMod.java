package net.johann.firstmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JohannMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final String MOD_ID = "johannmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// Better TNT Block - Johann's custom explosive!
	public static final Block BETTER_TNT = Registry.register(
		Registries.BLOCK,
		Identifier.of(MOD_ID, "better_tnt"),
		new BetterTntBlock(AbstractBlock.Settings.create()
			.strength(0.5f) // Easy to break like regular TNT
			.sounds(BlockSoundGroup.GRASS) // Grass-like sound (TNT sound)
		)
	);

	// Better TNT Item - so players can place the block
	public static final Item BETTER_TNT_ITEM = Registry.register(
		Registries.ITEM,
		Identifier.of(MOD_ID, "better_tnt"),
		new BlockItem(BETTER_TNT, new Item.Settings())
	);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world! Johann's mod is loading!");
		LOGGER.info("Better TNT registered and ready to explode!");

		// Add Better TNT to the Redstone creative tab (where regular TNT lives)
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(content -> {
			content.add(BETTER_TNT_ITEM);
		});
	}
}

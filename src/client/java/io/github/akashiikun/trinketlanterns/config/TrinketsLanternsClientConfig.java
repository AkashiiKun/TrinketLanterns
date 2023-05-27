package io.github.akashiikun.trinketlanterns.config;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeConfigSpec;

public class TrinketsLanternsClientConfig {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	
	public static final ForgeConfigSpec.ConfigValue<Boolean> LANTERN_SWING;
	
	static {
		BUILDER.push("Client Configs for Trinkets Lanterns");
		
		LANTERN_SWING = BUILDER.comment("Should the lantern swing or not.\nDefault: false").define("Should Swing", true);
		BUILDER.pop();
		SPEC = BUILDER.build();
	}
}
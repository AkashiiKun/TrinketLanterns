package io.github.akashiikun.trinketlanterns.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class TrinketsLanternsCommonConfig {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> TOTAL_SLOTS;
	
	static {
		BUILDER.push("Common Configs for Trinkets Lanterns");
		
		TOTAL_SLOTS = BUILDER.comment("Determines the max number of belt slots.\nNOTE: ONLY ADDS SLOTS, DOES NOT REMOVE SLOTS. Other mods can overwrite if too low.\nDefault: 1").define("Slots", 1);
		
		BUILDER.pop();
		SPEC = BUILDER.build();
	}
}
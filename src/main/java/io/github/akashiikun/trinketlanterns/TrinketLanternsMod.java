package io.github.akashiikun.trinketlanterns;

import io.github.akashiikun.trinketlanterns.config.TrinketsLanternsCommonConfig;
import net.fabricmc.api.ModInitializer;
import net.minecraftforge.api.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class TrinketLanternsMod implements ModInitializer {
    public static final String MOD_ID = "trinketlanterns";

    public static String[] lanterns = {
            "minecraft:lantern",
            "minecraft:soul_lantern"
    };

    @Override
    public void onInitialize() {
        ModLoadingContext.registerConfig(TrinketLanternsMod.MOD_ID, ModConfig.Type.COMMON, TrinketsLanternsCommonConfig.SPEC, "trinketlanterns-common.toml");
    }
}

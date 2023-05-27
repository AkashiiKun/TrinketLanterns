package io.github.akashiikun.trinketlanterns;

import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import io.github.akashiikun.trinketlanterns.config.TrinketsLanternsCommonConfig;
import net.fabricmc.api.ModInitializer;
import net.minecraftforge.fml.config.ModConfig;

public class TrinketLanternsMod implements ModInitializer {
    public static final String MOD_ID = "trinketlanterns";

    public static String[] lanterns = {
            "minecraft:lantern",
            "minecraft:soul_lantern"
    };

    @Override
    public void onInitialize() {
        ForgeConfigRegistry.INSTANCE.register(TrinketLanternsMod.MOD_ID, ModConfig.Type.COMMON, TrinketsLanternsCommonConfig.SPEC, "trinketlanterns-common.toml");

    }
}

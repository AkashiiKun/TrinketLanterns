package io.github.akashiikun.trinketlanterns;


import io.github.akashiikun.trinketlanterns.client.ClientModEvents;
import io.github.akashiikun.trinketlanterns.config.TrinketsLanternsClientConfig;
import net.fabricmc.api.ClientModInitializer;
import net.minecraftforge.api.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class TrinketLanternsModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModLoadingContext.registerConfig(TrinketLanternsMod.MOD_ID, ModConfig.Type.CLIENT, TrinketsLanternsClientConfig.SPEC, "trinketlanterns-client.toml");
        ClientModEvents.ClientSetup();
        ClientModEvents.modelRegistry();
    }
}
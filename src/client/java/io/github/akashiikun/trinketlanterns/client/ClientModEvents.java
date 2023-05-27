package io.github.akashiikun.trinketlanterns.client;

import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import io.github.akashiikun.trinketlanterns.TrinketLanternsMod;
import io.github.akashiikun.trinketlanterns.trinket.renderer.LanternRenderer;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class ClientModEvents {


	public static void ClientSetup() {

		for(String var : TrinketLanternsMod.lanterns) {
			String namespace = var.substring(0, var.indexOf(':'));
			String item = var.substring(var.indexOf(':')+1);
			if(FabricLoader.getInstance().isModLoaded(namespace)) {
				TrinketRendererRegistry.registerRenderer(BuiltInRegistries.ITEM.get(new ResourceLocation(namespace, item)), LanternRenderer::new);
			}
		}
	}



	public static void modelRegistry() {

		ModelLoadingRegistry.INSTANCE.registerResourceProvider(
				manager -> (resourceId, context) -> {
					for(String var : TrinketLanternsMod.lanterns) {
						if(resourceId.toString().equals(var)) {
						if (FabricLoader.getInstance().isModLoaded(resourceId.getNamespace())) {
							return context.loadModel(resourceId);
						}
					}
				}
					return null;
				}
		);
	}
}
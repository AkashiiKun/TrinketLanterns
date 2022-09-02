package com.psilocke.curiouslanterns.datagen;

import com.psilocke.curiouslanterns.CuriousLanterns;
import com.psilocke.curiouslanterns.client.ClientModEvents;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import top.theillusivec4.curios.api.CuriosApi;

public class ModItemTagsProvider extends ItemTagsProvider {
	
	public static final TagKey<Item> HIP = ItemTags.create(new ResourceLocation(CuriosApi.MODID, "hip"));
	
	protected ModItemTagsProvider(DataGenerator gen, BlockTagsProvider blockTags, ExistingFileHelper fileHelper) {
		super(gen, blockTags, CuriousLanterns.MOD_ID, fileHelper);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Item Tags";
	}

	@Override
	protected void addTags() {
		for(String var : ClientModEvents.lanterns) {
			String namespace = var.substring(0, var.indexOf(':'));
			String item = var.substring(var.indexOf(':')+1);
			
			this.tag(HIP).addOptional(new ResourceLocation(namespace, item));
		}
	}

}

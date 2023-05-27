package io.github.akashiikun.trinketlanterns.trinket.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.client.TrinketRenderer;
import io.github.akashiikun.trinketlanterns.config.TrinketsLanternsClientConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class MediumLanternRenderer implements TrinketRenderer {

	public MediumLanternRenderer(ItemStack itemStack, SlotReference slotReference, EntityModel<? extends LivingEntity> entityModel, PoseStack poseStack, MultiBufferSource multiBufferSource, int light, LivingEntity livingEntity, float limbSwing,
								 float limbSwingAmount,
								 float partialTicks,
								 float ageInTicks,
								 float netHeadYaw,
								 float headPitch) {
		render(itemStack, slotReference, entityModel, poseStack, multiBufferSource, light, livingEntity, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch);
	}

	@Override
	public void render(ItemStack itemStack, SlotReference slotReference, EntityModel<? extends LivingEntity> entityModel, PoseStack poseStack, MultiBufferSource multiBufferSource, int light, LivingEntity livingEntity, float limbSwing,
					   float limbSwingAmount,
					   float partialTicks,
					   float ageInTicks,
					   float netHeadYaw,
					   float headPitch) {
		poseStack.pushPose();
		ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
		BlockRenderDispatcher blockRenderer = Minecraft.getInstance().getBlockRenderer();
		if(livingEntity.isCrouching()) {
			poseStack.translate(0.0F, 0.18F, 0.3F);
		}
		poseStack.translate(-.23, 0.78, 0.133);
		poseStack.mulPose(Vector3f.XP.rotationDegrees(180));
		if(TrinketsLanternsClientConfig.LANTERN_SWING.get()) {
			double d0 = livingEntity.xo - livingEntity.getX();
            double d1 = livingEntity.yo - livingEntity.getY();
            double d2 = livingEntity.zo - livingEntity.getZ();
            float f = livingEntity.yBodyRotO + (livingEntity.yBodyRot - livingEntity.yBodyRotO);
            double d3 = (double) Mth.sin(f * ((float)Math.PI / 180F));
            double d4 = (double)(-Mth.cos(f * ((float)Math.PI / 180F)));
            float f1 = (float)d1 * 10.0F;
            f1 = Mth.clamp(f1, -6.0F, 32.0F);
            float f2 = (float)(d0 * d3 + d2 * d4) * 100.0F;
            f2 = Mth.clamp(f2, 0.0F, 150.0F);
            float f3 = (float)(d0 * d4 - d2 * d3) * 100.0F;
            f3 = Mth.clamp(f3, -20.0F, 20.0F);
            

            poseStack.mulPose(Vector3f.XP.rotationDegrees(6.0F + f2 / 2.0F + f1));
            poseStack.mulPose(Vector3f.ZP.rotationDegrees(-f3 / 2.0F));
		}
		poseStack.scale(0.33f, 0.33f, 0.33f);
		BakedModel lantern = blockRenderer.getBlockModel(Block.byItem(itemStack.getItem()).defaultBlockState());
		MultiBufferSource.BufferSource buffer = Minecraft.getInstance().renderBuffers().bufferSource();
		itemRenderer.render(itemStack, ItemTransforms.TransformType.HEAD, true, poseStack, buffer, light, OverlayTexture.NO_OVERLAY, lantern);
		poseStack.popPose();
	}

}
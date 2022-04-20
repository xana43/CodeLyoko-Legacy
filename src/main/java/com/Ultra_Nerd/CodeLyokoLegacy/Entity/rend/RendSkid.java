package com.Ultra_Nerd.CodeLyokoLegacy.Entity.rend;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle.EntitySkid;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;


public final class RendSkid extends EntityRenderer<EntitySkid>{


    private  static final BakedModel SkidBladnir;


    static
    {
        SkidBladnir = Minecraft.getInstance().getModelManager().getModel(CodeLyokoMain.CodeLyokoPrefix("entity/skid/skid"));
    }

    public RendSkid(EntityRendererProvider.@NotNull Context renderManagerIn) {
        super(renderManagerIn);



    }


    @Override
    public void render(@Nonnull EntitySkid entityIn, float entityYaw, float partialTicks, @Nonnull PoseStack matrixStackIn, @NotNull MultiBufferSource bufferIn, int packedLightIn) {

        matrixStackIn.pushPose();
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(360 - entityYaw));
        Minecraft.getInstance().getBlockRenderer().getModelRenderer().tesselateWithoutAO(entityIn.level,SkidBladnir, Blocks.AIR.defaultBlockState(),entityIn.blockPosition(),matrixStackIn,
                bufferIn.getBuffer(RenderType.solid()), false, entityIn.level.random,0,0);

        matrixStackIn.popPose();



    }

    @Override
    public boolean shouldRender(EntitySkid pLivingEntity, Frustum pCamera, double pCamX, double pCamY, double pCamZ) {
        return true;
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@Nonnull EntitySkid entity) {
        return InventoryMenu.BLOCK_ATLAS;
    }


}

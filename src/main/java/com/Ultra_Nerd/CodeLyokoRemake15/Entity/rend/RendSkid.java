package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntitySkid;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Random;

@OnlyIn(Dist.CLIENT)
public class RendSkid extends EntityRenderer<EntitySkid>{



    public RendSkid(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);



    }


    @Override
    public void render(@Nonnull EntitySkid entityIn, float entityYaw, float partialTicks, @Nonnull PoseStack matrixStackIn, @NotNull MultiBufferSource bufferIn, int packedLightIn) {

        matrixStackIn.pushPose();
        BakedModel SkidBladnir = Minecraft.getInstance().getModelManager().getModel(CodeLyokoMain.CodeLyokoPrefix("entity/skid/skid"));
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(360 - entityYaw));
        Minecraft.getInstance().getBlockRenderer().getModelRenderer().tesselateWithoutAO(entityIn.level,SkidBladnir, Blocks.AIR.defaultBlockState(),entityIn.blockPosition(),matrixStackIn,
                bufferIn.getBuffer(RenderType.solid()), false, entityIn.level.random,new Random().nextLong(),0);

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

package com.Ultra_Nerd.CodeLyokoLegacy.Entity.rend;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle.EntitySkid;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;


public final class RendSkid extends EntityRenderer<EntitySkid> {
    protected RendSkid(final EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(final EntitySkid entity) {
        return null;
    }
/*

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

 */


}

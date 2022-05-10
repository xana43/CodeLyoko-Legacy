package com.Ultra_Nerd.CodeLyokoLegacy.Entity.rend;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle.EntitySkid;
import dev.monarkhes.myron.api.Myron;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.SpriteAtlasManager;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3f;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;


public final class RendSkid extends EntityRenderer<EntitySkid> {
    private RendSkid(final EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(final EntitySkid entity) {
        return SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE;
    }


    private  static final BakedModel SkidBladnir;


    static
    {
        SkidBladnir = Myron.getModel(CodeLyokoMain.CodeLyokoPrefix("entity/skid/skid"));
    }


    @Override
    public void render(final EntitySkid entity, final float yaw, final float tickDelta, final MatrixStack matrices, final VertexConsumerProvider vertexConsumers, final int light) {
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
        matrices.push();
        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(360 - yaw));
        MinecraftClient.getInstance().getBlockRenderManager().getModelRenderer().render(entity.world,SkidBladnir,Blocks.AIR.getDefaultState(), entity.getBlockPos(),matrices, vertexConsumers.getBuffer(RenderLayer.getSolid()),
                false,entity.world.random,0,0);
        matrices.pop();
    }



    @Override
    public boolean shouldRender(EntitySkid pLivingEntity, Frustum pCamera, double pCamX, double pCamY, double pCamZ) {
        return true;
    }






}

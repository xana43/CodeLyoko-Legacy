package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntitySkid;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.model.ModelSkid;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.IForgeBakedModel;
import net.minecraftforge.client.model.data.IModelData;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

@OnlyIn(Dist.CLIENT)
public class RendSkid extends EntityRenderer<EntitySkid>{
    private final ModelSkid skid = new ModelSkid();
    IForgeBakedModel wrapper;


    public RendSkid(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
        wrapper = new IForgeBakedModel() {


            @NotNull
            @Override
            public IModelData getModelData(@NotNull BlockAndTintGetter level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull IModelData modelData) {
                return skid.getModelData(level, pos, state, modelData);
            }



            @Nonnull
            @Override
            public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @Nonnull Random rand, @Nonnull IModelData extraData) {
                return skid.getQuads(state, side, rand, extraData);
            }
        };


    }


    @Override
    public void render(@Nonnull EntitySkid entityIn, float entityYaw, float partialTicks, @Nonnull PoseStack matrixStackIn, @NotNull MultiBufferSource bufferIn, int packedLightIn) {

        matrixStackIn.pushPose();
        matrixStackIn.popPose();


        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@Nonnull EntitySkid entity) {
        return CodeLyokoMain.CodeLyokoPrefix("models/entities/skid/95adf18e.png");
    }


}

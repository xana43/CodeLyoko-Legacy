package com.Ultra_Nerd.CodeLyokoLegacy.tileentity.Renderer;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.LyokoCoreBE;
import dev.monarkhes.myron.api.Myron;
import dev.monarkhes.myron.impl.client.model.MyronBakedModel;
import net.fabricmc.fabric.api.client.model.ModelProviderContext;
import net.fabricmc.fabric.api.client.model.ModelProviderException;
import net.fabricmc.fabric.api.client.model.ModelResourceProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.scoreboard.ScoreboardCriterion;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Quaternion;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Random;

public final class CoreOfLyoko implements BlockEntityRenderer<LyokoCoreBE> {

    private static float  y;


    private static final BakedModel lyokoCore;

    static
    {
        lyokoCore = Myron.getModel(CodeLyokoMain.CodeLyokoPrefix("models/block/core_of_lyoko"));
    }

    @Override
    public void render(final LyokoCoreBE entity, final float tickDelta, final MatrixStack matrices, final VertexConsumerProvider vertexConsumers, final int light, final int overlay) {
        //blockRenderDispatcher.renderSingleBlock(ModBlocks.LYOKO_CORE.get().defaultBlockState(),pPoseStack,pBufferSource,pPackedOverlay,pPackedOverlay, EmptyModelData.INSTANCE);
        //this.context.getBlockRenderDispatcher().renderSingleBlock(ModBlocks.LYOKO_CORE.get().defaultBlockState(),pPoseStack,pBufferSource,pPackedLight,pPackedOverlay, EmptyModelData.INSTANCE);
        if(lyokoCore != null) {
            matrices.push();

            //pPoseStack.mulPose(new Quaternion(0,y++,0,true));




                matrices.translate(0.5, 0.5, 0.5);
                matrices.multiply(new Quaternion(0, y += 5, 0, true));
                matrices.translate(-0.5, -0.5, -0.5);

                lyokoCore.getQuads(null, null, Objects.requireNonNull(entity.getWorld()).random).forEach(bakedQuad -> {
                    vertexConsumers.getBuffer(RenderLayer.getTranslucent()).quad(matrices.peek(), bakedQuad, 1, 1, 1, light, overlay);
                });


                //
            matrices.pop();

        }
    }
}

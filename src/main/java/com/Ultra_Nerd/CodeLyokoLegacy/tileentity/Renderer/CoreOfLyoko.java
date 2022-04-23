package com.Ultra_Nerd.CodeLyokoLegacy.tileentity.Renderer;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.LyokoCoreBE;
import dev.monarkhes.myron.api.Myron;
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

import java.util.Random;

public final class CoreOfLyoko<T extends BlockEntity> implements BlockEntityRenderer<T> {

    private static float  y;
    private static final BakedModel lyokoCore = Myron.getModel(CodeLyokoMain.CodeLyokoPrefix("models/block/core_of_lyoko"));
    @Override
    public void render(final T pBlockEntity, final float pPartialTick, final MatrixStack pPoseStack, final VertexConsumerProvider pBufferSource, final int pPackedLight, final int pPackedOverlay) {




    //blockRenderDispatcher.renderSingleBlock(ModBlocks.LYOKO_CORE.get().defaultBlockState(),pPoseStack,pBufferSource,pPackedOverlay,pPackedOverlay, EmptyModelData.INSTANCE);
    //this.context.getBlockRenderDispatcher().renderSingleBlock(ModBlocks.LYOKO_CORE.get().defaultBlockState(),pPoseStack,pBufferSource,pPackedLight,pPackedOverlay, EmptyModelData.INSTANCE);
    pPoseStack.push();

        if(lyokoCore != null) {
    //pPoseStack.mulPose(new Quaternion(0,y++,0,true));

//if(pBlockEntity.getLevel() != null) {

    //CodeLyokoMain.Log.info("should render");
    pPoseStack.translate(0.5, 0.5, 0.5);
            pPoseStack.multiply(new Quaternion(0, y += 5, 0, true));
            pPoseStack.translate(-0.5, -0.5, -0.5);
    lyokoCore.getQuads(null,null,pBlockEntity.getWorld().random).forEach(bakedQuad -> {
        pBufferSource.getBuffer(RenderLayer.getTranslucent()).quad(pPoseStack.peek(), bakedQuad,1,1,1,pPackedLight,pPackedOverlay);
    });



    //

    }
    pPoseStack.pop();

    }



}

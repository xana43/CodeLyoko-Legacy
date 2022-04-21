package com.Ultra_Nerd.CodeLyokoLegacy.tileentity.Renderer;

import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.LyokoCoreBE;
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
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.scoreboard.ScoreboardCriterion;
import net.minecraft.util.math.Quaternion;

import java.util.Random;

public final class CoreOfLyoko<T extends BlockEntity> implements BlockEntityRenderer<T> {

    private final BlockEntityRendererFactory.Context context;
    private float x, y, z;
    //private static final BakedModel lyokoCore;

    static
    {
       // lyokoCore = MinecraftClient.getInstance().getBakedModelManager().getModel(new ModelIdentifier("cm:block/lyoko_core"));
    }

    public CoreOfLyoko( BlockEntityRendererFactory.Context context)
    {
        this.context = context;

    }


    @Override
    public void render(final T pBlockEntity, final float pPartialTick, final MatrixStack pPoseStack, final VertexConsumerProvider pBufferSource, final int pPackedLight, final int pPackedOverlay) {




        //blockRenderDispatcher.renderSingleBlock(ModBlocks.LYOKO_CORE.get().defaultBlockState(),pPoseStack,pBufferSource,pPackedOverlay,pPackedOverlay, EmptyModelData.INSTANCE);
        //this.context.getBlockRenderDispatcher().renderSingleBlock(ModBlocks.LYOKO_CORE.get().defaultBlockState(),pPoseStack,pBufferSource,pPackedLight,pPackedOverlay, EmptyModelData.INSTANCE);
        pPoseStack.push();


       //pPoseStack.mulPose(new Quaternion(0,y++,0,true));

//if(pBlockEntity.getLevel() != null) {

        //CodeLyokoMain.Log.info("should render");
        pPoseStack.translate(0.5,0.5,0.5);
        //this.context.getRenderManager().getModelRenderer().render(pBlockEntity.getWorld(), lyokoCore, Blocks.AIR.getDefaultState(), pBlockEntity.getPos(), pPoseStack, pBufferSource.getBuffer(RenderLayer.getTranslucent()), false,
           //     pBlockEntity.getWorld().getRandom(), new Random().nextLong(), 0);
        MinecraftClient.getInstance().getBlockEntityRenderDispatcher().get(pBlockEntity);
        pPoseStack.multiply(new Quaternion(0,y+=2,0,true));
        pPoseStack.translate(-0.5,-0.5,-0.5);
        //

//}
        pPoseStack.pop();
    }



}

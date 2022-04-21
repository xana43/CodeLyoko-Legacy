package com.Ultra_Nerd.CodeLyokoLegacy.tileentity.Renderer;

import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.LyokoCoreBE;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Quaternion;

public final class CoreOfLyoko implements BlockEntityRenderer<LyokoCoreBE> {

    private final BlockEntityRenderDispatcher context;
    private float x, y, z;
    private static final BakedModel lyokoCore;

    static
    {
        lyokoCore = MinecraftClient.getInstance().getBakedModelManager().getModel(new ModelIdentifier("cm:block/lyoko_core"));
    }

    public CoreOfLyoko( BlockEntityRenderDispatcher context)
    {
        this.context = context;

    }


    @Override
    public void render(final LyokoCoreBE pBlockEntity, final float pPartialTick, final MatrixStack pPoseStack, final VertexConsumerProvider pBufferSource, final int pPackedLight, final int pPackedOverlay) {




        //blockRenderDispatcher.renderSingleBlock(ModBlocks.LYOKO_CORE.get().defaultBlockState(),pPoseStack,pBufferSource,pPackedOverlay,pPackedOverlay, EmptyModelData.INSTANCE);
        //this.context.getBlockRenderDispatcher().renderSingleBlock(ModBlocks.LYOKO_CORE.get().defaultBlockState(),pPoseStack,pBufferSource,pPackedLight,pPackedOverlay, EmptyModelData.INSTANCE);
        pPoseStack.push();


       //pPoseStack.mulPose(new Quaternion(0,y++,0,true));

//if(pBlockEntity.getLevel() != null) {

        //CodeLyokoMain.Log.info("should render");
        pPoseStack.translate(0.5,0.5,0.5);
        //this.context.getBlockRenderDispatcher().getModelRenderer().tesselateWithAO(pBlockEntity.getLevel(), lyokoCore, Blocks.AIR.defaultBlockState(), pBlockEntity.getBlockPos(), pPoseStack, pBufferSource.getBuffer(RenderType.translucent()), false,
          //      pBlockEntity.getLevel().random, new Random().nextLong(), 0);
        pPoseStack.multiply(new Quaternion(0,y+=2,0,true));
        pPoseStack.translate(-0.5,-0.5,-0.5);
        this.context.render(pBlockEntity,pPartialTick,pPoseStack,pBufferSource);


//}
        pPoseStack.pop();
    }



}

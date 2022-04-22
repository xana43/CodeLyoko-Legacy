package com.Ultra_Nerd.CodeLyokoLegacy.tileentity.Renderer;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.LyokoCoreBE;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Quaternion;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.level.block.Blocks;

public final class CoreOfLyoko implements BlockEntityRenderer<LyokoCoreBE> {

    private final BlockEntityRendererProvider.Context context;
    private static float y;
    private static final BakedModel lyokoCore;

    static
    {
        lyokoCore = Minecraft.getInstance().getModelManager().getModel(CodeLyokoMain.CodeLyokoPrefix("block/lyoko_core"));
    }

    public CoreOfLyoko( BlockEntityRendererProvider.Context context)
    {
        this.context = context;

    }


    @Override
    public void render(final LyokoCoreBE pBlockEntity, final float pPartialTick, final PoseStack pPoseStack, final MultiBufferSource pBufferSource, final int pPackedLight, final int pPackedOverlay) {




        //blockRenderDispatcher.renderSingleBlock(ModBlocks.LYOKO_CORE.get().defaultBlockState(),pPoseStack,pBufferSource,pPackedOverlay,pPackedOverlay, EmptyModelData.INSTANCE);
        //this.context.getBlockRenderDispatcher().renderSingleBlock(ModBlocks.LYOKO_CORE.get().defaultBlockState(),pPoseStack,pBufferSource,pPackedLight,pPackedOverlay, EmptyModelData.INSTANCE);
        pPoseStack.pushPose();


       //pPoseStack.mulPose(new Quaternion(0,y++,0,true));

//if(pBlockEntity.getLevel() != null) {

        //CodeLyokoMain.Log.info("should render");
        pPoseStack.translate(0.5,0.5,0.5);
        //this.context.getBlockRenderDispatcher().getModelRenderer().tesselateWithAO(pBlockEntity.getLevel(), lyokoCore, Blocks.AIR.defaultBlockState(), pBlockEntity.getBlockPos(), pPoseStack, pBufferSource.getBuffer(RenderType.translucent()), false,
          //      pBlockEntity.getLevel().random, new Random().nextLong(), 0);
        pPoseStack.mulPose(new Quaternion(0,y+=5,0,true));
        pPoseStack.translate(-0.5,-0.5,-0.5);
        this.context.getBlockRenderDispatcher().getModelRenderer().tesselateWithoutAO(pBlockEntity.getLevel(), lyokoCore, Blocks.AIR.defaultBlockState(), pBlockEntity.getBlockPos(), pPoseStack, pBufferSource.getBuffer(RenderType.translucent()), false,
                pBlockEntity.getLevel().random, 0, 0);


//}
        pPoseStack.popPose();
    }


}

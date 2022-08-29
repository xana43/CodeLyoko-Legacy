package com.Ultra_Nerd.CodeLyokoLegacy.tileentity.Renderer;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.client.APIEmbed.api.Myron;
import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.LyokoCoreBE;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3f;
import net.minecraft.world.World;

public record CoreOfLyoko(BlockEntityRendererFactory.Context context) implements BlockEntityRenderer<LyokoCoreBE> {

    private static int  y;

    private static final BakedModel lyokoCore = Myron.getModel(CodeLyokoMain.CodeLyokoPrefix("models/blocks/core_of_lyoko"));

    @Override
    public int getRenderDistance() {
        return 128;
    }

    @Override
    public void render(final LyokoCoreBE entity, final float tickDelta, final MatrixStack matrices, final VertexConsumerProvider vertexConsumers, final int light, final int overlay) {
        //blockRenderDispatcher.renderSingleBlock(ModBlocks.LYOKO_CORE.get().defaultBlockState(),pPoseStack,pBufferSource,pPackedOverlay,pPackedOverlay, EmptyModelData.INSTANCE);
        //this.context.getBlockRenderDispatcher().renderSingleBlock(ModBlocks.LYOKO_CORE.get().defaultBlockState(),pPoseStack,pBufferSource,pPackedLight,pPackedOverlay, EmptyModelData.INSTANCE);
       // if(lyokoCore != null) {

            matrices.push();

            //pPoseStack.mulPose(new Quaternion(0,y++,0,true));



                final World entityWorld = entity.getWorld();
                matrices.translate(0.5, 0.5, 0.5);
                matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(y +=6));
                if(y == 360)
                {
                    y = 0;
                }
                matrices.translate(-0.5, -0.5, -0.5);

            //MinecraftClient.getInstance().getBlockEntityRenderDispatcher().renderEntity(entity,matrices,vertexConsumers,light,overlay);

            context.getRenderManager().getModelRenderer().render(entityWorld, lyokoCore, Blocks.AIR.getDefaultState(), entity.getPos(), matrices, vertexConsumers.getBuffer(RenderLayer.getTranslucentMovingBlock()), true, entityWorld.getRandom(), 0, overlay);

            matrices.pop();


        //}
    }
}

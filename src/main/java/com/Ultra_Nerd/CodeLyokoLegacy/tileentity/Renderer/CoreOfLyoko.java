package com.Ultra_Nerd.CodeLyokoLegacy.tileentity.Renderer;

import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.LyokoCoreBE;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;

public record CoreOfLyoko(BlockEntityRendererFactory.Context context) implements BlockEntityRenderer<LyokoCoreBE> {

    //private static final BakedModel lyokoCore = Myron.getModel(
    //      CodeLyokoMain.codeLyokoPrefix("models/blocks/core_of_lyoko"));
    private static int y;

    @Override
    public int getRenderDistance() {
        return 128;
    }

    @Override
    public void render(final LyokoCoreBE entity, final float tickDelta, final MatrixStack matrices, final VertexConsumerProvider vertexConsumers, final int light, final int overlay) {

        matrices.push();
        final World entityWorld = entity.getWorld();
        matrices.translate(0.5, 0.5, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(y += 6));
        if (y == 360) {
            y = 0;
        }
        matrices.translate(-0.5, -0.5, -0.5);
        //context.getRenderManager().getModelRenderer()
        //      .render(entityWorld, lyokoCore, Blocks.AIR.getDefaultState(), entity.getPos(), matrices,
        //            vertexConsumers.getBuffer(RenderLayer.getTranslucentMovingBlock()), true,
        //          entityWorld.getRandom(), 0, overlay);

        matrices.pop();


        //}
    }
}

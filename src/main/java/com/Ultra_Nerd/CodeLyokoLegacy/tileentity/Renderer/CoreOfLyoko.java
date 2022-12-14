package com.Ultra_Nerd.CodeLyokoLegacy.tileentity.Renderer;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.LyokoCoreBE;
import com.Ultra_Nerd.CodeLyokoLegacy.util.client.APIEmbed.api.Myron;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
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

    private static final BakedModel lyokoCore = Myron.getModel(
            CodeLyokoMain.codeLyokoPrefix("models/blocks/core_of_lyoko"));
    private static int y;

    @Override
    public int getRenderDistance() {
        return 128;
    }

    @SuppressFBWarnings("ST_WRITE_TO_STATIC_FROM_INSTANCE_METHOD")
    @Override
    public void render(final LyokoCoreBE entity, final float tickDelta, final MatrixStack matrices, final VertexConsumerProvider vertexConsumers, final int light, final int overlay) {

        matrices.push();
        final World entityWorld = entity.getWorld();
        matrices.translate(0.5, 0.5, 0.5);
        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(y += 6));
        if (y == 360) {
            y = 0;
        }
        matrices.translate(-0.5, -0.5, -0.5);
        context.getRenderManager().getModelRenderer()
                .render(entityWorld, lyokoCore, Blocks.AIR.getDefaultState(), entity.getPos(), matrices,
                        vertexConsumers.getBuffer(RenderLayer.getTranslucentMovingBlock()), true,
                        entityWorld.getRandom(), 0, overlay);

        matrices.pop();


        //}
    }
}

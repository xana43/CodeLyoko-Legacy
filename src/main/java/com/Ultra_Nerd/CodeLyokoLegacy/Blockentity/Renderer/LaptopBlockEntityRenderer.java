package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Renderer;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.LaptopBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

/**
 * @author Ultra_Nerd
 * @desc <br/>
 * @since 2025-04-07
 */
public final class LaptopBlockEntityRenderer extends GeoBlockRenderer<LaptopBlockEntity> {
    private static final class LaptopGeoModel extends GeoModel<LaptopBlockEntity> {
        private static final Identifier model = CodeLyokoMain.codeLyokoPrefix("block/jeremy_laptop");
        private static final Identifier animation = CodeLyokoMain.codeLyokoPrefix("block/jeremy_laptop");
        //private static final Identifier texture = CodeLyokoMain.codeLyokoPrefix();

        @Override
        public Identifier getModelResource(GeoRenderState renderState) {
            return model;
        }

        @Override
        public Identifier getTextureResource(GeoRenderState renderState) {
            return null;
        }

        @Override
        public Identifier getAnimationResource(LaptopBlockEntity animatable) {
            return animation;
        }
    }
    public LaptopBlockEntityRenderer(final BlockEntityRendererFactory.Context context) {
        super(new LaptopGeoModel());
    }

    @Override
    protected void rotateBlock(Direction facing, MatrixStack poseStack) {
        switch (facing) {
            case SOUTH -> poseStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0));
            case WEST -> poseStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(270.0F));
            case NORTH -> poseStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F));
            case EAST -> poseStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90.0F));
            case UP -> poseStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F));
            case DOWN -> poseStack.multiply(RotationAxis.NEGATIVE_X.rotationDegrees(90.0F));
        }
    }
}

package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Renderer;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.SuperComputerCoreBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

/**
 * @author Ultra_Nerd
 * @desc <br/>
 * @since 2025-06-14
 */
@Environment(EnvType.CLIENT)
public final class SuperComputerBlockEntityRenderer extends GeoBlockRenderer<SuperComputerCoreBlockEntity> {

    private static final class SuperComputerModel extends GeoModel<SuperComputerCoreBlockEntity> {
        private static final Identifier model = CodeLyokoMain.codeLyokoPrefix("supercomputer");
        private static final Identifier animation = CodeLyokoMain.codeLyokoPrefix("block/supercomputer");
        private static final Identifier texture = CodeLyokoMain.codeLyokoPrefix("textures/block/supercomputer/supercomputer.png");
        @Override
        public Identifier getModelResource(GeoRenderState renderState) {
            return model;
        }

        @Override
        public Identifier getTextureResource(GeoRenderState renderState) {
            return texture;
        }

        @Override
        public Identifier getAnimationResource(SuperComputerCoreBlockEntity animatable) {
            return animation;
        }
    }
    public SuperComputerBlockEntityRenderer(final BlockEntityRendererFactory.Context context) {
        super(new SuperComputerModel());
    }
}

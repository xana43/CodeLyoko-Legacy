package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.MantaEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class MantaRenderer extends GeoEntityRenderer<MantaEntity> {

//new ModelManta(), 2f
    public MantaRenderer(EntityRendererProvider.Context renderManagerIn, AnimatedGeoModel<MantaEntity> manta) {
        super(renderManagerIn,manta);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@Nonnull MantaEntity entity) {
        return CodeLyokoMain.CodeLyokoPrefix("textures/entity/manta/mantatemplate.png");
    }
}

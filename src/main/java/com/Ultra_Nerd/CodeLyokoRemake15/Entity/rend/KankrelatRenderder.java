package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.KankrelatEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class KankrelatRenderder extends GeoEntityRenderer<KankrelatEntity> {

    private static final ResourceLocation Tex = new ResourceLocation(CodeLyokoMain.MOD_ID, "textures/entity/kankrelat/kankrelattemplate.png");
 //new ModelKankrelat(), 0.5f
    public KankrelatRenderder(EntityRendererProvider.Context renderManagerIn, AnimatedGeoModel<KankrelatEntity> kanKrelatModel) {
        super(renderManagerIn,kanKrelatModel);
        this.shadowRadius = 0.5f;
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@Nonnull KankrelatEntity entity) {
        return Tex;
    }
}

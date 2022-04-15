package com.Ultra_Nerd.CodeLyokoLegacy.Entity.rend;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.KankrelatEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nonnull;


public final class KankrelatRenderder extends GeoEntityRenderer<KankrelatEntity> {

    private static final ResourceLocation Tex = new ResourceLocation(CodeLyokoMain.MOD_ID, "textures/entity/kankrelat/kankrelattemplate.png");
 //new ModelKankrelat(), 0.5f
    public KankrelatRenderder(EntityRendererProvider.@NotNull Context renderManagerIn, AnimatedGeoModel<KankrelatEntity> kanKrelatModel) {
        super(renderManagerIn,kanKrelatModel);
        this.shadowRadius = 0.5f;
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@Nonnull KankrelatEntity entity) {
        return Tex;
    }
}

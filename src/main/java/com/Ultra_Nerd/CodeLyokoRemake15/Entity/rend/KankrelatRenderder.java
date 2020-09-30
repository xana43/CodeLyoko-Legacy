package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.KankrelatEntity;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.model.ModelKankrelat;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
@OnlyIn(Dist.CLIENT)
public class KankrelatRenderder extends MobRenderer<KankrelatEntity, ModelKankrelat> {

    private static final ResourceLocation Tex = new ResourceLocation(Base.MOD_ID,"textures/entity/kankrelat/kankrelattemplate.png");
    public KankrelatRenderder(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelKankrelat(), 0.5f);
    }

    @Nonnull
    @Override
    public ResourceLocation getEntityTexture(@Nonnull KankrelatEntity entity) {
        return Tex;
    }
}

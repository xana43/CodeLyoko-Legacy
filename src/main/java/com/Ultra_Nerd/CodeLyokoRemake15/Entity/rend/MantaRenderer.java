package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.MantaEntity;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.model.ModelManta;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class MantaRenderer extends MobRenderer<MantaEntity, ModelManta> {
    private static final ResourceLocation resourceLocation = new ResourceLocation(Base.MOD_ID, "textures/entity/manta/mantatemplate.png");

    public MantaRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelManta(), 2f);
    }

    @Nonnull
    @Override
    public ResourceLocation getEntityTexture(@Nonnull MantaEntity entity) {
        return resourceLocation;
    }
}

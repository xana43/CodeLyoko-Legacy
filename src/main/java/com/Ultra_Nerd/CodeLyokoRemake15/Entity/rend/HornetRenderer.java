package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.HornetEntity;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.model.ModelHornet;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class HornetRenderer extends MobRenderer<HornetEntity, ModelHornet<HornetEntity>> {

    protected static final ResourceLocation tex = new ResourceLocation(Base.MOD_ID,"textures/entity/hornet.png");

    public HornetRenderer(EntityRendererManager rendManIn)
    {
        super(rendManIn,new ModelHornet<HornetEntity>() ,1f);
    }

    @Nonnull
    @Override
    public ResourceLocation getEntityTexture(@Nonnull HornetEntity entity) {
        return tex;
    }

}

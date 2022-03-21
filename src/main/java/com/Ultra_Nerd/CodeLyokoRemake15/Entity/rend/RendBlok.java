package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityBlok;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.model.ModelBlok;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

@OnlyIn(Dist.CLIENT)
public class RendBlok extends GeoEntityRenderer<EntityBlok> {



    public RendBlok(EntityRendererProvider.Context renderManager) {
        super(renderManager,new ModelBlok());

    }


}

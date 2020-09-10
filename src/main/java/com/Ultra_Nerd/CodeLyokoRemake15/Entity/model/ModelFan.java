// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package com.Ultra_Nerd.CodeLyokoRemake15.Entity.model;

import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityFan;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class ModelFan extends AnimatedEntityModel<EntityFan> {

    private final AnimatedModelRenderer fanbody;

    public ModelFan()
    {
        textureWidth = 32;
    textureHeight = 32;
    fanbody = new AnimatedModelRenderer(this);
		fanbody.setRotationPoint(0.0F, 23.5F, 0.0F);
		fanbody.setTextureOffset(0, 0).addBox(-3.0F, -0.5F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		fanbody.setTextureOffset(0, 0).addBox(-2.0F, -0.5F, 3.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		fanbody.setTextureOffset(6, 6).addBox(-2.0F, -0.5F, -4.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		fanbody.setTextureOffset(3, 0).addBox(3.0F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		fanbody.setTextureOffset(3, 0).addBox(-4.0F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		fanbody.setModelRendererName("fanbody");
		this.registerModelRenderer(fanbody);

    this.rootBones.add(fanbody);
  }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation("cm", "animations/entities/fan.json");
    }
}
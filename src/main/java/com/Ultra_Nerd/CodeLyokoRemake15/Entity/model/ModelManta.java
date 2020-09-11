// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package com.Ultra_Nerd.CodeLyokoRemake15.Entity.model;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class animated_entity_model extends AnimatedEntityModel<MantaEntity> {

    private final AnimatedModelRenderer mainbody;
	private final AnimatedModelRenderer face;
	private final AnimatedModelRenderer tail;
	private final AnimatedModelRenderer wing2;
	private final AnimatedModelRenderer wing1;

    public animated_entity_model()
    {
        textureWidth = 64;
    textureHeight = 64;
    mainbody = new AnimatedModelRenderer(this);
		mainbody.setRotationPoint(-0.2F, 23.6F, 0.0F);
		setRotationAngle(mainbody, -3.1416F, 0.0F, 3.1416F);
		mainbody.setTextureOffset(0, 0).addBox(-4.8F, -3.6F, -8.0F, 8.0F, 4.0F, 16.0F, 0.0F, false);
		mainbody.setModelRendererName("mainbody");
		this.registerModelRenderer(mainbody);

		face = new AnimatedModelRenderer(this);
		face.setRotationPoint(-0.8F, 0.4F, 11.0F);
		mainbody.addChild(face);
		setRotationAngle(face, 0.0F, -1.5708F, 0.0F);
		face.setTextureOffset(36, 36).addBox(-3.0F, -4.0F, -4.0F, 2.0F, 4.0F, 8.0F, 0.0F, false);
		face.setTextureOffset(46, 0).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 6.0F, 0.0F, false);
		face.setTextureOffset(0, 20).addBox(1.0F, -2.0F, -2.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);
		face.setModelRendererName("face");
		this.registerModelRenderer(face);

		tail = new AnimatedModelRenderer(this);
		tail.setRotationPoint(-0.8F, -0.1F, -11.0F);
		mainbody.addChild(tail);
		setRotationAngle(tail, 0.0F, 1.5708F, -3.1416F);
		tail.setTextureOffset(0, 35).addBox(-3.0F, -0.5F, -4.0F, 2.0F, 4.0F, 8.0F, 0.0F, false);
		tail.setTextureOffset(0, 0).addBox(-1.0F, -0.5F, -3.0F, 2.0F, 3.0F, 6.0F, 0.0F, false);
		tail.setTextureOffset(16, 20).addBox(1.0F, -0.5F, -2.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);
		tail.setTextureOffset(24, 20).addBox(3.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		tail.setModelRendererName("tail");
		this.registerModelRenderer(tail);

		wing2 = new AnimatedModelRenderer(this);
		wing2.setRotationPoint(-7.8F, -1.1F, 0.0F);
		mainbody.addChild(wing2);
		setRotationAngle(wing2, 0.0F, 0.0F, -3.1416F);
		wing2.setTextureOffset(0, 20).addBox(-3.0F, -0.5F, -6.0F, 2.0F, 3.0F, 12.0F, 0.0F, false);
		wing2.setTextureOffset(32, 0).addBox(-1.0F, -0.5F, -5.0F, 2.0F, 2.0F, 10.0F, 0.0F, false);
		wing2.setTextureOffset(12, 39).addBox(1.0F, -0.5F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
		wing2.setTextureOffset(0, 9).addBox(3.0F, -0.5F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
		wing2.setModelRendererName("wing2");
		this.registerModelRenderer(wing2);

		wing1 = new AnimatedModelRenderer(this);
		wing1.setRotationPoint(10.2F, 0.4F, 0.0F);
		mainbody.addChild(wing1);
		wing1.setTextureOffset(16, 23).addBox(-7.0F, -4.0F, -6.0F, 2.0F, 3.0F, 12.0F, 0.0F, false);
		wing1.setTextureOffset(32, 20).addBox(-5.0F, -3.0F, -5.0F, 2.0F, 2.0F, 10.0F, 0.0F, false);
		wing1.setTextureOffset(24, 40).addBox(-3.0F, -2.0F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
		wing1.setTextureOffset(46, 14).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
		wing1.setModelRendererName("wing1");
		this.registerModelRenderer(wing1);

    this.rootBones.add(mainbody);
  }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation("cm", "animations/entities/manta.json");
    }
}
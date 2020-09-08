// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package com.Ultra_Nerd.CodeLyokoRemake15.Entity.model;

import com.Ultra_Nerd.CodeLyokoRemake15.Entity.HornetEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class ModelHornet extends AnimatedEntityModel<HornetEntity> {

    private final AnimatedModelRenderer body;
	private final AnimatedModelRenderer mainbody;
	private final AnimatedModelRenderer wingL;
	private final AnimatedModelRenderer wingR;
	private final AnimatedModelRenderer stinger;
	private final AnimatedModelRenderer head;
	private final AnimatedModelRenderer proboscis;

    public ModelHornet()
    {
        textureWidth = 16;
    textureHeight = 16;
    body = new AnimatedModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		
		body.setModelRendererName("body");
		this.registerModelRenderer(body);

		mainbody = new AnimatedModelRenderer(this);
		mainbody.setRotationPoint(-0.9F, -8.0F, -1.0F);
		body.addChild(mainbody);
		mainbody.setTextureOffset(0, 0).addBox(-0.875F, -1.875F, 1.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		mainbody.setModelRendererName("mainbody");
		this.registerModelRenderer(mainbody);

		wingL = new AnimatedModelRenderer(this);
		wingL.setRotationPoint(0.8875F, -1.6F, 2.5F);
		mainbody.addChild(wingL);
		wingL.setTextureOffset(0, 0).addBox(-0.0125F, 0.0F, -1.5F, 2.0F, 0.0F, 3.0F, 0.0F, false);
		wingL.setModelRendererName("wingL");
		this.registerModelRenderer(wingL);

		wingR = new AnimatedModelRenderer(this);
		wingR.setRotationPoint(-0.8375F, -1.6F, 2.5F);
		mainbody.addChild(wingR);
		wingR.setTextureOffset(0, 2).addBox(-2.5125F, 0.0F, -1.5F, 2.0F, 0.0F, 3.0F, 0.0F, false);
		wingR.setModelRendererName("wingR");
		this.registerModelRenderer(wingR);

		stinger = new AnimatedModelRenderer(this);
		stinger.setRotationPoint(0.0F, 0.0F, 3.0F);
		mainbody.addChild(stinger);
		stinger.setTextureOffset(2, 5).addBox(-0.25F, -1.275F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, false);
		stinger.setModelRendererName("stinger");
		this.registerModelRenderer(stinger);

		head = new AnimatedModelRenderer(this);
		head.setRotationPoint(0.0F, -1.0F, 1.0F);
		mainbody.addChild(head);
		head.setTextureOffset(5, 5).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		head.setModelRendererName("head");
		this.registerModelRenderer(head);

		proboscis = new AnimatedModelRenderer(this);
		proboscis.setRotationPoint(-0.7F, 0.575F, -1.5F);
		head.addChild(proboscis);
		proboscis.setTextureOffset(2, 12).addBox(0.45F, -0.5F, -1.425F, 0.0F, 0.0F, 0.0F, 0.0F, false);
		proboscis.setModelRendererName("proboscis");
		this.registerModelRenderer(proboscis);

    this.rootBones.add(body);

  }



	@Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation("cm", "animations/entities/hornet.json");
    }
}
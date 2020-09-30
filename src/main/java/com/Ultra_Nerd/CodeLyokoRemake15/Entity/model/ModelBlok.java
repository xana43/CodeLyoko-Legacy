// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package com.Ultra_Nerd.CodeLyokoRemake15.Entity.model;

import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityBlok;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class ModelBlok extends AnimatedEntityModel<EntityBlok> {

    private final AnimatedModelRenderer Body;
    private final AnimatedModelRenderer Joint;
    private final AnimatedModelRenderer Leg;
    private final AnimatedModelRenderer leglower;
    private final AnimatedModelRenderer Leg2;
    private final AnimatedModelRenderer leglower2;
    private final AnimatedModelRenderer Leg3;
    private final AnimatedModelRenderer leglower3;
    private final AnimatedModelRenderer Leg4;
    private final AnimatedModelRenderer leglower4;
    private final AnimatedModelRenderer Leg5;
    private final AnimatedModelRenderer leglower5;
    private final AnimatedModelRenderer Leg6;
    private final AnimatedModelRenderer leglower6;

    public ModelBlok() {
        textureWidth = 128;
        textureHeight = 128;
        Body = new AnimatedModelRenderer(this);
        Body.setRotationPoint(0.0F, 24.0F, 0.0F);
        Body.setTextureOffset(0, 0).addBox(-16.0F, -41.0F, -16.0F, 32.0F, 32.0F, 32.0F, 0.0F, false);
        Body.setModelRendererName("Body");
        this.registerModelRenderer(Body);

        Joint = new AnimatedModelRenderer(this);
        Joint.setRotationPoint(-3.0F, -8.0F, 1.0F);
        Body.addChild(Joint);
        Joint.setTextureOffset(14, 26).addBox(-1.0F, -1.0F, -3.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
        Joint.setTextureOffset(0, 0).addBox(0.0F, -1.0F, -4.0F, 6.0F, 2.0F, 6.0F, 0.0F, false);
        Joint.setTextureOffset(0, 26).addBox(6.0F, -1.0F, -3.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
        Joint.setTextureOffset(46, 64).addBox(1.0F, -1.0F, 2.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
        Joint.setTextureOffset(36, 64).addBox(1.0F, -1.0F, -5.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
        Joint.setModelRendererName("Joint");
        this.registerModelRenderer(Joint);

        Leg = new AnimatedModelRenderer(this);
        Leg.setRotationPoint(4.5342F, 0.8057F, -4.8799F);
        Joint.addChild(Leg);
        setRotationAngle(Leg, -0.623F, 0.1603F, -1.4539F);
        Leg.setTextureOffset(0, 64).addBox(-0.4776F, 0.6887F, 0.3187F, 1.0F, 16.0F, 2.0F, 0.0F, false);
        Leg.setModelRendererName("Leg");
        this.registerModelRenderer(Leg);

        leglower = new AnimatedModelRenderer(this);
        leglower.setRotationPoint(-0.1907F, 16.1913F, 0.8928F);
        Leg.addChild(leglower);
        setRotationAngle(leglower, 0.0F, 0.0F, 1.6144F);
        leglower.setTextureOffset(30, 64).addBox(0.4554F, -4.5427F, -0.5F, 1.0F, 9.0F, 2.0F, 0.0F, false);
        leglower.setModelRendererName("leglower");
        this.registerModelRenderer(leglower);

        Leg2 = new AnimatedModelRenderer(this);
        Leg2.setRotationPoint(5.0146F, 0.8057F, -0.8799F);
        Joint.addChild(Leg2);
        setRotationAngle(Leg2, 0.0277F, -0.0359F, -1.3441F);
        Leg2.setTextureOffset(24, 0).addBox(-0.1058F, 0.6887F, -1.0828F, 1.0F, 16.0F, 2.0F, 0.0F, false);
        Leg2.setModelRendererName("Leg2");
        this.registerModelRenderer(Leg2);

        leglower2 = new AnimatedModelRenderer(this);
        leglower2.setRotationPoint(-0.2625F, 16.1359F, -1.1051F);
        Leg2.addChild(leglower2);
        setRotationAngle(leglower2, 0.0F, 0.0F, 1.6144F);
        leglower2.setTextureOffset(24, 64).addBox(0.3008F, -4.4873F, 0.0965F, 1.0F, 9.0F, 2.0F, 0.0F, false);
        leglower2.setModelRendererName("leglower2");
        this.registerModelRenderer(leglower2);

        Leg3 = new AnimatedModelRenderer(this);
        Leg3.setRotationPoint(5.0146F, 0.8057F, 2.1201F);
        Joint.addChild(Leg3);
        setRotationAngle(Leg3, 0.6643F, -0.1646F, -1.4102F);
        Leg3.setTextureOffset(18, 8).addBox(-0.1897F, 0.6887F, -1.5786F, 1.0F, 16.0F, 2.0F, 0.0F, false);
        Leg3.setModelRendererName("Leg3");
        this.registerModelRenderer(Leg3);

        leglower3 = new AnimatedModelRenderer(this);
        leglower3.setRotationPoint(-0.2984F, 16.1082F, -1.1041F);
        Leg3.addChild(leglower3);
        setRotationAngle(leglower3, 0.0F, 0.0F, 1.6144F);
        leglower3.setTextureOffset(18, 64).addBox(0.0418F, -4.4596F, -0.4004F, 1.0F, 9.0F, 2.0F, 0.0F, false);
        leglower3.setModelRendererName("leglower3");
        this.registerModelRenderer(leglower3);

        Leg4 = new AnimatedModelRenderer(this);
        Leg4.setRotationPoint(0.0146F, 0.8057F, 1.1201F);
        Joint.addChild(Leg4);
        setRotationAngle(Leg4, 2.4783F, -0.1188F, -1.7675F);
        Leg4.setTextureOffset(12, 12).addBox(-0.1058F, 0.6887F, -1.0828F, 1.0F, 16.0F, 2.0F, 0.0F, false);
        Leg4.setModelRendererName("Leg4");
        this.registerModelRenderer(Leg4);

        leglower4 = new AnimatedModelRenderer(this);
        leglower4.setRotationPoint(-0.2984F, 16.1082F, -1.1041F);
        Leg4.addChild(leglower4);
        setRotationAngle(leglower4, 0.0F, 0.0F, 1.6144F);
        leglower4.setTextureOffset(12, 64).addBox(0.3367F, -4.4596F, 0.0955F, 1.0F, 9.0F, 2.0F, 0.0F, false);
        leglower4.setModelRendererName("leglower4");
        this.registerModelRenderer(leglower4);

        Leg5 = new AnimatedModelRenderer(this);
        Leg5.setRotationPoint(0.0146F, 0.8057F, -1.1533F);
        Joint.addChild(Leg5);
        setRotationAngle(Leg5, -3.1394F, 0.03F, -1.7983F);
        Leg5.setTextureOffset(6, 8).addBox(-0.1058F, 0.6887F, -1.0828F, 1.0F, 16.0F, 2.0F, 0.0F, false);
        Leg5.setModelRendererName("Leg5");
        this.registerModelRenderer(Leg5);

        leglower5 = new AnimatedModelRenderer(this);
        leglower5.setRotationPoint(-0.2625F, 16.1359F, -1.1051F);
        Leg5.addChild(leglower5);
        setRotationAngle(leglower5, 0.0F, 0.0F, 1.6144F);
        leglower5.setTextureOffset(6, 64).addBox(0.3008F, -4.4873F, 0.0965F, 1.0F, 9.0F, 2.0F, 0.0F, false);
        leglower5.setModelRendererName("leglower5");
        this.registerModelRenderer(leglower5);

        Leg6 = new AnimatedModelRenderer(this);
        Leg6.setRotationPoint(0.7695F, 0.8057F, -3.4307F);
        Joint.addChild(Leg6);
        setRotationAngle(Leg6, -2.4948F, 0.1617F, -1.7342F);
        Leg6.setTextureOffset(0, 8).addBox(-0.1058F, 0.6887F, -1.0828F, 1.0F, 16.0F, 2.0F, 0.0F, false);
        Leg6.setModelRendererName("Leg6");
        this.registerModelRenderer(Leg6);

        leglower6 = new AnimatedModelRenderer(this);
        leglower6.setRotationPoint(-0.2625F, 16.1359F, -1.1051F);
        Leg6.addChild(leglower6);
        setRotationAngle(leglower6, 0.0F, 0.0F, 1.6144F);
        leglower6.setTextureOffset(24, 18).addBox(0.3008F, -4.4873F, 0.0965F, 1.0F, 9.0F, 2.0F, 0.0F, false);
        leglower6.setModelRendererName("leglower6");
        this.registerModelRenderer(leglower6);

        this.rootBones.add(Body);
    }


    @Override
    public ResourceLocation getAnimationFileLocation() {
        return new ResourceLocation("cm", "animations/entities/blok.json");
    }
}
// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package com.Ultra_Nerd.CodeLyokoRemake15.Entity.model;

import com.Ultra_Nerd.CodeLyokoRemake15.Entity.KankrelatEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class ModelKankrelat extends AnimatedEntityModel<KankrelatEntity> {

    private final AnimatedModelRenderer body;
    private final AnimatedModelRenderer joint;
    private final AnimatedModelRenderer Leg;
    private final AnimatedModelRenderer lowerleg;
    private final AnimatedModelRenderer Leg2;
    private final AnimatedModelRenderer lowerleg2;
    private final AnimatedModelRenderer Leg3;
    private final AnimatedModelRenderer lowerleg3;
    private final AnimatedModelRenderer Leg4;
    private final AnimatedModelRenderer lowerleg4;

    public ModelKankrelat() {
        textureWidth = 64;
        textureHeight = 64;
        body = new AnimatedModelRenderer(this);
        body.setRotationPoint(-3.0F, 19.6016F, 5.0F);
        body.setTextureOffset(0, 0).addBox(-1.0F, -5.6016F, -6.0F, 8.0F, 5.0F, 3.0F, 0.0F, false);
        body.setTextureOffset(20, 14).addBox(0.0F, -4.6016F, -7.0F, 6.0F, 5.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(20, 8).addBox(0.0F, -3.6016F, -8.0F, 6.0F, 5.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(0, 24).addBox(1.0F, -2.6016F, -9.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(22, 27).addBox(2.0F, -1.6016F, -10.0F, 2.0F, 3.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(32, 0).addBox(2.0F, -0.6016F, -11.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(20, 20).addBox(-1.0F, -6.6016F, -3.0F, 8.0F, 5.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(0, 16).addBox(-1.0F, -6.6016F, -1.0F, 8.0F, 6.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(0, 8).addBox(-1.0F, -6.0F, 1.0F, 8.0F, 6.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(22, 0).addBox(1.0F, -5.0F, 3.0F, 4.0F, 5.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(10, 24).addBox(2.0F, -4.0F, 4.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(28, 28).addBox(2.0F, -1.0F, 5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        body.setModelRendererName("body");
        this.registerModelRenderer(body);

        joint = new AnimatedModelRenderer(this);
        joint.setRotationPoint(3.0F, 2.0095F, -7.6667F);
        body.addChild(joint);
        joint.setTextureOffset(14, 27).addBox(-1.0F, -0.6111F, -1.3333F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        joint.setTextureOffset(30, 32).addBox(-2.0F, -0.6111F, -1.3333F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        joint.setTextureOffset(6, 32).addBox(1.0F, -0.6111F, -1.3333F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        joint.setTextureOffset(12, 33).addBox(-1.0F, -0.6111F, -2.3333F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        joint.setTextureOffset(22, 6).addBox(-1.0F, -0.6111F, 0.6667F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        joint.setModelRendererName("joint");
        this.registerModelRenderer(joint);

        Leg = new AnimatedModelRenderer(this);
        Leg.setRotationPoint(-1.1406F, 0.0031F, -1.5228F);
        joint.addChild(Leg);
        setRotationAngle(Leg, 0.7418F, 0.7418F, 0.0F);
        Leg.setTextureOffset(0, 32).addBox(-0.4449F, -0.4713F, -2.4489F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        Leg.setModelRendererName("Leg");
        this.registerModelRenderer(Leg);

        lowerleg = new AnimatedModelRenderer(this);
        lowerleg.setRotationPoint(-0.2093F, -0.4619F, -2.7706F);
        Leg.addChild(lowerleg);
        setRotationAngle(lowerleg, 0.9599F, 0.0F, 0.0F);
        lowerleg.setTextureOffset(26, 31).addBox(-0.1914F, -0.6143F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        lowerleg.setModelRendererName("lowerleg");
        this.registerModelRenderer(lowerleg);

        Leg2 = new AnimatedModelRenderer(this);
        Leg2.setRotationPoint(-1.1445F, 0.0031F, 0.8229F);
        joint.addChild(Leg2);
        setRotationAngle(Leg2, -2.3998F, 0.7418F, -3.1416F);
        Leg2.setTextureOffset(20, 31).addBox(-0.5408F, -0.4569F, -2.4332F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        Leg2.setModelRendererName("Leg2");
        this.registerModelRenderer(Leg2);

        lowerleg2 = new AnimatedModelRenderer(this);
        lowerleg2.setRotationPoint(-0.3052F, -0.4475F, -2.7548F);
        Leg2.addChild(lowerleg2);
        setRotationAngle(lowerleg2, 0.9599F, 0.0F, 0.0F);
        lowerleg2.setTextureOffset(30, 4).addBox(-0.1914F, -0.6143F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        lowerleg2.setModelRendererName("lowerleg2");
        this.registerModelRenderer(lowerleg2);

        Leg3 = new AnimatedModelRenderer(this);
        Leg3.setRotationPoint(1.1611F, 0.0031F, -1.5062F);
        joint.addChild(Leg3);
        setRotationAngle(Leg3, 0.7418F, -0.7418F, 0.0F);
        Leg3.setTextureOffset(16, 30).addBox(-0.5735F, -0.4322F, -2.4062F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        Leg3.setModelRendererName("Leg3");
        this.registerModelRenderer(Leg3);

        lowerleg3 = new AnimatedModelRenderer(this);
        lowerleg3.setRotationPoint(-0.3379F, -0.4227F, -2.7279F);
        Leg3.addChild(lowerleg3);
        setRotationAngle(lowerleg3, 0.9599F, 0.0F, 0.0F);
        lowerleg3.setTextureOffset(10, 30).addBox(-0.1914F, -0.6143F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        lowerleg3.setModelRendererName("lowerleg3");
        this.registerModelRenderer(lowerleg3);

        Leg4 = new AnimatedModelRenderer(this);
        Leg4.setRotationPoint(1.1484F, 0.2658F, 0.8258F);
        joint.addChild(Leg4);
        setRotationAngle(Leg4, -2.3998F, -0.7418F, 3.1416F);
        Leg4.setTextureOffset(6, 29).addBox(-0.5246F, -0.7224F, -2.3341F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        Leg4.setModelRendererName("Leg4");
        this.registerModelRenderer(Leg4);

        lowerleg4 = new AnimatedModelRenderer(this);
        lowerleg4.setRotationPoint(-0.289F, -0.713F, -2.6558F);
        Leg4.addChild(lowerleg4);
        setRotationAngle(lowerleg4, 0.9599F, 0.0F, 0.0F);
        lowerleg4.setTextureOffset(0, 29).addBox(-0.1914F, -0.6143F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        lowerleg4.setModelRendererName("lowerleg4");
        this.registerModelRenderer(lowerleg4);

        this.rootBones.add(body);
    }


    @Override
    public ResourceLocation getAnimationFileLocation() {
        return new ResourceLocation("cm", "animations/entities/kankrelat.json");
    }
}
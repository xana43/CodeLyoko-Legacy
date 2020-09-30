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

    private final AnimatedModelRenderer mainbody;
    private final AnimatedModelRenderer wingL;
    private final AnimatedModelRenderer wingR;
    private final AnimatedModelRenderer Body2;
    private final AnimatedModelRenderer Body3;
    private final AnimatedModelRenderer stinger;
    private final AnimatedModelRenderer head;
    private final AnimatedModelRenderer proboscis;

    public ModelHornet() {
        textureWidth = 64;
        textureHeight = 64;
        mainbody = new AnimatedModelRenderer(this);
        mainbody.setRotationPoint(1.6225F, 20.6196F, 0.5667F);
        mainbody.setTextureOffset(0, 16).addBox(-3.2012F, -3.3716F, -2.7333F, 3.0F, 3.0F, 6.0F, 0.0F, false);
        mainbody.setModelRendererName("mainbody");
        this.registerModelRenderer(mainbody);

        wingL = new AnimatedModelRenderer(this);
        wingL.setRotationPoint(0.3649F, -1.0966F, 0.2667F);
        mainbody.addChild(wingL);
        wingL.setTextureOffset(12, 12).addBox(-1.0124F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, 0.0F, false);
        wingL.setModelRendererName("wingL");
        this.registerModelRenderer(wingL);

        wingR = new AnimatedModelRenderer(this);
        wingR.setRotationPoint(-3.6351F, -1.0966F, 0.2667F);
        mainbody.addChild(wingR);
        wingR.setTextureOffset(0, 10).addBox(-5.0124F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, 0.0F, false);
        wingR.setModelRendererName("wingR");
        this.registerModelRenderer(wingR);

        Body2 = new AnimatedModelRenderer(this);
        Body2.setRotationPoint(-1.5676F, -1.0628F, 3.35F);
        mainbody.addChild(Body2);
        Body2.setTextureOffset(18, 18).addBox(-1.1346F, -1.8914F, -0.0833F, 2.0F, 2.0F, 4.0F, 0.0F, false);
        Body2.setModelRendererName("Body2");
        this.registerModelRenderer(Body2);

        Body3 = new AnimatedModelRenderer(this);
        Body3.setRotationPoint(0.9951F, 0.4922F, 3.7312F);
        Body2.addChild(Body3);
        Body3.setTextureOffset(12, 16).addBox(-2.2F, -2.201F, 0.1854F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        Body3.setModelRendererName("Body3");
        this.registerModelRenderer(Body3);

        stinger = new AnimatedModelRenderer(this);
        stinger.setRotationPoint(-0.95F, 0.049F, 3.1899F);
        Body3.addChild(stinger);
        stinger.setTextureOffset(20, 32).addBox(-0.25F, -1.25F, -0.0045F, 0.0F, 0.0F, 2.0F, 0.0F, false);
        stinger.setModelRendererName("stinger");
        this.registerModelRenderer(stinger);

        head = new AnimatedModelRenderer(this);
        head.setRotationPoint(-0.7717F, -0.8081F, -2.65F);
        mainbody.addChild(head);
        head.setTextureOffset(0, 0).addBox(-3.95F, -3.6885F, -5.0833F, 6.0F, 5.0F, 5.0F, 0.0F, false);
        head.setModelRendererName("head");
        this.registerModelRenderer(head);

        proboscis = new AnimatedModelRenderer(this);
        proboscis.setRotationPoint(-1.0359F, 0.1365F, -4.0458F);
        head.addChild(proboscis);
        proboscis.setTextureOffset(18, 5).addBox(-0.75F, -0.75F, -6.0375F, 1.0F, 1.0F, 5.0F, 0.0F, false);
        proboscis.setModelRendererName("proboscis");
        this.registerModelRenderer(proboscis);

        this.rootBones.add(mainbody);
    }


    @Override
    public ResourceLocation getAnimationFileLocation() {
        return new ResourceLocation("cm", "animations/entities/hornet.json");
    }
}
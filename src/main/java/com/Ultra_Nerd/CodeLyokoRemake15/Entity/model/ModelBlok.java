package com.Ultra_Nerd.CodeLyokoRemake15.Entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelCreeper - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelBlok extends ModelBase {
    public ModelRenderer blokbody;
    public ModelRenderer sleg4;
    public ModelRenderer Sleg3;
    public ModelRenderer Sleg1;
    public ModelRenderer sleg2;
    public ModelRenderer sleg2s;
    public ModelRenderer sleg2_1;
    public ModelRenderer sleg2_2;
    public ModelRenderer sleg2_3;

    public ModelBlok() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Sleg1 = new ModelRenderer(this, 18, 0);
        this.Sleg1.setRotationPoint(0.8F, 10.0F, -1.0F);
        this.Sleg1.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(Sleg1, 0.0F, -0.7853981633974483F, -0.7853981633974483F);
        this.sleg2 = new ModelRenderer(this, 18, 0);
        this.sleg2.setRotationPoint(0.8F, 10.0F, 1.0F);
        this.sleg2.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(sleg2, 0.0F, -0.39269908169872414F, 0.5811946409141118F);
        this.blokbody = new ModelRenderer(this, 4, 16);
        this.blokbody.setRotationPoint(-5.7F, -8.8F, -9.6F);
        this.blokbody.addBox(-4.0F, 0.0F, -2.0F, 20, 20, 20, 0.0F);
        this.sleg2s = new ModelRenderer(this, 19, 1);
        this.sleg2s.setRotationPoint(-14.1F, -2.7F, 0.6F);
        this.sleg2s.addBox(-1.0F, -1.0F, -1.0F, 9, 1, 1, 0.0F);
        this.setRotateAngle(sleg2s, 0.0F, 2.821499268774033F, -1.352804703220805F);
        this.sleg2_2 = new ModelRenderer(this, 19, 1);
        this.sleg2_2.setRotationPoint(-15.0F, -2.9F, -1.9F);
        this.sleg2_2.addBox(-1.0F, -1.0F, -1.0F, 9, 1, 1, 0.0F);
        this.setRotateAngle(sleg2_2, 0.0F, 3.637440694081382F, -1.352804703220805F);
        this.Sleg3 = new ModelRenderer(this, 18, 0);
        this.Sleg3.setRotationPoint(0.8F, 10.0F, -1.0F);
        this.Sleg3.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(Sleg3, 0.0F, 0.7853981633974483F, 0.7853981633974483F);
        this.sleg2_1 = new ModelRenderer(this, 19, 1);
        this.sleg2_1.setRotationPoint(14.5F, -11.9F, -4.1F);
        this.sleg2_1.addBox(8.0F, 1.0F, -1.1F, 9, 1, 1, 0.0F);
        this.setRotateAngle(sleg2_1, 0.0F, -0.42388575621640967F, 1.337620338728454F);
        this.sleg2_3 = new ModelRenderer(this, 19, 1);
        this.sleg2_3.setRotationPoint(14.1F, -12.7F, 2.1F);
        this.sleg2_3.addBox(8.0F, 1.0F, -1.1F, 9, 1, 1, 0.0F);
        this.setRotateAngle(sleg2_3, 0.0F, 0.13386675362796507F, 1.337620338728454F);
        this.sleg4 = new ModelRenderer(this, 18, 0);
        this.sleg4.setRotationPoint(0.8F, 10.0F, 1.0F);
        this.sleg4.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(sleg4, 0.0F, 0.39269908169872414F, -0.5811946409141118F);
        this.sleg4.addChild(this.sleg2s);
        this.Sleg1.addChild(this.sleg2_2);
        this.Sleg3.addChild(this.sleg2_1);
        this.sleg2.addChild(this.sleg2_3);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Sleg1.render(f5);
        this.sleg2.render(f5);
        this.blokbody.render(f5);
        this.Sleg3.render(f5);
        this.sleg4.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,float headPitch, float scaleFactor, Entity entityIn) {
    	// TODO Auto-generated method stub
    	
    	
    }
}

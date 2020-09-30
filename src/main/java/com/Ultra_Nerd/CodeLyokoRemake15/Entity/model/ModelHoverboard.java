package com.Ultra_Nerd.CodeLyokoRemake15.Entity.model;
// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.Ultra_Nerd.CodeLyokoRemake15.Entity.HoverboardEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

import javax.annotation.Nonnull;

public class ModelHoverboard<T extends HoverboardEntity> extends EntityModel<T> {
    private final ModelRenderer mainbody;
    private final ModelRenderer thruster;

    public ModelHoverboard() {
        textureWidth = 32;
        textureHeight = 32;

        mainbody = new ModelRenderer(this);
        mainbody.setRotationPoint(0.0315F, 23.5192F, 1.1426F);
        mainbody.setTextureOffset(0, 12).addBox(-2.0315F, -0.5192F, -18.3281F, 4.0F, 1.0F, 12.0F, 0.0F, false);
        mainbody.setTextureOffset(0, 8).addBox(-4.0315F, -0.5192F, -17.3281F, 2.0F, 1.0F, 8.0F, 0.0F, false);
        mainbody.setTextureOffset(0, 8).addBox(2.0261F, -0.5192F, -5.165F, 1.0F, 1.0F, 8.0F, 0.0F, false);
        mainbody.setTextureOffset(0, 7).addBox(-3.6289F, -0.5192F, -5.165F, 1.0F, 1.0F, 7.0F, 0.0F, false);
        mainbody.setTextureOffset(0, 18).addBox(-2.1075F, -0.5192F, -6.29F, 4.0F, 1.0F, 18.0F, 0.0F, false);
        mainbody.setTextureOffset(0, 4).addBox(2.0262F, -0.5192F, -9.165F, 4.0F, 1.0F, 4.0F, 0.0F, false);
        mainbody.setTextureOffset(0, 9).addBox(2.0262F, -0.5192F, 2.835F, 4.0F, 1.0F, 9.0F, 0.0F, false);
        mainbody.setTextureOffset(0, 1).addBox(3.5379F, -0.5192F, -5.165F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        mainbody.setTextureOffset(0, 1).addBox(3.5379F, -0.5192F, 0.9746F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        mainbody.setTextureOffset(0, 1).addBox(-5.0891F, -0.5192F, -5.165F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        mainbody.setTextureOffset(0, 1).addBox(-5.0891F, -0.5192F, 0.9737F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        mainbody.setTextureOffset(0, 4).addBox(-6.1075F, -0.5192F, -9.165F, 4.0F, 1.0F, 4.0F, 0.0F, false);
        mainbody.setTextureOffset(0, 9).addBox(-6.1075F, -0.5192F, 2.8301F, 4.0F, 1.0F, 9.0F, 0.0F, false);
        mainbody.setTextureOffset(0, 8).addBox(1.9685F, -0.5192F, -17.3281F, 2.0F, 1.0F, 8.0F, 0.0F, false);
        mainbody.setTextureOffset(0, 7).addBox(-5.0315F, -0.5192F, -16.3281F, 1.0F, 1.0F, 7.0F, 0.0F, false);
        mainbody.setTextureOffset(0, 7).addBox(3.9685F, -0.5192F, -16.3281F, 1.0F, 1.0F, 7.0F, 0.0F, false);
        mainbody.setTextureOffset(0, 6).addBox(-6.0315F, -0.5192F, -15.3281F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        mainbody.setTextureOffset(0, 6).addBox(4.9685F, -0.5192F, -15.3281F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        mainbody.setTextureOffset(0, 2).addBox(-6.1076F, -0.5192F, 11.8321F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        mainbody.setTextureOffset(0, 2).addBox(5.0271F, -0.5192F, 11.8321F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        mainbody.setTextureOffset(0, 3).addBox(4.0271F, -0.5192F, 11.8321F, 1.0F, 1.0F, 3.0F, 0.0F, false);
        mainbody.setTextureOffset(0, 4).addBox(2.0271F, -0.5192F, 11.8321F, 2.0F, 1.0F, 4.0F, 0.0F, false);
        mainbody.setTextureOffset(0, 3).addBox(-5.1076F, -0.5192F, 11.8321F, 1.0F, 1.0F, 3.0F, 0.0F, false);
        mainbody.setTextureOffset(0, 4).addBox(-4.1076F, -0.5192F, 11.8321F, 2.0F, 1.0F, 4.0F, 0.0F, false);
        mainbody.setTextureOffset(0, 5).addBox(-2.1096F, -0.5192F, 11.8321F, 4.0F, 1.0F, 5.0F, 0.0F, false);

        thruster = new ModelRenderer(this);
        thruster.setRotationPoint(-2.0315F, -9.5192F, 5.8574F);
        mainbody.addChild(thruster);
        thruster.setTextureOffset(0, 6).addBox(-7.0F, 8.0F, -21.1855F, 3.0F, 2.0F, 6.0F, 0.0F, false);
        thruster.setTextureOffset(0, 6).addBox(8.0F, 8.0F, -21.1855F, 3.0F, 2.0F, 6.0F, 0.0F, false);
        thruster.setTextureOffset(0, 6).addBox(-6.0F, 7.0F, -21.1855F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        thruster.setTextureOffset(0, 6).addBox(9.0F, 7.0F, -21.1855F, 1.0F, 1.0F, 6.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(@Nonnull HoverboardEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void render(@Nonnull MatrixStack matrixStack, @Nonnull IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        mainbody.render(matrixStack, buffer, packedLight, packedOverlay);
    }

}
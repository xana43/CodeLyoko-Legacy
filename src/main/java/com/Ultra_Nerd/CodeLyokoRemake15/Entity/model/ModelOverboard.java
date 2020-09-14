package com.Ultra_Nerd.CodeLyokoRemake15.Entity.model;// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.Ultra_Nerd.CodeLyokoRemake15.Entity.OverboardEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

import javax.annotation.Nonnull;

public class ModelOverboard<T extends OverboardEntity> extends EntityModel<T> {
	private final ModelRenderer Mainbody;

	public ModelOverboard() {
		textureWidth = 64;
		textureHeight = 64;

		Mainbody = new ModelRenderer(this);
		Mainbody.setRotationPoint(0.0F, 24.0F, 0.0F);
		Mainbody.setTextureOffset(28, 0).addBox(-3.0F, -1.0F, -4.0F, 6.0F, 1.0F, 9.0F, 0.0F, false);
		Mainbody.setTextureOffset(10, 47).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(4, 47).addBox(-1.0F, -1.0F, 5.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(15, 21).addBox(-4.0F, -1.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		Mainbody.setTextureOffset(15, 22).addBox(-5.0F, -2.0F, -6.0F, 1.0F, 1.0F, 13.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 27).addBox(-4.0F, -2.0F, -6.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 57).addBox(-4.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(56, 42).addBox(-3.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(56, 40).addBox(-3.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(55, 56).addBox(-3.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(45, 56).addBox(-2.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(35, 56).addBox(-2.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(31, 56).addBox(-2.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(27, 56).addBox(-2.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(23, 56).addBox(-1.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(19, 56).addBox(0.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(55, 54).addBox(1.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(55, 52).addBox(1.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(55, 17).addBox(0.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(55, 14).addBox(-1.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(55, 12).addBox(-1.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(55, 10).addBox(0.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(55, 6).addBox(1.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(55, 4).addBox(1.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(55, 2).addBox(2.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(55, 0).addBox(2.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(52, 55).addBox(2.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(48, 55).addBox(3.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(42, 55).addBox(3.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(38, 55).addBox(3.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(16, 55).addBox(3.0F, -2.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(12, 55).addBox(3.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(8, 55).addBox(3.0F, -2.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(4, 55).addBox(3.0F, -2.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 55).addBox(3.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(54, 50).addBox(3.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(54, 48).addBox(3.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(54, 26).addBox(2.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(54, 24).addBox(2.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(54, 22).addBox(2.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(54, 20).addBox(1.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(45, 54).addBox(1.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(35, 54).addBox(1.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(31, 54).addBox(1.0F, -2.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(27, 54).addBox(-4.0F, -2.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(23, 54).addBox(-4.0F, -2.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(19, 54).addBox(-4.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(53, 41).addBox(-4.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(53, 39).addBox(-4.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(52, 53).addBox(-3.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(48, 53).addBox(-2.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(42, 53).addBox(-2.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(38, 53).addBox(-3.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(16, 53).addBox(-3.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(12, 53).addBox(-2.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(8, 53).addBox(-2.0F, -2.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(4, 53).addBox(-1.0F, -2.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 53).addBox(0.0F, -2.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(52, 18).addBox(0.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(52, 15).addBox(-1.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(52, 13).addBox(-1.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(52, 11).addBox(0.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 21).addBox(4.0F, -2.0F, -6.0F, 1.0F, 1.0F, 13.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 35).addBox(-6.0F, -2.0F, -5.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
		Mainbody.setTextureOffset(32, 32).addBox(5.0F, -2.0F, -5.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
		Mainbody.setTextureOffset(13, 36).addBox(-7.0F, -2.0F, -3.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 10).addBox(6.0F, -2.0F, -3.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(7.0F, -3.0F, -4.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
		Mainbody.setTextureOffset(30, 21).addBox(2.0F, -4.0F, -3.0F, 7.0F, 1.0F, 7.0F, 0.0F, false);
		Mainbody.setTextureOffset(28, 10).addBox(-9.0F, -4.0F, -3.0F, 7.0F, 1.0F, 7.0F, 0.0F, false);
		Mainbody.setTextureOffset(44, 44).addBox(2.0F, -4.0F, -5.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(30, 29).addBox(2.0F, -4.0F, 4.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(11, 6).addBox(-8.0F, -4.0F, 4.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(28, 44).addBox(-8.0F, -4.0F, -5.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(45, 36).addBox(2.0F, -4.0F, -7.0F, 5.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(45, 30).addBox(2.0F, -4.0F, 6.0F, 5.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(37, 36).addBox(-7.0F, -4.0F, 6.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(45, 33).addBox(-7.0F, -4.0F, -7.0F, 5.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(2, 42).addBox(2.0F, -4.0F, -9.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(28, 6).addBox(2.0F, -4.0F, 8.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(22, 36).addBox(-4.0F, -4.0F, 4.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
		Mainbody.setTextureOffset(45, 39).addBox(-4.0F, -4.0F, -9.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(30, 32).addBox(-6.0F, -4.0F, -8.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 35).addBox(-2.0F, -4.0F, -10.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-2.0F, -4.0F, -9.0F, 4.0F, 1.0F, 20.0F, 0.0F, false);
		Mainbody.setTextureOffset(45, 41).addBox(4.0F, -4.0F, -8.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(44, 18).addBox(4.0F, -4.0F, 8.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(19, 44).addBox(-6.0F, -4.0F, 4.0F, 2.0F, 1.0F, 5.0F, 0.0F, false);
		Mainbody.setTextureOffset(32, 36).addBox(6.0F, -3.0F, -6.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		Mainbody.setTextureOffset(52, 7).addBox(5.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(52, 5).addBox(5.0F, -3.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(52, 3).addBox(4.0F, -3.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(52, 1).addBox(4.0F, -3.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(45, 52).addBox(3.0F, -3.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(35, 52).addBox(2.0F, -3.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(31, 52).addBox(2.0F, -3.0F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(27, 52).addBox(1.0F, -3.0F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(23, 52).addBox(0.0F, -3.0F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(19, 52).addBox(-1.0F, -3.0F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(51, 49).addBox(-2.0F, -3.0F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(51, 47).addBox(-3.0F, -3.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(51, 23).addBox(-4.0F, -3.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(51, 21).addBox(-5.0F, -3.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(50, 51).addBox(-5.0F, -3.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(42, 51).addBox(-6.0F, -3.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(38, 51).addBox(-6.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(16, 51).addBox(-7.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(12, 51).addBox(-7.0F, -3.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(8, 51).addBox(-7.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(4, 51).addBox(-8.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(50, 40).addBox(-8.0F, -3.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(47, 50).addBox(-8.0F, -3.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(35, 50).addBox(-8.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(31, 50).addBox(-8.0F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(27, 50).addBox(-8.0F, -3.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(23, 50).addBox(-8.0F, -3.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(19, 50).addBox(-8.0F, -3.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(49, 19).addBox(-8.0F, -3.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(49, 14).addBox(-7.0F, -3.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(49, 12).addBox(-7.0F, -3.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(49, 10).addBox(-7.0F, -3.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(49, 6).addBox(-6.0F, -3.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(49, 4).addBox(-6.0F, -3.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(49, 2).addBox(-5.0F, -3.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(49, 0).addBox(-5.0F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(44, 49).addBox(-4.0F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(40, 49).addBox(-3.0F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(16, 49).addBox(-3.0F, -3.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(12, 49).addBox(-2.0F, -3.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(8, 49).addBox(-1.0F, -3.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(4, 49).addBox(1.0F, -3.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(45, 47).addBox(2.0F, -3.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(41, 47).addBox(2.0F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(28, 47).addBox(3.0F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(20, 47).addBox(4.0F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(16, 47).addBox(4.0F, -3.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(42, 44).addBox(5.0F, -3.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(19, 44).addBox(5.0F, -3.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(39, 33).addBox(6.0F, -3.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(24, 32).addBox(6.0F, -3.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(9, 31).addBox(6.0F, -3.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(48, 48).addBox(0.0F, -3.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(51, 25).addBox(-3.0F, -3.0F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 21).addBox(3.0F, -1.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 18).addBox(-2.0F, -15.0F, -5.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(9, 10).addBox(-2.0F, -9.0F, -10.0F, 4.0F, 5.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(30, 21).addBox(2.0F, -9.0F, -9.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(28, 0).addBox(-4.0F, -9.0F, -9.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(28, 10).addBox(4.0F, -9.0F, -8.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(11, 0).addBox(-6.0F, -9.0F, -8.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 47).addBox(6.0F, -9.0F, -7.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(22, 36).addBox(-7.0F, -9.0F, -7.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 37).addBox(6.0F, -10.0F, -6.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(13, 36).addBox(-7.0F, -10.0F, -6.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 10).addBox(7.0F, -9.0F, -5.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-8.0F, -9.0F, -5.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(15, 21).addBox(8.0F, -8.0F, -3.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 21).addBox(-9.0F, -8.0F, -3.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(39, 39).addBox(8.0F, -7.0F, -2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(37, 47).addBox(8.0F, -6.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(33, 47).addBox(-9.0F, -6.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(24, 29).addBox(8.0F, -5.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(16, 16).addBox(-9.0F, -5.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 27).addBox(-9.0F, -7.0F, -2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(32, 40).addBox(4.0F, -10.0F, -7.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(22, 22).addBox(4.0F, -12.0F, -6.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(7, 21).addBox(-6.0F, -12.0F, -6.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(38, 18).addBox(-6.0F, -10.0F, -7.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(13, 44).addBox(2.0F, -10.0F, -8.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(4, 40).addBox(-4.0F, -10.0F, -8.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(4, 37).addBox(2.0F, -12.0F, -7.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(7, 24).addBox(2.0F, -13.0F, -6.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 7).addBox(-4.0F, -13.0F, -6.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(6, 27).addBox(-4.0F, -12.0F, -7.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(15, 30).addBox(-2.0F, -11.0F, -9.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(15, 27).addBox(-2.0F, -12.0F, -8.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 32).addBox(-2.0F, -13.0F, -7.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(28, 18).addBox(-2.0F, -14.0F, -6.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(10, 18).addBox(-2.0F, -15.0F, -3.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(5, 6).addBox(-3.0F, -15.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(4, 0).addBox(2.0F, -15.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(@Nonnull T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}


	@Override
	public void render(@Nonnull MatrixStack matrixStack, @Nonnull IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Mainbody.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
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
	private final ModelRenderer bb_main;

	public ModelOverboard() {
		textureWidth = 32;
		textureHeight = 32;

		Mainbody = new ModelRenderer(this);
		Mainbody.setRotationPoint(0.0F, 24.0F, 0.0F);
		Mainbody.setTextureOffset(0, 0).addBox(-3.0F, -1.0F, -4.0F, 6.0F, 1.0F, 9.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, 5.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-4.0F, -1.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-5.0F, -2.0F, -6.0F, 1.0F, 1.0F, 13.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-4.0F, -2.0F, -6.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-4.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-3.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-3.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-3.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(0.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(1.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(1.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(0.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(0.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(1.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(1.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(2.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(2.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(2.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(3.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(3.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(3.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(3.0F, -2.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(3.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(3.0F, -2.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(3.0F, -2.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(3.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(3.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(3.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(2.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(2.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(2.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(1.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(1.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(1.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(1.0F, -2.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-4.0F, -2.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-4.0F, -2.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-4.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-4.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-4.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-3.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-3.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-3.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(0.0F, -2.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(0.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(0.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(4.0F, -2.0F, -6.0F, 1.0F, 1.0F, 13.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-6.0F, -2.0F, -5.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(5.0F, -2.0F, -5.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-7.0F, -2.0F, -3.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(6.0F, -2.0F, -3.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
		Mainbody.setTextureOffset(11, 11).addBox(7.0F, -3.0F, -4.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 20).addBox(6.0F, -4.0F, -3.0F, 3.0F, 1.0F, 7.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(6.0F, -4.0F, -4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 7).addBox(4.0F, -4.0F, -4.0F, 2.0F, 1.0F, 12.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 7).addBox(-6.0F, -4.0F, -4.0F, 2.0F, 1.0F, 12.0F, 0.0F, true);
		Mainbody.setTextureOffset(0, 20).addBox(-4.0F, -4.0F, 6.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 1).addBox(-4.0F, -4.0F, -3.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(1, 0).addBox(-2.0F, -4.0F, -9.0F, 4.0F, 1.0F, 6.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 20).addBox(-9.0F, -4.0F, -3.0F, 3.0F, 1.0F, 7.0F, 0.0F, true);
		Mainbody.setTextureOffset(0, 0).addBox(2.0F, -4.0F, -5.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(6.0F, -4.0F, 4.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-8.0F, -4.0F, 4.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-8.0F, -4.0F, -5.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(2.0F, -4.0F, -7.0F, 5.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(6.0F, -4.0F, 6.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-7.0F, -4.0F, 6.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-7.0F, -4.0F, -7.0F, 5.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(2.0F, -4.0F, -9.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(2.0F, -4.0F, 8.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, 8.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, -9.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-6.0F, -4.0F, -8.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(13, 0).addBox(-2.0F, -4.0F, -10.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-2.0F, -4.0F, 8.0F, 4.0F, 1.0F, 3.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 9).addBox(-4.0F, -4.0F, 2.0F, 8.0F, 1.0F, 4.0F, 0.0F, true);
		Mainbody.setTextureOffset(0, 13).addBox(-4.0F, -4.0F, -2.0F, 8.0F, 1.0F, 4.0F, 0.0F, true);
		Mainbody.setTextureOffset(0, 0).addBox(4.0F, -4.0F, -8.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(4.0F, -4.0F, 8.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-6.0F, -4.0F, 8.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 17).addBox(6.0F, -3.0F, -6.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(5.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(5.0F, -3.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(4.0F, -3.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(4.0F, -3.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(3.0F, -3.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(2.0F, -3.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(2.0F, -3.0F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(1.0F, -3.0F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(0.0F, -3.0F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(-1.0F, -3.0F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(-2.0F, -3.0F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-3.0F, -3.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(-4.0F, -3.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(-5.0F, -3.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-5.0F, -3.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(-6.0F, -3.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-6.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(-7.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(-7.0F, -3.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-7.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(-8.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(-8.0F, -3.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(-8.0F, -3.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(-8.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(-8.0F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(-8.0F, -3.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(-8.0F, -3.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(-8.0F, -3.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(-8.0F, -3.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-7.0F, -3.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(-7.0F, -3.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(-7.0F, -3.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-6.0F, -3.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(-6.0F, -3.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-5.0F, -3.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(-5.0F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(-4.0F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-3.0F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(-3.0F, -3.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(-2.0F, -3.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(-1.0F, -3.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(1.0F, -3.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(2.0F, -3.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(2.0F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(3.0F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(4.0F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(4.0F, -3.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(5.0F, -3.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(5.0F, -3.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(6.0F, -3.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(6.0F, -3.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(6.0F, -3.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(0.0F, -3.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addBox(-3.0F, -3.0F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(3.0F, -1.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-2.0F, -15.0F, -5.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(13, 0).addBox(-2.0F, -9.0F, -10.0F, 4.0F, 5.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(2.0F, -9.0F, -9.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-4.0F, -9.0F, -9.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(4.0F, -9.0F, -8.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-6.0F, -9.0F, -8.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(6.0F, -9.0F, -7.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-7.0F, -9.0F, -7.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(6.0F, -10.0F, -6.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-7.0F, -10.0F, -6.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(7.0F, -9.0F, -5.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-8.0F, -9.0F, -5.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(8.0F, -8.0F, -3.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-9.0F, -8.0F, -3.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(8.0F, -7.0F, -2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(8.0F, -6.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-9.0F, -6.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(8.0F, -5.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-9.0F, -5.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-9.0F, -7.0F, -2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(4.0F, -10.0F, -7.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(4.0F, -12.0F, -6.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-6.0F, -12.0F, -6.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-6.0F, -10.0F, -7.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(2.0F, -10.0F, -8.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-4.0F, -10.0F, -8.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(2.0F, -12.0F, -7.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(2.0F, -13.0F, -6.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-4.0F, -13.0F, -6.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-4.0F, -12.0F, -7.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(13, 0).addBox(-2.0F, -11.0F, -9.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(13, 0).addBox(-2.0F, -12.0F, -8.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(13, 0).addBox(-2.0F, -13.0F, -7.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(13, 0).addBox(-2.0F, -14.0F, -6.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-2.0F, -15.0F, -3.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(-3.0F, -15.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addBox(2.0F, -15.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(0, 0).addBox(-8.0F, -4.0F, -4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, -4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 0).addBox(2.0F, -4.0F, -4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(@Nonnull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(@Nonnull MatrixStack matrixStack, @Nonnull IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Mainbody.render(matrixStack, buffer, packedLight, packedOverlay);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
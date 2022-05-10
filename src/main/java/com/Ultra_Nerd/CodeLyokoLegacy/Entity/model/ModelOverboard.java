// Made with Blockbench 4.2.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports

	package com.Ultra_Nerd.CodeLyokoLegacy.Entity.model;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle.OverboardEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class ModelOverboard extends EntityModel<OverboardEntity> {
//private final ModelPart Mainbody;
public ModelOverboard() {
	/*
		textureWidth = 32;
		textureHeight = 32;
		Mainbody = new ModelPart(this);
		Mainbody.setPivot(0.0F, 24.0F, 0.0F);
		setRotationAngle(Mainbody, 0.0F, 3.1416F, 0.0F);
		Mainbody.setTextureOffset(0, 0).addCuboid(-3.0F, -1.0F, -4.0F, 6.0F, 1.0F, 9.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-1.0F, -1.0F, -5.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-1.0F, -1.0F, 5.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-4.0F, -1.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-5.0F, -2.0F, -6.0F, 1.0F, 1.0F, 13.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-4.0F, -2.0F, -6.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-4.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-3.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-3.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-3.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-2.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-2.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-2.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-2.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-1.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(0.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(1.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(1.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(0.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-1.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-1.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(0.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(1.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(1.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(2.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(2.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(2.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(3.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(3.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(3.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(3.0F, -2.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(3.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(3.0F, -2.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(3.0F, -2.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(3.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(3.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(3.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(2.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(2.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(2.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(1.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(1.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(1.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(1.0F, -2.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-4.0F, -2.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-4.0F, -2.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-4.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-4.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-4.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-3.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-2.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-2.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-3.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-3.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-2.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-2.0F, -2.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-1.0F, -2.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(0.0F, -2.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(0.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-1.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-1.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(0.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(4.0F, -2.0F, -6.0F, 1.0F, 1.0F, 13.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-6.0F, -2.0F, -5.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(5.0F, -2.0F, -5.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-7.0F, -2.0F, -3.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(6.0F, -2.0F, -3.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
		Mainbody.setTextureOffset(11, 11).addCuboid(7.0F, -3.0F, -4.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 20).addCuboid(6.0F, -4.0F, -3.0F, 3.0F, 1.0F, 7.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(6.0F, -4.0F, -4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 7).addCuboid(4.0F, -4.0F, -4.0F, 2.0F, 1.0F, 12.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 7).addCuboid(-6.0F, -4.0F, -4.0F, 2.0F, 1.0F, 12.0F, 0.0F, true);
		Mainbody.setTextureOffset(0, 20).addCuboid(-4.0F, -4.0F, 6.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 1).addCuboid(-4.0F, -4.0F, -3.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(1, 0).addCuboid(-2.0F, -4.0F, -9.0F, 4.0F, 1.0F, 6.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 20).addCuboid(-9.0F, -4.0F, -3.0F, 3.0F, 1.0F, 7.0F, 0.0F, true);
		Mainbody.setTextureOffset(0, 0).addCuboid(2.0F, -4.0F, -5.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(6.0F, -4.0F, 4.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-8.0F, -4.0F, 4.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-8.0F, -4.0F, -5.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(2.0F, -4.0F, -7.0F, 5.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(6.0F, -4.0F, 6.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-7.0F, -4.0F, 6.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-7.0F, -4.0F, -7.0F, 5.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(2.0F, -4.0F, -9.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(2.0F, -4.0F, 8.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-4.0F, -4.0F, 8.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-4.0F, -4.0F, -9.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-6.0F, -4.0F, -8.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(13, 0).addCuboid(-2.0F, -4.0F, -10.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-2.0F, -4.0F, 8.0F, 4.0F, 1.0F, 3.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 9).addCuboid(-4.0F, -4.0F, 2.0F, 8.0F, 1.0F, 4.0F, 0.0F, true);
		Mainbody.setTextureOffset(0, 13).addCuboid(-4.0F, -4.0F, -2.0F, 8.0F, 1.0F, 4.0F, 0.0F, true);
		Mainbody.setTextureOffset(0, 0).addCuboid(4.0F, -4.0F, -8.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(4.0F, -4.0F, 8.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-6.0F, -4.0F, 8.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 17).addCuboid(6.0F, -3.0F, -6.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(5.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(5.0F, -3.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(4.0F, -3.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(4.0F, -3.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(3.0F, -3.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(2.0F, -3.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(2.0F, -3.0F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(1.0F, -3.0F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(0.0F, -3.0F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(-1.0F, -3.0F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(-2.0F, -3.0F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-3.0F, -3.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(-4.0F, -3.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(-5.0F, -3.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-5.0F, -3.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(-6.0F, -3.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-6.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(-7.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(-7.0F, -3.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-7.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(-8.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(-8.0F, -3.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(-8.0F, -3.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(-8.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(-8.0F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(-8.0F, -3.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(-8.0F, -3.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(-8.0F, -3.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(-8.0F, -3.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-7.0F, -3.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(-7.0F, -3.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(-7.0F, -3.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-6.0F, -3.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(-6.0F, -3.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-5.0F, -3.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(-5.0F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(-4.0F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-3.0F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(-3.0F, -3.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(-2.0F, -3.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(-1.0F, -3.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(1.0F, -3.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(2.0F, -3.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(2.0F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(3.0F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(4.0F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(4.0F, -3.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(5.0F, -3.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(5.0F, -3.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(6.0F, -3.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(6.0F, -3.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(6.0F, -3.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(0.0F, -3.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 19).addCuboid(-3.0F, -3.0F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(3.0F, -1.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-2.0F, -15.0F, -5.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(13, 0).addCuboid(-2.0F, -9.0F, -10.0F, 4.0F, 5.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(2.0F, -9.0F, -9.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-4.0F, -9.0F, -9.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(4.0F, -9.0F, -8.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-6.0F, -9.0F, -8.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(6.0F, -9.0F, -7.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-7.0F, -9.0F, -7.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(6.0F, -10.0F, -6.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-7.0F, -10.0F, -6.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(7.0F, -9.0F, -5.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-8.0F, -9.0F, -5.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(8.0F, -8.0F, -3.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-9.0F, -8.0F, -3.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(8.0F, -7.0F, -2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(8.0F, -6.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-9.0F, -6.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(8.0F, -5.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-9.0F, -5.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-9.0F, -7.0F, -2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(4.0F, -10.0F, -7.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(4.0F, -12.0F, -6.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-6.0F, -12.0F, -6.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-6.0F, -10.0F, -7.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(2.0F, -10.0F, -8.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-4.0F, -10.0F, -8.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(2.0F, -12.0F, -7.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(2.0F, -13.0F, -6.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-4.0F, -13.0F, -6.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-4.0F, -12.0F, -7.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(13, 0).addCuboid(-2.0F, -11.0F, -9.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(13, 0).addCuboid(-2.0F, -12.0F, -8.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(13, 0).addCuboid(-2.0F, -13.0F, -7.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(13, 0).addCuboid(-2.0F, -14.0F, -6.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-2.0F, -15.0F, -3.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-3.0F, -15.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(2.0F, -15.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(2.0F, -4.0F, -4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-8.0F, -4.0F, -4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(0, 0).addCuboid(-4.0F, -4.0F, -4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

	 */
}
@Override
public void setAngles(OverboardEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
}
@Override
public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		
		//Mainbody.render(matrixStack, buffer, packedLight, packedOverlay);
}
public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
}

	}
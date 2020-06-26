package com.Ultra_Nerd.CodeLyokoRemake15.Entity.model;// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityLaser;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelLaserArrow<T extends EntityLaser> extends EntityModel<T> {
	private final ModelRenderer main;
	private final ModelRenderer arrowside1;
	private final ModelRenderer arrowside2;

	public ModelLaserArrow() {
		textureWidth = 4096;
		textureHeight = 4096;

		main = new ModelRenderer(this);
		main.setRotationPoint(-2.0F, 24.0F, -5.0F);
		main.setTextureOffset(108, 1548).addBox(1.0F, -1.0F, -3.0F, 1.0F, 1.0F, 16.0F, 0.0F, false);

		arrowside1 = new ModelRenderer(this);
		arrowside1.setRotationPoint(4.0F, 0.0F, 4.5F);
		main.addChild(arrowside1);
		setRotationAngle(arrowside1, 0.0F, -0.3491F, 0.0F);
		arrowside1.setTextureOffset(0, 0).addBox(-5.8518F, -1.0F, -6.0609F, 1.0F, 1.0F, 5.0F, 0.0F, false);

		arrowside2 = new ModelRenderer(this);
		arrowside2.setRotationPoint(11.0F, 0.0F, 4.5F);
		main.addChild(arrowside2);
		setRotationAngle(arrowside2, 0.0F, 0.3491F, 0.0F);
		arrowside2.setTextureOffset(0, 0).addBox(-6.5957F, -1.0F, -10.3031F, 1.0F, 1.0F, 5.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
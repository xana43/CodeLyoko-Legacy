package io.github.elsopeen.lyokomod.Entity.Model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import io.github.elsopeen.lyokomod.Entity.Entityblok;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class ModelBlok<T extends Entityblok> extends EntityModel<T> {
	private final ModelRenderer Body;
	private final ModelRenderer Legs;
	private final ModelRenderer Leg1;
	private final ModelRenderer Leg2;
	private final ModelRenderer Leg3;
	private final ModelRenderer Leg4;

	public ModelBlok() {
		textureWidth = 128;
		textureHeight = 64;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(1.0F, 23.0F, 0.0F);
		Body.setTextureOffset(4, 15).addBox(-11.0F, -25.0F, -9.75F, 20.0F, 20.0F, 20.0F, 0.0F, false);

		Legs = new ModelRenderer(this);
		Legs.setRotationPoint(0.0F, 0.0F, -1.0F);
		Body.addChild(Legs);
		Legs.setTextureOffset(32, 0).addBox(-1.35F, -6.5F, 0.5F, 1.0F, 1.0F, 1.0F, 1.0F, false);

		Leg1 = new ModelRenderer(this);
		Leg1.setRotationPoint(-0.5F, 1.0F, 2.25F);
		Legs.addChild(Leg1);
		setRotationAngle(Leg1, -0.5236F, -1.1345F, 0.9599F);
		Leg1.setTextureOffset(34, 0).addBox(-5.4749F, -3.6458F, 1.9061F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		Leg2 = new ModelRenderer(this);
		Leg2.setRotationPoint(-1.0F, 1.0F, 0.0F);
		Legs.addChild(Leg2);
		setRotationAngle(Leg2, -0.5236F, -0.9599F, 0.0F);
		Leg2.setTextureOffset(34, 0).addBox(0.0473F, -5.4391F, -4.4613F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Leg3 = new ModelRenderer(this);
		Leg3.setRotationPoint(-1.0F, 1.0F, 1.0F);
		Legs.addChild(Leg3);
		setRotationAngle(Leg3, -0.5236F, -2.1817F, 0.0F);
		Leg3.setTextureOffset(25, 0).addBox(-0.0319F, -4.0191F, -5.0887F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		Leg4 = new ModelRenderer(this);
		Leg4.setRotationPoint(-1.55F, 0.4F, 2.0F);
		Legs.addChild(Leg4);
		setRotationAngle(Leg4, -0.5236F, 2.3562F, 0.0F);
		Leg4.setTextureOffset(29, 0).addBox(-0.3225F, -4.2294F, -3.4245F, 1.0F, 2.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		// TODO Auto-generated method stub
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
	}
	
	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
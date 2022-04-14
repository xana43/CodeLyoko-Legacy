// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class steve<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "steve"), "main");
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;

	public steve(ModelPart root) {
		this.Body = root.getChild("Body");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(2, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(16, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.25F))
		.texOffs(0, 0).addBox(-5.0F, -1.0F, -5.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(28, 35).addBox(-2.0F, 0.0F, -2.0625F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(28, 32).addBox(-3.0F, 1.0F, -2.0625F, 6.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(32, 21).addBox(-3.0F, 2.0F, -2.0625F, 6.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(28, 20).addBox(-4.0F, 3.0F, -2.0625F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(28, 19).addBox(-4.0F, 4.0F, -2.0625F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(18, 22).addBox(-4.0F, 5.0F, -2.1875F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 11).addBox(-4.0F, 6.0F, -2.0625F, 8.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tt3E_r1 = Body.addOrReplaceChild("tt3E_r1", CubeListBuilder.create().texOffs(12, 18).addBox(-2.0F, 3.0F, 4.0375F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(12, 17).addBox(-2.0F, 4.0F, 4.0375F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(12, 19).addBox(-2.0F, 3.0F, -4.025F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(12, 20).addBox(-2.0F, 4.0F, -4.025F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 8).addBox(-2.0F, 5.0F, -4.125F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 33).addBox(-2.0F, 5.0F, 3.125F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 11).addBox(-2.0F, 6.0F, -4.0375F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(20, 32).addBox(-2.0F, 6.0F, 4.0625F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition tt6S_r1 = Body.addOrReplaceChild("tt6S_r1", CubeListBuilder.create().texOffs(0, 22).addBox(-4.0F, 5.0F, -2.1875F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 18).addBox(-4.0F, 4.0F, -2.0625F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(28, 17).addBox(-4.0F, 3.0F, -2.0625F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(30, 9).addBox(-3.0F, 2.0F, -2.0625F, 6.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(30, 8).addBox(-3.0F, 1.0F, -2.0625F, 6.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(35, 22).addBox(-2.0F, 0.0F, -2.0625F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 11).addBox(-4.0F, 6.0F, -2.0625F, 8.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(40, 32).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F))
		.texOffs(10, 32).addBox(-3.0F, 3.0F, -2.0625F, 4.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 32).addBox(-3.0F, 3.0F, 1.05F, 4.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 17).addBox(-3.0F, 9.125F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition RightGloveE_r1 = RightArm.addOrReplaceChild("RightGloveE_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 3.0F, -1.075F, 4.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(30, 24).addBox(-2.0F, 3.0F, 2.05F, 4.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(32, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(48, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F))
		.texOffs(30, 0).addBox(-1.0F, 3.0F, -2.0625F, 4.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 24).addBox(-1.0F, 3.0F, 1.05F, 4.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 17).addBox(-1.0F, 9.125F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition LeftGloveW_r1 = LeftArm.addOrReplaceChild("LeftGloveW_r1", CubeListBuilder.create().texOffs(0, 24).addBox(-2.0F, 3.0F, 2.05F, 4.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 24).addBox(-2.0F, 3.0F, -1.075F, 4.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, buffer, packedLight, packedOverlay);
		RightArm.render(poseStack, buffer, packedLight, packedOverlay);
		LeftArm.render(poseStack, buffer, packedLight, packedOverlay);
	}
}
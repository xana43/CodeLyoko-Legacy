// Made with Blockbench 4.2.1
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class Hoverboard<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "hoverboard"), "main");
	private final ModelPart mainbody;

	public Hoverboard(ModelPart root) {
		this.mainbody = root.getChild("mainbody");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition mainbody = partdefinition.addOrReplaceChild("mainbody", CubeListBuilder.create().texOffs(0, 19).addBox(-1.993F, -0.5192F, -18.3281F, 4.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 32).addBox(-3.993F, -0.5192F, -17.3281F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(2.0646F, -0.5192F, -5.165F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(36, 30).addBox(-3.5905F, -0.5192F, -5.165F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-2.069F, -0.5192F, -6.29F, 4.0F, 1.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(0, 41).addBox(2.0646F, -0.5192F, -9.165F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(26, 0).addBox(2.0646F, -0.5192F, 2.835F, 4.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(12, 12).addBox(3.5763F, -0.5192F, -5.165F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 5).addBox(3.5763F, -0.5192F, 0.9746F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 12).addBox(-5.0506F, -0.5192F, -5.165F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 3).addBox(-5.0506F, -0.5192F, 0.9737F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(22, 39).addBox(-6.069F, -0.5192F, -9.165F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(20, 20).addBox(-6.069F, -0.5192F, 2.8301F, 4.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(24, 30).addBox(2.007F, -0.5192F, -17.3281F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(37, 20).addBox(-4.993F, -0.5192F, -16.3281F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(37, 12).addBox(4.007F, -0.5192F, -16.3281F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(22, 44).addBox(-5.993F, -0.5192F, -15.3281F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(43, 0).addBox(5.007F, -0.5192F, -15.3281F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(10, 0).addBox(-6.0692F, -0.5192F, 11.8321F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 9).addBox(5.0656F, -0.5192F, 11.8321F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(4.0656F, -0.5192F, 11.8321F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 19).addBox(2.0656F, -0.5192F, 11.8321F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 4).addBox(-5.0692F, -0.5192F, 11.8321F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 24).addBox(-4.0692F, -0.5192F, 11.8321F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(12, 32).addBox(-2.0711F, -0.5192F, 11.8321F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.007F, 23.5192F, 1.1426F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition thruster = mainbody.addOrReplaceChild("thruster", CubeListBuilder.create().texOffs(26, 10).addBox(-7.0F, 8.0F, -21.1855F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 9).addBox(8.0F, 8.0F, -21.1855F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(38, 38).addBox(-6.0F, 7.0F, -21.1855F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(14, 38).addBox(9.0F, 7.0F, -21.1855F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.993F, -9.5192F, 5.8574F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		mainbody.render(poseStack, buffer, packedLight, packedOverlay);
	}
}
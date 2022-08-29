package com.Ultra_Nerd.CodeLyokoLegacy.Entity.model;
// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle.HoverboardEntity;

public final class ModelHoverboard<T extends HoverboardEntity> /*extends EntityModel<T>*/ {
    /*
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(CodeLyokoMain.CodeLyokoPrefix("hoverboard"),"main");
    private final @NotNull ModelPart mainbody;


    public ModelHoverboard(@NotNull ModelPart root)
    {
        this.mainbody = root.getChild("mainbody");
    }



    public static @NotNull LayerDefinition createLayer() {
       // textureWidth = 32;
        //textureHeight = 32;
        final MeshDefinition meshDefinition = new MeshDefinition();
        final PartDefinition partDefinition = meshDefinition.getRoot();



        final PartDefinition mainbody = partDefinition.addOrReplaceChild("mainbody", CubeListBuilder.create().texOffs(0, 19).addBox(-1.993F, -0.5192F, -18.3281F, 4.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
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

        final PartDefinition thruster = mainbody.addOrReplaceChild("thruster", CubeListBuilder.create().texOffs(26, 10).addBox(-7.0F, 8.0F, -21.1855F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 9).addBox(8.0F, 8.0F, -21.1855F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(38, 38).addBox(-6.0F, 7.0F, -21.1855F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(14, 38).addBox(9.0F, 7.0F, -21.1855F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.993F, -9.5192F, 5.8574F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @Override
    public void setupAnim(T p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {

    }



    @Override
    public void renderToBuffer(@Nonnull PoseStack matrixStack, @Nonnull VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        mainbody.render(matrixStack, buffer, packedLight, packedOverlay);
    }

     */




}
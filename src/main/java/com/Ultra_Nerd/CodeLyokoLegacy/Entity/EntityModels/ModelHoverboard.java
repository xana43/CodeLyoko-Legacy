package com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityModels;
// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.VehicleEntities.HoverboardEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import org.jetbrains.annotations.NotNull;


public final class ModelHoverboard<T extends HoverboardEntity> extends EntityModel<T> {

    public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(CodeLyokoMain.codeLyokoPrefix("hoverboard"),
            "main");
    private final @NotNull ModelPart mainbody;


    public ModelHoverboard(@NotNull ModelPart root)
    {
        this.mainbody = root.getChild("mainbody");
    }



    public static @NotNull TexturedModelData createLayer() {
       // textureWidth = 32;
        //textureHeight = 32;
        final ModelData meshDefinition = new ModelData();
        final ModelPartData partDefinition = meshDefinition.getRoot();



        final ModelPartData mainbody = partDefinition.addChild("mainbody",
                ModelPartBuilder.create().uv(0, 19).cuboid(-1.993F, -0.5192F, -18.3281F, 4.0F, 1.0F, 12.0F,
                                new Dilation(0.0F))
                .uv(0, 32).cuboid(-3.993F, -0.5192F, -17.3281F, 2.0F, 1.0F, 8.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(2.0646F, -0.5192F, -5.165F, 1.0F, 1.0F, 8.0F, new Dilation(0.0F))
                        .uv(36, 30).cuboid(-3.5905F, -0.5192F, -5.165F, 1.0F, 1.0F, 7.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-2.069F, -0.5192F, -6.29F, 4.0F, 1.0F, 18.0F, new Dilation(0.0F))
                .uv(0, 41).cuboid(2.0646F, -0.5192F, -9.165F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F))
                .uv(26, 0).cuboid(2.0646F, -0.5192F, 2.835F, 4.0F, 1.0F, 9.0F, new Dilation(0.0F))
                .uv(12, 12).cuboid(3.5763F, -0.5192F, -5.165F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(10, 5).cuboid(3.5763F, -0.5192F, 0.9746F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 12).cuboid(-5.0506F, -0.5192F, -5.165F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(10, 3).cuboid(-5.0506F, -0.5192F, 0.9737F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(22, 39).cuboid(-6.069F, -0.5192F, -9.165F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F))
                .uv(20, 20).cuboid(-6.069F, -0.5192F, 2.8301F, 4.0F, 1.0F, 9.0F, new Dilation(0.0F))
                .uv(24, 30).cuboid(2.007F, -0.5192F, -17.3281F, 2.0F, 1.0F, 8.0F, new Dilation(0.0F))
                .uv(37, 20).cuboid(-4.993F, -0.5192F, -16.3281F, 1.0F, 1.0F, 7.0F, new Dilation(0.0F))
                .uv(37, 12).cuboid(4.007F, -0.5192F, -16.3281F, 1.0F, 1.0F, 7.0F, new Dilation(0.0F))
                .uv(22, 44).cuboid(-5.993F, -0.5192F, -15.3281F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(43, 0).cuboid(5.007F, -0.5192F, -15.3281F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(10, 0).cuboid(-6.0692F, -0.5192F, 11.8321F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 9).cuboid(5.0656F, -0.5192F, 11.8321F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(4.0656F, -0.5192F, 11.8321F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 19).cuboid(2.0656F, -0.5192F, 11.8321F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 4).cuboid(-5.0692F, -0.5192F, 11.8321F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 24).cuboid(-4.0692F, -0.5192F, 11.8321F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F))
                .uv(12, 32).cuboid(-2.0711F, -0.5192F, 11.8321F, 4.0F, 1.0F, 5.0F, new Dilation(0.0F)),
                ModelTransform.of(-0.007F, 23.5192F, 1.1426F, -3.1416F, 0.0F, 3.1416F));

        final ModelPartData thruster = mainbody.addChild("thruster", ModelPartBuilder.create().uv(26,
                        10).cuboid(-7.0F, 8.0F, -21.1855F, 3.0F, 2.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 9).cuboid(8.0F, 8.0F, -21.1855F, 3.0F, 2.0F, 6.0F, new Dilation(0.0F))
                .uv(38, 38).cuboid(-6.0F, 7.0F, -21.1855F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(14, 38).cuboid(9.0F, 7.0F, -21.1855F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)),
                ModelTransform.pivot(-1.993F, -9.5192F, 5.8574F));

        return TexturedModelData.of(meshDefinition, 64, 64);
    }







    @Override
    public void setAngles(final T entity, final float limbAngle, final float limbDistance, final float animationProgress, final float headYaw, final float headPitch) {

    }

    @Override
    public void render(final MatrixStack matrices, final VertexConsumer vertices, final int light, final int overlay, final float red, final float green, final float blue, final float alpha) {
        mainbody.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
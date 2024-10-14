package com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityModels;// Made with Blockbench 4.2.4
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.VehicleEntities.OverboardEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;

public final class ModelOverboard<T extends OverboardEntity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(
            CodeLyokoMain.codeLyokoPrefix("overboard"), "main");

    private final ModelPart Mainbody;

    public ModelOverboard(final ModelPart root) {
        this.Mainbody = root.getChild("Mainbody");


    }


    public static TexturedModelData createBodyLayer() {
        final ModelData meshdefinition = new ModelData();
        final ModelPartData partdefinition = meshdefinition.getRoot();

        final ModelPartData MainBody = partdefinition.addChild("Mainbody",
                ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -1.0F, -4.0F, 6.0F, 1.0F, 9.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-1.0F, -1.0F, -5.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-1.0F, -1.0F, 5.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-4.0F, -1.0F, -2.0F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-5.0F, -2.0F, -6.0F, 1.0F, 1.0F, 13.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-4.0F, -2.0F, -6.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-4.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-3.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-3.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-3.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-2.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-2.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-2.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-2.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-1.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(0.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(1.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(1.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(0.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-1.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-1.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(0.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(1.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(1.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(2.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(2.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(2.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(3.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(3.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(3.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(3.0F, -2.0F, -4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(3.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(3.0F, -2.0F, 3.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(3.0F, -2.0F, 4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(3.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(3.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(3.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(2.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(2.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(2.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(1.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(1.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(1.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(1.0F, -2.0F, 8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-4.0F, -2.0F, 3.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-4.0F, -2.0F, 4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-4.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-4.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-4.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-3.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-2.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-2.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-3.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-3.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-2.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-2.0F, -2.0F, 8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-1.0F, -2.0F, 8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(0.0F, -2.0F, 8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(0.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-1.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-1.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(0.0F, -2.0F, 6.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(4.0F, -2.0F, -6.0F, 1.0F, 1.0F, 13.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-6.0F, -2.0F, -5.0F, 1.0F, 1.0F, 11.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(5.0F, -2.0F, -5.0F, 1.0F, 1.0F, 11.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-7.0F, -2.0F, -3.0F, 1.0F, 1.0F, 7.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(6.0F, -2.0F, -3.0F, 1.0F, 1.0F, 7.0F, new Dilation(0.0F))
                        .uv(11, 11).cuboid(7.0F, -3.0F, -4.0F, 1.0F, 1.0F, 9.0F, new Dilation(0.0F))
                        .uv(0, 20).cuboid(6.0F, -4.0F, -3.0F, 3.0F, 1.0F, 7.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(6.0F, -4.0F, -4.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 7).cuboid(4.0F, -4.0F, -4.0F, 2.0F, 1.0F, 12.0F, new Dilation(0.0F))
                        .uv(0, 7).mirrored().cuboid(-6.0F, -4.0F, -4.0F, 2.0F, 1.0F, 12.0F, new Dilation(0.0F))
                        .mirrored(false)
                        .uv(0, 20).cuboid(-4.0F, -4.0F, 6.0F, 8.0F, 1.0F, 2.0F, new Dilation(0.0F))
                        .uv(0, 1).cuboid(-4.0F, -4.0F, -3.0F, 8.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(1, 0).cuboid(-2.0F, -4.0F, -9.0F, 4.0F, 1.0F, 6.0F, new Dilation(0.0F))
                        .uv(0, 20).mirrored().cuboid(-9.0F, -4.0F, -3.0F, 3.0F, 1.0F, 7.0F, new Dilation(0.0F))
                        .mirrored(false)
                        .uv(0, 0).cuboid(2.0F, -4.0F, -5.0F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(6.0F, -4.0F, 4.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-8.0F, -4.0F, 4.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-8.0F, -4.0F, -5.0F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(2.0F, -4.0F, -7.0F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(6.0F, -4.0F, 6.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-7.0F, -4.0F, 6.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-7.0F, -4.0F, -7.0F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(2.0F, -4.0F, -9.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(2.0F, -4.0F, 8.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-4.0F, -4.0F, 8.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-4.0F, -4.0F, -9.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-6.0F, -4.0F, -8.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(13, 0).cuboid(-2.0F, -4.0F, -10.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-2.0F, -4.0F, 8.0F, 4.0F, 1.0F, 3.0F, new Dilation(0.0F))
                        .uv(0, 9).mirrored().cuboid(-4.0F, -4.0F, 2.0F, 8.0F, 1.0F, 4.0F, new Dilation(0.0F))
                        .mirrored(false)
                        .uv(0, 13).mirrored().cuboid(-4.0F, -4.0F, -2.0F, 8.0F, 1.0F, 4.0F, new Dilation(0.0F))
                        .mirrored(false)
                        .uv(0, 0).cuboid(4.0F, -4.0F, -8.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(4.0F, -4.0F, 8.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-6.0F, -4.0F, 8.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 17).cuboid(6.0F, -3.0F, -6.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(5.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(5.0F, -3.0F, -7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(4.0F, -3.0F, -7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(4.0F, -3.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(3.0F, -3.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(2.0F, -3.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(2.0F, -3.0F, -9.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(1.0F, -3.0F, -9.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(0.0F, -3.0F, -9.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(-1.0F, -3.0F, -9.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(-2.0F, -3.0F, -9.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-3.0F, -3.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(-4.0F, -3.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(-5.0F, -3.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-5.0F, -3.0F, -7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(-6.0F, -3.0F, -7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-6.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(-7.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(-7.0F, -3.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-7.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(-8.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(-8.0F, -3.0F, -3.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(-8.0F, -3.0F, -2.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(-8.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(-8.0F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(-8.0F, -3.0F, 1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(-8.0F, -3.0F, 2.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(-8.0F, -3.0F, 3.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(-8.0F, -3.0F, 4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-7.0F, -3.0F, 4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(-7.0F, -3.0F, 5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(-7.0F, -3.0F, 6.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-6.0F, -3.0F, 6.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(-6.0F, -3.0F, 7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-5.0F, -3.0F, 7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(-5.0F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(-4.0F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-3.0F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(-3.0F, -3.0F, 9.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(-2.0F, -3.0F, 9.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(-1.0F, -3.0F, 9.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(1.0F, -3.0F, 9.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(2.0F, -3.0F, 9.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(2.0F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(3.0F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(4.0F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(4.0F, -3.0F, 7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(5.0F, -3.0F, 7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(5.0F, -3.0F, 6.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(6.0F, -3.0F, 6.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(6.0F, -3.0F, 5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(6.0F, -3.0F, 4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(0.0F, -3.0F, 9.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 19).cuboid(-3.0F, -3.0F, -9.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(3.0F, -1.0F, -2.0F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-2.0F, -15.0F, -5.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(13, 0).cuboid(-2.0F, -9.0F, -10.0F, 4.0F, 5.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(2.0F, -9.0F, -9.0F, 2.0F, 5.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-4.0F, -9.0F, -9.0F, 2.0F, 5.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(4.0F, -9.0F, -8.0F, 2.0F, 5.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-6.0F, -9.0F, -8.0F, 2.0F, 5.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(6.0F, -9.0F, -7.0F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-7.0F, -9.0F, -7.0F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(6.0F, -10.0F, -6.0F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-7.0F, -10.0F, -6.0F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(7.0F, -9.0F, -5.0F, 1.0F, 5.0F, 2.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-8.0F, -9.0F, -5.0F, 1.0F, 5.0F, 2.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(8.0F, -8.0F, -3.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-9.0F, -8.0F, -3.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(8.0F, -7.0F, -2.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(8.0F, -6.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-9.0F, -6.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(8.0F, -5.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-9.0F, -5.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-9.0F, -7.0F, -2.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(4.0F, -10.0F, -7.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(4.0F, -12.0F, -6.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-6.0F, -12.0F, -6.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-6.0F, -10.0F, -7.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(2.0F, -10.0F, -8.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-4.0F, -10.0F, -8.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(2.0F, -12.0F, -7.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(2.0F, -13.0F, -6.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-4.0F, -13.0F, -6.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-4.0F, -12.0F, -7.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
                        .uv(13, 0).cuboid(-2.0F, -11.0F, -9.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F))
                        .uv(13, 0).cuboid(-2.0F, -12.0F, -8.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F))
                        .uv(13, 0).cuboid(-2.0F, -13.0F, -7.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(13, 0).cuboid(-2.0F, -14.0F, -6.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-2.0F, -15.0F, -3.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-3.0F, -15.0F, -4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(2.0F, -15.0F, -4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(2.0F, -4.0F, -4.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-8.0F, -4.0F, -4.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-4.0F, -4.0F, -4.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)),
                ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        return TexturedModelData.of(meshdefinition, 32, 32);
    }


    @Override
    public void render(MatrixStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, final int color) {
        Mainbody.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);


    }


    @Override
    public void setAngles(final T entity, final float limbAngle, final float limbDistance, final float animationProgress, final float headYaw, final float headPitch) {

    }
}
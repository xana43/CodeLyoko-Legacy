package com.Ultra_Nerd.CodeLyokoRemake15.items.armor.Models;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import org.jetbrains.annotations.NotNull;

public class testmodel {

    public static @NotNull MeshDefinition addParts(@NotNull CubeDeformation deformation)
    {
        MeshDefinition meshDefinition = HumanoidModel.createMesh(deformation,0);
        PartDefinition partDefinition = meshDefinition.getRoot();
        PartDefinition head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0,0)
                .addBox(1f,1f,1f,1f,1f,1f,deformation), PartPose.offset(0,0,0));
        return meshDefinition;
    }

}

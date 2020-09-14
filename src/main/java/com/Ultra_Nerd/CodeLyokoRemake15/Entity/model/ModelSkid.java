package com.Ultra_Nerd.CodeLyokoRemake15.Entity.model;


import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.renderer.model.*;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModelConfiguration;
import net.minecraftforge.client.model.geometry.IModelGeometry;
import net.minecraftforge.client.model.geometry.IModelGeometryPart;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.client.model.obj.OBJModel;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

public class ModelSkid implements/*IMultipartModelGeometry<OBJModel>,*/ IModelGeometry<OBJModel> {

    public OBJLoader loader = new OBJLoader();
    public OBJModel objModel;

    public ModelSkid() {

        objModel = loader.loadModel(new OBJModel.ModelSettings(new ResourceLocation(Base.MOD_ID,"models/entities/skid/skid.obj"),false,true,
                true,false,null));
    }

    @Override
    public Collection<? extends IModelGeometryPart> getParts() {
        return this.objModel.getParts();
    }

    @Override
    public Optional<? extends IModelGeometryPart> getPart(String name) {
        return Optional.empty();
    }

    @Override
    public Collection<Material> getTextures(IModelConfiguration owner, Function<ResourceLocation, IUnbakedModel> modelGetter, Set<Pair<String, String>> missingTextureErrors) {
        return this.objModel.getTextures(owner,modelGetter,missingTextureErrors);
    }

    @Override
    public IBakedModel bake(IModelConfiguration owner, ModelBakery bakery, Function<Material, TextureAtlasSprite> spriteGetter, IModelTransform modelTransform, ItemOverrideList overrides, ResourceLocation modelLocation) {
        return this.objModel.bake(owner,bakery,spriteGetter,modelTransform,overrides,modelLocation);
    }











   /* OBJLoader Loader = new OBJLoader();
    public ModelSkid(EntityRendererManager entityRendererManager) {
        super(entityRendererManager);
        Loader.loadModel(new OBJModel.ModelSettings());

        this.modelLocation(new ResourceLocation());
        //https://gitlab.com/Lycanite/LycanitesMobs/-/blob/master/src/main/java/com/lycanitesmobs/client/model/CreatureModel.java
        //https://gitlab.com/Lycanite/LycanitesMobs/-/blob/master/src/main/java/com/lycanitesmobs/client/model/CreatureObjModel.java
        // This code could be used to have entity models as OBJ files, to scavenge and adapt to our problems
    }

    @Override
    public ResourceLocation getEntityTexture(EntitySkid entity) {
        return null;
    }

    */




}

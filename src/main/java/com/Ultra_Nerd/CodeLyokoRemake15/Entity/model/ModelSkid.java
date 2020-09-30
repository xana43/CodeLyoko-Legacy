package com.Ultra_Nerd.CodeLyokoRemake15.Entity.model;


import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.*;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ILightReader;
import net.minecraftforge.client.extensions.IForgeBakedModel;
import net.minecraftforge.client.model.IModelBuilder;
import net.minecraftforge.client.model.IModelConfiguration;
import net.minecraftforge.client.model.IModelLoader;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.client.model.geometry.IModelGeometry;
import net.minecraftforge.client.model.geometry.IModelGeometryPart;
import net.minecraftforge.client.model.geometry.IMultipartModelGeometry;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.client.model.obj.OBJModel;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Function;

public class ModelSkid implements IMultipartModelGeometry<OBJModel>, IModelGeometry<OBJModel>, IForgeBakedModel, IModelLoader<OBJModel>, IRenderTypeBuffer, IBakedModel {

    private final OBJLoader loader = new OBJLoader();
    private final OBJModel objModel;
    public IBakedModel bakedModel;

    public ModelSkid() {

        objModel = loader.loadModel(new OBJModel.ModelSettings(new ResourceLocation(Base.MOD_ID, "models/entities/skid/skid.obj"), false, true,
                true, false, null));
        bakedModel = this.getBakedModel();
    }

    @Nonnull
    @Override
    public IModelData getModelData(@Nonnull ILightReader world, @Nonnull BlockPos pos, @Nonnull BlockState state, @Nonnull IModelData tileData) {
        return this.getBakedModel().getModelData(world, pos, state, tileData);
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
        return this.objModel.getTextures(owner, modelGetter, missingTextureErrors);
    }

    @Override
    public IBakedModel bake(IModelConfiguration owner, ModelBakery bakery, Function<Material, TextureAtlasSprite> spriteGetter, IModelTransform modelTransform, ItemOverrideList overrides, ResourceLocation modelLocation) {
        return this.objModel.bake(owner, bakery, spriteGetter, modelTransform, overrides, modelLocation);
    }

    @Override
    public void addQuads(IModelConfiguration owner, IModelBuilder<?> modelBuilder, ModelBakery bakery, Function<Material, TextureAtlasSprite> spriteGetter, IModelTransform modelTransform, ResourceLocation modelLocation) {
        this.objModel.addQuads(owner, modelBuilder, bakery, spriteGetter, modelTransform, modelLocation);
    }

    @Nonnull
    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @Nonnull Random rand, @Nonnull IModelData extraData) {
        return this.getBakedModel().getQuads(state, side, rand, extraData);
    }

    @Override
    public void onResourceManagerReload(@Nonnull IResourceManager resourceManager) {

    }

    @Nonnull
    @Override
    public OBJModel read(@Nonnull JsonDeserializationContext deserializationContext, @Nonnull JsonObject modelContents) {
        return this.loader.read(deserializationContext, modelContents);
    }


    @Nonnull
    @Override
    public IVertexBuilder getBuffer(@Nonnull RenderType p_getBuffer_1_) {
        return this.getBuffer(p_getBuffer_1_);
    }

    @Nonnull
    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, Random rand) {
        return this.bakedModel.getQuads(state, side, rand);
    }

    @Override
    public boolean isAmbientOcclusion() {
        return false;
    }

    @Override
    public boolean isGui3d() {
        return false;
    }

    @Override
    public boolean func_230044_c_() {
        return false;
    }

    @Override
    public boolean isBuiltInRenderer() {
        return false;
    }

    @Override
    public TextureAtlasSprite getParticleTexture() {
        return null;
    }

    @Override
    public ItemOverrideList getOverrides() {
        return null;
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

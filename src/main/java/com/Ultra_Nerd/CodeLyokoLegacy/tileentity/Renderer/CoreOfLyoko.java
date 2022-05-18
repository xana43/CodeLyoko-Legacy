package com.Ultra_Nerd.CodeLyokoLegacy.tileentity.Renderer;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModFluids;
import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.LyokoCoreBE;
import dev.monarkhes.myron.api.Myron;
import dev.monarkhes.myron.impl.client.model.MyronBakedModel;
import dev.monarkhes.myron.impl.client.model.MyronMaterial;
import dev.monarkhes.myron.impl.client.model.MyronUnbakedModel;
import myron.shaded.de.javagl.obj.Obj;
import myron.shaded.de.javagl.obj.ObjData;
import net.fabricmc.fabric.api.client.model.ModelProviderContext;
import net.fabricmc.fabric.api.client.model.ModelProviderException;
import net.fabricmc.fabric.api.client.model.ModelResourceProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.fluid.Fluids;
import net.minecraft.scoreboard.ScoreboardCriterion;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Quaternion;
import net.minecraft.util.math.Vec3f;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Random;

public record CoreOfLyoko(BlockEntityRendererFactory.Context context) implements BlockEntityRenderer<LyokoCoreBE> {

    private static int  y;

    private static final BakedModel lyokoCore = Myron.getModel(CodeLyokoMain.CodeLyokoPrefix("models/blocks/core_of_lyoko"));

    @Override
    public int getRenderDistance() {
        return 128;
    }

    @Override
    public void render(final LyokoCoreBE entity, final float tickDelta, final MatrixStack matrices, final VertexConsumerProvider vertexConsumers, final int light, final int overlay) {
        //blockRenderDispatcher.renderSingleBlock(ModBlocks.LYOKO_CORE.get().defaultBlockState(),pPoseStack,pBufferSource,pPackedOverlay,pPackedOverlay, EmptyModelData.INSTANCE);
        //this.context.getBlockRenderDispatcher().renderSingleBlock(ModBlocks.LYOKO_CORE.get().defaultBlockState(),pPoseStack,pBufferSource,pPackedLight,pPackedOverlay, EmptyModelData.INSTANCE);
       // if(lyokoCore != null) {

            matrices.push();

            //pPoseStack.mulPose(new Quaternion(0,y++,0,true));



                final World entityWorld = entity.getWorld();
                matrices.translate(0.5, 0.5, 0.5);
                matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(y +=6));
                if(y == 360)
                {
                    y = 0;
                }
                matrices.translate(-0.5, -0.5, -0.5);

            //MinecraftClient.getInstance().getBlockEntityRenderDispatcher().renderEntity(entity,matrices,vertexConsumers,light,overlay);

                context.getRenderManager().getModelRenderer().render(entityWorld, lyokoCore, Blocks.AIR.getDefaultState(), entity.getPos(), matrices, vertexConsumers.getBuffer(RenderLayer.getTranslucentMovingBlock()), true, entityWorld.getRandom(), 0, overlay);

            matrices.pop();


        //}
    }
}

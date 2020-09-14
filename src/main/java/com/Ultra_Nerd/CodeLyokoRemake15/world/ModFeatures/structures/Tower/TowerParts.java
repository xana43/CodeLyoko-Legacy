package com.Ultra_Nerd.CodeLyokoRemake15.world.ModFeatures.structures.Tower;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModWorldFeatures;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class TowerParts {
    private static final ResourceLocation PART1 = new ResourceLocation(Base.MOD_ID,"tower_new_bellow");
    private static final ResourceLocation PART2 = new ResourceLocation(Base.MOD_ID,"tower_new_top");
    private static final Map<ResourceLocation, BlockPos> offset = ImmutableMap.of(PART1,new BlockPos(0,-14,0),PART2,new BlockPos(0,0,0));
    public static void Start(TemplateManager manager, BlockPos pos, Rotation rotation, List<StructurePiece> pieces, Random rand)
    {
        int x = pos.getX();
        int z = pos.getZ();
        BlockPos rotoff = new BlockPos(0,0,0).rotate(rotation);
        BlockPos blockPos = rotoff.add(x,pos.getY(),z);
        pieces.add(new TowerParts.Part(manager,PART1,blockPos,rotation));
        pieces.add(new TowerParts.Part(manager,PART2,blockPos,rotation));
    }

    public static class Part extends TemplateStructurePiece{
        private ResourceLocation resourceLocation;
        private Rotation rotation;

        public Part(TemplateManager templateManagerIn, ResourceLocation resourceLocationIn, BlockPos pos,
                     Rotation rotationIn) {
            super(ModWorldFeatures.TOWER_PART, 0);
            this.resourceLocation = resourceLocationIn;
            BlockPos blockpos = TowerParts.offset.get(resourceLocation);
            //BlockPos blockpos2 = TowerParts.offset2.get(resourceLocation);
            this.templatePosition = pos.add(blockpos.getX(), blockpos.getY(), blockpos.getZ());
            //this.templatePosition = pos.add(blockpos2.getX(),blockpos2.getY(),blockpos2.getZ());
            this.rotation = rotationIn;
            this.setupPiece(templateManagerIn);
        }

        public Part(TemplateManager templateManagerIn, CompoundNBT tagCompound) {
            super(ModWorldFeatures.TOWER_PART, tagCompound);
            this.resourceLocation = new ResourceLocation(tagCompound.getString("Template"));
            this.rotation = Rotation.valueOf(tagCompound.getString("Rot"));
            this.setupPiece(templateManagerIn);
        }

        private void setupPiece(TemplateManager templateManager) {
            Template template = templateManager.getTemplateDefaulted(this.resourceLocation);
            PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation)
                    .setMirror(Mirror.NONE);
            this.setup(template, this.templatePosition, placementsettings);
        }

        @Override
        protected void readAdditional(CompoundNBT tagCompound) {
            super.readAdditional(tagCompound);
            tagCompound.putString("Template", this.resourceLocation.toString());
            tagCompound.putString("Rot", this.rotation.name());
        }

        @Override
        protected void handleDataMarker(String function, BlockPos pos, IWorld worldIn, Random rand,
                                        MutableBoundingBox sbb) {
            if ("chest".equals(function)) {
                worldIn.setBlockState(pos, Blocks.CHEST.getDefaultState(), 2);
                TileEntity tileentity = worldIn.getTileEntity(pos);
                if (tileentity instanceof ChestTileEntity) {
                    // here you can set any loot tables for the chests
                }
            }
        }

        // create

        @Override
        public boolean create(IWorld worldIn, ChunkGenerator<?> generator, Random randomIn,
                                      MutableBoundingBox structureBoundingBoxIn, ChunkPos chunkPos) {
            PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation)
                    .setMirror(Mirror.NONE);
            BlockPos blockpos = TowerParts.offset.get(this.resourceLocation);
            this.templatePosition.add(Template.transformedBlockPos(placementsettings,
                    new BlockPos(0 - blockpos.getX(), 0, 0 - blockpos.getZ())));


            return super.create(worldIn, generator, randomIn, structureBoundingBoxIn, chunkPos);
        }
    }
}

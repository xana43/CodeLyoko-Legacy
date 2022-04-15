package com.Ultra_Nerd.CodeLyokoLegacy.world.ModFeatures.structures.Tower;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class TowerParts  {

    private static final ResourceLocation PART1 = new ResourceLocation(CodeLyokoMain.MOD_ID, "tower_new_bellow");
    private static final ResourceLocation PART2 = new ResourceLocation(CodeLyokoMain.MOD_ID, "tower_new_top");
    private static final Map<ResourceLocation, BlockPos> offset = ImmutableMap.of(PART1, new BlockPos(0, -14, 0), PART2, new BlockPos(0, 0, 0));
/*
    public static void Start(StructureManager manager, BlockPos pos, Rotation rotation, List<StructurePiece> pieces, Random rand) {
        int x = pos.getX();
        int z = pos.getZ();
        BlockPos rotoff = new BlockPos(0, 0, 0).rotate(rotation);
        BlockPos blockPos = rotoff.offset(x, pos.getY(), z);
        pieces.add(new TowerParts.Part(PART1, blockPos, rotation,manager));
        pieces.add(new TowerParts.Part(PART2, blockPos, rotation,manager));
    }

    public static class Part extends TemplateStructurePiece {
        private final ResourceLocation resourceLocation;
        private Rotation rotation;

        public Part(StructurePieceType typeIn, StructureManager mang) {
            super(ModWorldFeatures.TOWER_PART, 0,manager);
            this.resourceLocation = resourceLocationIn;
            BlockPos blockpos = TowerParts.offset.get(resourceLocation);
            //BlockPos blockpos2 = TowerParts.offset2.get(resourceLocation);
            //this.templatePosition = pos.offset(blockpos.getX(), blockpos.getY(), blockpos.getZ());
            //this.templatePosition = pos.add(blockpos2.getX(),blockpos2.getY(),blockpos2.getZ());
            this.rotation = rotationIn;
            this.setupPiece(templateManagerIn);
        }

        public Part(StructurePieceType templateManagerIn, CompoundTag tagCompound) {
            super(ModWorldFeatures.TOWER_PART, tagCompound);
            this.resourceLocation = new ResourceLocation(tagCompound.getString("Template"));
            this.rotation = Rotation.valueOf(tagCompound.getString("Rot"));
            this.setupPiece(templateManagerIn);
        }


        private void setupPiece(StructureManager templateManager) {
            StructureTemplate template = templateManager.get(this.resourceLocation).get();
            StructurePlaceSettings placementsettings = (new StructurePlaceSettings()).setRotation(this.rotation)
                    .setMirror(Mirror.NONE);
            this.(template., this.getLocatorPosition(), placementsettings);
        }



        @Override
        protected void addAdditionalSaveData(StructurePieceSerializationContext context, @Nonnull CompoundTag tagCompound) {
            tagCompound.putString("Template", this.resourceLocation.toString());
            tagCompound.putString("Rot", this.rotation.name());
        }

        @Override
        public void postProcess(WorldGenLevel p_192637_, StructureFeatureManager p_192638_, ChunkGenerator p_192639_, Random p_192640_, BoundingBox p_192641_, ChunkPos p_192642_, BlockPos p_192643_) {

        }

        @Override
        protected void handleDataMarker(@Nonnull String function, @Nonnull BlockPos pos, @Nonnull ServerLevelAccessor worldIn, @Nonnull Random rand,
                                        @Nonnull BoundingBox sbb) {
            if ("chest".equals(function)) {
                worldIn.setBlock(pos, Blocks.CHEST.defaultBlockState(), 2);
                BlockEntity tileentity = worldIn.getBlockEntity(pos);
                if (tileentity instanceof ChestBlockEntity) {
                    // here you can set any loot tables for the chests
                }
            }
        }



        // create

        @Override
        protected boolean canBeReplaced(LevelReader p_163553_, int p_163554_, int p_163555_, int p_163556_, BoundingBox p_163557_) {
            StructurePlaceSettings placementsettings = (new StructurePlaceSettings()).setRotation(this.rotation)
                    .setMirror(Mirror.NONE);
            BlockPos blockpos = TowerParts.offset.get(this.resourceLocation);
            this.getLocatorPosition().offset(StructureTemplate.calculateRelativePosition(placementsettings,
                    new BlockPos(0 - blockpos.getX(), 0, 0 - blockpos.getZ())));
            return super.canBeReplaced(p_163553_, p_163554_, p_163555_, p_163556_, p_163557_);
        }




    }

 */




}

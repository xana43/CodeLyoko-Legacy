package com.Ultra_Nerd.CodeLyokoRemake15.world.ModFeatures.structures.Tower;

public class TowerParts {
    /*
    private static final ResourceLocation PART1 = new ResourceLocation(CodeLyokoMain.MOD_ID, "tower_new_bellow");
    private static final ResourceLocation PART2 = new ResourceLocation(CodeLyokoMain.MOD_ID, "tower_new_top");
    private static final Map<ResourceLocation, BlockPos> offset = ImmutableMap.of(PART1, new BlockPos(0, -14, 0), PART2, new BlockPos(0, 0, 0));

    public static void Start(TemplateStructurePiece manager, BlockPos pos, Rotation rotation, List<StructurePiece> pieces, Random rand) {
        int x = pos.getX();
        int z = pos.getZ();
        BlockPos rotoff = new BlockPos(0, 0, 0).rotate(rotation);
        BlockPos blockPos = rotoff.offset(x, pos.getY(), z);
        pieces.add(new TowerParts.Part(manager, PART1, blockPos, rotation));
        pieces.add(new TowerParts.Part(manager, PART2, blockPos, rotation));
    }

    public static class Part extends TemplateStructurePiece {
        private final ResourceLocation resourceLocation;
        private Rotation rotation;

        public Part(TemplateStructurePiece templateManagerIn, ResourceLocation resourceLocationIn, BlockPos pos,
                    Rotation rotationIn) {
            super(ModWorldFeatures.TOWER_PART, 0);
            this.resourceLocation = resourceLocationIn;
            BlockPos blockpos = TowerParts.offset.get(resourceLocation);
            //BlockPos blockpos2 = TowerParts.offset2.get(resourceLocation);
            this.templatePosition = pos.offset(blockpos.getX(), blockpos.getY(), blockpos.getZ());
            //this.templatePosition = pos.add(blockpos2.getX(),blockpos2.getY(),blockpos2.getZ());
            this.rotation = rotationIn;
            this.setupPiece(templateManagerIn);
        }

        public Part(TemplateStructurePiece templateManagerIn, CompoundTag tagCompound) {
            super(ModWorldFeatures.TOWER_PART, tagCompound);
            this.resourceLocation = new ResourceLocation(tagCompound.getString("Template"));
            this.rotation = Rotation.valueOf(tagCompound.getString("Rot"));
            this.setupPiece(templateManagerIn);
        }

        private void setupPiece(TemplateStructurePiece templateManager) {
            Template template = templateManager.getTemplateDefaulted(this.resourceLocation);
            PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation)
                    .setMirror(Mirror.NONE);
            this.setup(template, this.templatePosition, placementsettings);
        }

        @Override
        protected void readAdditional(@Nonnull CompoundNBT tagCompound) {
            super.readAdditional(tagCompound);
            tagCompound.putString("Template", this.resourceLocation.toString());
            tagCompound.putString("Rot", this.rotation.name());
        }

        @Override
        protected void handleDataMarker(@Nonnull String function, @Nonnull BlockPos pos, @Nonnull ServerLevelAccessor worldIn, @Nonnull Random rand,
                                        @Nonnull BoundingBox sbb) {
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
        public boolean create(@Nonnull IWorld worldIn, @Nonnull ChunkGenerator<?> generator, @Nonnull Random randomIn,
                              @Nonnull MutableBoundingBox structureBoundingBoxIn, @Nonnull ChunkPos chunkPos) {
            PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation)
                    .setMirror(Mirror.NONE);
            BlockPos blockpos = TowerParts.offset.get(this.resourceLocation);
            this.templatePosition.add(Template.transformedBlockPos(placementsettings,
                    new BlockPos(0 - blockpos.getX(), 0, 0 - blockpos.getZ())));


            return super.create(worldIn, generator, randomIn, structureBoundingBoxIn, chunkPos);
        }


    }

     */
}

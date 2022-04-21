package com.Ultra_Nerd.CodeLyokoLegacy.blocks.tower;

import net.minecraft.block.Block;


public class TowerWallCorner extends Block {
    public TowerWallCorner(final Settings settings) {
        super(settings);
    }
/*
    public static final DirectionProperty DIRTOWERC = BlockStateProperties.HORIZONTAL_FACING;

    public TowerWallCorner() {
        super(Properties.of(Material.BARRIER)
                .strength(-1, -1)
                .sound(SoundType.GLASS)

        );

    }


    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return 11;
    }

    @Override
    public boolean isValidSpawn(BlockState state, BlockGetter level, BlockPos pos, SpawnPlacements.Type type, EntityType<?> entityType) {
        return false;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(DIRTOWERC);
    }



    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        // TODO Auto-generated method stub
        return this.getStateDefinition().any().setValue(DIRTOWERC, context.getHorizontalDirection().getOpposite());
    }

    //mod compatiability
    @Nonnull
    @Override
    public BlockState rotate(@NotNull BlockState state, @NotNull Rotation rot) {
        return state.setValue(DIRTOWERC, rot.rotate(state.getValue(DIRTOWERC)));
    }

    @Nonnull
    @Override
    public BlockState mirror(@NotNull BlockState state, @NotNull Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(DIRTOWERC)));
    }
    //



    @OnlyIn(Dist.CLIENT)
    @Override
    public void animateTick(@Nonnull BlockState stateIn, @Nonnull Level worldIn, @Nonnull BlockPos pos, @Nonnull Random rand) {
        super.animateTick(stateIn, worldIn, pos, rand);
        double d0 = (double) pos.getX() + 0.5D + (rand.nextDouble() - 0.5D);
        double d1 = (double) pos.getY() + 0.5D + (rand.nextDouble() - 0.5D);
        double d2 = (double) pos.getZ() + 0.5D + (rand.nextDouble() - 0.5D);
        if (stateIn.getValue(DIRTOWERC) == Direction.NORTH) {
            if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1)) == Blocks.AIR.defaultBlockState()) {
                worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                        d0, d1, pos.getZ() + 1.25f, 0, -1, 0);
            } else {
                worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                        pos.getX() - 0.25f, d1, d2, 0, -1, 0);
            }
        } else if (stateIn.getValue(DIRTOWERC) == Direction.SOUTH) {
            if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1)) == Blocks.AIR.defaultBlockState()) {
                worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                        d0, d1, pos.getZ() - 0.25f, 0, -1, 0);
            } else {
                worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                        pos.getX() + 1.25f, d1, d2, 0, -1, 0);
            }
        } else if (stateIn.getValue(DIRTOWERC) == Direction.EAST) {
            if (worldIn.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())) == Blocks.AIR.defaultBlockState()) {
                worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                        pos.getX() - 0.25f, d1, d2, 0, -1, 0);
            } else {
                worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                        d0, d1, pos.getZ() - 0.25f, 0, -1, 0);
            }
        } else if (stateIn.getValue(DIRTOWERC) == Direction.WEST) {
            if (worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())) == Blocks.AIR.defaultBlockState()) {
                worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                        pos.getX() + 1.25f, d1, d2, 0, -1, 0);
            } else {
                worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                        d0, d1, pos.getZ() + 1.25f, 0, -1, 0);
            }
        }
    }

 */
}
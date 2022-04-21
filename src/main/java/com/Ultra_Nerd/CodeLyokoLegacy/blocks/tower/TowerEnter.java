package com.Ultra_Nerd.CodeLyokoLegacy.blocks.tower;

import net.minecraft.block.Block;


public final class TowerEnter extends Block {
    public TowerEnter(final Settings settings) {
        super(settings);
    }
/*
    public static final DirectionProperty DIRTOWER2 = BlockStateProperties.HORIZONTAL_FACING;

    public TowerEnter() {
        super(Properties.of(Material.BARRIER)

                .strength(-1, -1)
                .sound(SoundType.GLASS)
                .noCollission()


        );

    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return 5;
    }

    @Override
    public void entityInside(BlockState p_60495_, Level p_60496_, BlockPos p_60497_, Entity p_60498_) {
        super.entityInside(p_60495_, p_60496_, p_60497_, p_60498_);
        if(!(p_60498_ instanceof Player))
        {
            p_60498_.hurt(DamageSource.OUT_OF_WORLD, Float.MAX_VALUE);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(DIRTOWER2);
    }




    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        // TODO Auto-generated method stub
        return this.defaultBlockState().setValue(DIRTOWER2, context.getHorizontalDirection().getOpposite());
    }

    //mod compatiability
    @Nonnull
    @Override
    public BlockState rotate(@NotNull BlockState state, @NotNull Rotation rot) {
        return state.setValue(DIRTOWER2, rot.rotate(state.getValue(DIRTOWER2)));
    }

    @Nonnull
    @Override
    public BlockState mirror(@NotNull BlockState state, @NotNull Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(DIRTOWER2)));
    }

    //


    @Override
    public boolean isValidSpawn(BlockState state, BlockGetter level, BlockPos pos, SpawnPlacements.Type type, EntityType<?> entityType) {
        return false;
    }

 */




}
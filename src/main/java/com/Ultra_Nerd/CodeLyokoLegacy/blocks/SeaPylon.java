package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import net.minecraft.block.Block;


public final class SeaPylon extends Block {
    public SeaPylon(final Settings settings) {
        super(settings);
    }
/*
    public static final DirectionProperty DIRPYLON = BlockStateProperties.HORIZONTAL_FACING;

    public SeaPylon() {
        super(Properties.of(new Material.Builder(MaterialColor.METAL).build())

                .strength(-1, -1)
                .sound(SoundType.GLASS)
                .noOcclusion()



        );

    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(DIRPYLON);
    }




    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return 5;
    }



    @Override
    public @NotNull BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        // TODO Auto-generated method stub
        return this.defaultBlockState().setValue(DIRPYLON, context.getHorizontalDirection().getOpposite());
    }

    //mod compatiability
    @Nonnull
    @Override
    public BlockState rotate(@NotNull BlockState state, @NotNull Rotation rot) {
        return state.setValue(DIRPYLON, rot.rotate(state.getValue(DIRPYLON)));
    }

    @Nonnull
    @Override
    public BlockState mirror(@NotNull BlockState state, @NotNull Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(DIRPYLON)));
    }
    //

 */





}
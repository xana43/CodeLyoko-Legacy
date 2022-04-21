package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;

public final class DigitalLavaBlock extends FluidBlock {
    public DigitalLavaBlock(final FlowableFluid fluid, final Settings settings) {
        super(fluid, settings);
    }




/*


    @Override
    public void entityInside(@Nonnull BlockState state, @Nonnull Level worldIn, @Nonnull BlockPos pos, @Nonnull Entity entityIn) {
        super.entityInside(state, worldIn, pos, entityIn);
        entityIn.setRemainingFireTicks(100);
        entityIn.hurt(new DamageSource(Objects.requireNonNull(this.getRegistryName()).toString()).bypassArmor().setIsFire(),Float.MAX_VALUE);
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter world, BlockPos pos) {
        return Blocks.LAVA.getLightEmission(state,world,pos);
    }

 */


}

package io.github.elsopeen.lyokomod.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class NumericSeaFluidBlock extends FlowingFluidBlock {
    public NumericSeaFluidBlock(Supplier<? extends FlowingFluid> supplier, Properties p_i48368_1_) {
        super(supplier, p_i48368_1_);
    }


    @Override
    public void onEntityCollision(@Nonnull BlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull Entity entityIn) {
        if(entityIn instanceof LivingEntity){
            entityIn.attackEntityFrom(DamageSource.OUT_OF_WORLD, Integer.MAX_VALUE);
        }
    }
}

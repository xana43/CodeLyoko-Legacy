package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import com.Ultra_Nerd.CodeLyokoRemake15.Entity.MantaEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import javax.annotation.Nonnull;
import java.util.function.Supplier;


public class DigitalSeaBlock extends ForgeFlowingFluid {


    public DigitalSeaBlock(Supplier<? extends FlowingFluid> supplier) {
        super(supplier, Block.Properties.from(Blocks.WATER).variableOpacity());
    }


    @Override
    public void onEntityCollision(@Nonnull BlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull Entity entityIn) {
        if (!(entityIn instanceof MantaEntity)) {
            entityIn.attackEntityFrom(new DamageSource(this.getTranslationKey()), Byte.MAX_VALUE);
        }
    }

    @Override
    public boolean isNormalCube(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos) {
        return false;
    }

    @Override
    public boolean isTransparent(@Nonnull BlockState state) {
        return true;
    }

    @Override
    public boolean propagatesSkylightDown(@Nonnull BlockState state, @Nonnull IBlockReader reader, @Nonnull BlockPos pos) {
        return true;
    }
}

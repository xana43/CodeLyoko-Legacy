package com.Ultra_Nerd.CodeLyokoLegacy.blocks.saplings;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;
import org.jetbrains.annotations.NotNull;

public final class DigitalMountainSapling extends SaplingBlock  {




    public DigitalMountainSapling(@NotNull AbstractTreeGrower TreeStruct, @NotNull Properties properties) {
        super(TreeStruct,properties);

    }






    @Override
    public boolean canSustainPlant(@NotNull BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        return state.getBlock() == ModBlocks.DIGITAL_ROCK.get();
    }












}
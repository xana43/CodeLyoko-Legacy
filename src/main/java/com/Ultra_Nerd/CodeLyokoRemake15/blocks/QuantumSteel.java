package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class QuantumSteel extends Block {
    public static final BooleanProperty formed = BooleanProperty.create("formed");
    public QuantumSteel(Properties properties) {
        super(properties);
        this.setDefaultState(this.getStateContainer().getBaseState().with(formed,false));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(formed);
    }

    public static void SetModel(boolean act, World worldIn, BlockPos pos)
    {
        BlockState state = worldIn.getBlockState(pos);


        if(act) {
            worldIn.setBlockState(pos, state.with(formed,true));

        }
        else {
            worldIn.setBlockState(pos, state.with(formed,false));
        }



    }
}

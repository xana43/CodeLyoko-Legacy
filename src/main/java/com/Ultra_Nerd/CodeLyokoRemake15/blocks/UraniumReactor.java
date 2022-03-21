package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.ComputerReactorTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ToolType;
import org.jetbrains.annotations.Nullable;

public class UraniumReactor extends BaseEntityBlock {

    public UraniumReactor() {
        super(Block.Properties.of(Material.METAL)

                .strength(6, 10)
                .sound(SoundType.METAL)


        // TODO Auto-generated constructor stub
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ComputerReactorTileEntity(pos,state);
    }
	/*
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		// TODO Auto-generated method stub
		return true;
	}

	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		// TODO Auto-generated method stub
		return new ComputerReactorTileEntity();
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		ComputerReactorTileEntity tileentity = (ComputerReactorTileEntity)worldIn.getTileEntity(pos);
		worldIn.spawnEntity(new EntityItem(worldIn,pos.getX(),pos.getY(),pos.getZ(), tileentity.handle.getStackInSlot(0)));
		super.breakBlock(worldIn, pos, state);
	}
	*/

}

package com.Ultra_Nerd.CodeLyokoLegacy.blocks.SuperCalculator;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.Nullable;

public final class ComputerIntegratedReactor extends BaseEntityBlock {

    public ComputerIntegratedReactor() {
        super(Block.Properties.of(Material.METAL)

                .strength(6, 10)
                .sound(SoundType.METAL));




        // TODO Auto-generated constructor stub
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return null; //ModTileEntities.REACTOR_BLOCK_ENTITY.get().create(pos,state);
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
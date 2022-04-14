package com.Ultra_Nerd.CodeLyokoRemake15.blocks;


import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.Nullable;

public class UniversalEnergyBlock extends BaseEntityBlock {

    //private UniversalEnergyStorageTileEntity Text = new UniversalEnergyStorageTileEntity();
    public UniversalEnergyBlock() {
        super(Properties.of(Material.DECORATION)
                .sound(SoundType.GLASS)
                .requiresCorrectToolForDrops()



        );

    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return null;
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
	return new UniversalEnergyStorageTileEntity();
}
  
  @Override
public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
		EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
	playerIn.sendMessage(new TextComponentString(Integer.toString(Text.getall(0)) + "RF" + "/" + Integer.toString(Text.getStoreMax()) + "RF") );
	return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
}
*/
}

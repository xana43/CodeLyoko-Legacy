package com.Ultra_Nerd.CodeLyokoLegacy.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public final class UniversalEnergyBlock extends BlockWithEntity {
    public UniversalEnergyBlock(final Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return null;
    }
/*
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

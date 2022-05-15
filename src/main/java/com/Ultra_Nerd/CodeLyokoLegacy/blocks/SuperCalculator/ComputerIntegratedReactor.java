package com.Ultra_Nerd.CodeLyokoLegacy.blocks.SuperCalculator;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public final class ComputerIntegratedReactor extends Block implements BlockEntityProvider {
    public ComputerIntegratedReactor() {
        super(FabricBlockSettings.of(Material.METAL).strength(6,10).sounds(BlockSoundGroup.METAL));
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return null;
    }
/*
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

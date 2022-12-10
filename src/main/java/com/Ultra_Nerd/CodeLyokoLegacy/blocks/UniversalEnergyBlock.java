package com.Ultra_Nerd.CodeLyokoLegacy.blocks;


import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.UniversalEnergyStorageTileEntity;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;



public final class UniversalEnergyBlock extends BlockWithEntity {

    public UniversalEnergyBlock(final Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return ModTileEntities.UNIVERSAL_ENERGY_STORAGE.instantiate(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(final BlockState state) {
        return BlockRenderType.INVISIBLE;
    }

    @Override
    public ActionResult onUse(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final Hand hand, final BlockHitResult hit) {

        final BlockEntity be = world.getBlockEntity(pos);
        if(be instanceof UniversalEnergyStorageTileEntity universalEnergyStorageTile && world.isClient())
        {
            player.sendMessage(Text.of("Energy Amount: " + universalEnergyStorageTile.getCurrentAmount()),false);
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void randomDisplayTick(final BlockState state, final World world, final BlockPos pos, final Random random) {
        super.randomDisplayTick(state, world, pos, random);
    }

    @Override
    public void onStateReplaced(final BlockState state, final World world, final BlockPos pos, final BlockState newState, final boolean moved) {
        if(state.getBlock() != newState.getBlock())
        {
            final BlockEntity be = world.getBlockEntity(pos);
            if(be instanceof UniversalEnergyStorageTileEntity universalEnergyStorageTile)
            {
                universalEnergyStorageTile.setEnergyAmount(0);
            }
        }
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    @Override
    public void onBreak(final World world, final BlockPos pos, final BlockState state, final PlayerEntity player) {


            final BlockEntity be = world.getBlockEntity(pos);
            if(be instanceof UniversalEnergyStorageTileEntity universalEnergyStorageTile)
            {
                universalEnergyStorageTile.setEnergyAmount(0);
            }

        super.onBreak(world, pos, state, player);

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

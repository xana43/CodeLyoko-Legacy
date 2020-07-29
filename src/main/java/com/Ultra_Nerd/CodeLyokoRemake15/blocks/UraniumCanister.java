package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModFluids;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class UraniumCanister extends Block {

    protected static final VoxelShape shape = Block.makeCuboidShape(3.5D,0.0D,3.5D,12.0D,15.0D,12.0D);
    public UraniumCanister(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return shape;
    }




    @Override
    public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state) {

            worldIn.setBlockState(pos, ModFluids.URANIUM.get().getDefaultState(),1);

        super.onPlayerDestroy(worldIn, pos, state);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {


            if(!player.isCreative()) {
                player.addPotionEffect(new EffectInstance(Effects.HUNGER, 100, 2, false, false, false));
                player.addPotionEffect(new EffectInstance(Effects.NAUSEA, 4000, 255, false, false, false));
                player.addPotionEffect(new EffectInstance(Effects.POISON, 100, 1, false, true, false));
            }

        return ActionResultType.SUCCESS;
    }

    @Override
    public boolean isTransparent(BlockState state) {
        return true;
    }

    @Override
    public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return true;
    }
}

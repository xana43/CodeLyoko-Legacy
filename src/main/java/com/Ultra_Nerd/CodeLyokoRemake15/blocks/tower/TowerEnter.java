package com.Ultra_Nerd.CodeLyokoRemake15.blocks.tower;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


public class TowerEnter extends Block {

    public static final DirectionProperty DIRTOWER2 = BlockStateProperties.HORIZONTAL_FACING;

    public TowerEnter() {
        super(Properties.create(Material.MISCELLANEOUS)

                .hardnessAndResistance(-1, -1)
                .sound(SoundType.GLASS)
                .lightValue(5)
                .doesNotBlockMovement()


        );

    }

    @Override
    public void onEntityCollision(@Nonnull BlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull Entity entityIn) {
        super.onEntityCollision(state, worldIn, pos, entityIn);
        if(!(entityIn instanceof PlayerEntity))
        {
            entityIn.attackEntityFrom(DamageSource.OUT_OF_WORLD,Integer.MAX_VALUE);
        }
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(DIRTOWER2);
    }


    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        // TODO Auto-generated method stub
        return this.getDefaultState().with(DIRTOWER2, context.getPlacementHorizontalFacing().getOpposite());
    }

    //mod compatiability
	@Nonnull
	@Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(DIRTOWER2, rot.rotate(state.get(DIRTOWER2)));
    }

	@Nonnull
	@Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(DIRTOWER2)));
    }
    //
    @Override
    public boolean canCreatureSpawn(BlockState state, IBlockReader world, BlockPos pos, EntitySpawnPlacementRegistry.PlacementType type, @Nullable EntityType<?> entityType) {
        return false;
    }
    @Override
    public boolean isNormalCube(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isTransparent(@Nonnull BlockState state) {
        // TODO Auto-generated method stub
        return true;
    }


}
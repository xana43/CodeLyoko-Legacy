package com.Ultra_Nerd.CodeLyokoRemake15.blocks.tests;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModDimensionTypes;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModDimensions;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.ITeleporter;

import javax.annotation.Nonnull;

public class TestBlockPortal extends Block implements ITeleporter {

    public TestBlockPortal(Properties properties) {
        super(properties);

    }


    @Override
    public void onEntityCollision(@Nonnull BlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull Entity entityIn) {
        super.onEntityCollision(state, worldIn, pos, entityIn);
        if(entityIn instanceof PlayerEntity) {
            if (!entityIn.getPositionVec().equals(new Vec3d(0, 128, 0))) {
                entityIn.changeDimension((DimensionManager.registerOrGetDimension(ModDimensionTypes.DimensionTypeCarthage, ModDimensions.SECTOR_5.get(),null,true)),this);

                entityIn.setPosition(0, 128, 0);
            }
        }
    }
}

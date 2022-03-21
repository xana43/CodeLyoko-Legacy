package com.Ultra_Nerd.CodeLyokoRemake15.blocks.tests;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModDimensionTypes;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.ITeleporter;

import javax.annotation.Nonnull;

public class TestBlockPortal extends Block implements ITeleporter {

    public TestBlockPortal(Properties properties) {
        super(properties);

    }


    @Override
    public void entityInside(@Nonnull BlockState state, @Nonnull Level worldIn, @Nonnull BlockPos pos, @Nonnull Entity entityIn) {
        super.entityInside(state, worldIn, pos, entityIn);
        if (entityIn instanceof Player) {
            if (!entityIn.position().equals(new Vec3(0, 128, 0))) {
                entityIn.changeDimension((DimensionManager.registerOrGetDimension(ModDimensionTypes.DimensionTypeCarthage, ModDimensions.SECTOR_5.get(), null, true)), this);

                entityIn.setPos(0, 128, 0);
            }
        }
    }
}

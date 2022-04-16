package com.Ultra_Nerd.CodeLyokoLegacy.blocks.tests;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.MultiBlock.MasterEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class BlockPatternTest extends BaseEntityBlock {


    public BlockPatternTest(final Properties p_49224_) {
        super(p_49224_);
    }

    @Override
    public void tick(final BlockState pState, final ServerLevel pLevel, final BlockPos pPos, final Random pRandom) {
        super.tick(pState, pLevel, pPos, pRandom);
    }

    @Override
    public @NotNull RenderShape getRenderShape(final @NotNull BlockState pState) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(final Level pLevel, final BlockState pState, final BlockEntityType<T> pBlockEntityType) {
        if(!pLevel.isClientSide())
        {
            return (pLevel1, pPos, pState1, pBlockEntity) -> {
                if (pBlockEntity instanceof MasterEntity masterEntity)
                {
                    masterEntity.tick(pLevel1,pPos,pState1,masterEntity);
                }
            };
        }
        return null;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(final BlockPos pPos, final BlockState pState) {
        return ModTileEntities.MASTER_ENTITY_TEST.get().create(pPos,pState);
    }
}

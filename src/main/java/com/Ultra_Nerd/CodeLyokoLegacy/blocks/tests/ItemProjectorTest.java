package com.Ultra_Nerd.CodeLyokoLegacy.blocks.tests;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlockEntities;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public final class ItemProjectorTest extends Block implements BlockEntityProvider {
    public ItemProjectorTest() {
        super(FabricBlockSettings.copyOf(Blocks.BARRIER));
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return ModBlockEntities.ITEM_PROJECTOR_TEST_BLOCK_ENTITY.instantiate(pos,state);
    }
}

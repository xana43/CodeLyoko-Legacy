package com.Ultra_Nerd.CodeLyokoLegacy.Util.MultiBlock;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;

import java.util.Objects;

public abstract class MasterEntity extends BlockEntity  {



    BlockPattern blockPattern = BlockPatternBuilder.start().aisle(
            "sss",
            "sms",
            "sss").where('s', BlockInWorld.hasState(state -> state == Blocks.IRON_BLOCK.defaultBlockState()))
            .where('m',BlockInWorld.hasState(state -> state == ModBlocks.BLOCK_PATTERN.get().defaultBlockState())).build();

    public MasterEntity(final BlockPos pWorldPosition, final BlockState pBlockState) {
        super(ModTileEntities.MASTER_ENTITY_TEST.get(), pWorldPosition, pBlockState);
    }



    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        ///CompoundTag nbtTag = new CompoundTag();
        //Write your data into the nbtTag
        return ClientboundBlockEntityDataPacket.create(Objects.requireNonNull(Objects.requireNonNull(this.getLevel()).getBlockEntity(worldPosition)));
    }


    public abstract void tick(final Level pLevel, final BlockPos pPos, final BlockState pState, final MasterEntity pBlockEntity);
}

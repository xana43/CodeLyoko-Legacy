package com.Ultra_Nerd.CodeLyokoLegacy.player;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.HashMap;

public final class BlockEntityCapabilit implements INBTSerializable<ListTag> {


    private static final HashMap<BlockState,BlockPos> posHashMap = new HashMap<>();

    public void setThispos(BlockEntity blockEntity)
    {
        //CodeLyokoMain.Log.info("saveedScanner");

        posHashMap.put(blockEntity.getBlockState(), blockEntity.getBlockPos());


    }
    public void removePos(BlockEntity blockEntity)
    {
        posHashMap.remove(blockEntity.getBlockState(),blockEntity.getBlockPos());
    }
    public BlockPos getPos()
    {

        BlockPos blockPos = new BlockPos(0,0,0);
        for(BlockState blockEntityType : posHashMap.keySet())
        {
            blockPos = posHashMap.get(blockEntityType);
        }
        return blockPos;
    }



    @Override
    public ListTag serializeNBT() {

        ListTag tag = new ListTag();
        for(BlockState blockEntityType : posHashMap.keySet())
        {
            CompoundTag compoundTag = new CompoundTag();
            compoundTag.putIntArray(blockEntityType.toString(), new int[]{posHashMap.get(blockEntityType).getX(), posHashMap.get(blockEntityType).getY(), posHashMap.get(blockEntityType).getZ()});

            tag.add(compoundTag);
        }


        return tag;
    }

    @Override
    public void deserializeNBT(final ListTag nbt)
    {
        BlockPos blockpos = new BlockPos(0,0,0);
        for(int i = 0; i < nbt.size(); i++) {
            blockpos = new BlockPos(nbt.getIntArray(i)[0], nbt.getIntArray(i)[1], nbt.getIntArray(i)[2]);
        }
        for(BlockState entityType : posHashMap.keySet())
        {
            CodeLyokoMain.Log.info("loading position");
            posHashMap.replace(entityType,blockpos);
        }
    }
}

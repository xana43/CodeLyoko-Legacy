package com.Ultra_Nerd.CodeLyokoRemake15.Util.MultiBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PartBlockEntity extends BlockEntity implements PartLogic {
    private static final String TAG_BASE_POS = "basePos";
    private static final String TAG_BASE_BLOCK = "baseBlock";
   // @Getter
    @Nullable
    private BlockPos basepos;
    @Nullable
    private Block baseBlock;


    public boolean hasBaseBlock()
    {
        return basepos != null;
    }


    protected void setBase(@Nullable BlockPos base,@Nullable Block block)
    {
        basepos = base;
        baseBlock = block;
        this.setChangedFast();
    }

    protected boolean validateManager()
    {
        if(basepos == null)
        {
            return false;
        }
        assert level != null;
        if(level.getBlockState(basepos).getBlock() == baseBlock)
        {
            return true;
        }
        setBase(null,null);
        return false;
    }



    public PartBlockEntity(@NotNull BlockEntityType<?> pType, @NotNull BlockPos pWorldPosition, @NotNull BlockState pBlockState) {
        super(pType, pWorldPosition, pBlockState);
    }
    public boolean isClient()
    {
        return this.getLevel() != null && this.getLevel().isClientSide;
    }

    @SuppressWarnings("deprecation")
    public void setChangedFast()
    {
        if(level != null)
        {
            if(level.hasChunkAt(worldPosition))
            {
                level.getChunkAt(worldPosition).setUnsaved(true);
            }
        }
    }

    protected boolean shouldSync()
    {
        return true;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return shouldSync() ? ClientboundBlockEntityDataPacket.create(this) : null;
    }

    protected void saveSync(CompoundTag tag)
    {

    }


    @Override
    public @NotNull CompoundTag getUpdateTag() {
        CompoundTag nbt = new CompoundTag();
        saveSync(nbt);
        return nbt;
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag pTag) {
        super.saveAdditional(pTag);
        saveSync(pTag);
    }

    @Override
    public @Nullable BlockPos getPremierePos() {
        return null;
    }

    @Override
    public void updatePremiere(BlockPos pos, BlockState state) {
        if(validateManager())
        {

            assert basepos != null;

        }
    }

    @Override
    public boolean isActuallyMaster(PremiereBlockLogic master) {
        return false;
    }

    @Override
    public void assignPremiereToPart(@NotNull PremiereBlockLogic premiereBlockLogic) {
        BlockPos newmaster = premiereBlockLogic.getPremierePosition();
        if(newmaster.equals(this.basepos))
        {
            baseBlock = premiereBlockLogic.getPremiereBlock().getBlock();
            this.setChangedFast();
        }
        else if(!validateManager())
        {
            setBase(newmaster,premiereBlockLogic.getPremiereBlock().getBlock());
        }
    }

    @Override
    public void removePremiere(@NotNull PremiereBlockLogic premiereBlockLogic) {
            if(basepos != null && basepos.equals(premiereBlockLogic.getPremierePosition()))
            {
                setBase(null,null);
            }
    }


}

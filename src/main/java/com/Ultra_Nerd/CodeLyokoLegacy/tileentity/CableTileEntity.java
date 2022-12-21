package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class CableTileEntity extends BlockEntity {
    public CableTileEntity(final BlockPos pos, final BlockState state) {
        super(ModTileEntities.CABLE_TILE_ENTITY_BLOCK_ENTITY_TYPE, pos, state);
    }
    private boolean isMaster = false;
    public List<BlockPos> connectedPositions = new ArrayList<>();
    private boolean initialCheck()
    {
        for (final Direction dir : Direction.values())
        {
            if(world.getBlockState(pos.offset(dir,1)).isOf(ModBlocks.CABLE_BLOCK))
            {
                return false;
            }
        }
        return true;
    }
    private static final SecureRandom random = new SecureRandom();
    private boolean isEnd = false;
    public void checkIfEnd()
    {
        int count = 0;
        for (final Direction dir : Direction.values())
        {
            final BlockPos checkPos = pos.offset(dir,1);
            if(world.getBlockState(checkPos).isOf(ModBlocks.CABLE_BLOCK))
            {
                count++;
            }
        }
        isEnd = count <= 1;
    }
    public boolean getIsEnd()
    {
        return isEnd;
    }
    public void setIsEnd(final Boolean isEnd)
    {
        this.isEnd = isEnd;
    }
    public boolean getIsMaster()
    {
        return isMaster;
    }
    public BlockPos currentMaster = BlockPos.ORIGIN;
    public void propogateCheck(final int offset)
    {

            for (final Direction dir : Direction.values()) {

                BlockPos checkedPos = pos.offset(dir, offset);
                if (world.getBlockState(checkedPos).isOf(ModBlocks.CABLE_BLOCK)) {
                    if (world.getBlockEntity(checkedPos) instanceof CableTileEntity cableTile) {
                        if (cableTile.isMaster) {
                            currentMaster = checkedPos;
                            appendToMaster(pos, checkedPos, world);
                            return;
                        }
                        propogateCheck(offset + 1);
                    }
                }


            }


    }


    public void calculateConnected()
    {
        isMaster = initialCheck();
        if(!this.isMaster)
        {
            propogateCheck(1);
        }
        for(final Direction dir : Direction.values())
        {
            final BlockPos nextPosition = pos.offset(dir,1);
             if (world.getBlockState(nextPosition).isOf(ModBlocks.CABLE_BLOCK)) {
                if(world.getBlockEntity(pos) instanceof CableTileEntity tileEntity)
                {
                    if(tileEntity.isMaster && this.isMaster)
                    {
                        final int chose = random.nextInt(0,1);
                        if(chose == 1)
                        {
                            tileEntity.isMaster = false;
                        }
                        else
                        {
                            this.isMaster = false;
                        }
                    }
                }
            }
        }

    }

    public static void appendToMaster(final BlockPos appendPosition,final BlockPos masterPos,final World world)
    {
        if(world.getBlockEntity(masterPos) instanceof CableTileEntity cableTileEntity)
        {
            if(cableTileEntity.isMaster && !cableTileEntity.connectedPositions.contains(appendPosition))
            {
                cableTileEntity.connectedPositions.add(appendPosition);
            }
        }
    }

    @Override
    public boolean isRemoved() {



        return super.isRemoved();
    }

    public static void removeFromMaster(final BlockPos appendPosition,final BlockPos masterPos,final World world)
    {
        if(world.getBlockEntity(masterPos) instanceof CableTileEntity cableTileEntity)
        {
            cableTileEntity.connectedPositions.remove(appendPosition);
        }
    }
    private static final String positionsKey = "connected_positions";
    private static final String isMasterKey = "is_master";
    private static final String isEndKey = "is_end";
    private static final String currentMasterKey = "current_master";
    @Override
    protected void writeNbt(final NbtCompound nbt) {
        super.writeNbt(nbt);
        final NbtList nbtList = new NbtList();
        for(final BlockPos blockPos : connectedPositions)
        {
            nbtList.add(NbtOps.INSTANCE.createLong(blockPos.asLong()));
        }
        nbt.put(positionsKey,nbtList);
        nbt.putBoolean(isMasterKey,isMaster);
        nbt.putBoolean(isEndKey,isEnd);
        if(currentMaster != BlockPos.ORIGIN) {
            nbt.put(currentMasterKey, NbtOps.INSTANCE.createLong(currentMaster.asLong()));
        }
    }

    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
       final NbtList nbtList = (NbtList)nbt.get(positionsKey);
       for (int i = 0; i < nbtList.size(); ++i)
       {
           final NbtLong nbtLong = (NbtLong)nbtList.get(i);
           connectedPositions.add(BlockPos.fromLong(nbtLong.longValue()));
       }
       isMaster = nbt.getBoolean(isMasterKey);
       isEnd = nbt.getBoolean(isEndKey);
       currentMaster = BlockPos.fromLong(((NbtLong)nbt.get(currentMasterKey)).longValue());

    }
    /*
    public static @NotNull HashMap<CableTileEntity, ArrayList<BlockEntity>> CONNECTIONS = new HashMap<>();

    private boolean connectedToScanner;
    private boolean connectedToComp;
    private boolean connectedToRouter;


    @Override
    public boolean isRemoved() {
        super.isRemoved();
        this.markRemoved();
        ArrayList<BlockEntity> toDisconnect = CableTileEntity.CONNECTIONS.get(this);
        this.disconnectToComp();
        this.disconnectToScanner();
        this.disconnectToRouter();
        CableTileEntity.CONNECTIONS.remove(this);
        if(toDisconnect != null) {
            for (BlockEntity te : toDisconnect) {
                if (te instanceof CableTileEntity) {
                    CableTileEntity.CONNECTIONS.get(te).remove(this);
                }
            }
        }
        return false;
    }

    @Override
    protected void writeNbt(final NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putBoolean("isConnectedToComp",connectedToComp);
        nbt.putBoolean("isConnectedToScanner",connectedToScanner);
        nbt.putBoolean("isConnectedToRouter",connectedToRouter);
    }

    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
        connectedToComp = nbt.getBoolean("isConnectedToComp");
        connectedToScanner = nbt.getBoolean("isConnectedToScanner");
        connectedToRouter = nbt.getBoolean("isConnectedToRouter");
    }

    public void connectToScanner() {
        this.connectedToScanner = true;
    }
    public void disconnectToScanner() {
        this.connectedToScanner = false;
    }
    public void connectToComp() {
        this.connectedToComp = true;
    }
    public void disconnectToComp() {
        this.connectedToComp = false;
    }
    public void connectedToRouter()
    {
        this.connectedToRouter = true;
    }
    public void disconnectToRouter()
    {
        this.connectedToRouter = false;
    }
*/

}

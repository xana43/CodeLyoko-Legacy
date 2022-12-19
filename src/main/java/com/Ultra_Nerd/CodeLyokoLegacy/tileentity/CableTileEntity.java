package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.awt.geom.Area;
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
                CodeLyokoMain.LOG.info("there should be no blocks around");
                return false;
            }
        }
        return true;
    }
    private static final SecureRandom random = new SecureRandom();
    public boolean getIsMaster()
    {
        return isMaster;
    }
    public void calculateConnected()
    {
        isMaster = initialCheck();
        for(final Direction dir : Direction.values())
        {
            final BlockPos nextPosition = pos.offset(dir,1);
            if(world.getBlockState(nextPosition).isOf(ModBlocks.CABLE_BLOCK) && !connectedPositions.contains(nextPosition) &&
                    !world.getBlockEntity(nextPosition,ModTileEntities.CABLE_TILE_ENTITY_BLOCK_ENTITY_TYPE).get().isMaster && this.isMaster)
            {
                connectedPositions.add(nextPosition);
            } else if (!this.isMaster) {
                if(world.getBlockEntity(nextPosition) instanceof CableTileEntity cableTileEntity) {
                    if (cableTileEntity.isMaster) {
                        appendToMaster(pos, nextPosition, world);
                    }
                }
            } else if (world.getBlockState(nextPosition).isOf(ModBlocks.CABLE_BLOCK)) {
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
        /*for (final Direction dir : Direction.values())
        {
            final BlockPos nextPosition = pos.offset(dir,1);
            if(world != null && !world.isClient()) {
                if (!this.isMaster && world.getBlockEntity(nextPosition) != null && world.getBlockState(pos)
                        .isOf(ModBlocks.CABLE_BLOCK)) {
                    if (world.getBlockEntity(nextPosition) instanceof CableTileEntity cableTileEntity) {
                        if (cableTileEntity.isMaster) {
                            removeFromMaster(pos, nextPosition, world);
                        }
                    }
                }
            }
        }

         */
        return super.isRemoved();
    }

    public static void removeFromMaster(final BlockPos appendPosition,final BlockPos masterPos,final World world)
    {
        if(world.getBlockEntity(masterPos) instanceof CableTileEntity cableTileEntity)
        {
            if(cableTileEntity.isMaster)
            {
                cableTileEntity.connectedPositions.remove(appendPosition);
            }
        }
    }
    private static final String positionsKey = "connected_positions";
    private static final String isMasterKey = "is_master";
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

package com.Ultra_Nerd.CodeLyokoRemake15.containers;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModContainerTypes;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.TowerInterfaceTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

import java.util.Objects;

public class TowerInterfaceContainer extends Container {
    public final TowerInterfaceTileEntity TowerEntity;
    private final IWorldPosCallable canInteractWithCallable;
    public TowerInterfaceContainer(final int windowid, final PlayerInventory PInventory,final TowerInterfaceTileEntity TowerEntity)
    {
        super(ModContainerTypes.TOWER_INTERFACE_CONTAINER.get(),windowid);
        this.TowerEntity = TowerEntity;
        this.canInteractWithCallable = IWorldPosCallable.of(TowerEntity.getWorld(),TowerEntity.getPos());
    }
    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(canInteractWithCallable,playerIn, ModBlocks.TOWER_INTERFACE.get());
    }


    private static TowerInterfaceTileEntity getTowerEntity(final PlayerInventory inventory,final PacketBuffer data)
    {
        Objects.requireNonNull(inventory,"player inventory can't be null");
        Objects.requireNonNull(data,"data can't be null");
        final TileEntity tileAtPos = inventory.player.world.getTileEntity(data.readBlockPos());
        if(tileAtPos instanceof TowerInterfaceTileEntity)
        {
            return (TowerInterfaceTileEntity)tileAtPos;
        }
        else
        {
            throw new IllegalStateException("TileEntity isn't correct" + tileAtPos);
        }
    }
    public TowerInterfaceContainer(final int windowid,final PlayerInventory inven,final PacketBuffer data)
    {
        this(windowid,inven,getTowerEntity(inven,data));
    }

}
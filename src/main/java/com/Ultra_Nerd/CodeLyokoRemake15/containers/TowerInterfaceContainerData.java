package com.Ultra_Nerd.CodeLyokoRemake15.containers;

import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.TowerInterfaceTileEntity;
import net.minecraft.world.inventory.SimpleContainerData;

public class TowerInterfaceContainerData extends SimpleContainerData {
    private final TowerInterfaceTileEntity tileEntity;
    public TowerInterfaceContainerData(TowerInterfaceTileEntity be, int amount) {
        super(amount);
        this.tileEntity = be;
    }


}

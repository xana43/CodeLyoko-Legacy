package com.Ultra_Nerd.CodeLyokoRemake15.player;


import net.minecraft.nbt.INBT;
import net.minecraft.nbt.Tag;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nullable;
import java.util.concurrent.Callable;

public class PlayerHungerCapabilityStorage extends CapabilityProvider implements ICapabilitySerializable {


    protected PlayerHungerCapabilityStorage(Class baseClass) {
        super(baseClass);
    }

    @Nullable
    @Override
    public INBT writeNBT(Capability<IPlayerCapability> capability, IPlayerCapability instance, Direction side) {
        return null;
    }

    @Override
    public void readNBT(Capability<IPlayerCapability> capability, IPlayerCapability instance, Direction side, INBT nbt) {

    }

    @Override
    public Tag serializeNBT() {
        return null;
    }

    @Override
    public void deserializeNBT(Tag nbt) {

    }

    public static class CapabilityFactory implements Callable<IPlayerCapability>
    {

        @Override
        public IPlayerCapability call() throws Exception {
            return new IPlayerCapability() {};
        }
    }
}

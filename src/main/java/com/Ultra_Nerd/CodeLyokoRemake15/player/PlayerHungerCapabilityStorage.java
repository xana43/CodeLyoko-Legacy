package com.Ultra_Nerd.CodeLyokoRemake15.player;


import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;
import java.util.concurrent.Callable;

public class PlayerHungerCapabilityStorage implements Capability.IStorage<IPlayerCapability> {


    @Nullable
    @Override
    public INBT writeNBT(Capability<IPlayerCapability> capability, IPlayerCapability instance, Direction side) {
        return null;
    }

    @Override
    public void readNBT(Capability<IPlayerCapability> capability, IPlayerCapability instance, Direction side, INBT nbt) {

    }

    public static class CapabilityFactory implements Callable<IPlayerCapability>
    {

        @Override
        public IPlayerCapability call() throws Exception {
            return new IPlayerCapability() {};
        }
    }
}

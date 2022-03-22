package com.Ultra_Nerd.CodeLyokoRemake15.player;


import net.minecraft.nbt.Tag;
import net.minecraftforge.common.capabilities.CapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import java.util.concurrent.Callable;

public class PlayerHungerCapabilityStorage extends CapabilityProvider implements ICapabilitySerializable {


    protected PlayerHungerCapabilityStorage(Class baseClass) {
        super(baseClass);
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

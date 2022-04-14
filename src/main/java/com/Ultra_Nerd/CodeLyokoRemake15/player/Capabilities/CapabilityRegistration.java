package com.Ultra_Nerd.CodeLyokoRemake15.player.Capabilities;

import com.Ultra_Nerd.CodeLyokoRemake15.Util.ConstantUtil;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public final class CapabilityRegistration {

    public static final Capability<IPlayerClassCapability> CLASS_CAPABILITY = CapabilityManager.get(new CapabilityToken<>(){});


    public static void registerCaps(RegisterCapabilitiesEvent event)
    {
        event.register(IPlayerClassCapability.class);
    }

    public static void setCaps(AttachCapabilitiesEvent<Entity> event)
    {
        if(event.getObject() instanceof Player player)
        {
            event.addCapability(ConstantUtil.CAPABILITY_RESOURCE_LOCATION, new ICapabilitySerializable<CompoundTag>()
            {
                final LazyOptional<IPlayerClassCapability> instance = LazyOptional.of(()->{
                   final PlayerClassCapabilityHandler capabilityHandler = new PlayerClassCapabilityHandler();

                    return capabilityHandler;
                });

                @Override
                public CompoundTag serializeNBT() {
                    return instance.orElseThrow(NullPointerException::new).serializeNBT();
                }

                @Override
                public void deserializeNBT(final CompoundTag nbt) {
                    instance.orElseThrow(NullPointerException::new).deserializeNBT(nbt);
                }

                @NotNull
                @Override
                public <T> LazyOptional<T> getCapability(@NotNull final Capability<T> cap, @Nullable final Direction side) {
                    return CLASS_CAPABILITY.orEmpty(cap,instance.cast());
                }
            });
        }
    }




}

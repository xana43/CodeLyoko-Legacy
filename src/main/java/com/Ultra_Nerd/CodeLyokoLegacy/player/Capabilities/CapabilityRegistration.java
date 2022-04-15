package com.Ultra_Nerd.CodeLyokoLegacy.player.Capabilities;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.player.Dimension.DimensionCapabilities;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public final class CapabilityRegistration {

    public static final Capability<PlayerClassCapabilityHandler> CLASS_CAPABILITY = CapabilityManager.get(new CapabilityToken<>(){});
    public static final Capability<DimensionCapabilities> INVENTORY_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});
    private static final ResourceLocation CAPABILITY_RESOURCE_LOCATION = CodeLyokoMain.CodeLyokoPrefix("cap_class");
    private static final ResourceLocation INVENTORY_RESOURCE_LOCATION = CodeLyokoMain.CodeLyokoPrefix("cap_inventory");
    public static void registerCaps(RegisterCapabilitiesEvent event)
    {
        event.register(PlayerClassCapabilityHandler.class);
        event.register(DimensionCapabilities.class);
    }

    public static void setCaps(AttachCapabilitiesEvent<Entity> event)
    {
        if(event.getObject() instanceof Player)
        {
            event.addCapability(CAPABILITY_RESOURCE_LOCATION, new ICapabilitySerializable<CompoundTag>()
            {
                final LazyOptional<PlayerClassCapabilityHandler> instance = LazyOptional.of(PlayerClassCapabilityHandler::new);

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
                    return CLASS_CAPABILITY.orEmpty(cap,instance);
                }
            });
            event.addCapability(INVENTORY_RESOURCE_LOCATION, new ICapabilitySerializable<ListTag>() {
                final LazyOptional<DimensionCapabilities> instance = LazyOptional.of(DimensionCapabilities::new);
                @Override
                public ListTag serializeNBT() {
                    return instance.orElseThrow(NullPointerException::new).serializeNBT();
                }

                @Override
                public void deserializeNBT(final ListTag nbt) {
                    instance.orElseThrow(NullPointerException::new).deserializeNBT(nbt);
                }

                @NotNull
                @Override
                public <T> LazyOptional<T> getCapability(@NotNull final Capability<T> cap, @Nullable final Direction side) {
                    return INVENTORY_CAPABILITY.orEmpty(cap,instance);
                }





            });
        }
    }




}

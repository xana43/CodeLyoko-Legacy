package com.Ultra_Nerd.CodeLyokoLegacy.player.Capabilities;

public final class CapabilityRegistration {
/*
    public static final Capability<PlayerClassCapabilityHandler> CLASS_CAPABILITY = CapabilityManager.get(new CapabilityToken<>(){});
    public static final Capability<DimensionCapabilities> INVENTORY_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});
    public static final Capability<BlockEntityCapabilit> BLOCK_ENTITY_CAP = CapabilityManager.get(new CapabilityToken<>(){});
    private static final ResourceLocation CAPABILITY_RESOURCE_LOCATION = CodeLyokoMain.CodeLyokoPrefix("cap_class");
    private static final ResourceLocation INVENTORY_RESOURCE_LOCATION = CodeLyokoMain.CodeLyokoPrefix("cap_inventory");
    private static final ResourceLocation BLOCK_ENTITY_RESOURCE = CodeLyokoMain.CodeLyokoPrefix("cap_blockentity");
    public static void registerCaps(RegisterCapabilitiesEvent event)
    {
        event.register(PlayerClassCapabilityHandler.class);
        event.register(DimensionCapabilities.class);
        event.register(BlockEntityCapabilit.class);
    }

    public static void setLevelCap(AttachCapabilitiesEvent<Level> event)
    {
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
        event.addCapability(BLOCK_ENTITY_RESOURCE, new ICapabilitySerializable<ListTag>() {

            final LazyOptional<BlockEntityCapabilit> instance = LazyOptional.of(BlockEntityCapabilit::new);

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
                return BLOCK_ENTITY_CAP.orEmpty(cap,instance);
            }
        });
    }


    public static void setCaps(AttachCapabilitiesEvent<Entity> event)
    {
        if(event.getObject() instanceof Player)
        {
            //event.addCapability(CodeLyokoMain.CodeLyokoPrefix("cap_item"),new ItemCap());
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

        }
    }

 */




}

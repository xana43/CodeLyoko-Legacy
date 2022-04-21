package com.Ultra_Nerd.CodeLyokoLegacy.player;

//@Mod.EventBusSubscriber(modid = CodeLyokoMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class PlayerCustomAttributesBothOrigins {
/*
    @SubscribeEvent
    public static void PlayerSetup(final @NotNull EntityJoinWorldEvent event) {
      /*  if(!FMLEnvironment.production)
        {
            if(event.getEntity() instanceof Player player)
            {
                player.setUUID(UUID.nameUUIDFromBytes("test".getBytes()));
            }
        }


        CodeLyokoMain.random = 1000;
        final String nbt = "first_join";
        //TODO: create xana attack feature
        boolean XANA = false;
        if (event.getEntity() instanceof final @NotNull Player player) {

            if (player.level.isClientSide) {
                //makes it so that when the player re-enters the world default music doesn't play

                ModSounds.LAZY_HASH_MAP.forEach((levelResourceKey, musicLazy) -> {
                    //Log.debug(levelResourceKey.toString(),musicLazy.toString());
                    if (player.level.dimension() == levelResourceKey) {

                        Minecraft.getInstance().getMusicManager().startPlaying(musicLazy.get());


                    }

                });


            }


            final CompoundTag tag = event.getEntity().getPersistentData();
            CompoundTag existing;
            if (!tag.contains(Player.PERSISTED_NBT_TAG)) {
                tag.put(Player.PERSISTED_NBT_TAG, (existing = new CompoundTag()));
            } else {
                existing = tag.getCompound(Player.PERSISTED_NBT_TAG);
            }

            if (!existing.contains(nbt)) {
                existing.putBoolean(nbt, true);

                player.getInventory().add(player.getInventory().getFreeSlot(), new ItemStack(ModItems.STORY_BOOK.get(), 1));


            }






        }
    }

 @SubscribeEvent
 public static void reattachCapabilities(PlayerEvent.Clone event)
 {

            //check if the player died
            if(event.isWasDeath()) {
                //save the original capabilities from the GC
                event.getOriginal().reviveCaps();
                //blit the old capabilities to the new entity
                event.getOriginal().getCapability(CapabilityRegistration.CLASS_CAPABILITY).ifPresent(cap -> event.getPlayer().getCapability(CapabilityRegistration.CLASS_CAPABILITY).ifPresent(newcap -> {

                    //newcap.setClass(cap.getClassType());
                    CapabilityPlayerClassSync.Sync(cap.getClassType());

                }));
                //dereference the original capabilities
                event.getOriginal().invalidateCaps();
            }



 }
    @SubscribeEvent
    public static void DestroyItemEntityOnDropInLyoko(final LivingDropsEvent event)
    {
        if(DimensionCheck.EntityNotInVanillaWorld(event.getEntity()))
        {

            event.setCanceled(true);
        }
    }
    @SubscribeEvent
    public static void PreventAllDrops(final EntityEvent.EntityConstructing event)
    {
            if(DimensionCheck.EntityNotInVanillaWorld(event.getEntity())){

                if(event.getEntity() instanceof ItemEntity)
                {
                    if(!event.getEntity().level.isClientSide) {
                        event.getEntity().discard();
                    }
                }
            }
    }
    @SubscribeEvent
    public static void DTick(final @NotNull PlayerEvent.PlayerChangedDimensionEvent event)
    {
        if(event.getEntity() instanceof Player player) {

            if(player.level.isClientSide) {
                //makes it so that when the player re-enters the world default music doesn't play

                ModSounds.LAZY_HASH_MAP.forEach((levelResourceKey, musicLazy) -> {
                    //Log.debug(levelResourceKey.toString(),musicLazy.toString());
                    if (player.level.dimension() == levelResourceKey) {

                        Minecraft.getInstance().getMusicManager().startPlaying(musicLazy.get());


                    }

                });
            }
            if(!DimensionCheck.worldIsVanilla(event.getTo()))
            {
                //ListTag listTag = new ListTag();
                //player.getInventory().save(listTag);

                if(DimensionCheck.worldIsVanilla(event.getFrom()))
                {
                    event.getPlayer().level.getCapability(CapabilityRegistration.INVENTORY_CAPABILITY).ifPresent(dimensionCapabilities -> dimensionCapabilities.savePlayerInventory(player));
                }
                player.getInventory().clearContent();
                player.getCapability(CapabilityRegistration.CLASS_CAPABILITY).ifPresent(playerClassCapabilityHandler -> {


                    if(playerClassCapabilityHandler.getClassType() != PlayerClassType.Samurai)
                    {
                        player.getInventory().armor.set(EquipmentSlot.HEAD.getIndex(), new ItemStack(ModItems.BLANKHELMET.get()));
                    }

                    switch (playerClassCapabilityHandler.getClassType())
                    {
                        case Feline -> {
                            player.getInventory().armor.set(EquipmentSlot.CHEST.getIndex(),new ItemStack(ModItems.ODD_CHESTPLATE.get()));
                            player.getInventory().armor.set(EquipmentSlot.LEGS.getIndex(),new ItemStack(ModItems.ODD_LEGGINGS.get()));
                            player.getInventory().armor.set(EquipmentSlot.FEET.getIndex(),new ItemStack(ModItems.ODD_BOOTS.get()));
                            player.getInventory().setItem(player.getInventory().getFreeSlot(),new ItemStack(ModItems.LASER_ARROWSHOOTER.get()));
                        }
                        case Samurai -> {
                            player.getInventory().armor.set(EquipmentSlot.HEAD.getIndex(), new ItemStack(ModItems.ULRICH_HEADBAND.get()));
                            player.getInventory().armor.set(EquipmentSlot.CHEST.getIndex(), new ItemStack(ModItems.ULRICH_CHESTPLATE.get()));
                            player.getInventory().armor.set(EquipmentSlot.LEGS.getIndex(), new ItemStack(ModItems.ULRICH_LEGGINGS.get()));
                            player.getInventory().armor.set(EquipmentSlot.FEET.getIndex(), new ItemStack(ModItems.ULRICH_BOOTS.get()));
                            player.getInventory().setItem(player.getInventory().getFreeSlot(),new ItemStack(ModItems.DIGITAL_SABER.get()));
                        }

                    }


                });
                //CapabilityPlayerInventorySync.Sync(listTag);
            }
            else if(DimensionCheck.worldIsVanilla(event.getTo()))
            {
                //player.getInventory().clearContent();
                player.level.getCapability(CapabilityRegistration.INVENTORY_CAPABILITY).ifPresent(cap -> cap.setPlayerInventory(player));
            }
        }
    }

 */



}

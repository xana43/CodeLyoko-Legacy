package com.Ultra_Nerd.CodeLyokoLegacy.Util;

//@Mod.EventBusSubscriber(modid = CodeLyokoMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class ForgeEventSubscriber {
/*

    @SubscribeEvent
    public static void disableShiftInDigitalOcean(final @NotNull EntityMountEvent event)
    {
      if(event.getEntity() instanceof Player player)
      {
          if(player.level.dimension() == ModDimensions.DIGITAL_OCEAN)
          {

              if(player.getVehicle() instanceof EntitySkid && !player.isCreative())
              {
                  if(event.isDismounting())
                  {
                      event.setCanceled(true);
                  }
              }
          }
      }
    }

    @SubscribeEvent
    public static void explosions(final @NotNull ExplosionEvent world) {
        if (world.getWorld().dimension() == ModDimensions.FOREST || world.getWorld().dimension() == ModDimensions.SECTOR5 ||
                world.getWorld().dimension() == ModDimensions.VOLCANO || world.getWorld().dimension() == ModDimensions.DESERT ||
                world.getWorld().dimension() == ModDimensions.ICE ||
                world.getWorld().dimension() == ModDimensions.DIGITAL_OCEAN || world.getWorld().dimension() == ModDimensions.MOUNTAIN) {

            world.getExplosion().clearToBlow();

        }
    }
    @SubscribeEvent
    public static void unbreaking(final BlockEvent.@NotNull BreakEvent event)
    {
      if(DimensionCheck.playerNotInVanillaWorld(event.getPlayer()) && !event.getPlayer().isCreative())
      {
          event.setCanceled(true);
      }
    }
    @SubscribeEvent
    public static void unbreakinglevel3(final BlockEvent.@NotNull EntityPlaceEvent event)
    {
       if(DimensionCheck.EntityNotInVanillaWorld(Objects.requireNonNull(event.getEntity())))
       {
           if(event.getEntity() instanceof Player player && player.isCreative())
           {
               event.setCanceled(false);
           }
           event.setCanceled(true);
       }
    }
    @SubscribeEvent
    public static void unbreakingLevel2(final PlayerInteractEvent.@NotNull LeftClickBlock event)
    {
        if(DimensionCheck.playerNotInVanillaWorld(event.getPlayer()) && !event.getPlayer().isCreative())
        {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void preventBreakAnimation(final BlockEvent.@NotNull BlockToolModificationEvent event)
    {

            if (DimensionCheck.playerNotInVanillaWorld(event.getPlayer()) && !event.getPlayer().isCreative()) {
                event.setCanceled(true);
            }


    }

 */


}

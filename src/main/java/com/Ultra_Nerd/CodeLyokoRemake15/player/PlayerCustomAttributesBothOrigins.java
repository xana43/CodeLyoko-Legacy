package com.Ultra_Nerd.CodeLyokoRemake15.player;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.Network.Util.CapabilityPlayerInventorySync;
import com.Ultra_Nerd.CodeLyokoRemake15.Util.client.DimensionCheck;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import com.Ultra_Nerd.CodeLyokoRemake15.player.Capabilities.CapabilityRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(modid = CodeLyokoMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerCustomAttributesBothOrigins {

    @SubscribeEvent
    public static void PlayerSetup(final @NotNull EntityJoinWorldEvent event) {

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
        if(event.isWasDeath())
        {
            event.getOriginal().getCapability(CapabilityRegistration.CLASS_CAPABILITY).ifPresent(cap ->{
                event.getPlayer().getCapability(CapabilityRegistration.CLASS_CAPABILITY).ifPresent(newCap ->{
                    newCap.deserializeNBT(cap.serializeNBT());
                });
            });
            event.getOriginal().getCapability(CapabilityRegistration.INVENTORY_CAPABILITY).ifPresent(oldCap->{
                event.getPlayer().getCapability(CapabilityRegistration.INVENTORY_CAPABILITY).ifPresent(newCap ->{
                    newCap.deserializeNBT(oldCap.serializeNBT());
                });
            });
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
            if(DimensionCheck.playerNotInVanillaWorld(player))
            {
                ListTag listTag = new ListTag();
                player.getInventory().save(listTag);
                CapabilityPlayerInventorySync.Sync(listTag);
            }
        }
    }
}

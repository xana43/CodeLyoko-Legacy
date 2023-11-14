package com.Ultra_Nerd.CodeLyokoLegacy.HookEvents;

import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModTags;
import com.Ultra_Nerd.CodeLyokoLegacy.player.PlayerProfile;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;

public record EntityLoadServerEvent() {


    public static void consume(final Entity entity, final ServerWorld world) {
        if(entity instanceof final ServerPlayerEntity player)
        {
            CardinalData.PlayerSavedProfile.saveProfile(world.getServer().getSaveProperties().getMainWorldProperties(),player);
            final PlayerProfile updatedProfile =
                    CardinalData.PlayerSavedProfile.getPlayerProfile(world.getServer().getSaveProperties().getMainWorldProperties(), player);
            if(!updatedProfile.getFirstJoin()) {
                //CodeLyokoMain.LOG.info("updating first join");
                final PlayerInventory tmpInventory = player.getInventory();
                if(tmpInventory.getEmptySlot() != -1) {
                    tmpInventory.setStack(tmpInventory.getEmptySlot(), new ItemStack(ModItems.STORY_BOOK));
                }
                updatedProfile.setFirstJoin(true);
                //CodeLyokoMain.LOG.info(String.valueOf(updatedProfile.getFirstJoin()));
                CardinalData.PlayerSavedProfile.updateProfile(world.getServer().getSaveProperties().getMainWorldProperties(), updatedProfile);
            }
        }
        if (entity instanceof final ItemEntity itemEntity) {
            if (MethodUtil.DimensionCheck.isWorldLyoko(world) && !itemEntity.getStack()
                    .isIn(ModTags.ItemTags.LYOKO_ITEM)) {
                itemEntity.kill();
            }
        }
    }
}

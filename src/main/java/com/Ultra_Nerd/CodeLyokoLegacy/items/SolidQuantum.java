package com.Ultra_Nerd.CodeLyokoLegacy.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.item.ItemEvent;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

//@Mod.EventBusSubscriber(modid = CodeLyokoMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public final class SolidQuantum extends Item {
    public SolidQuantum(final @NotNull Properties properties) {
        super(properties);

    }

    @Override
    public boolean isDamageable(final ItemStack stack) {
        return false;
    }



    @SubscribeEvent
    public void ItemInvulnerable(final @NotNull ItemExpireEvent event) {
        if (event.getEntityItem().getItem().getItem() == this) {

            event.getEntityItem().setInvulnerable(true);

        }
    }

    @SubscribeEvent
    public void ItemInvulnerable2(final @NotNull ItemEvent event) {
        if (event.getEntityItem().getItem().getItem() == this) {

            event.getEntityItem().setInvulnerable(true);

        }
    }

}

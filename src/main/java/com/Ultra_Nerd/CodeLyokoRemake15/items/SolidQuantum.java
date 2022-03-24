package com.Ultra_Nerd.CodeLyokoRemake15.items;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.item.ItemEvent;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

//@Mod.EventBusSubscriber(modid = CodeLyokoMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class SolidQuantum extends Item {
    public SolidQuantum(Properties properties) {
        super(properties);

    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }



    @SubscribeEvent
    public void ItemInvulnerable(ItemExpireEvent event) {
        if (event.getEntityItem().getItem().getItem() == this) {

            event.getEntityItem().isInvulnerableTo(DamageSource.LAVA);

        }
    }

    @SubscribeEvent
    public void ItemInvulnerable2(ItemEvent event) {
        if (event.getEntityItem().getItem().getItem() == this) {

            event.getEntityItem().isInvulnerableTo(DamageSource.LAVA);

        }
    }

}

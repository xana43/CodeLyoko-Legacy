package com.Ultra_Nerd.CodeLyokoRemake15.items;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import net.minecraft.util.DamageSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.item.ItemEvent;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Base.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
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

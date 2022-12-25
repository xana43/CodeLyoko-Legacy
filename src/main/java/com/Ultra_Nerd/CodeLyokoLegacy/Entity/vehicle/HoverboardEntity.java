package com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public final class HoverboardEntity extends LyokoVehicleEntity {


    public HoverboardEntity(final EntityType<? extends LyokoVehicleEntity> entityType, final World world) {
        super(entityType, world);
        setNoGravity(true);
    }
    @Override
    public boolean handleFallDamage(final float fallDistance, final float damageMultiplier, final DamageSource damageSource) {
        return false;
    }


    @Override
    public Item asItem() {
        return ModItems.HOVERBOARD_SPAWN_ITEM;
    }
}

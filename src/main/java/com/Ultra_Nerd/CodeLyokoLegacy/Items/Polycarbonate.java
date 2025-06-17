package com.Ultra_Nerd.CodeLyokoLegacy.Items;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModItems;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.ThreadLocalRandom;
public final class Polycarbonate extends Item {
    private static final String NBT_ACCESOR = "timer";

    public Polycarbonate(@NotNull Settings properties) {
        super(properties);


    }

    @Override
    public void inventoryTick(final ItemStack stack,final ServerWorld world,final Entity entity,final @Nullable EquipmentSlot slot) {
        super.inventoryTick(stack, world, entity, slot);
        NbtCompound timerTag = stack.get(DataComponentTypes.CUSTOM_DATA).copyNbt();
        if (timerTag == null) {
            timerTag = new NbtCompound();
            timerTag.putInt(NBT_ACCESOR, ThreadLocalRandom.current().nextInt(100, 1000));
            stack.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(timerTag));
        }
        timerTag.putInt(NBT_ACCESOR, timerTag.getInt(NBT_ACCESOR).orElse(0) - 1);
        if (timerTag.getInt(NBT_ACCESOR).orElse(0) <= 0 && entity instanceof final @NotNull PlayerEntity playerEntity) {
            final ItemStack stack1 = new ItemStack(ModItems.COLD_POLYCARBONATE_CONCENTRATE);
            stack1.setCount(stack.getCount());
            playerEntity.getInventory().setStack(slot.getEntitySlotId(), stack1);

        }
        entity.damage(world,entity.getWorld().getDamageSources().inFire(), 0.2f);

    }

//new LyokoDamage("damage.polycarbonate")
}

package com.Ultra_Nerd.CodeLyokoLegacy.Items;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadLocalRandom;
public final class Polycarbonate extends Item {
    private static final String NBT_ACCESOR = "timer";

    public Polycarbonate(@NotNull Settings properties) {
        super(properties);


    }

    @Override
    public void inventoryTick(final ItemStack stack, final World world, final Entity entity, final int slot, final boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        NbtCompound timerTag = stack.getNbt();
        if (timerTag == null) {
            timerTag = new NbtCompound();
            timerTag.putInt(NBT_ACCESOR, ThreadLocalRandom.current().nextInt(100, 1000));
            stack.setNbt(timerTag);
        }
        timerTag.putInt(NBT_ACCESOR, timerTag.getInt(NBT_ACCESOR) - 1);
        if (timerTag.getInt(NBT_ACCESOR) <= 0 && entity instanceof final @NotNull PlayerEntity playerEntity) {
            final ItemStack stack1 = new ItemStack(ModItems.COLD_POLYCARBONATE_CONCENTRATE);
            stack1.setCount(stack.getCount());
            playerEntity.getInventory().setStack(slot, stack1);

        }
        if (selected) {
            entity.damage(entity.getWorld().getDamageSources().inFire(), 0.2f);
        }
    }

//new LyokoDamage("damage.polycarbonate")
}

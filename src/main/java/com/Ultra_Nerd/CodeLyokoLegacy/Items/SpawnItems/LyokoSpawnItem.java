package com.Ultra_Nerd.CodeLyokoLegacy.Items.SpawnItems;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.MethodUtil;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;

import java.util.Objects;

public final class LyokoSpawnItem extends Item {
    private final EntityType<?> entity;

    public LyokoSpawnItem(final Settings pProperties, final EntityType<?> entityType) {
        super(pProperties);
        this.entity = entityType;
    }

    @Override
    public boolean isDamageable() {
        return false;
    }


    @Override
    public ActionResult useOnBlock(final ItemUsageContext context) {
        if (MethodUtil.DimensionCheck.isPlayerInLyoko(Objects.requireNonNull(context.getPlayer()))) {
            if (!context.getWorld().isClient()) {
                entity.spawnFromItemStack((ServerWorld) context.getWorld(), context.getStack(),
                        context.getPlayer(), context.getBlockPos(), SpawnReason.SPAWN_EGG, true, false);
            }
        }
        return super.useOnBlock(context);
    }
}

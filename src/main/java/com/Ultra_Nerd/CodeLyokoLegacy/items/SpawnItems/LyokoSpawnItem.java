package com.Ultra_Nerd.CodeLyokoLegacy.items.SpawnItems;

import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;

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
        if (MethodUtil.DimensionCheck.playerNotInVanillaWorld(Objects.requireNonNull(context.getPlayer()))) {
            final MinecraftClient client = MinecraftClient.getInstance();
            final HitResult hit = client.crosshairTarget;
            BlockPos hitPosition = BlockPos.ORIGIN;
            switch (Objects.requireNonNull(hit).getType()) {
                case MISS, ENTITY -> {
                }
                case BLOCK -> {
                    final BlockHitResult blockHitResult = (BlockHitResult) hit;
                    hitPosition = blockHitResult.getBlockPos();
                }
            }
            if (!context.getWorld().isClient() && hitPosition != BlockPos.ORIGIN) {
                entity.spawnFromItemStack((ServerWorld) context.getWorld(), context.getStack(),
                        context.getPlayer(), hitPosition, SpawnReason.SPAWN_EGG, true, false);
            }
        }
        return super.useOnBlock(context);
    }
}

package com.Ultra_Nerd.CodeLyokoLegacy.util.event.server;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.Entity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public record ServerEvents() {
    public static final Event<PlaceBlockEvent> PLACE_BLOCK_EVENT = EventFactory.createArrayBacked(PlaceBlockEvent.class,
            (listeners) -> (entity, world, pos) -> {
                for (final PlaceBlockEvent placeBlockEvent : listeners) {
                    final ActionResult result = placeBlockEvent.onPlace(entity, world, pos);
                    if (result != ActionResult.PASS) {
                        return result;
                    }
                }
                return ActionResult.PASS;
            });
    @FunctionalInterface
    public interface PlaceBlockEvent {
        ActionResult onPlace(final Entity entity, final World world, final BlockPos pos);
    }
}

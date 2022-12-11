package com.Ultra_Nerd.CodeLyokoLegacy.util.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.Entity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface PlaceBlockEvent {
    Event<PlaceBlockEvent> EVENT = EventFactory.createArrayBacked(PlaceBlockEvent.class,
            (listeners) -> (entity, world, pos) -> {
                for (PlaceBlockEvent placeBlockEvent : listeners) {
                    ActionResult result = placeBlockEvent.onPlace(entity, world, pos);
                    if (result != ActionResult.PASS) {
                        return result;
                    }
                }
                return ActionResult.PASS;
            });


    ActionResult onPlace(final Entity entity, final World world, final BlockPos pos);
}

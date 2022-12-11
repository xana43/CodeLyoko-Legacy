package com.Ultra_Nerd.CodeLyokoLegacy.items.SpawnItems;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle.OverboardEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModEntities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;

public final class OverBoardItem extends Item {


    public OverBoardItem(final Settings settings) {
        super(settings);
    }


    @Override
    public ActionResult useOnBlock(final ItemUsageContext context) {
        if (!context.getWorld().isClient) {

            final OverboardEntity overboardEntity = new OverboardEntity(ModEntities.OVERBOARD, context.getWorld());
            overboardEntity.setPosition(context.getHitPos());
            context.getPlayer().getStackInHand(context.getHand()).decrement(1);
            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL;


    }
}

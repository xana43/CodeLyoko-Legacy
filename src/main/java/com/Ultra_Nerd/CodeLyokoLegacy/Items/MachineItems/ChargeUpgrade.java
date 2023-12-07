package com.Ultra_Nerd.CodeLyokoLegacy.Items.MachineItems;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

public final class ChargeUpgrade extends Item {
    private final int upgradeTier;
    public ChargeUpgrade(final Rarity rarity,final int upgradeTier) {
        super(new FabricItemSettings().rarity(rarity).maxCount(64));
        this.upgradeTier = upgradeTier;
    }

    public static int getUpgradeTierFromItem(final Item item)
    {
        return item instanceof final ChargeUpgrade chargeUpgrade ? chargeUpgrade.upgradeTier : -1;
    }


}

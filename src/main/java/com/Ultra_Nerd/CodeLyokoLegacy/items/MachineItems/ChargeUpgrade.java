package com.Ultra_Nerd.CodeLyokoLegacy.items.MachineItems;

import com.Ultra_Nerd.CodeLyokoLegacy.util.CustomLyokoRarity;
import com.Ultra_Nerd.CodeLyokoLegacy.util.enums.ChargerUpgradeTiers;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public final class ChargeUpgrade extends Item {
    private final ChargerUpgradeTiers upgradeTier;
    public ChargeUpgrade(final ChargerUpgradeTiers upgradeTier) {
        super(new FabricItemSettings().rarity(CustomLyokoRarity.SERVER_CONSUMER));
        this.upgradeTier = upgradeTier;
    }
    public static ChargerUpgradeTiers getUpgradeTierFromItem(final Item item)
    {
        if(item instanceof final ChargeUpgrade chargeUpgrade)
        {
            return chargeUpgrade.upgradeTier;
        }
        return null;
    }

}

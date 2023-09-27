package com.Ultra_Nerd.CodeLyokoLegacy.init;

import net.minecraft.advancement.criterion.Criteria;

public record ModCustomTrackedCriteria() {

    public static final ModCriteria.EnteredLyoko enteredLyoko = Criteria.register(new ModCriteria.EnteredLyoko());
    public static final ModCriteria.UseItem usedItem = Criteria.register(new ModCriteria.UseItem());
    public static void init()
    {

    }
}

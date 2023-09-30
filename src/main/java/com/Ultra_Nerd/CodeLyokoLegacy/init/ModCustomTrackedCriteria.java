package com.Ultra_Nerd.CodeLyokoLegacy.init;

import net.minecraft.advancement.criterion.Criteria;

public record ModCustomTrackedCriteria() {

    public static final ModCriteria.EnteredLyoko ENTERED_LYOKO = Criteria.register(new ModCriteria.EnteredLyoko());
    public static final ModCriteria.UseItem USED_ITEM = Criteria.register(new ModCriteria.UseItem());
    public static final ModCriteria.InvokeClassChange INVOKE_CLASS_CHANGE = Criteria.register(new ModCriteria.InvokeClassChange());
    public static void init() {}
}

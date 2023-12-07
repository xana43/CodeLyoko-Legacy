package com.Ultra_Nerd.CodeLyokoLegacy.Init.Common;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.advancement.criterion.Criterion;

public record ModCustomTrackedCriteria() {

    private static<T extends Criterion<?>> T createCriteria(final String name, T instance)
    {
        return Criteria.register(CodeLyokoMain.MOD_ID+'/'+name,instance);
    }
    public static final ModCriteria.EnteredLyoko ENTERED_LYOKO = createCriteria("entered_lyoko",new ModCriteria.EnteredLyoko());
    public static final ModCriteria.UseItem USED_ITEM = createCriteria("used_item",new ModCriteria.UseItem());
    public static final ModCriteria.InvokeClassChange INVOKE_CLASS_CHANGE = createCriteria("class_changed",new ModCriteria.InvokeClassChange());
    @SuppressWarnings("EmptyMethod")
    public static void init() {}
}

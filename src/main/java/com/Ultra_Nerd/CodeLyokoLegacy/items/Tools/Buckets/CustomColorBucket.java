package com.Ultra_Nerd.CodeLyokoLegacy.items.Tools.Buckets;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModFluids;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;

public final class CustomColorBucket extends BucketItem {
    private final int fluidColor;
    public CustomColorBucket(final Fluid fluid,final Settings settings,final int fluidColor) {
        super(fluid, settings);
        this.fluidColor =fluidColor;
    }

    public int getFluidColor(final int tintIndex) {
        return tintIndex == 1 ? fluidColor:-1;
    }
}

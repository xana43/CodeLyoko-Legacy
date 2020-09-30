package com.Ultra_Nerd.CodeLyokoRemake15.Util;

import net.minecraft.util.IntReferenceHolder;

import java.util.function.IntConsumer;
import java.util.function.IntSupplier;

public class FunctionalVariableReferenceHolder extends IntReferenceHolder {

    private final IntSupplier getter;
    private final IntConsumer setter;

    public FunctionalVariableReferenceHolder(final IntSupplier getter, final IntConsumer setter) {
        this.setter = setter;
        this.getter = getter;
    }

    @Override
    public int get() {
        return this.getter.getAsInt();
    }

    @Override
    public void set(int p_221494_1_) {
        this.setter.accept(p_221494_1_);
    }
}

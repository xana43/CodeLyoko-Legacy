package com.Ultra_Nerd.CodeLyokoLegacy.Util.Modules;

import java.util.function.Supplier;

public final class TestModule implements Module<TestModule>{

    @Override
    public Supplier<TestModule> getModule() {
        return () -> this;
    }
}

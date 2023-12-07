package com.Ultra_Nerd.CodeLyokoLegacy.Util.Modules;

import java.util.function.Supplier;

public interface Module <T>{
    Supplier<T> getModule();
    static <T> Module<T> of(final T instance){
        return () -> () -> instance;
    };

}

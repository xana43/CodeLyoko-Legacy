package com.Ultra_Nerd.CodeLyokoLegacy.Util.SuperCalculator;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import java.util.List;
import net.minecraft.util.Identifier;

public record DataPacketType<T>(Identifier id, List<T> encapsulatedData) {
    
    public static <T> DataPacketType<T> create(final String name, final List<T> data) {
        return new DataPacketType<>(CodeLyokoMain.codeLyokoPrefix(name), data);
    }

    public T getEncapsulatedData(final int index) {
        return encapsulatedData.get(index);
    }

}

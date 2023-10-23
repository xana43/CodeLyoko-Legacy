package com.Ultra_Nerd.CodeLyokoLegacy.util.SuperCalculator;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.SuperCalculatorDataPackets;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.List;

public final class DataPacketType<T> {
    private final Identifier id;
    private final List<T> encapsulatedData;

    DataPacketType(final Identifier id, final List<T> data) {
        this.id = id;
        encapsulatedData = data;
    }

    @SafeVarargs
    public static <T> DataPacketType<T> create(final String name, final T... data) {
        return new DataPacketType<>(CodeLyokoMain.codeLyokoPrefix(name), Arrays.stream(data).toList());
    }

    public Identifier getId() {
        return id;
    }

    public List<T> getEncapsulatedData() {
        return encapsulatedData;
    }

    public T getEncapsulatedData(final int index) {
        return encapsulatedData.get(index);
    }

}

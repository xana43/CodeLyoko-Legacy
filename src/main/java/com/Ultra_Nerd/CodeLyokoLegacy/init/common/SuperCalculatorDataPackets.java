package com.Ultra_Nerd.CodeLyokoLegacy.init.common;

import com.Ultra_Nerd.CodeLyokoLegacy.util.SuperCalculator.DataPacketType;
import it.unimi.dsi.fastutil.ints.IntList;

public record SuperCalculatorDataPackets() {

    
    public static final DataPacketType<Integer> NumberTest = DataPacketType.create("test", IntList.of(23));

}

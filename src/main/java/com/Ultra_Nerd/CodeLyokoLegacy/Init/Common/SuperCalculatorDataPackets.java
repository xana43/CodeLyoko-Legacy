package com.Ultra_Nerd.CodeLyokoLegacy.Init.Common;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.SuperCalculator.DataPacketType;
import it.unimi.dsi.fastutil.ints.IntList;

public record SuperCalculatorDataPackets() {

    
    public static final DataPacketType<Integer> NumberTest = DataPacketType.create("test", IntList.of(23));

}

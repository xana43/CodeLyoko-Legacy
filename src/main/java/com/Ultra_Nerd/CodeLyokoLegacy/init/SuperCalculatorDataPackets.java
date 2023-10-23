package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.util.SuperCalculator.DataPacketType;

public record SuperCalculatorDataPackets() {

    public static final DataPacketType<Integer> NumberTest = DataPacketType.create("test",23);

}

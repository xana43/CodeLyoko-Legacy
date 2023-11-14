package com.Ultra_Nerd.CodeLyokoLegacy.init.common;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids.DigitalLAVA;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids.DigitalOcean;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids.LiquidHeliumFluid;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids.UraniumWasteFluid;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public record ModFluids() {


    public static final FlowableFluid FLOWING_DIGITAL_LAVA = register("digital_lava_flowing",new DigitalLAVA.Flowing());
    public static final FlowableFluid FLOWING_DIGITAL_OCEAN = register("digital_ocean_flowing",new DigitalOcean.Flowing());
    public static final FlowableFluid FLOWING_LIQUID_HELIUM = register("flowing_liquid_helium",new LiquidHeliumFluid.Flowing());
    public static final FlowableFluid FLOWING_URANIUM = register("flowing_uranium",new UraniumWasteFluid.Flowing());
    public static final FlowableFluid STILL_DIGITAL_LAVA = register("digital_lava",new DigitalLAVA.Still());
    //fluid definition
    public static final FlowableFluid STILL_DIGITAL_OCEAN = register("digital_ocean",new DigitalOcean.Still());
    public static final FlowableFluid STILL_LIQUID_HELIUM = register("still_liquid_helium",new LiquidHeliumFluid.Still());
    public static final FlowableFluid STILL_URANIUM = register("still_uranium",new UraniumWasteFluid.Still());

    public static void registerModFluids(){}
    private static <T extends Fluid> T register(final String name,final T value)
    {
        return Registry.register(Registries.FLUID, CodeLyokoMain.codeLyokoPrefix(name),value);
    }



}

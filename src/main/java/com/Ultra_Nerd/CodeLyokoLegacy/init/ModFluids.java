package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids.DigitalLAVA;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids.DigitalOcean;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids.LiquidHeliumFluid;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids.UraniumWasteFluid;
import com.google.common.collect.ImmutableMap;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;

public record ModFluids() {


    //fluid definition
    public static final FlowableFluid STILL_DIGITAL_OCEAN = new DigitalOcean.Still();
    public static final FlowableFluid FLOWING_DIGITAL_OCEAN = new DigitalOcean.Flowing();
    public static final FlowableFluid STILL_DIGITAL_LAVA = new DigitalLAVA.Still();
    public static final FlowableFluid FLOWING_DIGITAL_LAVA = new DigitalLAVA.Flowing();
    public static final FlowableFluid STILL_URANIUM = new UraniumWasteFluid.Still();
    public static final FlowableFluid FLOWING_URANIUM = new UraniumWasteFluid.Flowing();
    public static final FlowableFluid STILL_LIQUID_HELIUM = new LiquidHeliumFluid.Still();
    public static final FlowableFluid FLOWING_LIQUID_HELIUM = new LiquidHeliumFluid.Flowing();
    public static final ImmutableMap<String, Fluid> FLUID_IMMUTABLE_MAP = ImmutableMap.<String, Fluid>builder()
            .put("digital_ocean", STILL_DIGITAL_OCEAN)
            .put("digital_ocean_flowing", FLOWING_DIGITAL_OCEAN)
            .put("digital_lava", STILL_DIGITAL_LAVA)
            .put("digital_lava_flowing", FLOWING_DIGITAL_LAVA)
            .put("still_uranium", STILL_URANIUM)
            .put("flowing_uranium", FLOWING_URANIUM)
            .put("still_liquid_helium", STILL_LIQUID_HELIUM)
            .put("flowing_liquid_helium", FLOWING_LIQUID_HELIUM)
            .build();



}

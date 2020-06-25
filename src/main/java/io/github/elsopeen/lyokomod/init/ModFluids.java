package io.github.elsopeen.lyokomod.init;

import io.github.elsopeen.lyokomod.LyokoMod;
import io.github.elsopeen.lyokomod.fluid.NumericSeaFluid;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS = new DeferredRegister(ForgeRegistries.FLUIDS, LyokoMod.MOD_ID);

    public static final RegistryObject<FlowingFluid> FLOWING_NUMERIC_SEA = FLUIDS.register("flowing_numeric_sea", NumericSeaFluid.Flowing::new);
    public static final RegistryObject<FlowingFluid> NUMERIC_SEA = FLUIDS.register("numeric_sea", NumericSeaFluid.Source::new);
}

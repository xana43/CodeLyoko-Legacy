package elsopeen.lyokomod.init;

import elsopeen.lyokomod.LyokoMod;
import elsopeen.lyokomod.fluid.NumericSeaFluid;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, LyokoMod.MOD_ID);

    public static final RegistryObject<FlowingFluid> FLOWING_NUMERIC_SEA = FLUIDS.register("flowing_numeric_sea", () -> new NumericSeaFluid.Flowing());
    public static final RegistryObject<FlowingFluid> NUMERIC_SEA = FLUIDS.register("numeric_sea", ()-> new NumericSeaFluid.Source());
}

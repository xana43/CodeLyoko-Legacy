package io.github.elsopeen.lyokomod.init;

import io.github.elsopeen.lyokomod.LyokoMod;
import io.github.elsopeen.lyokomod.world.dimension.BanquiseModDim;
import io.github.elsopeen.lyokomod.world.dimension.DesertModDim;
import io.github.elsopeen.lyokomod.world.dimension.ForestModDim;
import io.github.elsopeen.lyokomod.world.dimension.MountainModDim;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModDimensions {
    public static final DeferredRegister<ModDimension> DIMENSIONS = DeferredRegister.create(ForgeRegistries.MOD_DIMENSIONS, LyokoMod.MOD_ID);

    public static final RegistryObject<ModDimension> LYOKO_FOREST = DIMENSIONS.register("forest", ForestModDim::new);
    public static final RegistryObject<ModDimension> LYOKO_MOUNTAIN = DIMENSIONS.register("mountain", MountainModDim::new);
    public static final RegistryObject<ModDimension> LYOKO_DESERT = DIMENSIONS.register("desert", DesertModDim::new);
    public static final RegistryObject<ModDimension> LYOKO_BANQUISE = DIMENSIONS.register("banquise", BanquiseModDim::new);
}

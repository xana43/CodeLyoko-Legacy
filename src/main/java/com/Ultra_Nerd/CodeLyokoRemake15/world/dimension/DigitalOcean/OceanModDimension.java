package com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.DigitalOcean;

import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.ModDimension;

import java.util.function.BiFunction;

public class OceanModDimension extends ModDimension {

    @Override
    public BiFunction<World, DimensionType, ? extends Dimension> getFactory() {
        return OceanDimension::new;
    }

}

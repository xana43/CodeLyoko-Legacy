package io.github.elsopeen.lyokomod.world.template;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SurfaceMinus22 extends Placement<FrequencyConfig> {

    public SurfaceMinus22(Function<Dynamic<?>, ? extends FrequencyConfig> configFactoryIn) {
        super(configFactoryIn);
    }

    @Nonnull
    @Override
    public Stream<BlockPos> getPositions(@Nonnull IWorld worldIn, @Nonnull ChunkGenerator<? extends GenerationSettings> generatorIn,
                                         @Nonnull Random random, FrequencyConfig configIn, @Nonnull BlockPos pos) {
        return IntStream.range(0, configIn.count).mapToObj((p_227441_3_) -> {
            int i = random.nextInt(16) + pos.getX();
            int j = random.nextInt(16) + pos.getZ();
            int k = worldIn.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, i, j) - 22;
            return k <= 22 ? null : new BlockPos(i, random.nextInt(k), j);
        }).filter(Objects::nonNull);
    }

}

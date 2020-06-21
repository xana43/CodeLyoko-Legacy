package elsopeen.lyokomod.world.structures;

import com.google.common.math.StatsAccumulator;
import com.mojang.datafixers.Dynamic;
import elsopeen.lyokomod.init.ModStructurePieceTypes;
import elsopeen.lyokomod.init.ModStructures;
import elsopeen.lyokomod.world.structures.pieces.TowerPiece;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.ScatteredStructure;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.function.Function;

public class Tower extends ScatteredStructure<NoFeatureConfig> {

    public Tower(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
        super(configFactoryIn);
    }

    @Override
    protected int getSeedModifier() {
        return 165745296;
    }

    @Nullable
    @Override
    public BlockPos findNearest(World worldIn, ChunkGenerator<? extends GenerationSettings> chunkGenerator, BlockPos pos, int radius, boolean p_211405_5_) {
        return super.findNearest(worldIn, chunkGenerator, pos, radius, p_211405_5_);
    }

    @Override
    public IStartFactory getStartFactory() {
        return Start::new;
    }

    @Override
    public String getStructureName() {
        return ModStructures.TOWER.getId().getNamespace();
    }

    @Override
    public int getSize() {
        return 1;
    }

    public class Start extends StructureStart {

        public Start(Structure<?> structIn, int int_1, int int_2, MutableBoundingBox mutableBB, int int_3, long long_1) {
            super(structIn, int_1, int_2, mutableBB, int_3, long_1);
        }

        @Override
        public void init(ChunkGenerator<?> generator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn) {
            int worldX = chunkX * 16;
            int worldZ = chunkZ * 16;
            BlockPos blockpos = new BlockPos(worldX, 0, worldZ);
            TowerPiece.generate(generator, templateManagerIn, blockpos, this.components, rand);
            this.recalculateStructureSize();
        }


    }

}

package elsopeen.lyokomod.structures;

import com.google.common.math.StatsAccumulator;
import com.mojang.datafixers.Dynamic;
import elsopeen.lyokomod.init.ModStructurePieceTypes;
import elsopeen.lyokomod.init.ModStructures;
import elsopeen.lyokomod.structures.pieces.TowerPiece;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.WorldGenRegion;
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

    @Override // Loosely based on WorldGenFossils
    public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        //Random random = world.getChunk(pos).getRandomWithSeed(987234911L);
        Random random = world.getRandom();

        TemplateManager templatemanager = ((ServerWorld)world.getWorld()).getStructureTemplateManager();
        Template template = templatemanager.getTemplate(ModStructures.TOWER.getId());

        Rotation[] rotations = Rotation.values();
        Rotation rotation = rotations[random.nextInt(rotations.length)];

        Mirror[] mirrors = Mirror.values();
        Mirror mirror = mirrors[random.nextInt(mirrors.length+1) % mirrors.length];

        ChunkPos chunkpos = new ChunkPos(pos.add(-8, 0, -8));
        MutableBoundingBox structureboundingbox = new MutableBoundingBox(chunkpos.getXStart() + 8, 0, chunkpos.getZStart() + 8, chunkpos.getXEnd() + 8, 255, chunkpos.getZEnd() + 8);
        PlacementSettings placementsettings = (new PlacementSettings()).setMirror(mirror).setRotation(rotation).setBoundingBox(structureboundingbox).setRandom(random);

        BlockPos posSnap = chunkpos.getBlock(8, pos.getY() - 1, 8);

        BlockPos transformedSize = template.transformedSize(rotation);
        int dx = random.nextInt(17 - transformedSize.getX());
        int dz = random.nextInt(17 - transformedSize.getZ());

        BlockPos.Mutable startPos = new BlockPos.Mutable(posSnap.add(dx, 0, dz));

        if (!offsetToAverageGroundLevel(world.getWorld(), startPos, transformedSize)) {
            return false;
        }

        BlockPos placementPos = template.getZeroPositionWithTransform(startPos, mirror, rotation);
        template.addBlocksToWorld(world, placementPos, placementsettings, 20);

        return true;
    }

    private static boolean offsetToAverageGroundLevel(World world, BlockPos.Mutable startPos, BlockPos size) {
        StatsAccumulator heights = new StatsAccumulator();

        for (int dx = 0; dx < size.getX(); dx++) {
            for (int dz = 0; dz < size.getZ(); dz++) {

                int x = startPos.getX() + dx;
                int z = startPos.getZ() + dz;

                int y = world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, x, z);

                while (y >= 0) {
                    BlockState state = world.getBlockState(new BlockPos(x, y, z));
                    if (isBlockNotOk(state)) return false;
                    if (isBlockOk(state)) break;
                    y--;
                }

                if (y < 0) return false;

                heights.add(y);
            }
        }

        if (heights.populationStandardDeviation() > 2.0) {
            return false;
        }

        int baseY = (int) Math.round(heights.mean());
        int maxY = (int) heights.max();

        startPos.setY(baseY);

        return isAreaClear(world, startPos.up(maxY - baseY + 1), startPos.add(size));
    }

    private static boolean isAreaClear(IWorld world, BlockPos min, BlockPos max) {
        for (BlockPos pos : BlockPos.getAllInBoxMutable(min, max)) {
            if (!world.getBlockState(pos).getMaterial().isReplaceable()) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBlockOk(BlockState state) {
        Material material = state.getMaterial();
        return material == Material.ROCK || material == Material.EARTH || material == Material.ORGANIC || material == Material.SAND;
    }

    private static boolean isBlockNotOk(BlockState state) {
        Material material = state.getMaterial();
        return material == Material.WATER || material == Material.LAVA || state.getBlock() == Blocks.BEDROCK;
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
            this.components.add(new TowerPiece.Piece(templateManagerIn, ModStructurePieceTypes.TOWER_LOC, blockpos, Rotation.NONE, 1));
            this.recalculateStructureSize();
        }


    }

}

package elsopeen.lyokomod.world.template;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.jigsaw.IJigsawDeserializer;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.SingleJigsawPiece;
import net.minecraft.world.gen.feature.template.*;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Random;

public class LyokoSingleJigsawPiece extends SingleJigsawPiece {

    public static IJigsawDeserializer LYOKO_SINGLE_POOL_ELEMENT = IJigsawDeserializer.register("lyoko_single_pool_element", LyokoSingleJigsawPiece::new);

    public LyokoSingleJigsawPiece(String location) {
        this(location, ImmutableList.of());
    }

    public LyokoSingleJigsawPiece(String location, List<StructureProcessor> processors) {
        this(location, processors, JigsawPattern.PlacementBehaviour.RIGID);
    }

    public LyokoSingleJigsawPiece(String location, List<StructureProcessor> processors, JigsawPattern.PlacementBehaviour placementBehaviour) {
        super(location, processors, placementBehaviour);
    }

    public LyokoSingleJigsawPiece(Dynamic<?> dynamic) {
        super(dynamic);
    }



    @Override
    public boolean func_225575_a_(TemplateManager templateManager, @Nonnull IWorld world, ChunkGenerator<?> generator, @Nonnull BlockPos position, @Nonnull Rotation rotation, @Nonnull MutableBoundingBox bounds, @Nonnull Random random) {
        Template template = templateManager.getTemplateDefaulted(this.location);
        PlacementSettings placementSettings = createPlacementSettings(rotation, bounds);
        if (!template.addBlocksToWorld(world, position, placementSettings, 18)) {
            return false;
        } else {
            for(Template.BlockInfo blockInfo : Template.processBlockInfos(template, world, position, placementSettings, func_214857_a(templateManager, position, rotation, false))) {
                this.func_214846_a(world, blockInfo, position, rotation, random, bounds);
            }

            return true;
        }
    }

    @Override
    protected @Nonnull PlacementSettings createPlacementSettings(@Nonnull Rotation rotation, @Nonnull MutableBoundingBox bounds) {
        PlacementSettings placementSettings = new PlacementSettings();
        placementSettings.setBoundingBox(bounds);
        placementSettings.setRotation(rotation);
        placementSettings.func_215223_c(true);
        placementSettings.setIgnoreEntities(false);
        placementSettings.addProcessor(JigsawReplacementStructureProcessor.INSTANCE);
        placementSettings.addProcessor(Processors.STONE_REPLACEMENT_PROCESSOR);
        this.processors.forEach(placementSettings::addProcessor);
        this.getPlacementBehaviour().getStructureProcessors().forEach(placementSettings::addProcessor);
        return placementSettings;
    }

    @Override
    public @Nonnull
    IJigsawDeserializer getType() {
        return LYOKO_SINGLE_POOL_ELEMENT;
    }
}
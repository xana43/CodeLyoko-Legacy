package elsopeen.lyokomod.world.structures.pieces;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import elsopeen.lyokomod.LyokoMod;
import elsopeen.lyokomod.init.ModStructurePieceTypes;
import elsopeen.lyokomod.world.template.LyokoSingleJigsawPiece;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.JigsawPiece;
import net.minecraft.world.gen.feature.structure.AbstractVillagePiece;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.List;
import java.util.Random;

public class TowerPiece {

    public static void register() {
        JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(LyokoMod.MOD_ID, "towers"),
                new ResourceLocation("lyokomod:tower"),
                ImmutableList.of(Pair.of(new LyokoSingleJigsawPiece(LyokoMod.MOD_ID + ":tower"), 1)),
                JigsawPattern.PlacementBehaviour.RIGID));
    }

    public static void generate(ChunkGenerator<?> generator, TemplateManager templateManager, BlockPos position,
                                List<StructurePiece> pieces, SharedSeedRandom random) {
        JigsawManager.addPieces(new ResourceLocation(LyokoMod.MOD_ID, "towers"),
                7, Piece::new, generator, templateManager, position, pieces, random);
    }

    public static class Piece extends AbstractVillagePiece {

        public Piece(TemplateManager templateMgr, CompoundNBT nbt) {
            super(templateMgr,nbt, ModStructurePieceTypes.TOWER_PIECE);
        }

        public Piece(TemplateManager templateManager, JigsawPiece jigsawPiece, BlockPos blockPos, int groundLevelDelta, Rotation rotation, MutableBoundingBox mutableBoundingBox) {
            super(ModStructurePieceTypes.TOWER_PIECE, templateManager, jigsawPiece, blockPos, groundLevelDelta, rotation, mutableBoundingBox);
        }

    }
}

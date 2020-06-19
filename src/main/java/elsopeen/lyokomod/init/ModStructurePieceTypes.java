package elsopeen.lyokomod.init;

import elsopeen.lyokomod.structures.pieces.TowerPiece;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.registries.ObjectHolder;

public class ModStructurePieceTypes {

    public static final ResourceLocation TOWER_LOC = new ResourceLocation("lyokomod:tower_piece");

    public static IStructurePieceType TOWER_PIECE = null;
}

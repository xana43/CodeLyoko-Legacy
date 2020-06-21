package elsopeen.lyokomod.init;

import elsopeen.lyokomod.world.structures.pieces.TowerPiece;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;

public class ModStructurePieceTypes {

    public static final ResourceLocation TOWER_LOC = new ResourceLocation("lyokomod:tower");

    public static IStructurePieceType TOWER_PIECE = TowerPiece.Piece::new;

    public static void registerPieces() {
        TowerPiece.register();
        Registry.register(Registry.STRUCTURE_PIECE, TOWER_LOC, TOWER_PIECE);
    }
}

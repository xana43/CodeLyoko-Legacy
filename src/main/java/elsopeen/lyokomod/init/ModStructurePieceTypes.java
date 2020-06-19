package elsopeen.lyokomod.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

public class ModStructurePieceTypes {

    public static final ResourceLocation TOWER_LOC = new ResourceLocation("lyokomod:tower");

    public static IStructurePieceType TOWER_PIECE = null;

    @ObjectHolder("lyokomod:tower")
    public static Structure<NoFeatureConfig> TOWER;

}

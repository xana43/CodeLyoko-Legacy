package elsopeen.lyokomod.init;

import elsopeen.lyokomod.LyokoMod;
import elsopeen.lyokomod.tileentity.InterfaceTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

//@ObjectHolder(LyokoMod.MOD_ID)
public class ModTileEntityTypes {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, LyokoMod.MOD_ID);

    public static final RegistryObject<TileEntityType<InterfaceTileEntity>> INTERFACE = TILE_ENTITY_TYPES.register("interface", () ->
            TileEntityType.Builder.create(InterfaceTileEntity::new, ModBlocks.INTERFACE.get())
            .build(null));
}

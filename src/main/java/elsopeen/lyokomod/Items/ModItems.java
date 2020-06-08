package elsopeen.lyokomod.Items;

import elsopeen.lyokomod.LyokoMod;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    //The ITEMS deferred register in which you can register items.
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, LyokoMod.MOD_ID);

    //Register the tutorial dust with "tutorial_dust" as registry name and default properties
    public static final RegistryObject<Item> MOUNTAIN_ROCK_ITEM = ITEMS.register("mountain_rock_item", () -> new Item(new Item.Properties()));


}

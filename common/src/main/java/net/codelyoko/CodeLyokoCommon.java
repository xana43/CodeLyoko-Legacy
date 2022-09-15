package net.codelyoko;

import com.google.common.base.Suppliers;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.Registries;
import net.codelyoko.registration.BlockRegistration;
import net.codelyoko.registration.ItemRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.apache.logging.log4j.LogManager;

import java.util.function.Supplier;

public class CodeLyokoCommon {
    public static final String MOD_ID = "codelyoko";
    public static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();
    // We can use this if we don't want to use DeferredRegister
    public static final Supplier<Registries> REGISTRIES = Suppliers.memoize(() -> Registries.get(MOD_ID));
    // Registering a new creative tab
    public static final CreativeModeTab LYOKO_TAB = CreativeTabRegistry.create(new ResourceLocation(MOD_ID,
          "lyoko_tab"), () ->
        new ItemStack(ItemRegistration.BIT.get()));


    public static void init() {
        BlockRegistration.BLOCK_DEFERRED_REGISTER.register();
        ItemRegistration.ITEM_DEFERRED_REGISTER.register();


    }

}

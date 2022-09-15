package net.codelyoko.registration;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.codelyoko.CodeLyokoCommon;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.function.Supplier;

public final class ItemRegistration {
    public static final DeferredRegister<Item> ITEM_DEFERRED_REGISTER =
            DeferredRegister.create(CodeLyokoCommon.MOD_ID, Registry.ITEM_REGISTRY);
    public static final RegistrySupplier<? extends Item> BIT = registerItem("bit");


    private static RegistrySupplier<? extends Item> registerItem(final String name,final Supplier<? extends Item> supplier)
    {
        return ITEM_DEFERRED_REGISTER.register(name,supplier);
    }
    private static RegistrySupplier<? extends Item> registerItem(final String name)
    {
        return ITEM_DEFERRED_REGISTER.register(name,() -> new Item(new Item.Properties().tab(CodeLyokoCommon.LYOKO_TAB)));
    }
}

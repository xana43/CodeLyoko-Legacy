package net.codelyoko.registration;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.codelyoko.CodeLyokoCommon;
import net.minecraft.core.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

import java.util.function.Supplier;


public final class BlockRegistration {
    public static final DeferredRegister<Block> BLOCK_DEFERRED_REGISTER = DeferredRegister.create(
            CodeLyokoCommon.MOD_ID, Registry.BLOCK_REGISTRY);




    private static RegistrySupplier<? extends Block> registerItem(final String name, final Supplier<Block> propertySupplier, final Item.Properties itemProperties) {
        final RegistrySupplier<? extends Block> block = BLOCK_DEFERRED_REGISTER.register(name, propertySupplier);
        ItemRegistration.ITEM_DEFERRED_REGISTER.register(name,
                () -> new BlockItem(block.get(), itemProperties.tab(CodeLyokoCommon.LYOKO_TAB)));
        return block;
    }

    private static RegistrySupplier<? extends Block> registerItem(final String name, final Supplier<Block> propertySupplier) {
        final RegistrySupplier<? extends Block> block = BLOCK_DEFERRED_REGISTER.register(name, propertySupplier);
        ItemRegistration.ITEM_DEFERRED_REGISTER.register(name,
                () -> new BlockItem(block.get(), new Item.Properties().tab(CodeLyokoCommon.LYOKO_TAB)));
        return block;
    }
}

package net.codelyoko.registration;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.codelyoko.CodeLyokoCommon;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

public final class BlockEntityRegistration {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_DEFERRED_REGISTER = DeferredRegister.create(
            CodeLyokoCommon.MOD_ID, Registry.BLOCK_ENTITY_TYPE_REGISTRY);


    public static RegistrySupplier<BlockEntityType<?>> registerBlockEntity(final String name, final BlockEntityType.BlockEntitySupplier<?> supplier, final Block... blocks) {
        return BLOCK_ENTITY_DEFERRED_REGISTER.register(name,
                () -> BlockEntityType.Builder.of(supplier, blocks).build(null));
    }
}

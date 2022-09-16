package net.codelyoko.registration;

import com.mojang.serialization.Codec;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.codelyoko.CodeLyokoCommon;
import net.codelyoko.world.ModFeatures.structures.Tower.TowerBase;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;

import java.util.function.Supplier;

public final class StructureRegistration {
    public static final DeferredRegister<StructureType<?>> STRUCTURE_DEFERRED_REGISTER =
            DeferredRegister.create(
            CodeLyokoCommon.MOD_ID, Registry.STRUCTURE_TYPE_REGISTRY);

    public static final RegistrySupplier<StructureType<TowerBase>> TOWER = STRUCTURE_DEFERRED_REGISTER.register(
            "tower_base",() -> () -> TowerBase.CODEC);



}

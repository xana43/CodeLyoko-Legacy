package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModDamageTypes;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

/**
 * @author Ultra_Nerd
 * @desc <br/>
 * @since 2025-06-02
 */
public class DamageTypeProvider extends FabricDynamicRegistryProvider {
    public DamageTypeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup, Entries entries) {
        final RegistryWrapper.Impl<DamageType> damageTypesImpl = wrapperLookup.getWrapperOrThrow(RegistryKeys.DAMAGE_TYPE);
        Object2ObjectMaps.fastForEach(ModDamageTypes.DAMAGE_TYPE_MAP,registryKeyDamageTypeEntry -> entries.add(registryKeyDamageTypeEntry.getKey(),damageTypesImpl.getOrThrow(registryKeyDamageTypeEntry.getKey()).value()));
        ModDamageTypes.DAMAGE_TYPE_MAP.clear();
    }

    @Override
    public String getName() {
        return "";
    }
}

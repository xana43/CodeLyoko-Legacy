package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModDamageTypes;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectLists;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.DamageTypeTags;

import java.util.concurrent.CompletableFuture;

/**
 * @author Ultra_Nerd
 * @desc <br/>
 * @since 2025-06-02
 */
public class DamageTypeTagProvider extends FabricTagProvider<DamageType> {
    public DamageTypeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.DAMAGE_TYPE, registriesFuture);
    }
    private void bypassesArmor()
    {
        final ObjectList<RegistryKey<DamageType>> BYPASSES_ARMOR = ObjectLists.unmodifiable(ObjectList.of(
                        ModDamageTypes.DIGITAL_OCEAN,
                        ModDamageTypes.DIGITAL_LAVA
                )
        );
        BYPASSES_ARMOR.parallelStream().forEach(registryKey -> getOrCreateTagBuilder(DamageTypeTags.BYPASSES_ARMOR).add(registryKey).setReplace(false));
    }
    private void bypassShield(){
        final ObjectList<RegistryKey<DamageType>> BYPASSES_ARMOR = ObjectLists.unmodifiable(ObjectList.of(
                        ModDamageTypes.DIGITAL_OCEAN,
                        ModDamageTypes.DIGITAL_LAVA
                )
        );
        BYPASSES_ARMOR.parallelStream().forEach(registryKey -> getOrCreateTagBuilder(DamageTypeTags.BYPASSES_SHIELD).add(registryKey).setReplace(false));
    }
    private void bypassEffects(){
        final ObjectList<RegistryKey<DamageType>> BYPASSES_ARMOR = ObjectLists.unmodifiable(ObjectList.of(
                        ModDamageTypes.DIGITAL_OCEAN,
                        ModDamageTypes.DIGITAL_LAVA
                )
        );
        BYPASSES_ARMOR.parallelStream().forEach(registryKey -> getOrCreateTagBuilder(DamageTypeTags.BYPASSES_EFFECTS).add(registryKey).setReplace(false));
    }
    private void bypassResistance(){
        final ObjectList<RegistryKey<DamageType>> BYPASSES_ARMOR = ObjectLists.unmodifiable(ObjectList.of(
                        ModDamageTypes.DIGITAL_OCEAN,
                        ModDamageTypes.DIGITAL_LAVA
                )
        );
        BYPASSES_ARMOR.parallelStream().forEach(registryKey -> getOrCreateTagBuilder(DamageTypeTags.BYPASSES_RESISTANCE).add(registryKey).setReplace(false));
    }
    private void bypassEnchantments(){
        final ObjectList<RegistryKey<DamageType>> BYPASSES_ARMOR = ObjectLists.unmodifiable(ObjectList.of(
                        ModDamageTypes.DIGITAL_OCEAN,
                        ModDamageTypes.DIGITAL_LAVA
                )
        );
        BYPASSES_ARMOR.parallelStream().forEach(registryKey -> getOrCreateTagBuilder(DamageTypeTags.BYPASSES_ENCHANTMENTS).add(registryKey).setReplace(false));
    }
    private void isDrowning()
    {
        final ObjectList<RegistryKey<DamageType>> DROWNING = ObjectLists.unmodifiable(ObjectList.of(
                ModDamageTypes.DIGITAL_OCEAN
        ));
        DROWNING.parallelStream().forEach(registryKey -> getOrCreateTagBuilder(DamageTypeTags.IS_DROWNING).add(registryKey).setReplace(false));
    }
    private void isBurning()
    {
        final ObjectList<RegistryKey<DamageType>> BURNING =  ObjectLists.unmodifiable(ObjectList.of(
                ModDamageTypes.DIGITAL_LAVA
        ));
        BURNING.parallelStream().forEach(registryKey -> getOrCreateTagBuilder(DamageTypeTags.IS_FIRE).add(registryKey).setReplace(false));
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        bypassesArmor();
        bypassShield();
        bypassEffects();
        bypassResistance();
        bypassEnchantments();
        isDrowning();
        isBurning();

    }
}

package com.Ultra_Nerd.CodeLyokoLegacy.Items.Armor;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.CardinalData;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.ConstantUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.MethodUtil;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import team.reborn.energy.api.base.SimpleEnergyItem;

import java.security.SecureRandom;
import java.util.List;


public final class MindHelm extends ArmorItem implements SimpleEnergyItem {
    private static final int initialTimer = MethodUtil.TickConversion.secondsToTicks(60);
    private static final String stressTimer = "stress_timer";
    private static final SecureRandom random = new SecureRandom();

    public MindHelm(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }


    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type); tooltip.add(Text.translatable("tooltip.energy.mindhelm", getStoredEnergy(stack)));

    }



    @Override
    public void inventoryTick(final ItemStack stack, final World world, final Entity entity, final int slot, final boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (!world.isClient()) {
            NbtCompound Timer = stack.get(DataComponentTypes.CUSTOM_DATA).getNbt();
            if (Timer == null) {
                Timer = new NbtCompound();
                Timer.putInt(stressTimer, initialTimer);
                NbtComponent.set(DataComponentTypes.CUSTOM_DATA,stack,Timer);
            }
            Timer.putInt(stressTimer, Timer.getInt(stressTimer) - 1);
            if (Timer.getInt(stressTimer) <= 0 && entity instanceof PlayerEntity player) {
                if (slot == EquipmentSlot.HEAD.getEntitySlotId()) {
                    CodeLyokoMain.LOG.debug("cause stress damage");
                    CardinalData.MindHelmStress.increaseStress(1, player);
                    final int information = random.nextInt(0, 420);
                    if (information == 69) {
                        final int randomRecipe = random.nextInt(0, ConstantUtil.RECIPE_IDENTIFIERS.length);
                        //player.unlockRecipes(new Identifier[]{ConstantUtil.RECIPE_IDENTIFIERS[randomRecipe]});
                    }
                    final int stress = CardinalData.MindHelmStress.getStressLevel(player);
                    if (stress >= ConstantUtil.STRESS_THRESHOLD && !player.isCreative()) {
                        entity.damage(entity.getWorld().getDamageSources().magic(),
                                random.nextInt(stress >> 1, stress));
                    }
                }
                Timer.putInt(stressTimer, initialTimer);
            }
        }
    }
    @Override
    public long getEnergyCapacity(final ItemStack stack) {
        return 432000;
    }
    @Override
    public long getEnergyMaxInput(final ItemStack stack) {
        return 2000;
    }
    @Override
    public long getEnergyMaxOutput(final ItemStack stack) {
        return 0;
    }
//new DamageSource("stress").setNeutral().setUnblockable().setBypassesArmor().setBypassesProtection()
}

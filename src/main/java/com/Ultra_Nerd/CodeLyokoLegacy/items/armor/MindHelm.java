package com.Ultra_Nerd.CodeLyokoLegacy.items.armor;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import com.Ultra_Nerd.CodeLyokoLegacy.util.ConstantUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.security.SecureRandom;


public final class MindHelm extends ArmorItem {
    private static final int initialTimer = MethodUtil.TickConversion.secondsToTicks(60);
    private static final String stressTimer = "stress_timer";
    private static final SecureRandom random = new SecureRandom();
    public MindHelm(@NotNull ArmorMaterial materialIn, @NotNull EquipmentSlot slot, @NotNull Settings builder) {
        super(materialIn, slot, builder);
    }

    @Override
    public void inventoryTick(final ItemStack stack, final World world, final Entity entity, final int slot, final boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (!world.isClient()) {
            NbtCompound Timer = stack.getNbt();
            if (Timer == null) {
                Timer = new NbtCompound();
                Timer.putInt(stressTimer, initialTimer);
                stack.setNbt(Timer);
            }
            Timer.putInt(stressTimer, Timer.getInt(stressTimer) - 1);
            if (Timer.getInt(stressTimer) <= 0 && entity instanceof PlayerEntity player) {
                if (slot == EquipmentSlot.HEAD.getEntitySlotId()) {
                    CodeLyokoMain.LOG.debug("cause stress damage");
                    CardinalData.MindHelmStress.increaseStress(1, player);
                    final int information = random.nextInt(0, 420);
                    if (information == 69) {
                        final int randomRecipe = random.nextInt(0, ConstantUtil.RECIPIE_IDENTIFIERS.length);
                        player.unlockRecipes(new Identifier[]{ConstantUtil.RECIPIE_IDENTIFIERS[randomRecipe]});
                    }
                    final int stress = CardinalData.MindHelmStress.getStressLevel(player);
                    if (stress >= ConstantUtil.STRESS_THRESHHOLD && !player.isCreative()) {
                        entity.damage(new DamageSource("stress").setNeutral().setUnblockable().setBypassesArmor().setBypassesProtection(),
                                random.nextInt(stress >> 1, stress));
                    }
                }
                Timer.putInt(stressTimer, initialTimer);
            }
        }
    }

}

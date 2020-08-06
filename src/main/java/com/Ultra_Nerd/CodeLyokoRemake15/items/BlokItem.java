package com.Ultra_Nerd.CodeLyokoRemake15.items;

import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BlokItem extends SpawnEggItem {
    protected static final List<BlokItem> UNADDED = new ArrayList<BlokItem>();
    private final Lazy<? extends EntityType<?>> supplier;

    public BlokItem(final NonNullSupplier<? extends EntityType<?>> type, final int PrimaaryColor, final int Secondary, final Item.Properties properties) {
        super(null, PrimaaryColor, Secondary, properties);
        this.supplier = Lazy.of(type::get);
        UNADDED.add(this);
    }

    public BlokItem(final RegistryObject<? extends EntityType<?>> type, final int PrimaaryColor, final int Secondary, final Item.Properties properties) {
        super(null, PrimaaryColor, Secondary, properties);
        this.supplier = Lazy.of(type::get);
        UNADDED.add(this);
    }

    public static void initEgg() {
        final Map<EntityType<?>, SpawnEggItem> EGG = ObfuscationReflectionHelper.getPrivateValue(SpawnEggItem.class, null, "field_195987_b");
        DefaultDispenseItemBehavior behavior = new DefaultDispenseItemBehavior() {
            @Override
            protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
                Direction direction = source.getBlockState().get(DispenserBlock.FACING);
                EntityType<?> type = ((SpawnEggItem) stack.getItem()).getType(stack.getTag());
                type.spawn(source.getWorld(), stack, null, source.getBlockPos().offset(direction), SpawnReason.DISPENSER, direction != Direction.UP, false);
                stack.shrink(1);
                return stack;
            }

        };
        for (final SpawnEggItem egg : UNADDED) {
            EGG.put(egg.getType(null), egg);
            DispenserBlock.registerDispenseBehavior(egg, behavior);
        }
        UNADDED.clear();
    }

    @Nonnull
    @Override
    public EntityType<?> getType(@Nullable CompoundNBT p_208076_1_) {
        return this.supplier.get();
    }
}

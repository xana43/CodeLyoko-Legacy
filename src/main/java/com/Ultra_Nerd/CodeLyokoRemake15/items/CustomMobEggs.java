package com.Ultra_Nerd.CodeLyokoRemake15.items;

import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomMobEggs extends SpawnEggItem {
    protected static final List<CustomMobEggs> UNADDED = new ArrayList<CustomMobEggs>();
    private final Lazy<? extends EntityType<?>> supplier;

    public CustomMobEggs(final NonNullSupplier<? extends EntityType<?>> type, final int PrimaryColor, final int Secondary, final Item.Properties properties) {
        super(null, PrimaryColor, Secondary, properties);
        this.supplier = Lazy.of(type::get);
        UNADDED.add(this);
    }

    public CustomMobEggs(final RegistryObject<? extends EntityType<?>> type, final int PrimaryColor, final int Secondary, final Item.Properties properties) {
        super(null, PrimaryColor, Secondary, properties);
        this.supplier = Lazy.of(type::get);
        UNADDED.add(this);
    }

    public static void initEgg() {
        final Map<EntityType<?>, SpawnEggItem> EGG = ObfuscationReflectionHelper.getPrivateValue(SpawnEggItem.class, null, "field_195987_b");
        DefaultDispenseItemBehavior behavior = new DefaultDispenseItemBehavior() {

            @Override
            protected ItemStack execute(BlockSource source, ItemStack stack) {
                Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
                EntityType<?> type = ((SpawnEggItem) stack.getItem()).getType(stack.getTag());
                type.spawn(source.getLevel(), stack, null, source.getPos().offset(direction.getNormal()), MobSpawnType.DISPENSER, direction != Direction.UP, false);
                stack.shrink(1);
                return stack;
            }

        };
        for (final SpawnEggItem egg : UNADDED) {
            EGG.put(egg.getType(null), egg);
            DispenserBlock.registerBehavior(egg, behavior);
        }
        UNADDED.clear();
    }



    @Nonnull
    @Override
    public EntityType<?> getType(@Nullable CompoundTag p_208076_1_) {
        return this.supplier.get();
    }
}

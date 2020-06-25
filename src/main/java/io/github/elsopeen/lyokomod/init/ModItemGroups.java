package io.github.elsopeen.lyokomod.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

/**
 * Registering class for ItemGroups
 * as explained in Forge Docs 1.15.2
 */
public class ModItemGroups {
    public static class ModItemGroup extends ItemGroup {
        private final Supplier<ItemStack> iconSupplier;

        public ModItemGroup(final String name, final Supplier<ItemStack> iconSupplier) {
            super(name);
            this.iconSupplier = iconSupplier;
        }

        @Nonnull
        @Override
        public ItemStack createIcon() {
            return iconSupplier.get();
        }
    }

    public static final ItemGroup CODE_LYOKO_BLOCKS = new ModItemGroup("code_lyoko_blocks", () -> new ItemStack(ModItems.INTERFACE.get()));
    public static final ItemGroup CODE_LYOKO_ITEMS = new ModItemGroup("code_lyoko_items", ()-> new ItemStack(ModItems.NUMERIC_SEA_BUCKET.get()));

}

package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public final class CustomItemTags extends FabricTagProvider.ItemTagProvider {


    public CustomItemTags(final FabricDataOutput output, final CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(final RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.IRON_ORES).add(ModBlocks.BORNITE_ORE.asItem());
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS).add(ModItems.ITEM_MAP.get("lyokodisc"));
        getOrCreateTagBuilder(ItemTags.SAND).add(ModBlocks.SILICA_SAND.asItem());
        getOrCreateTagBuilder(ModTags.ItemTags.LYOKO_ITEM).add(ModItems.HOVERBOARD_SPAWN_ITEM,ModItems.OVERBOARD_SPAWN_ITEM);

    }
/*
    public CustomItemTags(DataGenerator p_126530_, BlockTagsProvider p_126531_ , @Nullable ExistingFileHelper existingFileHelper) {
        super(p_126530_, p_126531_, CodeLyokoMain.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        //super.addTags();
        tag(Tags.Items.ORES)
                .add(ModBlocks.BORNITE_ORE.get().asItem());
        tag(CustomTags.CODELYOKO_URANIUM_ORE_ITEM)
                .add(ModBlocks.BORNITE_ORE.get().asItem());
    }

 */
}

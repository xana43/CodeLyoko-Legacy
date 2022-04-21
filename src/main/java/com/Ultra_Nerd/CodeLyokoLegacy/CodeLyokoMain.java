package com.Ultra_Nerd.CodeLyokoLegacy;


import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public record CodeLyokoMain() implements ModInitializer {
    public static final String MODID = "cm";
    public static final ItemGroup LYOKO_ITEM = FabricItemGroupBuilder.build(new Identifier(MODID,"lyoko_items"),() -> new ItemStack(ModItems.BIT));
    public static final ItemGroup LYOKO_BLOCKS = FabricItemGroupBuilder.build(new Identifier(MODID,"lyoko_blocks"), () -> new ItemStack(ModBlocks.TOWER_INTERFACE));
    public CodeLyokoMain
    {
        ModBlocks.addBlocksToRegistry();
        ModItems.addItemsToRegistry();
    }
    @Override
    public void onInitialize() {
        ModBlocks.BLOCK_MAP.forEach((s, block) -> {
            Registry.register(Registry.BLOCK,new Identifier(MODID,s),block);
            Registry.register(Registry.ITEM,new Identifier(MODID,s),new BlockItem(block,new FabricItemSettings().group(LYOKO_BLOCKS)));
        });
        ModItems.ITEM_MAP.forEach((s, item) -> Registry.register(Registry.ITEM,new Identifier(MODID,s),item));

    }
}
package com.Ultra_Nerd.CodeLyokoLegacy;


import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import software.bernie.geckolib3.GeckoLib;


public record CodeLyokoMain() implements ModInitializer {
    public static final String MODID = "cm";
    public static final ItemGroup LYOKO_ITEM = FabricItemGroupBuilder.build(new Identifier(MODID,"lyoko_items"),() -> new ItemStack(ModItems.BIT));
    public static final ItemGroup LYOKO_BLOCKS = FabricItemGroupBuilder.build(new Identifier(MODID,"lyoko_blocks"), () -> new ItemStack(ModBlocks.TOWER_INTERFACE));


    public static Identifier CodeLyokoPrefix(String name)
    {
        return new Identifier(MODID,name);
    }

    public CodeLyokoMain
    {
        ModBlocks.addBlocksToRegistry();
        ModItems.addItemsToRegistry();
        ModTileEntities.registerBlockEntities();
    }
    @Override
    public void onInitialize() {
        GeckoLib.initialize();
        ModBlocks.BLOCK_MAP.forEach((s, block) -> {
            Registry.register(Registry.BLOCK,new Identifier(MODID,s),block);
            Registry.register(Registry.ITEM,new Identifier(MODID,s),new BlockItem(block,new FabricItemSettings().group(LYOKO_BLOCKS)));
        });
        ModItems.ITEM_MAP.forEach((s, item) -> Registry.register(Registry.ITEM,new Identifier(MODID,s),item));
        ModTileEntities.BLOCKENTITY_MAP.forEach((s, blockEntityType) -> Registry.register(Registry.BLOCK_ENTITY_TYPE,CodeLyokoPrefix(s),blockEntityType));
    }
}
package com.Ultra_Nerd.CodeLyokoLegacy;


import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityBlok;
import com.Ultra_Nerd.CodeLyokoLegacy.init.*;
import com.mojang.logging.LogUtils;
import dev.monarkhes.myron.api.Myron;
import dev.monarkhes.myron.impl.client.model.MyronBakedModel;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;


public record CodeLyokoMain() implements ModInitializer {
    public static final Logger LOG = LogUtils.getLogger();
    public static final String MOD_ID = "cm";
    public static final ItemGroup LYOKO_ITEM = FabricItemGroupBuilder.build(new Identifier(MOD_ID,"lyoko_items"),() -> new ItemStack(ModItems.BIT));
    public static final ItemGroup LYOKO_BLOCKS = FabricItemGroupBuilder.build(new Identifier(MOD_ID,"lyoko_blocks"), () -> new ItemStack(ModBlocks.TOWER_INTERFACE));
    public static final ItemGroup LYOKO_ARMOR = FabricItemGroupBuilder.build(CodeLyokoPrefix("lyoko_armor"), ()->new ItemStack(ModItems.WILLIAM_CHESTPLATE));

    public static Identifier CodeLyokoPrefix(String name)
    {
        return new Identifier(MOD_ID,name);
    }


    @Override
    public void onInitialize() {
        GeckoLib.initialize();

        //Registration
        ModBlocks.BLOCK_MAP.forEach((s, block) -> {

            Registry.register(Registry.BLOCK,new Identifier(MOD_ID,s),block);
            //LOG.info(String.valueOf(block));
            if(block != ModBlocks.LYOKO_CORE && block != ModBlocks.DIGITAL_OCEAN_BLOCK && block != ModBlocks.DIGITAL_LAVA_BLOCK) {
                Registry.register(Registry.ITEM, new Identifier(MOD_ID, s), new BlockItem(block, new FabricItemSettings().group(LYOKO_BLOCKS)));
            }
        });
        ModItems.ITEM_MAP.forEach((s, item) -> Registry.register(Registry.ITEM,new Identifier(MOD_ID,s),item));
        ModTileEntities.BLOCKENTITY_MAP.forEach((s, blockEntityType) -> Registry.register(Registry.BLOCK_ENTITY_TYPE,CodeLyokoPrefix(s),blockEntityType));
        ModSounds.SOUNDS.forEach(soundEvent -> Registry.register(Registry.SOUND_EVENT,soundEvent.getId(),soundEvent));
        ModBiome.BIOME_MAP.forEach((s, biome) -> Registry.register(BuiltinRegistries.BIOME,CodeLyokoPrefix(s),biome));
        ModEntities.ENTITY_TYPE_HASH_MAP.forEach((s, entityType) -> Registry.register(Registry.ENTITY_TYPE,CodeLyokoPrefix(s),entityType));
        ModFluids.FLUID_IMMUTABLE_MAP.forEach((s, fluid) ->
                Registry.register(Registry.FLUID,CodeLyokoPrefix(s),fluid));
        //Attribute Registration
        FabricDefaultAttributeRegistry.register(ModEntities.BLOK, EntityBlok.createMonsterAttributes());
        //Custom Sprites
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(CodeLyokoPrefix("block/digital_flowing"));
            registry.register(CodeLyokoPrefix("block/digital_flowing_lava"));
        });

        FluidRenderRegistry();
    }

    private static void FluidRenderRegistry()
    {
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_DIGITAL_OCEAN,ModFluids.FLOWING_DIGITAL_OCEAN,new SimpleFluidRenderHandler(CodeLyokoPrefix("block/digital_flowing"),CodeLyokoPrefix("block/digital_flowing")));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_DIGITAL_LAVA,ModFluids.FLOWING_DIGITAL_LAVA,new SimpleFluidRenderHandler(
                CodeLyokoPrefix("block/digital_flowing_lava"),
                CodeLyokoPrefix("block/digital_flowing_lava")
        ));
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),ModFluids.STILL_DIGITAL_OCEAN,ModFluids.FLOWING_DIGITAL_OCEAN);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getSolid(),ModFluids.FLOWING_DIGITAL_LAVA,ModFluids.STILL_DIGITAL_LAVA);

    }




}

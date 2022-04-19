package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables.DataProviders;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables.BlockStateSimple;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables.CustomBlockTags;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables.ItemModelGenerator;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables.LootTables;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = CodeLyokoMain.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD)
public final class Generator {

    @SubscribeEvent
    public static void genData(GatherDataEvent event)
    {
        final DataGenerator generator = event.getGenerator();
        CodeLyokoMain.Log.info("gather data");
        generator.addProvider(new LootTables(generator));
        generator.addProvider(new CustomBlockTags(generator,event.getExistingFileHelper()));
        generator.addProvider(new BlockStateSimple(generator,event.getExistingFileHelper()));
        generator.addProvider(new ItemModelGenerator(generator,event.getExistingFileHelper()));

    }

}

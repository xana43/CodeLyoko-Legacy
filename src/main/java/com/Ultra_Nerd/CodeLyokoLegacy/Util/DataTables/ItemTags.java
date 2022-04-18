package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public  final class ItemTags extends ItemTagsProvider {

    public ItemTags(DataGenerator p_126530_, BlockTagsProvider p_126531_ , @Nullable ExistingFileHelper existingFileHelper) {
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
}

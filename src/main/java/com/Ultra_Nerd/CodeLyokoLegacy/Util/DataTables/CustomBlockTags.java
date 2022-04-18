package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CustomBlockTags extends BlockTagsProvider {

    public CustomBlockTags(final DataGenerator p_126511_, @Nullable final ExistingFileHelper existingFileHelper) {
        super(p_126511_, CodeLyokoMain.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        //super.addTags();
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BORNITE_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BORNITE_ORE.get());
        tag(Tags.Blocks.ORES)
                .add(ModBlocks.BORNITE_ORE.get());
        tag(CustomTags.CODELYOKO_URANIUM_ORE)
                .add(ModBlocks.BORNITE_ORE.get());

    }

    @Override
    public @NotNull String getName() {
        return "ModBlock Tags";
    }
}

package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public final class ItemModelGenerator extends ItemModelProvider {
    public ItemModelGenerator(final DataGenerator generator,final ExistingFileHelper existingFileHelper) {
        super(generator, CodeLyokoMain.MOD_ID,existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(ModBlocks.BORNITE_ORE.get().getRegistryName().getPath(),mcLoc("cm:block/carnotite_ore"));
    }
}

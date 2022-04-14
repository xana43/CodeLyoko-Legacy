package com.Ultra_Nerd.CodeLyokoRemake15.Util.MultiBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.extensions.IForgeBlockEntity;
import org.jetbrains.annotations.Nullable;

public interface PartLogic extends IForgeBlockEntity  {
    @Nullable BlockPos getPremierePos();

    void updatePremiere(BlockPos pos, BlockState state);

    boolean isActuallyMaster(PremiereBlockLogic master);

    void assignPremiereToPart(PremiereBlockLogic premiereBlockLogic);
    void removePremiere(PremiereBlockLogic premiereBlockLogic);
}

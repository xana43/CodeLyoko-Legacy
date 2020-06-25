package io.github.elsopeen.lyokomod.blocks;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class TowerBottomResetBlock extends Block {

    public TowerBottomResetBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onEntityWalk(@Nonnull World worldIn, BlockPos pos, @Nonnull Entity entityIn) {
        Iterable<BlockPos> blockList = BlockPos.getAllInBoxMutable(pos.getX() - 7, pos.getY(), pos.getZ() - 7, pos.getX() + 7, pos.getY() + 32, pos.getZ() + 7);
        for (BlockPos blockPos : blockList) {
            if (worldIn.getBlockState(blockPos).getBlock() instanceof TowerPlatformTShapeBlock) {
                if(entityIn instanceof PlayerEntity)
                    entityIn.setPositionAndUpdate(blockPos.getX()+0.5, blockPos.getY()+1.0, blockPos.getZ()+0.5);
//                EnderTeleportEvent event = new EnderTeleportEvent((LivingEntity) entityIn, blockPos.getX(), blockPos.getY(), blockPos.getZ(), 0.0f);

            }
        }
        super.onEntityWalk(worldIn, pos, entityIn);
    }
}

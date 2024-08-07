package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Tower;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RedstoneOreBlock;
import net.minecraft.entity.Entity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public final class TowerPlatform extends Block {

    public TowerPlatform() {
        super(Settings.copy(Blocks.BEDROCK).sounds(BlockSoundGroup.GLASS).luminance(Blocks.createLightLevelFromLitBlockState(255)));
        this.setDefaultState(getDefaultState().with(RedstoneOreBlock.LIT,false));
    }

    @Override
    protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(RedstoneOreBlock.LIT));
    }
    private static void lightCircle(final World world, final BlockPos pos, final BlockState state) {
        for(final Direction dir : Direction.values()) {
            final BlockPos queriedPosition = pos.offset(dir);
            final BlockState queriedState =world.getBlockState(queriedPosition);
            if(queriedState.isOf(state.getBlock())) {

                world.setBlockState(queriedPosition,queriedState.with(RedstoneOreBlock.LIT,true));
                if(queriedState.getBlock() instanceof TowerPlatform && !queriedState.get(RedstoneOreBlock.LIT)) {
                    TowerPlatform.lightCircle(world,queriedPosition, queriedState);
                }
            }
        }
    }
    @Override
    public void onSteppedOn(final World world, final BlockPos pos, final BlockState state, final Entity entity) {
        if(!entity.bypassesSteppingEffects())
        {
            if(!state.get(RedstoneOreBlock.LIT)) {
                world.setBlockState(pos,state.with(RedstoneOreBlock.LIT,true));
                lightCircle(world, pos, state);
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }
}

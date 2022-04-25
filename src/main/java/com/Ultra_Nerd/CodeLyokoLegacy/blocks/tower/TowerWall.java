package com.Ultra_Nerd.CodeLyokoLegacy.blocks.tower;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import org.jetbrains.annotations.Nullable;


public class TowerWall extends Block {

    public static final DirectionProperty DIRTOWER = HorizontalFacingBlock.FACING;

    public TowerWall() {
        super(FabricBlockSettings.of(Material.BARRIER)
                .strength(-1, -1)
                .dropsNothing()
                .sounds(BlockSoundGroup.GLASS)
                .luminance(250)

        );

    }

    @Override
    public boolean canMobSpawnInside() {
        return false;
    }

    @Override
    protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(DIRTOWER));
    }

    @Nullable
    @Override
    public BlockState getPlacementState(final ItemPlacementContext ctx) {
        return this.getDefaultState().with(DIRTOWER,ctx.getPlayerFacing().getOpposite());
    }



    //mod compatiability




/*
    @OnlyIn(Dist.CLIENT)
    @Override
    public void animateTick(@Nonnull BlockState stateIn, @Nonnull Level worldIn, @Nonnull BlockPos pos, @Nonnull Random rand) {
        super.animateTick(stateIn, worldIn, pos, rand);
        double d0 = (double) pos.getX() + 0.5D + (rand.nextDouble() - 0.5D);
        double d1 = (double) pos.getY() + 0.5D + (rand.nextDouble() - 0.5D);
        double d2 = (double) pos.getZ() + 0.5D + (rand.nextDouble() - 0.5D);
        if (stateIn.getValue(DIRTOWER) == Direction.NORTH) {
            worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                    d0, d1, pos.getZ() + 1.25f, 0, 0, 0);

        } else if (stateIn.getValue(DIRTOWER) == Direction.SOUTH) {
            worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                    d0, d1, pos.getZ() - 0.25f, 0, 0, 0);
        } else if (stateIn.getValue(DIRTOWER) == Direction.EAST) {
            worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                    pos.getX() - 0.25f, d1, d2, 0, 0, 0);
        } else if (stateIn.getValue(DIRTOWER) == Direction.WEST) {
            worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                    pos.getX() + 1.25f, d1, d2, 0, 0, 0);
        }
    }

 */
}
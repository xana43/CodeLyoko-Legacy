package com.Ultra_Nerd.CodeLyokoLegacy.blocks.tower;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModParticles;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;


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

    @Override
    public void randomDisplayTick(final BlockState state, final World world, final BlockPos pos, final Random rand) {
        super.randomDisplayTick(state, world, pos, rand);
        final double d0 = (double) pos.getX() + 0.5D + (rand.nextDouble() - 0.5D);
        final double d1 = (double) pos.getY() + 0.5D + (rand.nextDouble() - 0.5D);
        final double d2 = (double) pos.getZ() + 0.5D + (rand.nextDouble() - 0.5D);
        switch (state.get(DIRTOWER))
        {
            case NORTH ->  world.addParticle(ModParticles.TOWER_PARTICLE,
                    d0, d1, pos.getZ() + 1.25f, 0, 0, 0);
            case SOUTH ->  world.addParticle(ModParticles.TOWER_PARTICLE,
                    d0, d1, pos.getZ() - 0.25f, 0, 0, 0);
            case EAST -> world.addParticle(ModParticles.TOWER_PARTICLE,
                    pos.getX() - 0.25f, d1, d2, 0, 0, 0);
            case WEST ->  world.addParticle(ModParticles.TOWER_PARTICLE,
                    pos.getX() + 1.25f, d1, d2, 0, 0, 0);

        }

    }


    //mod compatiability




/*
    @OnlyIn(Dist.CLIENT)
    @Override
    public void animateTick(@Nonnull BlockState stateIn, @Nonnull Level worldIn, @Nonnull BlockPos pos, @Nonnull Random rand) {
        super.animateTick(stateIn, worldIn, pos, rand);

    }

 */
}
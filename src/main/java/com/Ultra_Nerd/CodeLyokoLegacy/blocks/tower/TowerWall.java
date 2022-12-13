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
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class TowerWall extends HorizontalFacingBlock {


    public static final IntProperty CURRENT_ACTIVATION_STATE = IntProperty.of("activation", 0, 3);

    public TowerWall() {
        super(FabricBlockSettings.of(Material.BARRIER)
                .strength(-1, -1)
                .dropsNothing()
                .sounds(BlockSoundGroup.GLASS)
                .luminance(value -> 250)

        );

    }

    @Override
    public boolean canMobSpawnInside() {
        return false;
    }

    @Override
    protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(CURRENT_ACTIVATION_STATE));
    }

    @Nullable
    @Override
    public BlockState getPlacementState(final ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite())
                .with(CURRENT_ACTIVATION_STATE, 0);
    }

    @Override
    public void randomDisplayTick(final BlockState state, final World world, final BlockPos pos, final Random rand) {
        super.randomDisplayTick(state, world, pos, rand);
        final double d0 = (double) pos.getX() + 0.5D + (rand.nextDouble() - 0.5D);
        final double d1 = (double) pos.getY() + 0.5D + (rand.nextDouble() - 0.5D);
        final double d2 = (double) pos.getZ() + 0.5D + (rand.nextDouble() - 0.5D);
        switch (state.get(FACING)) {
            case NORTH -> {
                switch (state.get(CURRENT_ACTIVATION_STATE)) {
                    case 0 -> world.addParticle(ModParticles.TOWER_PARTICLE, d0, d1,
                            pos.getZ() + 1.25f, 0, 0, 0);
                    case 1 -> world.addParticle(ModParticles.TOWER_PARTICLE_XANA, d0, d1,
                            pos.getZ() + 1.25f, 0, 0, 0);
                    case 2 -> world.addParticle(ModParticles.TOWER_PARTICLE_FRANZ, d0, d1,
                            pos.getZ() + 1.25f, 0, 0, 0);
                    case 3 -> world.addParticle(ModParticles.TOWER_PARTICLE_JEREMY, d0, d1,
                            pos.getZ() + 1.25f, 0, 0, 0);
                }
            }
            case SOUTH -> {
                switch (state.get(CURRENT_ACTIVATION_STATE)) {
                    case 0 -> world.addParticle(ModParticles.TOWER_PARTICLE,
                            d0, d1, pos.getZ() - 0.25f, 0, 0, 0);
                    case 1 -> world.addParticle(ModParticles.TOWER_PARTICLE_XANA,
                            d0, d1, pos.getZ() - 0.25f, 0, 0, 0);
                    case 2 -> world.addParticle(ModParticles.TOWER_PARTICLE_FRANZ,
                            d0, d1, pos.getZ() - 0.25f, 0, 0, 0);
                    case 3 -> world.addParticle(ModParticles.TOWER_PARTICLE_JEREMY,
                            d0, d1, pos.getZ() - 0.25f, 0, 0, 0);
                }
            }
            case EAST -> {
                switch (state.get(CURRENT_ACTIVATION_STATE)) {
                    case 0 -> world.addParticle(ModParticles.TOWER_PARTICLE,
                            pos.getX() - 0.25f, d1, d2, 0, 0, 0);
                    case 1 -> world.addParticle(ModParticles.TOWER_PARTICLE_XANA,
                            pos.getX() - 0.25f, d1, d2, 0, 0, 0);
                    case 2 -> world.addParticle(ModParticles.TOWER_PARTICLE_FRANZ,
                            pos.getX() - 0.25f, d1, d2, 0, 0, 0);
                    case 3 -> world.addParticle(ModParticles.TOWER_PARTICLE_JEREMY,
                            pos.getX() - 0.25f, d1, d2, 0, 0, 0);
                }
            }
            case WEST -> {
                switch (state.get(CURRENT_ACTIVATION_STATE)) {
                    case 0 -> world.addParticle(ModParticles.TOWER_PARTICLE,
                            pos.getX() + 1.25f, d1, d2, 0, 0, 0);
                    case 1 -> world.addParticle(ModParticles.TOWER_PARTICLE_XANA,
                            pos.getX() + 1.25f, d1, d2, 0, 0, 0);
                    case 2 -> world.addParticle(ModParticles.TOWER_PARTICLE_FRANZ,
                            pos.getX() + 1.25f, d1, d2, 0, 0, 0);
                    case 3 -> world.addParticle(ModParticles.TOWER_PARTICLE_JEREMY,
                            pos.getX() + 1.25f, d1, d2, 0, 0, 0);
                }
            }

        }

    }


}
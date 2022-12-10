package com.Ultra_Nerd.CodeLyokoLegacy.blocks.tower;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModParticles;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;




public final class TowerWallCorner extends Block {


    public static final DirectionProperty DIRTOWERC = HorizontalFacingBlock.FACING;

    public TowerWallCorner() {
        super(FabricBlockSettings.of(Material.BARRIER)
                .strength(-1, -1)
                .sounds(BlockSoundGroup.GLASS)
                .luminance(11)
        );

    }


    @Override
    public boolean canMobSpawnInside() {
        return false;
    }

    @Override
    protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(DIRTOWERC));
    }

    @Nullable
    @Override
    public BlockState getPlacementState(final ItemPlacementContext ctx) {
        return this.getDefaultState().with(DIRTOWERC,ctx.getPlayerFacing().getOpposite());
    }


    @Override
    public void randomDisplayTick(final BlockState stateIn, final World worldIn, final BlockPos pos, final Random rand) {
        super.randomDisplayTick(stateIn, worldIn, pos, rand);
        double d0 = (double) pos.getX() + 0.5D + (rand.nextDouble() - 0.5D);
        double d1 = (double) pos.getY() + 0.5D + (rand.nextDouble() - 0.5D);
        double d2 = (double) pos.getZ() + 0.5D + (rand.nextDouble() - 0.5D);
        switch (stateIn.get(DIRTOWERC))
        {
            case NORTH ->{
                if(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1)).isOf(Blocks.AIR))
                {
                    worldIn.addParticle(ModParticles.TOWER_PARTICLE, d0, d1, pos.getZ() + 1.25f, 0, -1, 0);
                }
                else
                {
                    worldIn.addParticle(ModParticles.TOWER_PARTICLE, pos.getX() - 0.25f, d1, d2, 0, -1, 0);
                }
            }
            case SOUTH -> {
                if(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1)).isOf(Blocks.AIR))
                {
                    worldIn.addParticle(ModParticles.TOWER_PARTICLE, d0, d1, pos.getZ() - 0.25f, 0, -1, 0);
                }
                else
                {
                    worldIn.addParticle(ModParticles.TOWER_PARTICLE, pos.getX() + 1.25f, d1, d2, 0, -1, 0);
                }
            }
            case EAST -> {
                if (worldIn.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())).isOf(Blocks.AIR)) {
                    worldIn.addParticle(ModParticles.TOWER_PARTICLE, pos.getX() - 0.25f, d1, d2, 0, -1, 0);
                } else {
                    worldIn.addParticle(ModParticles.TOWER_PARTICLE, d0, d1, pos.getZ() - 0.25f, 0, -1, 0);
                }
            }
            case WEST -> {
                if (worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())).isOf(Blocks.AIR)) {
                    worldIn.addParticle(ModParticles.TOWER_PARTICLE,
                            pos.getX() + 1.25f, d1, d2, 0, -1, 0);
                } else {
                    worldIn.addParticle(ModParticles.TOWER_PARTICLE,
                            d0, d1, pos.getZ() + 1.25f, 0, -1, 0);
                }
            }
        }


    }





}
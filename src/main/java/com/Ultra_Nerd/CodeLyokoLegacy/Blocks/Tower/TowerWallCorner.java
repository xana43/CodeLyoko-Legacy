package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Tower;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModParticles;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;


public final class TowerWallCorner extends TowerWall {


    @Override
    public void randomDisplayTick(final BlockState stateIn, final World worldIn, final BlockPos pos, final Random rand) {
        super.randomDisplayTick(stateIn, worldIn, pos, rand);
        final double d0 = (double) pos.getX() + 0.5D + (rand.nextDouble() - 0.5D);
        final double d1 = (double) pos.getY() + 0.5D + (rand.nextDouble() - 0.5D);
        final double d2 = (double) pos.getZ() + 0.5D + (rand.nextDouble() - 0.5D);
        switch (stateIn.get(FACING)) {
            case NORTH -> {
                switch (stateIn.<Integer>get(CURRENT_ACTIVATION_STATE)) {
                    case 0 -> {
                        if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1))
                                .isOf(Blocks.AIR)) {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE, d0, d1, pos.getZ() + 1.25f, 0, -1, 0);
                        } else {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE, pos.getX() - 0.25f, d1, d2, 0, -1, 0);
                        }
                    }
                    case 1 -> {
                        if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1))
                                .isOf(Blocks.AIR)) {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE_XANA, d0, d1, pos.getZ() + 1.25f, 0, -1, 0);
                        } else {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE_XANA, pos.getX() - 0.25f, d1, d2, 0, -1, 0);
                        }
                    }
                    case 2 -> {
                        if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1))
                                .isOf(Blocks.AIR)) {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE_FRANZ, d0, d1, pos.getZ() + 1.25f, 0, -1,
                                    0);
                        } else {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE_FRANZ, pos.getX() - 0.25f, d1, d2, 0, -1,
                                    0);
                        }
                    }
                    case 3 -> {
                        if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1))
                                .isOf(Blocks.AIR)) {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE_JEREMY, d0, d1, pos.getZ() + 1.25f, 0,
                                    -1, 0);
                        } else {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE_JEREMY, pos.getX() - 0.25f, d1, d2, 0,
                                    -1, 0);
                        }
                    }
                    default -> {
                        CodeLyokoMain.LOG.error("case is:" + stateIn.get(CURRENT_ACTIVATION_STATE));
                        throw new UnsupportedOperationException("tower activation states doesn't exist");
                    }
                }
            }
            case SOUTH -> {
                switch (stateIn.<Integer>get(CURRENT_ACTIVATION_STATE)) {
                    case 0 -> {
                        if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1))
                                .isOf(Blocks.AIR)) {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE, d0, d1, pos.getZ() - 0.25f, 0, -1, 0);
                        } else {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE, pos.getX() + 1.25f, d1, d2, 0, -1, 0);
                        }
                    }
                    case 1 -> {
                        if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1))
                                .isOf(Blocks.AIR)) {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE_XANA, d0, d1, pos.getZ() - 0.25f, 0, -1, 0);
                        } else {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE_XANA, pos.getX() + 1.25f, d1, d2, 0, -1, 0);
                        }
                    }
                    case 2 -> {
                        if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1))
                                .isOf(Blocks.AIR)) {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE_FRANZ, d0, d1, pos.getZ() - 0.25f, 0, -1,
                                    0);
                        } else {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE_FRANZ, pos.getX() + 1.25f, d1, d2, 0, -1,
                                    0);
                        }
                    }
                    case 3 -> {
                        if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1))
                                .isOf(Blocks.AIR)) {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE_JEREMY, d0, d1, pos.getZ() - 0.25f, 0,
                                    -1, 0);
                        } else {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE_JEREMY, pos.getX() + 1.25f, d1, d2, 0,
                                    -1, 0);
                        }
                    }
                    default -> {
                        CodeLyokoMain.LOG.error("case is:" + stateIn.get(CURRENT_ACTIVATION_STATE));
                        throw new UnsupportedOperationException("tower activation states doesn't exist");
                    }
                }
            }
            case EAST -> {
                switch (stateIn.<Integer>get(CURRENT_ACTIVATION_STATE)) {
                    case 0 -> {
                        if (worldIn.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()))
                                .isOf(Blocks.AIR)) {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE, pos.getX() - 0.25f, d1, d2, 0, -1, 0);
                        } else {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE, d0, d1, pos.getZ() - 0.25f, 0, -1, 0);
                        }
                    }
                    case 1 -> {
                        if (worldIn.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()))
                                .isOf(Blocks.AIR)) {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE_XANA, pos.getX() - 0.25f, d1, d2, 0, -1, 0);
                        } else {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE_XANA, d0, d1, pos.getZ() - 0.25f, 0, -1, 0);
                        }
                    }
                    case 2 -> {
                        if (worldIn.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()))
                                .isOf(Blocks.AIR)) {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE_FRANZ, pos.getX() - 0.25f, d1, d2, 0, -1,
                                    0);
                        } else {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE_FRANZ, d0, d1, pos.getZ() - 0.25f, 0, -1,
                                    0);
                        }
                    }
                    case 3 -> {
                        if (worldIn.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()))
                                .isOf(Blocks.AIR)) {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE_JEREMY, pos.getX() - 0.25f, d1, d2, 0, -1,
                                    0);
                        } else {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE_JEREMY, d0, d1, pos.getZ() - 0.25f, 0, -1,
                                    0);
                        }
                    }
                    default -> {
                        CodeLyokoMain.LOG.error("case is:" + stateIn.get(CURRENT_ACTIVATION_STATE));
                        throw new UnsupportedOperationException("tower activation states doesn't exist");
                    }
                }
            }
            case WEST -> {
                switch (stateIn.<Integer>get(CURRENT_ACTIVATION_STATE)) {
                    case 0 -> {
                        if (worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()))
                                .isOf(Blocks.AIR)) {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE,
                                    pos.getX() + 1.25f, d1, d2, 0, -1, 0);
                        } else {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE,
                                    d0, d1, pos.getZ() + 1.25f, 0, -1, 0);
                        }
                    }
                    case 1 -> {
                        if (worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()))
                                .isOf(Blocks.AIR)) {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE_XANA,
                                    pos.getX() + 1.25f, d1, d2, 0, -1, 0);
                        } else {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE_XANA,
                                    d0, d1, pos.getZ() + 1.25f, 0, -1, 0);
                        }
                    }
                    case 2 -> {
                        if (worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()))
                                .isOf(Blocks.AIR)) {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE_FRANZ,
                                    pos.getX() + 1.25f, d1, d2, 0, -1, 0);
                        } else {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE_FRANZ,
                                    d0, d1, pos.getZ() + 1.25f, 0, -1, 0);
                        }
                    }
                    case 3 -> {
                        if (worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()))
                                .isOf(Blocks.AIR)) {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE_JEREMY,
                                    pos.getX() + 1.25f, d1, d2, 0, -1, 0);
                        } else {
                            worldIn.addParticle(ModParticles.TOWER_PARTICLE_JEREMY,
                                    d0, d1, pos.getZ() + 1.25f, 0, -1, 0);
                        }
                    }
                    default -> {
                        CodeLyokoMain.LOG.error("case is:" + stateIn.get(CURRENT_ACTIVATION_STATE));
                        throw new UnsupportedOperationException("tower activation states doesn't exist");
                    }
                }
            }
            default -> {
            }
        }


    }


}
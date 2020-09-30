package com.Ultra_Nerd.CodeLyokoRemake15.fluids;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModFluids;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.Item;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

public class LiquidHeliumFluid extends ForgeFlowingFluid {

    protected LiquidHeliumFluid(Properties properties) {
        super(properties);
    }

    @Nonnull
    @Override
    protected FluidAttributes createAttributes() {
        return net.minecraftforge.fluids.FluidAttributes.Water.builder(
                new ResourceLocation("cm:block/liquid_helium_still"),
                new ResourceLocation("cm:block/liquid_helium_flow"))
                .overlay(new ResourceLocation("cm:block/liquid_helium_still"))
                .translationKey("block.cm.liquid_helium_block")
                .color(0x868686).build(this);
    }

    @Override
    public boolean isEquivalentTo(Fluid fluidIn) {
        return fluidIn.equals(ModFluids.FLOWING_LIQUID_HELIUM.get()) || fluidIn.equals(ModFluids.STILL_LIQUID_HELIUM.get());
    }



    @Nonnull
    @Override
    public Fluid getFlowingFluid() {
        return ModFluids.FLOWING_LIQUID_HELIUM.get();
    }

    @Nonnull
    @Override
    public Fluid getStillFluid() {
        return ModFluids.STILL_LIQUID_HELIUM.get();
    }

    @Nonnull
    @Override
    public Item getFilledBucket() {
        return ModItems.LIQUID_HELIUM_BUCKET.get();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(@Nonnull World worldIn, @Nonnull BlockPos pos, IFluidState state, @Nonnull Random random) {
        if (!state.isSource() && !state.get(FALLING)) {
            if (random.nextInt(64) == 0) {
                worldIn.playSound((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, SoundEvents.BLOCK_WATER_AMBIENT, SoundCategory.BLOCKS, random.nextFloat() * 0.25F + 0.75F, random.nextFloat() + 0.5F, false);
            }
        } else if (random.nextInt(10) == 0) {
            worldIn.addParticle(ParticleTypes.UNDERWATER, (double) pos.getX() + (double) random.nextFloat(), (double) pos.getY() + (double) random.nextFloat(), (double) pos.getZ() + (double) random.nextFloat(), 0.0D, 0.0D, 0.0D);
        }

    }

    @Override
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public IParticleData getDripParticleData() {
        return ParticleTypes.DRIPPING_WATER;
    }

    @Override
    protected boolean canDisplace(@Nonnull IFluidState state, @Nonnull IBlockReader world, @Nonnull BlockPos pos,
                                  @Nonnull Fluid fluid, @Nonnull Direction dir) {
        return true;
    }

    @Nonnull
    @Override
    public Vec3d getFlow(@Nonnull IBlockReader blockReader, @Nonnull BlockPos pos, @Nonnull IFluidState state) {
        return super.getFlow(blockReader, pos, state);
    }

    @Override
    protected boolean canSourcesMultiply() {
        return true;
    }

    @Override
    protected void beforeReplacingBlock(IWorld worldIn, @Nonnull BlockPos pos, BlockState state) {
        TileEntity tileentity = state.getBlock().hasTileEntity(state) ? worldIn.getTileEntity(pos) : null;
        Block.spawnDrops(state, worldIn.getWorld(), pos, tileentity);
    }

    @Override
    protected int getSlopeFindDistance(@Nonnull IWorldReader worldIn) {
        return 4;
    }

    @Override
    protected int getLevelDecreasePerBlock(@Nonnull IWorldReader worldIn) {
        return 1;
    }

    @Override
    public int getTickRate(@Nonnull IWorldReader world) {
        return 5;
    }

    @Override
    protected float getExplosionResistance() {
        return 100.f;
    }

    @Override
    public float getActualHeight(@Nonnull IFluidState state, @Nonnull IBlockReader blockReader, @Nonnull BlockPos pos) {
        return super.getActualHeight(state, blockReader, pos);
    }

    @Override
    public float getHeight(@Nonnull IFluidState state) {
        return super.getHeight(state);
    }

    @Nonnull
    @Override
    protected BlockState getBlockState(@Nonnull IFluidState state) {
        return ModFluids.LIQUID_HELIUM.get().getDefaultState().with(FlowingFluidBlock.LEVEL, getLevelFromState(state));
    }

    @Override
    public boolean isSource(@Nonnull IFluidState state) {
        return false;
    }

    @Override
    public int getLevel(@Nonnull IFluidState state) {
        return getLevelFromState(state);
    }

    @Nonnull
    @Override
    public VoxelShape func_215664_b(@Nonnull IFluidState state, @Nonnull IBlockReader blockReader, @Nonnull BlockPos pos) {
        return super.func_215664_b(state, blockReader, pos);
    }

    public static class Flowing extends LiquidHeliumFluid {
        public Flowing(Properties properties) {
            super(properties);
        }

        @Nonnull
        @Override
        protected FluidAttributes createAttributes() {
            return super.createAttributes();
        }

        @Override
        protected void fillStateContainer(@Nonnull StateContainer.Builder<Fluid, IFluidState> builder) {
            super.fillStateContainer(builder);
            builder.add(LEVEL_1_8);
        }

        @Override
        public int getLevel(@Nonnull IFluidState state) {
            return state.get(LEVEL_1_8);
        }

        @Override
        public boolean isSource(@Nonnull IFluidState state) {
            return false;
        }
    }

    public static class Source extends LiquidHeliumFluid {
        public Source(Properties properties) {
            super(properties);
        }

        @Nonnull
        @Override
        protected FluidAttributes createAttributes() {
            return super.createAttributes();
        }

        @Override
        public int getLevel(@Nonnull IFluidState state) {
            return 8;
        }

        @Override
        public boolean isSource(@Nonnull IFluidState state) {
            return true;
        }
    }
}

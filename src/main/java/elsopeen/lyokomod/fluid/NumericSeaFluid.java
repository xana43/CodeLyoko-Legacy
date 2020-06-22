package elsopeen.lyokomod.fluid;

import elsopeen.lyokomod.init.ModBlocks;
import elsopeen.lyokomod.init.ModFluids;
import elsopeen.lyokomod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.*;
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

import javax.annotation.Nullable;
import java.util.Random;

public class NumericSeaFluid extends FlowingFluid {
    @Override
    protected FluidAttributes createAttributes() {
        return net.minecraftforge.fluids.FluidAttributes.Water.builder(
                new ResourceLocation("lyokomod:block/numeric_sea_still"),
                new ResourceLocation("lyokomod:block/numeric_sea_flow"))
                .overlay(new ResourceLocation("lyokomod:block/numeric_sea_overlay"))
                .translationKey("block.lyokomod.numeric_sea_block")
                .color(0x182678).build(this);
    }

    @Override
    public boolean isEquivalentTo(Fluid fluidIn) {
        return fluidIn.equals(ModFluids.FLOWING_NUMERIC_SEA.get()) || fluidIn.equals(ModFluids.NUMERIC_SEA.get());
    }

    @Override
    public Fluid getFlowingFluid() {
        return ModFluids.FLOWING_NUMERIC_SEA.get();
    }

    @Override
    public Fluid getStillFluid() {
        return ModFluids.NUMERIC_SEA.get();
    }

    @Override
    public Item getFilledBucket() {
        return ModItems.NUMERIC_SEA_BUCKET.get();
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(World worldIn, BlockPos pos, IFluidState state, Random random) {
        if (!state.isSource() && !state.get(FALLING)) {
            if (random.nextInt(64) == 0) {
                worldIn.playSound((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, SoundEvents.BLOCK_WATER_AMBIENT, SoundCategory.BLOCKS, random.nextFloat() * 0.25F + 0.75F, random.nextFloat() + 0.5F, false);
            }
        } else if (random.nextInt(10) == 0) {
            worldIn.addParticle(ParticleTypes.UNDERWATER, (double) pos.getX() + (double) random.nextFloat(), (double) pos.getY() + (double) random.nextFloat(), (double) pos.getZ() + (double) random.nextFloat(), 0.0D, 0.0D, 0.0D);
        }

    }

    @Nullable
    @OnlyIn(Dist.CLIENT)
    public IParticleData getDripParticleData() {
        return ParticleTypes.DRIPPING_WATER;
    }

    @Override
    protected boolean canDisplace(IFluidState p_215665_1_, IBlockReader p_215665_2_, BlockPos p_215665_3_, Fluid p_215665_4_, Direction p_215665_5_) {
        return false;
    }

    @Override
    public Vec3d getFlow(IBlockReader blockReader, BlockPos pos, IFluidState state) {
        return super.getFlow(blockReader, pos, state);
    }

    @Override
    protected boolean canSourcesMultiply() {
        return true;
    }

    @Override
    protected void beforeReplacingBlock(IWorld worldIn, BlockPos pos, BlockState state) {
        TileEntity tileentity = state.getBlock().hasTileEntity(state) ? worldIn.getTileEntity(pos) : null;
        Block.spawnDrops(state, worldIn.getWorld(), pos, tileentity);
    }

    @Override
    protected int getSlopeFindDistance(IWorldReader worldIn) {
        return 4;
    }

    @Override
    protected int getLevelDecreasePerBlock(IWorldReader worldIn) {
        return 1;
    }

    @Override
    public int getTickRate(IWorldReader world) {
        return 5;
    }

    @Override
    protected float getExplosionResistance() {
        return 100.f;
    }

    @Override
    public float getActualHeight(IFluidState state, IBlockReader blockReader, BlockPos pos) {
        return super.getActualHeight(state, blockReader, pos);
    }

    @Override
    public float getHeight(IFluidState state) {
        return super.getHeight(state);
    }

    @Override
    protected BlockState getBlockState(IFluidState state) {
        return ModBlocks.NUMERIC_SEA_FLUID_BLOCK.get().getDefaultState().with(FlowingFluidBlock.LEVEL, getLevelFromState(state));
    }

    @Override
    public boolean isSource(IFluidState state) {
        return false;
    }

    @Override
    public int getLevel(IFluidState state) {
        return getLevelFromState(state);
    }

    @Override
    public VoxelShape func_215664_b(IFluidState state, IBlockReader blockReader, BlockPos pos) {
        return super.func_215664_b(state, blockReader, pos);
    }

    public static class Flowing extends NumericSeaFluid {
        @Override
        protected FluidAttributes createAttributes() {
            return super.createAttributes();
        }

        protected void fillStateContainer(StateContainer.Builder<Fluid, IFluidState> builder) {
            super.fillStateContainer(builder);
            builder.add(LEVEL_1_8);
        }

        public int getLevel(IFluidState p_207192_1_) {
            return p_207192_1_.get(LEVEL_1_8);
        }

        public boolean isSource(IFluidState state) {
            return false;
        }
    }

    public static class Source extends NumericSeaFluid {
        @Override
        protected FluidAttributes createAttributes() {
            return super.createAttributes();
        }

        public int getLevel(IFluidState p_207192_1_) {
            return 8;
        }

        public boolean isSource(IFluidState state) {
            return true;
        }
    }
}

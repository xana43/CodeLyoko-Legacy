package com.Ultra_Nerd.CodeLyokoRemake15.fluids;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModFluids;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.Item;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.extensions.IForgeFluidState;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.IFluidBlock;
import org.jetbrains.annotations.NotNull;

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
    public boolean isSame(Fluid fluidIn) {
        return fluidIn.equals(ModFluids.FLOWING_LIQUID_HELIUM.get()) || fluidIn.equals(ModFluids.STILL_LIQUID_HELIUM.get();
    }

    @Override
    public Fluid getFlowing() {
        return ModFluids.FLOWING_LIQUID_HELIUM.get();
    }

    @Override
    public Item getBucket() {
         return ModItems.LIQUID_HELIUM_BUCKET.get();
    }


    @Override
    public Fluid getSource() {
        return ModFluids.STILL_LIQUID_HELIUM.get();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(@Nonnull Level worldIn, @Nonnull BlockPos pos, FluidState state, @Nonnull Random random) {
        if (!state.isSource() && !state.getValue(FALLING)) {
            if (random.nextInt(64) == 0) {
                worldIn.playSound(null, (double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, SoundEvents.WATER_AMBIENT, SoundSource.BLOCKS, random.nextFloat() * 0.25F + 0.75F, random.nextFloat() + 0.5F, false);
            }
        } else if (random.nextInt(10) == 0) {
            worldIn.addParticle(ParticleTypes.UNDERWATER, (double) pos.getX() + (double) random.nextFloat(), (double) pos.getY() + (double) random.nextFloat(), (double) pos.getZ() + (double) random.nextFloat(), 0.0D, 0.0D, 0.0D);
        }

    }


    @org.jetbrains.annotations.Nullable
    @Override
    @OnlyIn(Dist.CLIENT)
    protected ParticleOptions getDripParticle() {
        return ParticleTypes.DRIPPING_WATER;
    }



    @Override
    protected boolean canDisplace(@Nonnull FluidState state, @Nonnull LevelReader world, @Nonnull BlockPos pos,
                                  @Nonnull Fluid fluid, @Nonnull Direction dir) {
        return true;
    }


    @NotNull
    @Override
    public Vec3 getFlow(BlockGetter p_75987_, BlockPos p_75988_, FluidState p_75989_) {
        return super.getFlow(p_75987_, p_75988_, p_75989_);
    }







    @Override
    protected int getSlopeFindDistance(LevelReader worldIn) {
        return 4;
    }

    @Override
    public int getTickDelay(LevelReader level) {
        return 5;
    }


    @Override
    protected float getExplosionResistance() {
        return 100.f;
    }

    @Override
    public float getHeight(FluidState p_76050_, BlockGetter p_76051_, BlockPos p_76052_) {
        return super.getHeight(p_76050_, p_76051_, p_76052_);
    }

    @Override
    protected int getDropOff(LevelReader worldIn) {
        return 2;
    }




    @Override
    public boolean isSource(FluidState p_76140_) {
        return false;
    }



    @Override
    public VoxelShape getShape(FluidState p_76084_, BlockGetter p_76085_, BlockPos p_76086_) {
        return super.getShape(p_76084_, p_76085_, p_76086_);
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

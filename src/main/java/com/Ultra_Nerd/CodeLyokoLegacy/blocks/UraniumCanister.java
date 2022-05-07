package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModFluids;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stat;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public final class UraniumCanister extends Block {

    private static final VoxelShape shape = Block.box(3.5D, 0.0D, 3.5D, 12.0D, 15.0D, 12.0D);

    public UraniumCanister(@NotNull Settings properties) {
        super(properties);
    }


    @Override
    public VoxelShape getOutlineShape(final BlockState state, final BlockView world, final BlockPos pos, final ShapeContext context) {
        return shape;
    }

    @Override
    public void afterBreak(final World world, final PlayerEntity player, final BlockPos pos, final BlockState state, @Nullable final BlockEntity blockEntity, final ItemStack stack) {
        super.afterBreak(world, player, pos, state, blockEntity, stack);
        world.setBlockState(pos, ModBlocks.DIGITAL_OCEAN_BLOCK.getDefaultState());
    }

    @Override
    public ActionResult onUse(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final Hand hand, final BlockHitResult hit) {
        if(!player.isCreative())
        {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER,100,2,false,false,false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA,255,255,false,false,false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON,100,1,false,true,false));
        }
        return ActionResult.SUCCESS;
    }






}

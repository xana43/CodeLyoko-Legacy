package com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids.definition;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.DamageSources.LyokoDamage;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModFluids;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public final class DigitalLavaBlock extends FluidBlock {
    public DigitalLavaBlock() {
        super(ModFluids.STILL_DIGITAL_LAVA, FabricBlockSettings.copy(Blocks.LAVA));
    }

    @Override
    public void onEntityCollision(final BlockState state, final World world, final BlockPos pos, final Entity entity) {
        super.onEntityCollision(state, world, pos, entity);
        entity.damage(new LyokoDamage(this.getTranslationKey()).setBypassesArmor().setNeutral(),Float.MAX_VALUE);
    }

    @Override
    public float getAmbientOcclusionLightLevel(final BlockState state, final BlockView world, final BlockPos pos) {
        return Float.MAX_VALUE;
    }





    /*


    @Override
    public void entityInside(@Nonnull BlockState state, @Nonnull Level worldIn, @Nonnull BlockPos pos, @Nonnull Entity entityIn) {
        super.entityInside(state, worldIn, pos, entityIn);
        entityIn.setRemainingFireTicks(100);
        entityIn.hurt(new DamageSource(Objects.requireNonNull(this.getRegistryName()).toString()).bypassArmor().setIsFire(),Float.MAX_VALUE);
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter world, BlockPos pos) {
        return Blocks.LAVA.getLightEmission(state,world,pos);
    }

 */


}

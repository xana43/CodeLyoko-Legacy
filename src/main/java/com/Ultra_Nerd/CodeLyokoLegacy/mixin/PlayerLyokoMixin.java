package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class PlayerLyokoMixin {

    @Inject(method = "swingHand(Lnet/minecraft/util/Hand;)V", at = @At("HEAD"))
    public void swingSound(final CallbackInfo ci) {
        final MinecraftClient mc = MinecraftClient.getInstance();
        if (mc != null) {
            if (mc.player != null) {
                if (mc.player.getEquippedStack(EquipmentSlot.MAINHAND)
                        .getItem() == ModItems.DIGITAL_SABER && mc.options.attackKey.isPressed()) {
                    assert mc.crosshairTarget != null;
                    switch (mc.crosshairTarget.getType()) {
                        case MISS -> mc.player.playSound(ModSounds.SWORDSLASH, SoundCategory.PLAYERS,
                                mc.options.getSoundVolume(SoundCategory.PLAYERS), 1);
                        case BLOCK -> {
                            final BlockState targetedBlock =
                                    mc.player.world.getBlockState(new BlockPos(mc.crosshairTarget.getPos()));
                            if(targetedBlock.isIn(BlockTags.DIRT))
                            {

                            } else if (isFreshMetal(targetedBlock)) {
                                    
                            } else if (isGemLike(targetedBlock)) {
                                
                            }
                        }
                        case ENTITY -> {

                        }

                    }


                }
            }
        }
    }

    private static boolean isFreshMetal(final BlockState state)
    {
        return state.isOf(Blocks.IRON_BLOCK) || state.isOf(Blocks.IRON_DOOR) || state.isOf(Blocks.IRON_BARS) || state.isOf(Blocks.IRON_TRAPDOOR) || state.isOf(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE)
                || state.isOf(Blocks.GOLD_BLOCK) || state.isOf(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE) || state.isOf(Blocks.COPPER_BLOCK) || state.isOf(Blocks.CUT_COPPER) || state.isOf(Blocks.CUT_COPPER_SLAB)
                || state.isOf(Blocks.CUT_COPPER_STAIRS) || state.isOf(Blocks.EXPOSED_COPPER) || state.isOf(Blocks.EXPOSED_CUT_COPPER) || state.isOf(Blocks.EXPOSED_CUT_COPPER_SLAB) || state.isOf(Blocks.EXPOSED_CUT_COPPER_STAIRS)
                || state.isOf(Blocks.OXIDIZED_COPPER) || state.isOf(Blocks.OXIDIZED_CUT_COPPER) || state.isOf(Blocks.OXIDIZED_CUT_COPPER_SLAB) || state.isOf(Blocks.OXIDIZED_CUT_COPPER_STAIRS);
    }

    private static boolean isGemLike(final BlockState state)
    {
        return state.isIn(BlockTags.CRYSTAL_SOUND_BLOCKS) || state.isOf(Blocks.EMERALD_BLOCK) || state.isOf(Blocks.GLOWSTONE) || state.isOf(Blocks.LAPIS_BLOCK) || state.isOf(Blocks.CHISELED_QUARTZ_BLOCK)
                ||state.isOf(Blocks.QUARTZ_BLOCK) || state.isOf(Blocks.QUARTZ_BRICKS) || state.isOf(Blocks.QUARTZ_PILLAR) || state.isOf(Blocks.QUARTZ_SLAB) || state.isOf(Blocks.QUARTZ_STAIRS)
                || state.isOf(Blocks.SMOOTH_QUARTZ) || state.isOf(Blocks.SMOOTH_QUARTZ_SLAB) || state.isOf(Blocks.SMOOTH_QUARTZ_STAIRS);
    }


}

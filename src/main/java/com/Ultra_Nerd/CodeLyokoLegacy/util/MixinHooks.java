package com.Ultra_Nerd.CodeLyokoLegacy.util;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.common.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.common.ModSounds;
import com.Ultra_Nerd.CodeLyokoLegacy.util.event.Client.ClientEvents;
import com.Ultra_Nerd.CodeLyokoLegacy.util.event.server.ServerEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

public record MixinHooks() {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public static void customSplashTexts(final List<String> splashtexts)
    {
        splashtexts.add(Text.translatable("splashscreen.entry1").getString());
    }
    public static void invokeLanguageUpdate()
    {
        ClientEvents.ON_LANGUAGE_CHANGED_EVENT.invoker().languageChanged();
    }
    public static void disableStatusEffectsRenderInLyoko(
            final CallbackInfo ci)
    {

        if (mc != null) {
            if (mc.player != null) {
                if (MethodUtil.DimensionCheck.isPlayerInLyoko(mc.player)) {
                    ci.cancel();

                }
            }
        }
    }

    public record PlayerEvents()
    {
        public static void customDeathSoundInLyoko(final PlayerEntity thisPlayerEntity)
        {
            if (MethodUtil.DimensionCheck.isPlayerInLyoko(thisPlayerEntity)) {
                final World currentWorld = thisPlayerEntity.getWorld();
                final Vec3d currentPosition = thisPlayerEntity.getPos();
                currentWorld.playSound(currentPosition.x,currentPosition.y,currentPosition.z, ModSounds.DEVIRTUALIZATION, thisPlayerEntity.getSoundCategory(),0.8F, 0.8F,true);
            }
        }
        public static void cancelOnKeyPressed(final CallbackInfo ci)
        {
            if (mc.player != null) {
                if (MethodUtil.DimensionCheck.isPlayerInLyoko(mc.player)) {
                    if (mc.options.dropKey.isPressed()) {

                        ci.cancel();

                    }


                }
            }
        }
        public static void stopClickedOutOfInventoryBounds(final CallbackInfoReturnable<Boolean> cir)
        {
            if (mc.player != null) {
                if (MethodUtil.DimensionCheck.isPlayerInLyoko(mc.player) && !mc.player.isCreative()) {
                    cir.cancel();

                }
            }
        }
        public static void LyokoBlockPlacer(final World world, final BlockPos pos,@Nullable final LivingEntity placer, final CallbackInfo ci)
        {
            final ActionResult result = ServerEvents.PLACE_BLOCK_EVENT.invoker().onPlace(placer, world, pos);
            if (result == ActionResult.FAIL) {
                ci.cancel();
            }
        }

        public static void cancelPlayerEvents(final MinecraftClient client,final CallbackInfo ci)
        {
            if (client.player != null) {
                if (MethodUtil.DimensionCheck.isPlayerInLyoko(client.player)) {
                    ci.cancel();
                }
            }
        }

        public record swingCheckHook() {
            private static boolean isFreshMetal(final BlockState state) {
                return state.isOf(Blocks.IRON_BLOCK) || state.isOf(Blocks.IRON_DOOR) || state.isOf(
                        Blocks.IRON_BARS) || state.isOf(Blocks.IRON_TRAPDOOR) || state.isOf(
                        Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE)
                        || state.isOf(Blocks.GOLD_BLOCK) || state.isOf(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE) || state.isOf(
                        Blocks.COPPER_BLOCK) || state.isOf(Blocks.CUT_COPPER) || state.isOf(Blocks.CUT_COPPER_SLAB)
                        || state.isOf(Blocks.CUT_COPPER_STAIRS) || state.isOf(Blocks.EXPOSED_COPPER) || state.isOf(
                        Blocks.EXPOSED_CUT_COPPER) || state.isOf(Blocks.EXPOSED_CUT_COPPER_SLAB) || state.isOf(
                        Blocks.EXPOSED_CUT_COPPER_STAIRS)
                        || state.isOf(Blocks.OXIDIZED_COPPER) || state.isOf(Blocks.OXIDIZED_CUT_COPPER) || state.isOf(
                        Blocks.OXIDIZED_CUT_COPPER_SLAB) || state.isOf(Blocks.OXIDIZED_CUT_COPPER_STAIRS);
            }

            private static boolean isGemLike(final BlockState state) {
                return state.isIn(BlockTags.CRYSTAL_SOUND_BLOCKS) || state.isOf(Blocks.EMERALD_BLOCK) || state.isOf(
                        Blocks.GLOWSTONE) || state.isOf(Blocks.LAPIS_BLOCK) || state.isOf(Blocks.CHISELED_QUARTZ_BLOCK)
                        || state.isOf(Blocks.QUARTZ_BLOCK) || state.isOf(Blocks.QUARTZ_BRICKS) || state.isOf(
                        Blocks.QUARTZ_PILLAR) || state.isOf(Blocks.QUARTZ_SLAB) || state.isOf(Blocks.QUARTZ_STAIRS)
                        || state.isOf(Blocks.SMOOTH_QUARTZ) || state.isOf(Blocks.SMOOTH_QUARTZ_SLAB) || state.isOf(
                        Blocks.SMOOTH_QUARTZ_STAIRS);
            }

            public static void customSwingSound() {
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
                                            mc.player.getWorld()
                                                    .getBlockState(new BlockPos((int) mc.crosshairTarget.getPos().x,
                                                            (int) mc.crosshairTarget.getPos().y,
                                                            (int) mc.crosshairTarget.getPos().z));
                                    if (targetedBlock.isIn(BlockTags.DIRT)) {
                                             //TODO:implement a sound for when the sword hits a dirt-like block
                                    } else if (isFreshMetal(targetedBlock)) {
                                             //TODO:implement a sound for when the sword hits a fresh metal-like block
                                    } else if (isGemLike(targetedBlock)) {
                                             //TODO:implement a sound for when the sword hits a gem-like block
                                    }
                                }
                                case ENTITY -> {

                                }

                            }


                        }
                    }
                }
            }
        }
    }


}

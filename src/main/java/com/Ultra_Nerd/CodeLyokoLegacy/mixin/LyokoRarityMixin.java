package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.CustomLyokoRarity;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(Rarity.class)
public abstract class LyokoRarityMixin {
    @Mutable
    @Shadow
    @Final
    private static Rarity[] field_8905;

    @SuppressWarnings("InvokerTarget")
    @Invoker("<init>")
    private static Rarity codelyoko$newRarity(final String name, final int ordinal, final Formatting formatting) {
        throw new AssertionError();


    }

    @Inject(method = "<clinit>", at = @At(value = "FIELD", opcode = 179, target = "Lnet/minecraft/util/Rarity;field_8905:[Lnet/minecraft/util/Rarity;", shift = At.Shift.AFTER))
    private static void codelyoko$addNewRarity(final CallbackInfo ci) {

        final var rarities = new ObjectArrayList<>(field_8905);
        final var last = rarities.get(rarities.size() - 1);
        //define new rarities
        final var franz_starter = codelyoko$newRarity("rarity.franz_starter", last.ordinal() + 1, Formatting.AQUA);
        final var franz_novice = codelyoko$newRarity("rarity.franz_starter", last.ordinal() + 1, Formatting.GOLD);
        final var franz_hopper = codelyoko$newRarity("rarity.franz_hopper", last.ordinal() + 1, Formatting.DARK_PURPLE);
        final var common_part = codelyoko$newRarity("rarity.common_part", last.ordinal() + 1, Formatting.GRAY);
        final var server_beta = codelyoko$newRarity("rarity.server_beta", last.ordinal() + 1, Formatting.LIGHT_PURPLE);
        final var server_mature = codelyoko$newRarity("rarity.server_mature", last.ordinal() + 1, Formatting.RED);
        final var server_prosumer = codelyoko$newRarity("rarity.server_prosumer", last.ordinal() + 1, Formatting.UNDERLINE);
        final var mainframe = codelyoko$newRarity("rarity.mainframe", last.ordinal() + 1, Formatting.DARK_RED);
        final var consumer = codelyoko$newRarity("rarity.consumer", last.ordinal() + 1, Formatting.DARK_GRAY);
        final var server_consumer = codelyoko$newRarity("rarity.server_consumer", last.ordinal() + 1, Formatting.BOLD);
        final var prosumer = codelyoko$newRarity("rarity.prosumer", last.ordinal() + 1, Formatting.DARK_RED);
        final var enthusiast = codelyoko$newRarity("rarity.enthusiast", last.ordinal() + 1, Formatting.BLUE);
        final var datacenter = codelyoko$newRarity("rarity.datacenter", last.ordinal() + 1, Formatting.GREEN);
        //blit to public field
        CustomLyokoRarity.FRANZ_STARTER = franz_starter;
        CustomLyokoRarity.FRANZ_NOVICE = franz_novice;
        CustomLyokoRarity.FRANZ_HOPPER = franz_hopper;
        CustomLyokoRarity.COMMONPART = common_part;
        CustomLyokoRarity.CONSUMER = consumer;
        CustomLyokoRarity.SERVER_BETA = server_beta;
        CustomLyokoRarity.SERVER_MATURE = server_mature;
        CustomLyokoRarity.SERVER_PROSUMER = server_prosumer;
        CustomLyokoRarity.MAINFRAME = mainframe;
        CustomLyokoRarity.SERVER_CONSUMER = server_consumer;
        CustomLyokoRarity.PROSUMER = prosumer;
        CustomLyokoRarity.ENTHUSIAST = enthusiast;
        CustomLyokoRarity.DATACENTER = datacenter;
        //mix into the rarity enum class
        rarities.add(franz_starter);
        rarities.add(franz_novice);
        rarities.add(franz_hopper);
        rarities.add(common_part);
        rarities.add(server_beta);
        rarities.add(server_mature);
        rarities.add(server_prosumer);
        rarities.add(mainframe);
        rarities.add(consumer);
        rarities.add(server_prosumer);
        rarities.add(server_consumer);
        rarities.add(prosumer);
        rarities.add(enthusiast);
        rarities.add(datacenter);
        field_8905 = rarities.toArray(new Rarity[0]);
    }

}

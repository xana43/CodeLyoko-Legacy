package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

public abstract class LyokoRarityMixin {
 /*   @Mutable
    @Shadow
    @Final
    private static Rarity[] field_8905;

    @SuppressWarnings("InvokerTarget")
    private static Rarity codelyoko$newRarity(final int index, final String name,  final Formatting formatting) {
        throw new AssertionError();
    }

    @Inject(method = "<clinit>", at = @At(value = "FIELD", opcode = 179, target = "Lnet/minecraft/util/Rarity;field_8905:[Lnet/minecraft/util/Rarity;", shift = At.Shift.AFTER))
    private static void codelyoko$addNewRarity(final CallbackInfo ci) {

        final var rarities = new ObjectArrayList<>(field_8905);
        final var last = rarities.get(rarities.size() - 1);
        //define new rarities
        final var franz_starter = codelyoko$newRarity(last.ordinal() + 1,"rarity.franz_starter", Formatting.AQUA);
        final var franz_novice = codelyoko$newRarity(last.ordinal() + 1,"rarity.franz_starter", Formatting.GOLD);
        final var franz_hopper = codelyoko$newRarity(last.ordinal() + 1, "rarity.franz_hopper", Formatting.DARK_PURPLE);
        final var common_part = codelyoko$newRarity(last.ordinal() + 1,"rarity.common_part",  Formatting.GRAY);
        final var server_beta = codelyoko$newRarity(last.ordinal() + 1,"rarity.server_beta", Formatting.LIGHT_PURPLE);
        final var server_mature = codelyoko$newRarity(last.ordinal() + 1,"rarity.server_mature", Formatting.RED);
        final var server_prosumer = codelyoko$newRarity(last.ordinal() + 1,"rarity.server_prosumer", Formatting.UNDERLINE);
        final var mainframe = codelyoko$newRarity(last.ordinal() + 1,"rarity.mainframe", Formatting.DARK_RED);
        final var consumer = codelyoko$newRarity(last.ordinal() + 1,"rarity.consumer", Formatting.DARK_GRAY);
        final var server_consumer = codelyoko$newRarity(last.ordinal() + 1,"rarity.server_consumer", Formatting.BOLD);
        final var prosumer = codelyoko$newRarity(last.ordinal() + 1, "rarity.prosumer", Formatting.DARK_RED);
        final var enthusiast = codelyoko$newRarity(last.ordinal() + 1,"rarity.enthusiast", Formatting.BLUE);
        final var datacenter = codelyoko$newRarity(last.ordinal() + 1, "rarity.datacenter", Formatting.GREEN);
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
*/
}

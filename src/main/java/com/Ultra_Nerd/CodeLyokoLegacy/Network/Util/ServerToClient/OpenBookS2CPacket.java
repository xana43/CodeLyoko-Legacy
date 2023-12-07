package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ServerToClient;

import com.Ultra_Nerd.CodeLyokoLegacy.Screens.ClientScreens.StoryBookGUI;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.ConstantUtil;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.BookScreen;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;

public record OpenBookS2CPacket() {


    public static void receive(final MinecraftClient client, final ClientPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender responseSender) {
        final int entryIndex = buf.getInt(0);
        client.execute(() -> {
            final BookScreen.Contents testedLanguage = testLocale(client.getLanguageManager().getLanguage(),client.player,entryIndex);
            client.setScreen(new StoryBookGUI(testedLanguage));
        });
    }
    private static BookScreen.Contents testLocale(final String locale, final ClientPlayerEntity player, final int entryIndex)
    {
        return switch (locale)
        {
            case "en_us" -> ConstantUtil.StoryEntry.ENTRY_LIST_EN_US.values()[entryIndex].getEntries();
            case "fr_fr" -> ConstantUtil.StoryEntry.ENTRY_LIST_FR_FR.values()[entryIndex].getEntries();
            case "zh_cn" -> ConstantUtil.StoryEntry.ENTRY_LIST_ZH_CN.values()[entryIndex].getEntries();
            default -> {
                player.sendMessage(Text.literal("no translation present for this language"));
                throw new IllegalArgumentException("no translation present for language:"+locale);
            }
        };
    }
}

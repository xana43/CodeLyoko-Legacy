package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ServerToClient;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.items.EntryPool;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.ClientScreens.StoryBookGUI;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Text;

public record OpenBookS2CPacket() {


    public static void receive(final MinecraftClient client, final ClientPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender responseSender) {
        final int entryIndex = buf.readInt();
        client.execute(() -> {
            final StringVisitable[] testedLanguage = testLocale(client.getLanguageManager().getLanguage(),client.player,
                    EntryPool.getEntriesEnUs().get(entryIndex),
                    EntryPool.getEntriesFrFr().get(entryIndex));
            try {
                client.setScreen(new StoryBookGUI(testedLanguage, testedLanguage.length));
            } catch (final Exception e)
            {
                if(e instanceof final NullPointerException nullPointerException)
                {
                    CodeLyokoMain.LOG.error("no configured language found for");
                    throw nullPointerException;
                }
            }

        });
    }
    private static StringVisitable[] testLocale(final String locale, final ClientPlayerEntity player, final StringVisitable[] englishObject, final StringVisitable[] frenchObject)
    {
        return switch (locale)
        {
            case "en_us" -> englishObject;
            case "fr_fr" -> frenchObject;
            default -> {
                player.sendMessage(Text.literal("no translation present for this language"));
                throw new IllegalArgumentException("no translation present for language:"+locale);
            }
        };
    }
}

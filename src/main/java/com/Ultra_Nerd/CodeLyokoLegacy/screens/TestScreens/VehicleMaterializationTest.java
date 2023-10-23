package com.Ultra_Nerd.CodeLyokoLegacy.screens.TestScreens;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.PacketHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.TestHandler.VehicleMaterializeTestHandler;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
@Environment(EnvType.CLIENT)
public final class VehicleMaterializationTest extends HandledScreen<VehicleMaterializeTestHandler> {
    private static final Identifier TEXTURE = CodeLyokoMain.codeLyokoPrefix("textures/gui/laptopguibase_pot.png");
    private static final int xSize = 1024, ySize = 1024;
    private int x;

    public VehicleMaterializationTest(final VehicleMaterializeTestHandler handler, final PlayerInventory inventory, final Text title) {
        super(handler, inventory, title);
    }


    @Override
    protected void init() {
        super.init();
        x = (this.width - xSize) >> 1;
        ClientPlayNetworking.send(PacketHandler.PLAYER_QUERY_SERVER, PacketByteBufs.empty());
        //players = client.world.getServer().getPlayerManager().getPlayerList();
    }
    private static List<PlayerListEntry> playerList = new ArrayList<>();
    public static void setPlayerList(final List<PlayerListEntry> playerCollection)
    {
        playerList = playerCollection;
    }
    @Override
    public void render(final DrawContext matrices, final int mouseX, final int mouseY, final float delta) {
        super.render(matrices, mouseX, mouseY, delta);
        this.renderBackground(matrices,mouseX,mouseY,delta);
        /*for (final PlayerListEntry playerListEntry : playerList)
        {
            drawCenteredText(matrices,textRenderer,playerListEntry.getProfile().getName(),this.width >> 1,
                    this.height >> 1,
                    ColorHelper.Argb.getArgb(255,255,255,255));

        }*/
        for(final PlayerEntity player : client.world.getPlayers())
        {
            CodeLyokoMain.LOG.info(String.valueOf(player.getName()));
        }

    }

    @Override
    protected void drawBackground(final DrawContext matrices, final float delta, final int mouseX, final int mouseY) {

    }



    @Override
    public void renderBackground(final DrawContext matrices,final int mouseX, final int mouseY, final float delta) {
        super.renderBackground(matrices, mouseX, mouseY, delta);
        RenderSystem.setShaderTexture(0, TEXTURE);
        matrices.drawTexture(TEXTURE, x, 0, 0, 0, xSize, ySize);
    }
}

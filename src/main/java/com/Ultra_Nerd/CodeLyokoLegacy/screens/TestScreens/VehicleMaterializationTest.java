package com.Ultra_Nerd.CodeLyokoLegacy.screens.TestScreens;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.PacketHandlerCommon;
import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.TestHandler.VehicleMaterializeTestHandler;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.server.dedicated.gui.PlayerListGui;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;

import java.util.ArrayList;
import java.util.List;
@Environment(EnvType.CLIENT)
public class VehicleMaterializationTest extends HandledScreen<VehicleMaterializeTestHandler> {
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
        ClientPlayNetworking.send(PacketHandlerCommon.PLAYER_QUERY_SERVER, PacketByteBufs.empty());
        //players = client.world.getServer().getPlayerManager().getPlayerList();
    }
    private static List<PlayerListEntry> playerList = new ArrayList<>();
    public void setPlayerList(final List<PlayerListEntry> playerCollection)
    {
        playerList = playerCollection;
    }
    @Override
    public void render(final MatrixStack matrices, final int mouseX, final int mouseY, final float delta) {
        super.render(matrices, mouseX, mouseY, delta);
        this.renderBackground(matrices);
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
    protected void drawBackground(final MatrixStack matrices, final float delta, final int mouseX, final int mouseY) {

    }

    @Override
    public void renderBackground(final MatrixStack matrices) {
        super.renderBackground(matrices);
        RenderSystem.setShaderTexture(0, TEXTURE);
        this.drawTexture(matrices, x, 0, 0, 0, xSize, ySize);
    }
}

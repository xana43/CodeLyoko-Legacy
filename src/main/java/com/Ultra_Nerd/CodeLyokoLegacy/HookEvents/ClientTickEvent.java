package com.Ultra_Nerd.CodeLyokoLegacy.HookEvents;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.PacketHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.Items.Armor.SuperCalculatorDataLinker;
import com.Ultra_Nerd.CodeLyokoLegacy.Screens.ClientScreens.ClassScreen;
import com.Ultra_Nerd.CodeLyokoLegacy.Screens.Devirtualized;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.CardinalData;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.MethodUtil;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.DeathScreen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;

import java.util.Objects;

import static com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoClient.*;

public record ClientTickEvent() {
    private static final PacketByteBuf keyboardByteBuf = PacketByteBufs.create();
    public static void consume(final MinecraftClient client)
    {
        if (client.player != null) {
            if(client.player.getAbilities().creativeMode) {
                if(testTowerScan.isPressed())
                {
                    ClientPlayNetworking.send(PacketHandler.TOWER_SCANNER, PacketByteBufs.empty());
                }
                //testing buttons
                if (testClone.wasPressed()) {
                    keyboardByteBuf.clear();
                    keyboardByteBuf.writeGameProfile(client.player.getGameProfile());
                    ClientPlayNetworking.send(PacketHandler.SPAWN_TRIPLICATE, keyboardByteBuf);
                }
                if (testPsychic.isPressed()) {
                    final HitResult hitResult = client.crosshairTarget;
                    final PacketByteBuf buf = PacketByteBufs.create();
                    if (hitResult.getType() == HitResult.Type.BLOCK || hitResult.getType() == HitResult.Type.MISS) {
                        buf.writeBlockHitResult((BlockHitResult) hitResult);
                        ClientPlayNetworking.send(PacketHandler.RAY_CAST, buf);
                    } else {
                        final EntityHitResult entityHitResult = (EntityHitResult) hitResult;
                        final Vec3d entityPosition = entityHitResult.getPos();
                        buf.writeUuid(entityHitResult.getEntity().getUuid());
                        buf.writeVec3d(entityPosition);
                        ClientPlayNetworking.send(PacketHandler.RAY_CAST_ENTITY, buf);
                    }
                } else if (!testPsychic.isPressed() && testPsychic.wasPressed()) {

                    ClientPlayNetworking.send(PacketHandler.RAY_CAST_DROP, PacketByteBufs.empty());

                }
                if (testGuardianBuild.wasPressed()) {
                    final HitResult hitResult = client.crosshairTarget;
                    final PacketByteBuf buf = PacketByteBufs.create();
                    if (hitResult.getType() == HitResult.Type.BLOCK || hitResult.getType() == HitResult.Type.MISS) {
                        buf.writeBlockHitResult((BlockHitResult) hitResult);
                        ClientPlayNetworking.send(PacketHandler.BUILD_HOLOGRAM, buf);
                    }
                }
            } else {
                if(classAbility.isPressed())
                {
                    switch (CardinalData.LyokoClass.getLyokoClass(client.player))
                    {
                        case 0 ->{}
                        case 1 ->{
                            keyboardByteBuf.clear();
                            keyboardByteBuf.writeGameProfile(client.player.getGameProfile());
                            ClientPlayNetworking.send(PacketHandler.SPAWN_TRIPLICATE, keyboardByteBuf);
                        }
                        case 2 ->{
                            final HitResult hitResult = client.crosshairTarget;
                            final PacketByteBuf buf = PacketByteBufs.create();
                            if (hitResult.getType() == HitResult.Type.BLOCK || hitResult.getType() == HitResult.Type.MISS) {
                                buf.writeBlockHitResult((BlockHitResult) hitResult);
                                ClientPlayNetworking.send(PacketHandler.RAY_CAST, buf);
                            } else {
                                final EntityHitResult entityHitResult = (EntityHitResult) hitResult;
                                final Vec3d entityPosition = entityHitResult.getPos();
                                buf.writeUuid(entityHitResult.getEntity().getUuid());
                                buf.writeVec3d(entityPosition);
                                ClientPlayNetworking.send(PacketHandler.RAY_CAST_ENTITY, buf);
                            }
                        }
                        case 3 -> {
                            final HitResult hitResult = client.crosshairTarget;
                            final PacketByteBuf buf = PacketByteBufs.create();
                            if (hitResult.getType() == HitResult.Type.BLOCK || hitResult.getType() == HitResult.Type.MISS) {
                                buf.writeBlockHitResult((BlockHitResult) hitResult);
                                ClientPlayNetworking.send(PacketHandler.BUILD_HOLOGRAM, buf);
                            }
                        }
                    }
                } else if (!classAbility.isPressed() && classAbility.wasPressed()) {
                    switch (CardinalData.LyokoClass.getLyokoClass(client.player))
                    {
                        case 0 ->{}
                        case 1 ->{}
                        case 2 -> ClientPlayNetworking.send(PacketHandler.RAY_CAST_DROP, PacketByteBufs.empty());
                        case 3 ->{}
                    }
                }
            }
            //end of testing buttons
            //toggle proctor movement of vehicles
            if (MethodUtil.DimensionCheck.isPlayerInLyoko(client.player)) {

                if(moveVehicleUp.isPressed())
                {
                    keyboardByteBuf.clear();
                    keyboardByteBuf.writeInt(1);
                    ClientPlayNetworking.send(PacketHandler.KEYBOARD_UPDATE,keyboardByteBuf);
                } else if (moveVehicleDown.isPressed()) {
                    keyboardByteBuf.clear();
                    keyboardByteBuf.writeInt(0);
                    ClientPlayNetworking.send(PacketHandler.KEYBOARD_UPDATE,keyboardByteBuf);
                }
                else if((moveVehicleUp.wasPressed() || moveVehicleDown.wasPressed()) && !moveVehicleUp.isPressed() && !moveVehicleDown.isPressed()){
                    keyboardByteBuf.clear();
                    keyboardByteBuf.writeInt(-1);
                    ClientPlayNetworking.send(PacketHandler.KEYBOARD_UPDATE,keyboardByteBuf);
                }
                if(selectTransportHub.isPressed())
                {
                    ClientPlayNetworking.send(PacketHandler.SKID_BLADNIR_UPDATE,PacketByteBufs.empty());
                }
            }

            if (MethodUtil.DimensionCheck.isPlayerInLyoko(client.player)) {
                if (client.currentScreen instanceof DeathScreen) {
                    client.setScreen(new Devirtualized(null, Objects.requireNonNull(client.getServer()).isHardcore()));
                }
            }


            if (MethodUtil.DimensionCheck.playerInVanilla(client.player) && client.player.getEquippedStack(
                    EquipmentSlot.CHEST).isOf(ModItems.LINKER)) {
                final ItemStack linkerStack = client.player.getEquippedStack(EquipmentSlot.CHEST);
                final SuperCalculatorDataLinker SuperCalculatorDataLinker = (SuperCalculatorDataLinker) linkerStack.getItem();
                final long storedEnergy = SuperCalculatorDataLinker.getStoredEnergy(linkerStack);
                if (classScreenBinding.isPressed() && (storedEnergy > 0 || client.player.isCreative())) {
                    client.setScreen(new ClassScreen());
                }
            } else if (classScreenBinding.isPressed()) {
                client.player.sendMessage(Text.translatable("lyoko.link.unavailable"));
            }
        }
    }
}

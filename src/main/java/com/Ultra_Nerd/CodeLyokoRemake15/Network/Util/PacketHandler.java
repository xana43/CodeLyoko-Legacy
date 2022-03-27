package com.Ultra_Nerd.CodeLyokoRemake15.Network.Util;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class PacketHandler {
   private static final String NET_VERSION = "1";
    private static int nextId = 0;
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(CodeLyokoMain.MOD_ID, "network"),
            () -> NET_VERSION,
            NET_VERSION::equals,
            NET_VERSION::equals
    );

    public static void init() {
    //    INSTANCE.registerMessage(nextId++,DataTransferInterfaceMessage.class, DataTransferInterfaceMessage::encode,
      //          DataTransferInterfaceMessage::decode, DataTransferInterfaceMessage::handle);
    }




}

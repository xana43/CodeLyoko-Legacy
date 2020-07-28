package com.Ultra_Nerd.CodeLyokoRemake15.events;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Base.MOD_ID, bus = Bus.FORGE, value = Dist.CLIENT)
public class DoubleJumpEvent
{
    @SubscribeEvent
    public static void DoubleJumpEvent(InputEvent.KeyInputEvent event2)
    {
        PlayerEntity Entity = Minecraft.getInstance().player;

        Minecraft minecraft = Minecraft.getInstance();
 //       byte d = 10;
//            if(!Entity.onGround)
 //           {

//
 //           }


    }
}

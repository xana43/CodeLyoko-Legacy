package com.Ultra_Nerd.CodeLyokoRemake15.player;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.Util.client.DimensionCheck;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = CodeLyokoMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PlayerDeathCustom {


    @SubscribeEvent
    public void PlayerDie(final LivingDeathEvent event)
    {
        if (event.getEntity().level.isClientSide && event.getEntity() instanceof Player playerEntity)
        {
            if (DimensionCheck.playerNotInVanillaWorld(playerEntity))
            {
                playerEntity.level.playSound(null,playerEntity.blockPosition(),ModSounds.DEVIRTUALIZATION.get(), SoundSource.PLAYERS,1,1);
            }
                Minecraft.getInstance().getSoundManager().stop(SoundEvents.PLAYER_DEATH.getRegistryName(),null);
            }
    }



}


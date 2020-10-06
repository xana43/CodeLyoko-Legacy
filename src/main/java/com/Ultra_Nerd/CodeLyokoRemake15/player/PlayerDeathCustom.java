package com.Ultra_Nerd.CodeLyokoRemake15.player;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.Carthage.Sector5Dimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.DesertSector.DesertDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.ForestSector.ForestDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.Frontier.FrontierDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.IceSector.IceDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.MountainSector.MountainDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.VolcanoSector.VolcanoDimension;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.util.Iterator;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = Base.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class PlayerDeathCustom {
    private final Minecraft minecraft;
    private static Map sounds;
    private static Iterator it;
    PlayerDeathCustom(Minecraft minecraft) {
        sounds = ObfuscationReflectionHelper.getPrivateValue(SoundHandler.class, Minecraft.getInstance().getSoundHandler(),"sndManager");
        this.minecraft = minecraft;
        assert sounds != null;
        it = sounds.keySet().iterator();
    }


    @SubscribeEvent
    public static void PlayerDie(final LivingDeathEvent event) {
        if (!event.getEntity().world.isRemote() && event.getEntity() instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity) event.getEntity();
            if (playerEntity.world.dimension instanceof VolcanoDimension || playerEntity.world.dimension
                    instanceof Sector5Dimension || playerEntity.world.dimension instanceof ForestDimension ||
                    playerEntity.world.dimension instanceof DesertDimension || playerEntity.world.dimension instanceof FrontierDimension
                    || playerEntity.world.dimension instanceof IceDimension
                    || playerEntity.world.dimension instanceof MountainDimension) {

                playerEntity.world.playSound(null,playerEntity.getPosition(),ModSounds.DEVIRTUALIZATION.get(), SoundCategory.PLAYERS,1,1);
                Minecraft.getInstance().getSoundHandler().stop(SoundEvents.ENTITY_PLAYER_DEATH.getRegistryName(),null);
            }
        }

    }

}

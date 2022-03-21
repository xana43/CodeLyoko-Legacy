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
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = Base.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class PlayerDeathCustom {


    @SubscribeEvent
    public static void PlayerDie(final LivingDeathEvent event) {
        if (event.getEntity().level.isClientSide && event.getEntity() instanceof Player) {
            Player playerEntity = (Player) event.getEntity();
            if (playerEntity.world.dimension instanceof VolcanoDimension || playerEntity.world.dimension
                    instanceof Sector5Dimension || playerEntity.world.dimension instanceof ForestDimension ||
                    playerEntity.world.dimension instanceof DesertDimension || playerEntity.world.dimension instanceof FrontierDimension
                    || playerEntity.world.dimension instanceof IceDimension
                    || playerEntity.world.dimension instanceof MountainDimension) {

                playerEntity.level.playSound(null,playerEntity.blockPosition(),ModSounds.DEVIRTUALIZATION.get(), SoundSource.PLAYERS,1,1);
                Minecraft.getInstance().getSoundManager().stop(SoundEvents.PLAYER_DEATH.getRegistryName(),null);
            }
        }

    }

}

package com.Ultra_Nerd.CodeLyokoLegacy.HookEvents;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.SamuraiClass.ServerTriplicateCloneEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.common.ModStats;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public record PlayerAfterDeathEvent() {


    public static void consume(final LivingEntity entity, final DamageSource damageSource) {
        if(entity instanceof final ServerTriplicateCloneEntity triplicateClone)
        {
            CardinalData.LyokoClass.ExtraClassData.SamuraiData.removeClone(triplicateClone.getOwner());
            triplicateClone.getOwner().sendMessage(Text.translatable("triplicate.clone.died"));
        }
        if(entity instanceof final ServerPlayerEntity player) {
            if(MethodUtil.DimensionCheck.isPlayerInLyoko(player)) {
                player.incrementStat(ModStats.DIED_IN_LYOKO_IDENTIFIER);
            }
        }
    }
}

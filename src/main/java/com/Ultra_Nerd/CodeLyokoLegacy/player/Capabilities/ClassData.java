package com.Ultra_Nerd.CodeLyokoLegacy.player.Capabilities;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.SamuraiClass.ServerTriplicateCloneEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.entity.PlayerComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;

public record ClassData() {

    public static final class SamuraiClassData implements AutoSyncedComponent, PlayerComponent<SamuraiClassData>
    {
        private int maxClones = 3;
        private int currentAmountOfClones;
        private final PlayerEntity player;
        private static final String SAMURAI_MAX_CLONES = "max_clones";
        public SamuraiClassData(final PlayerEntity player)
        {

            this.player =  player;

        }

        public void addClone() {
            if(!player.getWorld().isClient) {
                if (currentAmountOfClones <= maxClones - 1) {
                    currentAmountOfClones++;
                    final ServerTriplicateCloneEntity clone = ModEntities.TRIPLICATE_ENTITY_TYPE.create(player.getWorld());
                    if (clone != null) {
                        clone.setOwner(player.getGameProfile(),player.getServer());
                    }
                    if (!MethodUtil.DimensionCheck.playerInVanilla(player)) {
                        player.getWorld().spawnEntity(clone);
                    } else {
                        player.sendMessage(Text.translatable("triplicate.cannot.spawn"));
                    }
                }
            }
        }
        public void onRemoveClone()
        {
            if(!player.getWorld().isClient) {
                if (currentAmountOfClones > 0) {
                    currentAmountOfClones--;
                }
            }
        }

        private boolean isSamurai()
        {
            return CardinalData.LyokoClass.getLyokoClass(player) == 1;
        }
        public int getMaxClones()
        {
            return maxClones;
        }
        public void setMaxClones(final int maxClones)
        {
            this.maxClones = maxClones;
        }

        public void addMaxClones()
        {
            if(maxClones <= 8)
            {
                maxClones++;
            }
        }


        @Override
        public void readFromNbt(final NbtCompound tag) {
            maxClones = tag.getInt(SAMURAI_MAX_CLONES);

        }

        @Override
        public void writeToNbt(final NbtCompound tag) {
            tag.putInt(SAMURAI_MAX_CLONES,maxClones);
        }
    }
}

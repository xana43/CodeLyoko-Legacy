package com.Ultra_Nerd.CodeLyokoRemake15.player;

import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.Carthadge.Sector5Dimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.ForestSector.ForestDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.IceSector.IceDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.MountainSector.MountainDimension;
import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.GameType;
import net.minecraft.world.World;

public class PlayerHealthCustom extends PlayerEntity {


    public PlayerHealthCustom(World worldIn, GameProfile gameProfileIn) {
        super(worldIn, gameProfileIn);
    }

    @Override
    protected boolean isPlayer() {
        return true;
    }


    @Override
    public void tick() {
        if(this.getEntity() instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity)this.getEntity();
            if (player.world.dimension instanceof ForestDimension || player.world.dimension instanceof MountainDimension ||
                    player.world.dimension instanceof IceDimension || player.world.dimension instanceof Sector5Dimension) {

               if(player.getHealth() != 1) {
                   player.setGameType(GameType.ADVENTURE);
                   player.setHealth(1);
               }
            }

        }
    }


    @Override
    public boolean isSpectator() {
        return false;
    }

    @Override
    public boolean isCreative() {
        return false;
    }
}

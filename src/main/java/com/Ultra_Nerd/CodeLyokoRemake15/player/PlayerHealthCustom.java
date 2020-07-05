package com.Ultra_Nerd.CodeLyokoRemake15.player;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.PlayerEntity;
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
    public boolean isSpectator() {
        return false;
    }

    @Override
    public boolean isCreative() {
        return false;
    }
}

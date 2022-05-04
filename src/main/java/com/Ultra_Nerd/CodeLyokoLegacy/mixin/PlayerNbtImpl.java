package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.mixin.util.PlayerNBTMixin;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public final class PlayerNbtImpl extends PlayerNBTMixin {

    public static int ClassID;


    @Override
    protected void saveClass(final NbtCompound nbt, final CallbackInfo ci) {
        final NbtCompound playerCompount = new NbtCompound();
        playerCompount.putInt("player_class",ClassID);
       nbt.put(CodeLyokoMain.MOD_ID, playerCompount);
    }

    @Override
    protected void readeClass(final NbtCompound nbt, final CallbackInfo ci) {

    }


}

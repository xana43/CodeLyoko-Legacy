package com.Ultra_Nerd.CodeLyokoRemake15.player.Capabilities;

import com.Ultra_Nerd.CodeLyokoRemake15.Util.client.ClientCapabilitySync;
import com.Ultra_Nerd.CodeLyokoRemake15.player.PlayerClassType;
import net.minecraft.nbt.CompoundTag;
import org.jetbrains.annotations.NotNull;

public final class PlayerClassCapabilityHandler implements IPlayerClassCapability
{
   //private Player player;
    private PlayerClassType classType = PlayerClassType.DEFAULT;
    //@Override
    //public void setPlayer(final Player player) {
    //    this.player = player;
    //}



    @Override
    public void setClass(PlayerClassType type) {


     classType = type;
        ClientCapabilitySync.setServerData(type);
     //serializeNBT();

    }

    @Override
    public @NotNull PlayerClassType getClassType() {
        return classType;
    }

    @Override
    public CompoundTag serializeNBT() {
        //CodeLyokoMain.Log.info("saving data");
        CompoundTag savedclass = new CompoundTag();



        savedclass.put(indentifier,this.classType.getClassTag());




        return savedclass;
    }
    private static final String indentifier = "Class";
    @Override
    public void deserializeNBT(final CompoundTag nbt) {


        if (nbt.get(indentifier).equals(PlayerClassType.Feline.getClassTag())) {
            this.setClass(PlayerClassType.Feline);

        }
        else if (nbt.get(indentifier).equals(PlayerClassType.Samurai.getClassTag())) {
            this.setClass(PlayerClassType.Samurai);

        }

    }


}

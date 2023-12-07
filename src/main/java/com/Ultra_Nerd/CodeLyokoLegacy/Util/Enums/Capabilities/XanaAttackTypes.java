package com.Ultra_Nerd.CodeLyokoLegacy.Util.Enums.Capabilities;

import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.entity.EntityType;

import java.util.List;

public enum XanaAttackTypes {
    DUMMY("DUMMY");

    private final String name;
    private final List<EntityType<?>> attackers;

    XanaAttackTypes(final String name, final EntityType<?>... attacker)
    {
        this.name = name;
        this.attackers =  ObjectList.of(attacker);
    }



    public final List<EntityType<?>> getAttackers() {
        return attackers;
    }

    public final String getName() {
        return name;
    }
}

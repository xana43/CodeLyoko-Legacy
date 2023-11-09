package com.Ultra_Nerd.CodeLyokoLegacy.util.enums.Capabilities;

import net.minecraft.entity.EntityType;

import java.util.List;

public enum XanaAttackTypes {
    DUMMY("DUMMY");

    private final String name;
    private final List<EntityType<?>> attackers;

    XanaAttackTypes(final String name, final EntityType<?>... attacker)
    {
        this.name = name;
        this.attackers =  List.of(attacker);
    }



    public final List<EntityType<?>> getAttackers() {
        return attackers;
    }

    public final String getName() {
        return name;
    }
}

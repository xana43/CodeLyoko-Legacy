package com.Ultra_Nerd.CodeLyokoLegacy.util.enums.Capabilities;

import net.minecraft.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public enum XanaAttackTypes {
    DUMMY("DUMMY");

    private final String name;
    private final List<Entity> attackers;

    XanaAttackTypes(final String name)
    {
        this.name = name;
        this.attackers =  new ArrayList<>();
    }



    public final List<Entity> getAttackers() {
        return attackers;
    }

    public final String getName() {
        return name;
    }
}

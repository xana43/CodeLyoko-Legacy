package com.Ultra_Nerd.CodeLyokoLegacy.util.enums.Capabilities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.HostileEntity;

import java.util.List;

public enum XanaAttackTypes {
    DUMMY("DUMMY");

    private final String name;
    private final List<Entity> attackers;

    XanaAttackTypes(final String name, final HostileEntity... attacker)
    {
        this.name = name;
        this.attackers =  List.of(attacker);
    }



    public final List<Entity> getAttackers() {
        return attackers;
    }

    public final String getName() {
        return name;
    }
}

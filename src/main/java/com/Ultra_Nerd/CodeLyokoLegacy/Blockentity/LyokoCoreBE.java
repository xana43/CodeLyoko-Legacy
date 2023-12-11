package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.MethodUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.blockentity.SyncedBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.blockentity.TickingBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

public final class LyokoCoreBE extends SyncedBlockEntity implements TickingBlockEntity {
    private static final float maxHealth = 500;
    private float health = maxHealth;
    private static final float regenerationCoefficient = 0.7f;
    private static float regenerationTime = MethodUtil.TickConversion.secondsToTicks(2);
    public LyokoCoreBE(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.LYOKO_CORE, pos, state);
    }

    public float getHealth() {
        return health;
    }

    public static float getMaxHealth() {
        return maxHealth;
    }
    public void damageHealth(final float toDamage) {
        health -= toDamage;
    }
    @Override
    public void tick() {
        if(regenerationTime <= 0) {
            if(health < maxHealth) {
                health += regenerationCoefficient;
            } else if (health > maxHealth){
                health = maxHealth;
            }
            regenerationTime = MethodUtil.TickConversion.secondsToTicks(2);
        } else {
            regenerationTime--;
        }
        if(health <= 0) {
            assert world != null;
            world.breakBlock(pos,false);
        }
    }
    private static final String HEALTH_KEY = "health";
    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
        health = nbt.getFloat(HEALTH_KEY);
    }

    @Override
    protected void writeNbt(final NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putFloat(HEALTH_KEY,health);
    }
}

package com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.client.DimensionCheck;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LyokoVehicleEntity extends Boat {
    public boolean movingUp = false;
    public boolean movingDown = false;

    public LyokoVehicleEntity(@NotNull EntityType<? extends LyokoVehicleEntity> p_38290_, @NotNull Level p_38291_) {
        super(p_38290_, p_38291_);

    }



    @Nullable
    @Override
    protected SoundEvent getPaddleSound() {
        return null;
    }

    @Override
    public void setPaddleState(boolean pLeft, boolean pRight) {
        super.setPaddleState(false, false);
    }


    @Override
    public float getGroundFriction() {
        return -10;
    }

    @Override
    protected @NotNull SoundEvent getSwimSound() {
        return null;
    }

    @Override
    public boolean isVehicle() {
        return true;
    }

    @Override
    public boolean canBeRiddenInWater(Entity rider) {
        return false;
    }

    @Override
    public @NotNull Item getDropItem() {
        return ItemStack.EMPTY.getItem();
    }

    @Override
    public boolean shouldRiderSit() {
        return false;
    }

    protected void movement()
    {
        if(movingDown)
        {

            this.setDeltaMovement(getDeltaMovement().subtract(0,1,0));
        }
        if(movingUp)
        {
            this.setDeltaMovement(getDeltaMovement().add(0,1,0));

        }

    }

    @Override
    public void tick() {
        super.tick();
        if(!DimensionCheck.EntityNotInVanillaWorld(this))
        {
            this.remove(RemovalReason.DISCARDED);
        }
        this.movement();

    }



}

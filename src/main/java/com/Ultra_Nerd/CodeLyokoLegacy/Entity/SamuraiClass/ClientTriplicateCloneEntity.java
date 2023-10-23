package com.Ultra_Nerd.CodeLyokoLegacy.Entity.SamuraiClass;

import com.mojang.authlib.GameProfile;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerModelPart;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;

@Environment(EnvType.CLIENT)
public final class ClientTriplicateCloneEntity extends OtherClientPlayerEntity {
    private boolean isSneaking = false;
    private ClientPlayerEntity owner;
    private ServerTriplicateCloneEntity triplicateClone;
    public ClientTriplicateCloneEntity(final ClientWorld world, final GameProfile profile) {
        super(world, profile);
    }
    public void setEntityOwner(final ClientPlayerEntity owner)
    {
        this.owner = owner;
        initialize();
    }

    public void setTriplicateClone(final ServerTriplicateCloneEntity SecondaryOwner)
    {
        triplicateClone = SecondaryOwner;
    }

    public ClientPlayerEntity getOwner() {
        return owner;
    }

    @Override
    public boolean isInSneakingPose() {
        return isSneaking;
    }

    @Override
    public boolean equals(final Object o) {
        if(o instanceof final ClientTriplicateCloneEntity triplicateClone)
        {
            return this.getRotationClient() == triplicateClone.getRotationClient() &&
                    this.bodyYaw == triplicateClone.bodyYaw && this.activeItemStack == triplicateClone.getActiveItem() &&
                    this.isSneaking == triplicateClone.isSneaking() &&
                    this.fallDistance == triplicateClone.fallDistance &&
                    this.headYaw == triplicateClone.headYaw;
        }
        return super.equals(o);
    }

    @Override
    public Iterable<ItemStack> getItemsEquipped() {
        return owner.getItemsEquipped();
    }

    @Override
    public Iterable<ItemStack> getHandItems() {
        return owner.getHandItems();
    }

    @Override
    public Iterable<ItemStack> getArmorItems() {
        return owner.getArmorItems();
    }
    public void update()
    {
        initialize();
    }
    private void initialize()
    {
        if(owner != null) {
            this.copyPositionAndRotation(triplicateClone);
            this.getInventory().clone(owner.getInventory());
            refreshPositionAndAngles(triplicateClone.getBlockPos(),0,0);
            this.prevCapeX = this.capeX = getX() + 0.5;
            this.prevCapeY = this.capeY = getY();
            this.prevCapeZ = this.capeZ = getZ() + 0.5;
            this.setWorld(triplicateClone.getWorld());
            this.copyFrom(triplicateClone);
            this.setSneaking(triplicateClone.isSneaking());
            this.setSprinting(false);
            this.setBodyYaw(triplicateClone.getBodyYaw());
            this.prevBodyYaw =triplicateClone.prevBodyYaw;
            this.activeItemStack = triplicateClone.getActiveItem();
            for(final EquipmentSlot slot : EquipmentSlot.values())
            {
                this.equipStack(slot,triplicateClone.getEquippedStack(slot));
            }
            this.setStackInHand(triplicateClone.getActiveHand(),triplicateClone.getStackInHand(triplicateClone.getActiveHand()));
            this.fallDistance = owner.fallDistance;
            this.setCustomName(owner.getCustomName());
            this.setHeadYaw(triplicateClone.getHeadYaw());
            this.prevHeadYaw = triplicateClone.prevHeadYaw;
            isSneaking = triplicateClone.isSneaking();
        }
    }

    @Override
    public boolean isPartVisible(final PlayerModelPart modelPart) {
        return true;
    }

    @Override
    public boolean shouldRenderName() {
        return true;
    }
}

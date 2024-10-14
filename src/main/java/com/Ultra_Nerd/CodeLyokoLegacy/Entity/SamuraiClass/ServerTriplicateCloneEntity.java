package com.Ultra_Nerd.CodeLyokoLegacy.Entity.SamuraiClass;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.Entity.CustomLivingEntityInventory;
import com.mojang.authlib.GameProfile;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Arm;
import net.minecraft.world.World;

public class ServerTriplicateCloneEntity extends LivingEntity {

    private GameProfile owner;
    private MinecraftServer server;
    private boolean isSneaking = false;
    private int timesAttacked = 0;
    private final CustomLivingEntityInventory inventory;


    public ServerTriplicateCloneEntity(final EntityType<? extends LivingEntity> entityType, final World world) {
        super(entityType, world);
        inventory = new CustomLivingEntityInventory(this);
        setInvulnerable(true);
    }

    public static DefaultAttributeContainer.Builder createPlayerAttributes() {
        return LivingEntity.createLivingAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH,Double.MAX_VALUE).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.10000000149011612).add(EntityAttributes.GENERIC_ATTACK_SPEED).add(EntityAttributes.GENERIC_LUCK);
    }





    public void setOwner(final GameProfile player,final MinecraftServer server)
    {
        this.owner = player;
        this.server = server;
        cloneLocalPlayer();
    }



    @Override
    public boolean shouldRenderName() {
        return true;
    }


    private Arm mainArm;
    private void cloneLocalPlayer()
    {
        if(owner != null)
        {
            final ServerPlayerEntity serverPlayerEntity = server.getPlayerManager().getPlayer(owner.getId());
            if(serverPlayerEntity != null) {
                this.copyPositionAndRotation(serverPlayerEntity);
                //this.copyFrom(owner);
                this.setSneaking(false);
                this.setSprinting(false);
                this.bodyYaw = serverPlayerEntity.bodyYaw;
                this.inventory.clone(serverPlayerEntity.getInventory());
                this.mainArm = serverPlayerEntity.getMainArm();
                for (final EquipmentSlot slot : EquipmentSlot.values()) {
                    this.equipStack(slot, serverPlayerEntity.getEquippedStack(slot));
                }
                this.activeItemStack = serverPlayerEntity.getActiveItem();
                this.setStackInHand(serverPlayerEntity.getActiveHand(), serverPlayerEntity.getStackInHand(serverPlayerEntity.getActiveHand()));
                this.fallDistance = serverPlayerEntity.fallDistance;
                this.headYaw = serverPlayerEntity.headYaw;
                this.setCustomName(serverPlayerEntity.getPlayerListName());
                this.setCustomNameVisible(true);
                isSneaking = serverPlayerEntity.isSneaking();
            }
        }
    }
    @Override
    public Arm getMainArm() {
        return this.mainArm;
    }

    @Override
    public Iterable<ItemStack> getArmorItems() {
        return this.inventory.armor;
    }

    @Override
    public ItemStack getEquippedStack(final EquipmentSlot slot) {
        if(inventory != null) {
            if (slot == EquipmentSlot.MAINHAND) {
                return this.inventory.getMainHandStack();
            } else if (slot == EquipmentSlot.OFFHAND) {
                return this.inventory.offHand.get(0);
            } else {
                return slot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR ? this.inventory.armor.get(slot.getEntitySlotId()) : ItemStack.EMPTY;
            }
        }
        return ItemStack.EMPTY;
    }
    @Override
    public void equipStack(final EquipmentSlot slot, final ItemStack stack) {
        if(inventory != null) {
            processEquippedStack(stack);
            if (slot == EquipmentSlot.MAINHAND) {
                this.onEquipStack(slot, this.inventory.main.set(this.inventory.selectedSlot, stack), stack);
            } else if (slot == EquipmentSlot.OFFHAND) {
                this.onEquipStack(slot, this.inventory.offHand.set(0, stack), stack);
            } else if (slot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR) {
                this.onEquipStack(slot, this.inventory.armor.set(slot.getEntitySlotId(), stack), stack);
            }
        }
    }

    @Override
    protected void applyDamage(final DamageSource source, final float amount) {
        super.applyDamage(source, amount);
        if(!getWorld().isClient) {
            if (timesAttacked > 1) {
                kill();
            } else {
                timesAttacked++;
            }
        }
    }



    @Override
    public boolean isInSneakingPose() {
        return isSneaking;
    }
    public boolean hasOwner()
    {
        return server.getPlayerManager().getPlayer(owner.getId()) != null;
    }
    public GameProfile getOwnerProfile()
    {
        return owner;
    }
    public ServerPlayerEntity getOwner()
    {
        return server.getPlayerManager().getPlayer(owner.getId());
    }



    @Override
    public boolean isSpectator() {
        return false;
    }



}

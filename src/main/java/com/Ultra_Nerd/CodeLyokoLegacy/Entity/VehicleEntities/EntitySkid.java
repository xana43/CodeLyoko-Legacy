package com.Ultra_Nerd.CodeLyokoLegacy.Entity.VehicleEntities;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.SeaPylon;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModDamageSources;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModDimensions;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModTags;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public final class EntitySkid extends LyokoVehicleEntity {
    public EntitySkid(final EntityType<? extends BoatEntity> entityType, final World world) {
        super(entityType, world);
    }
    private static final Identifier skidlocation = CodeLyokoMain.codeLyokoPrefix("entity" +
            "/skid_model/skid");
    public static Identifier getSkidLocation()
    {
        return skidlocation;
    }

    @Override
    public boolean shouldDismountUnderwater() {
        return false;
    }

    @Override
    public boolean isInvulnerableTo(final DamageSource damageSource) {
        return damageSource == ModDamageSources.digitalLavaSource || damageSource == ModDamageSources.digitalOceanSource;
    }

    @Override
    public boolean isSubmergedInWater() {
        return false;
    }

    public void selectHub()
    {
      final HitResult raycast = raycast(50,2,false);
      final BlockPos lookingPos = new BlockPos((int)raycast.getPos().x,(int)raycast.getPos().y,(int)raycast.getPos().z);
      if(getWorld().getBlockState(lookingPos).isOf(ModBlocks.DIGITAL_SEA_PYLON))
      {
          getWorld().setBlockState(lookingPos,getWorld().getBlockState(lookingPos).with(SeaPylon.SELECTED, Boolean.TRUE));
      }
    }

    @Override
    public void dismountVehicle() {
        if(getWorld().getRegistryKey() != ModDimensions.digitalOceanWorld) {
            super.dismountVehicle();
        }
    }

    @Override
    public Vec3d updatePassengerForDismount(final LivingEntity passenger) {
        final BlockPos dismountPos = checkForValidBlock(this);
        if(dismountPos != BlockPos.ORIGIN)
        {
            //passenger.setPos(dismountPos.getX(),dismountPos.getY(),dismountPos.getZ());
            return new Vec3d(dismountPos.getX(),dismountPos.getY(),dismountPos.getZ());
        }
        return super.updatePassengerForDismount(passenger);
    }
    private static BlockPos checkForValidBlock(final Entity entity)
    {

        for(int x = -30; x < 30; x++)
        {
            for(int y = -30; y < 30; y++)
            {
                for(int z = -30; z < 30; z++)
                {
                   final BlockPos checkedPos = entity.getBlockPos().add(x,y,z);
                   if(entity.getWorld().getBlockState(checkedPos).isIn(ModTags.Blocks.LYOKO_BLOCKS) &&
                   !entity.getWorld().getBlockState(checkedPos).isOf(ModBlocks.DIGITAL_LAVA_BLOCK) &&
                   !entity.getWorld().getBlockState(checkedPos).isOf(ModBlocks.DIGITAL_OCEAN_BLOCK))
                   {

                       if(entity.getWorld().getBlockState(checkedPos.add(0,1,0)).isOf(Blocks.AIR))
                       {
                           if(entity.getWorld().getBlockState(checkedPos.add(0,2,0)).isOf(Blocks.AIR))
                           {
                                return checkedPos;
                           }
                       }
                   }
                }
            }
        }
        return BlockPos.ORIGIN;
    }

    /*
    public EntitySkid(@NotNull EntityType<? extends LyokoVehicleEntity> entitySkidEntityType, @NotNull Level world) {
        super(entitySkidEntityType, world);


    }

    @Override
    public boolean shouldRiderSit() {
        return true;
    }

    @Override
    public void dismountTo(double pX, double pY, double pZ) {
        if(level.dimension() != ModDimensions.DIGITAL_OCEAN)
        {
            super.dismountTo(pX,pY,pZ);
        }

    }

    @Override
    public void setDeltaMovement(final Vec3 pMotion) {
        super.setDeltaMovement(pMotion.add(16,16,16));
    }

    @Override
    public boolean canRiderInteract() {
        return true;
    }



    @Override
    public boolean showVehicleHealth() {
        return true;
    }

    @Override
    public boolean rideableUnderWater() {
        return true;
    }

    @Override
    public boolean canBeRiddenInWater(Entity rider) {
        return true;
    }








    @Nonnull
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void positionRider(@NotNull Entity pPassenger) {
        super.positionRider(pPassenger);
        pPassenger.setPos(this.getX(),this.getY() + 7, this.getZ());
    }

    @Override
    public void ejectPassengers() {
        //super.ejectPassengers();
    }



    @Override
    public void tick() {
        super.tick();
        this.setNoGravity(this.isUnderWater());
          for (int i = 0; i < getPassengers().size(); i++)
          {
              getPassengers().get(i).setAirSupply(getPassengers().get(i).getMaxAirSupply());
              getPassengers().get(i).setSwimming(false);
              if(getPassengers().get(i) instanceof Player player)
              {
                  player.setDiscardFriction(true);
              }
          }

    }

 */


}

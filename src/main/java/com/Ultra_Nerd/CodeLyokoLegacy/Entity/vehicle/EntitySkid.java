package com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle;

import com.Ultra_Nerd.CodeLyokoLegacy.blocks.SeaPylon;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModDimensions;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTags;
import com.Ultra_Nerd.CodeLyokoLegacy.util.ConstantUtil;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public final class EntitySkid extends LyokoVehicleEntity {
    public EntitySkid(final EntityType<? extends BoatEntity> entityType, final World world) {
        super(entityType, world);
    }

    @Override
    public boolean canBeRiddenInWater() {
        return true;
    }

    @Override
    public boolean isSubmergedInWater() {
        return false;
    }

    public void selectHub()
    {
      final HitResult raycast = raycast(50,2,false);
      final BlockPos lookingPos = new BlockPos(raycast.getPos());
      if(world.getBlockState(lookingPos).isOf(ModBlocks.DIGITAL_SEA_PYLON))
      {
          world.setBlockState(lookingPos,world.getBlockState(lookingPos).with(SeaPylon.SELECTED,true));
      }
    }

    @Override
    public void dismountVehicle() {
        if(world.getDimensionKey() != ModDimensions.digitalOceanType) {
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
                   if(entity.world.getBlockState(checkedPos).isIn(ModTags.Blocks.LYOKO_BLOCKS) &&
                   !entity.world.getBlockState(checkedPos).isOf(ModBlocks.DIGITAL_LAVA_BLOCK) &&
                   !entity.world.getBlockState(checkedPos).isOf(ModBlocks.DIGITAL_OCEAN_BLOCK))
                   {

                       if(entity.world.getBlockState(checkedPos.add(0,1,0)).isOf(Blocks.AIR))
                       {
                           if(entity.world.getBlockState(checkedPos.add(0,2,0)).isOf(Blocks.AIR))
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

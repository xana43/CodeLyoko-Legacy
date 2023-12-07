package com.Ultra_Nerd.CodeLyokoLegacy.Entity.VehicleEntities;

import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.SeaPylon;
import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModDamageSources;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModDimensions;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModTags;
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




}

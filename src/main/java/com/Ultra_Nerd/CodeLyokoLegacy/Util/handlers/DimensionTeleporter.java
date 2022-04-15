package com.Ultra_Nerd.CodeLyokoLegacy.Util.handlers;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.util.ITeleporter;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class DimensionTeleporter {
   public static void teleportPlayerToWorld(@NotNull ServerPlayer player, @NotNull ServerLevel dest, @NotNull BlockPos pos, boolean top)
   {
       player.changeDimension(dest, new ITeleporter() {
           @Override
           public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destWorld, float yaw, @NotNull Function<Boolean, Entity> repositionEntity) {
               entity = repositionEntity.apply(false);
               int y = pos.getY();
               if(top)
               {
                   y = dest.getHeight(Heightmap.Types.WORLD_SURFACE_WG,pos.getX(),pos.getZ());
               }
               entity.teleportTo(pos.getX(),y,pos.getZ());
               return entity;
           }
       });
   }
}

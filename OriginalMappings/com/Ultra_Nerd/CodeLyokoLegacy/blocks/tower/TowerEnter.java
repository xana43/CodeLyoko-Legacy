package com.Ultra_Nerd.CodeLyokoLegacy.blocks.tower;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle.LyokoVehicleEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public final class TowerEnter extends Block {


    public static final DirectionProperty DIRTOWER2 = HorizontalFacingBlock.FACING;

    public TowerEnter() {
        super(FabricBlockSettings.of(Material.BARRIER)

                .strength(-1, -1)
                .sounds(BlockSoundGroup.GLASS)
                .noCollision().luminance(60)


        );

    }

    @Override
    public void onEntityCollision(final BlockState state, final World world, final BlockPos pos, final Entity entity) {
        super.onEntityCollision(state, world, pos, entity);
        if(!(entity instanceof PlayerEntity) && !(entity instanceof LyokoVehicleEntity))
        {
          entity.damage(DamageSource.OUT_OF_WORLD,Float.MAX_VALUE);
        }
    }

    @Override
    protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(DIRTOWER2));
    }


    @Nullable
    @Override
    public BlockState getPlacementState(final ItemPlacementContext ctx) {
        return this.getDefaultState().with(DIRTOWER2,ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public boolean canMobSpawnInside() {
        return false;
    }

    //









}
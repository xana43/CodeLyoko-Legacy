package com.Ultra_Nerd.CodeLyokoLegacy.player.Capabilities;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.SamuraiClass.ServerTriplicateCloneEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModDimensions;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import com.Ultra_Nerd.CodeLyokoLegacy.util.GeneralRendererUtils.RendererVariables;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.entity.PlayerComponent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public record ClassCapabilities() {

    public static final class SamuraiClassExtraCapabilities implements AutoSyncedComponent, PlayerComponent<SamuraiClassExtraCapabilities>
    {
        private int maxClones = 3;
        private int currentAmountOfClones;
        private final PlayerEntity player;
        private static final String SAMURAI_MAX_CLONES = "max_clones";
        public SamuraiClassExtraCapabilities(final PlayerEntity player)
        {

            this.player =  player;

        }

        public void addClone() {
            if(!player.getWorld().isClient && (CardinalData.LyokoClass.getLyokoClass(player) == 1 || player.getAbilities().creativeMode) && CardinalData.DigitalEnergyComponent.tryUseEnergy(player,4)) {
                if (currentAmountOfClones <= maxClones - 1) {
                    currentAmountOfClones++;
                    final ServerTriplicateCloneEntity clone = ModEntities.TRIPLICATE_ENTITY_TYPE.create(player.getWorld());
                    if (clone != null) {
                        clone.setOwner(player.getGameProfile(),player.getServer());
                    }
                    if (!MethodUtil.DimensionCheck.playerInVanilla(player)) {
                        player.getWorld().spawnEntity(clone);
                    } else {
                        player.sendMessage(Text.translatable("triplicate.cannot.spawn"));
                    }
                }
            }
        }
        public void onRemoveClone()
        {
            if(!player.getWorld().isClient) {
                if (currentAmountOfClones > 0) {
                    currentAmountOfClones--;
                }
            }
        }

        private boolean isSamurai()
        {
            return CardinalData.LyokoClass.getLyokoClass(player) == 1;
        }
        public int getMaxClones()
        {
            return maxClones;
        }
        public void setMaxClones(final int maxClones)
        {
            this.maxClones = maxClones;
        }

        public void addMaxClones()
        {
            if(maxClones <= 8)
            {
                maxClones++;
            }
        }


        @Override
        public void readFromNbt(final NbtCompound tag) {
            maxClones = tag.getInt(SAMURAI_MAX_CLONES);

        }

        @Override
        public void writeToNbt(final NbtCompound tag) {
            tag.putInt(SAMURAI_MAX_CLONES,maxClones);
        }
    }

    public static final class NinjaClassExtraCapabilities implements AutoSyncedComponent, PlayerComponent<NinjaClassExtraCapabilities>
    {
        private final PlayerEntity player;
        private FallingBlockEntity fallingBlockVersion;
        private boolean isHoldingBlock;
        private boolean negatedProjectileVelocity;
        public NinjaClassExtraCapabilities(final PlayerEntity player)
        {
            this.player = player;
        }
        public void onLetGoOfBlock()
        {

            if(fallingBlockVersion != null && isHoldingBlock) {
                fallingBlockVersion.distanceTraveled = 0;
                fallingBlockVersion.speed = 0;
                fallingBlockVersion.setVelocity(0, 0.05, 0);
                fallingBlockVersion.setNoGravity(false);
                isHoldingBlock = false;
            }
            if(fallingBlockVersion != null && fallingBlockVersion.isRemoved())
            {

                fallingBlockVersion = null;
            }

        }
        public void pickTargetedEntity(final UUID entityUUID,final Vec3d playerLookingPosition)
        {
            if((CardinalData.LyokoClass.getLyokoClass(player) == 2 || player.getAbilities().creativeMode) && CardinalData.DigitalEnergyComponent.tryUseEnergy(player,5)) {
                final Entity entity = ((ServerWorld) player.getWorld()).getEntity(entityUUID);
                if (entity instanceof final LivingEntity livingEntity) {

                    livingEntity.setPos(playerLookingPosition.getX(), playerLookingPosition.getY(), playerLookingPosition.getZ());
                    livingEntity.updatePosition(playerLookingPosition.getX(), playerLookingPosition.getY(), playerLookingPosition.getZ());
                    livingEntity.setVelocity(0, 0.05, 0);
                    livingEntity.updateTrackedPosition(playerLookingPosition.getX(), playerLookingPosition.getY(), playerLookingPosition.getZ());
                }
                if (entity instanceof final ProjectileEntity projectile) {

                    projectile.setPos(playerLookingPosition.getX(), playerLookingPosition.getY(), playerLookingPosition.getZ());
                    projectile.updatePosition(playerLookingPosition.getX(), playerLookingPosition.getY(), playerLookingPosition.getZ());
                    if (!negatedProjectileVelocity) {
                        projectile.setVelocity(projectile.getVelocity().negate());
                        negatedProjectileVelocity = true;
                    }
                    projectile.updateTrackedPosition(playerLookingPosition.getX(), playerLookingPosition.getY(), playerLookingPosition.getZ());
                } else {
                    negatedProjectileVelocity = false;
                }
            }
        }

        public void pickTargetedBlock(final BlockHitResult resultant) {
            if((CardinalData.LyokoClass.getLyokoClass(player) == 2 || player.getAbilities().creativeMode) && CardinalData.DigitalEnergyComponent.tryUseEnergy(player,2)) {
                if (fallingBlockVersion == null) {
                    final BlockState state = player.getWorld().getBlockState(resultant.getBlockPos());
                    if (state != Blocks.AIR.getDefaultState()) {
                        fallingBlockVersion = FallingBlockEntity.spawnFromBlock(player.getWorld(), resultant.getBlockPos(), state);
                    }
                }
                if (fallingBlockVersion != null) {
                    isHoldingBlock = true;
                    fallingBlockVersion.setVelocity(Vec3d.ZERO);
                    fallingBlockVersion.setNoGravity(true);
                    fallingBlockVersion.setPos(resultant.getPos().getX(), resultant.getPos().getY(), resultant.getPos().getZ());
                    fallingBlockVersion.updateTrackedPosition(resultant.getPos().getX(), resultant.getPos().getY(), resultant.getPos().getZ());
                    fallingBlockVersion.setFallingBlockPos(resultant.getBlockPos());

                }
            }
        }

        @Override
        public void readFromNbt(final NbtCompound tag) {

        }

        @Override
        public void writeToNbt(final NbtCompound tag) {

        }
    }
    public static final class GuardianClassExtraCapabilities implements AutoSyncedComponent, PlayerComponent<GuardianClassExtraCapabilities>
    {
        private final PlayerEntity player;
        private int maxLength = 5;
        private int maxWidth = 3;
        private static final String BUILD_LENGTH_KEY = "build_length",BUILD_WIDTH_KEY = "build_width";

        public GuardianClassExtraCapabilities(final PlayerEntity player) {
            this.player = player;
        }

        public void setMaxLength(final int maxLength) {
            this.maxLength = maxLength;
        }
        public void addToMaxLength(final int lengthToAdd)
        {
            this.maxLength += lengthToAdd;
        }
        public void addToMaxLength()
        {
            this.maxLength++;
        }

        public void setMaxWidth(final int maxWidth)
        {
            this.maxWidth = maxWidth;
        }
        public void addToMaxWidth()
        {
            maxWidth++;
        }
        public void addToMaxWidth(final int widthToAdd)
        {
            maxWidth+= widthToAdd;
        }

        public void calculateWorldBlockPlacements(final BlockHitResult hitResult) {
            if((CardinalData.LyokoClass.getLyokoClass(player) == 3 || player.getAbilities().creativeMode) && CardinalData.DigitalEnergyComponent.tryUseEnergy(player,3)) {
                final BlockPos position = hitResult.getBlockPos();
                final BlockBox blockBox = new BlockBox(position.getX() - maxWidth, position.getY() - 1, position.getZ() - maxLength, position.getX() + maxWidth, position.getY() + 1, position.getZ() + maxLength);
                final BlockPos calculatePosition = getBlockPos(player, blockBox);
                if (player.getWorld().getRegistryKey() == ModDimensions.desertSectorWorld) {
                    final MatrixStack matrixReference = RendererVariables.getMatrixStack();
                    final Block block = ModBlocks.DIGITAL_SAND;
                    //matrixReference.push();
                    switch (player.getHorizontalFacing()) {
                        case WEST, EAST -> {
                            for (int x = calculatePosition.getX() - maxLength; x < calculatePosition.getX() + maxLength; ++x) {
                                for (int y = calculatePosition.getY() - 1; y < calculatePosition.getY() + 1; ++y) {
                                    for (int z = calculatePosition.getZ() - maxWidth; z < calculatePosition.getZ() + maxWidth; ++z) {

                                        player.getWorld().setBlockState(new BlockPos(x, y, z), block.getDefaultState());
                                        //renderBuildingQuad(client,new BlockPos(x,y,z),block,matrixReference);


                                    }
                                }
                            }
                        }
                        case NORTH, SOUTH -> {
                            for (int x = calculatePosition.getX() - maxWidth; x < calculatePosition.getX() + maxWidth; ++x) {
                                for (int y = calculatePosition.getY() - 1; y < calculatePosition.getY() + 1; ++y) {
                                    for (int z = calculatePosition.getZ() - maxLength; z < calculatePosition.getZ() + maxLength; ++z) {
                                        player.getWorld().setBlockState(new BlockPos(x, y, z), block.getDefaultState());
                                        //renderBuildingQuad(client,new BlockPos(x,y,z),block,matrixReference);

                                    }
                                }
                            }
                        }
                    }
                    // matrixReference.pop();
                }
            }
        }
        @NotNull
        private static BlockPos getBlockPos(final PlayerEntity player, final BlockBox blockBox) {
            BlockRotation rotation = BlockRotation.NONE;
            switch (player.getHorizontalFacing())
            {
                case WEST, EAST -> rotation = BlockRotation.CLOCKWISE_90;
                default -> {}
            }

            final BlockPos pos = blockBox.getCenter();
            final BlockPos rotatedPosition = pos.rotate(rotation);
            final int offsetZ = rotatedPosition.getZ() - pos.getZ();
            final int offsetX = rotatedPosition.getX() - pos.getX();
            if(rotation != BlockRotation.NONE) {
                return new BlockPos(rotatedPosition.getX() - offsetX, pos.getY(),rotatedPosition.getZ() - offsetZ);
            }
            return pos;
        }
        @Override
        public void readFromNbt(final NbtCompound tag) {
                maxLength = tag.getInt(BUILD_LENGTH_KEY);
                maxWidth = tag.getInt(BUILD_WIDTH_KEY);
        }

        @Override
        public void writeToNbt(final NbtCompound tag) {
                tag.putInt(BUILD_LENGTH_KEY,maxLength);
                tag.putInt(BUILD_WIDTH_KEY,maxWidth);
        }
    }
}

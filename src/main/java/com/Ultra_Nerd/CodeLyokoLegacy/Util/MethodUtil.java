package com.Ultra_Nerd.CodeLyokoLegacy.Util;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModDimensions;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.component.ComponentChanges;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.EnergyStorage;
import team.reborn.energy.api.base.SimpleEnergyItem;

import java.util.function.Consumer;

public record MethodUtil() {
    public record ArmorMethods() {
        public static boolean isArmorSlot(final int slot) {
            return slot == EquipmentSlot.CHEST.getEntitySlotId() || slot == EquipmentSlot.LEGS.getEntitySlotId()
                    || slot == EquipmentSlot.FEET.getEntitySlotId() || slot == EquipmentSlot.HEAD.getEntitySlotId();
        }


    }
    public record AdvancementCreation()
    {

        private static final Identifier DEFAULT_BACKGROUND = new Identifier("textures/gui/advancements/backgrounds" +
                "/adventure.png");
        public static AdvancementEntry create(final AdvancementEntry parent,
                                         final ItemConvertible itemConvertible,
                                         final Text name,
                                         final Text description,@Nullable final Identifier background, final AdvancementFrame frameType,
                                         final boolean showToast, final boolean announceToChat, final boolean hidden,
                                         final String criteriaName, final AdvancementCriterion<?> conditions, final String location,
                                         final Consumer<AdvancementEntry> advancementConsumer)
        {
            if(parent != null) {
                return Advancement.Builder.create()
                        .parent(parent)
                        .display(itemConvertible, name, description, background, frameType, showToast,
                                announceToChat, hidden).criterion(criteriaName, conditions)
                        .build(advancementConsumer, convertToPath(location));
            }
            return Advancement.Builder.create()
                    .display(itemConvertible, name, description, background, frameType, showToast,
                            announceToChat, hidden).criterion(criteriaName, conditions)
                    .build(advancementConsumer, convertToPath(location));
        }
        private static String convertToPath(final String location)
        {
            final StringBuilder buffer = new StringBuilder();
            buffer.append(CodeLyokoMain.MOD_ID);
            if(location.charAt(0) == '/')
            {
                buffer.append(location);
            }
            else
            {
                buffer.append('/').append(location);
            }
            return buffer.toString();
        }

        public static AdvancementEntry create(
                final ItemConvertible itemConvertible,
                final Text name,
                final Text description,@Nullable final Identifier background,final AdvancementFrame frameType,
                final boolean showToast,final boolean announceToChat, final boolean hidden,
                final String criteriaName,final AdvancementCriterion<?> conditions,final String location,
                final Consumer<AdvancementEntry> advancementConsumer)
        {
            final Identifier usableBackground =(background == null || background.toString().isEmpty()) ? DEFAULT_BACKGROUND : background;
            return create(null,itemConvertible,name,description,usableBackground,frameType,showToast,announceToChat,hidden,criteriaName,conditions,
                        location,advancementConsumer);


        }
    }

    public record FluidStorageCreation() {
        public static SingleVariantStorage<FluidVariant> createFluidStorage(final BlockEntity blockEntity,
                final Fluid allowedVariant) {
            return new SingleVariantStorage<>() {
                @Override
                protected FluidVariant getBlankVariant() {
                    return FluidVariant.blank();
                }

                @Override
                protected long getCapacity(final FluidVariant variant) {
                    return FluidConstants.BUCKET;
                }

                @Override
                protected boolean canInsert(final FluidVariant variant) {
                    return variant.equals(FluidVariant.of(allowedVariant));
                }

                @Override
                protected void onFinalCommit() {
                    blockEntity.markDirty();
                }
            };

        }
        public static SingleVariantStorage<FluidVariant> createFluidStorage(final BlockEntity blockEntity,
                final Fluid... allowedVariant) {
            return new SingleVariantStorage<>() {
                @Override
                protected FluidVariant getBlankVariant() {
                    return FluidVariant.blank();
                }

                @Override
                protected long getCapacity(final FluidVariant variant) {
                    return FluidConstants.BUCKET;
                }

                @Override
                protected boolean canInsert(final FluidVariant variant) {
                    for (final Fluid fluid : allowedVariant) {
                        return variant.equals(FluidVariant.of(fluid));
                    }
                    return false;
                }

                @Override
                protected void onFinalCommit() {
                    blockEntity.markDirty();
                }
            };

        }
        public static SingleVariantStorage<FluidVariant> createFluidStorage(final BlockEntity blockEntity) {
            return new SingleVariantStorage<>() {
                @Override
                protected FluidVariant getBlankVariant() {
                    return FluidVariant.blank();
                }

                @Override
                protected long getCapacity(final FluidVariant variant) {
                    return FluidConstants.BUCKET;
                }


                @Override
                protected void onFinalCommit() {
                    blockEntity.markDirty();
                }
            };

        }
        public static SingleVariantStorage<FluidVariant> createFluidStorage(final BlockEntity blockEntity,
                final FluidVariant allowedVariant) {
            return new SingleVariantStorage<>() {
                @Override
                protected FluidVariant getBlankVariant() {
                    return FluidVariant.blank();
                }

                @Override
                protected long getCapacity(final FluidVariant variant) {
                    return FluidConstants.BUCKET;
                }

                @Override
                protected boolean canInsert(final FluidVariant variant) {
                    return variant.equals(allowedVariant);
                }

                @Override
                protected void onFinalCommit() {
                    blockEntity.markDirty();

                }
            };

        }
        public static SingleVariantStorage<FluidVariant> createFluidStorage(final BlockEntity blockEntity,
                final FluidVariant allowedVariant,final int amountOfBuckets) {
            return new SingleVariantStorage<>() {
                @Override
                protected FluidVariant getBlankVariant() {
                    return FluidVariant.blank();
                }

                @Override
                protected long getCapacity(final FluidVariant variant) {
                    return (amountOfBuckets * FluidConstants.BUCKET) / 81;
                }

                @Override
                protected boolean canInsert(final FluidVariant variant) {
                    return variant.equals(allowedVariant);
                }

                @Override
                protected void onFinalCommit() {
                    blockEntity.markDirty();

                }
            };

        }
        public static SingleVariantStorage<FluidVariant> createFluidStorage(final BlockEntity blockEntity,
                final Fluid allowedVariant, final int amountOfBuckets) {
            return new SingleVariantStorage<>() {
                @Override
                protected FluidVariant getBlankVariant() {
                    return FluidVariant.blank();
                }

                @Override
                protected long getCapacity(final FluidVariant variant) {
                    return (amountOfBuckets * FluidConstants.BUCKET) / 81;
                }

                @Override
                protected boolean canInsert(final FluidVariant variant) {
                    return variant.equals(FluidVariant.of(allowedVariant));
                }

                @Override
                protected void onFinalCommit() {
                    blockEntity.markDirty();

                }
            };

        }
        public static SingleVariantStorage<FluidVariant> createFluidStorage(final BlockEntity blockEntity,
                final Fluid allowedVariant, final NbtCompound compound) {
            return new SingleVariantStorage<>() {
                @Override
                protected FluidVariant getBlankVariant() {
                    return FluidVariant.blank();
                }

                @Override
                protected long getCapacity(final FluidVariant variant) {
                    return FluidConstants.BUCKET;
                }

                @Override
                protected boolean canInsert(final FluidVariant variant) {
                    return variant.equals(FluidVariant.of(allowedVariant, ComponentChanges.builder().add(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(compound)).build()));
                }

                @Override
                protected void onFinalCommit() {
                    blockEntity.markDirty();

                }
            };
        }
    }
        public record TickConversion() {
            public static int tickToSeconds(final int ticks) {
                return ticks / 20;
            }
            public static long tickToSeconds(final long ticks){return ticks / 20;}
            public static float tickToSeconds(final float ticks){return ticks / 20;}
            public static double tickToSeconds(final double ticks){return ticks / 20;}


            public static long secondsToTicks(final long seconds){return seconds * 20;}
            public static double secondsToTicks(final double seconds){return seconds * 20;}
            public static float secondsToTicks(final float seconds){return seconds * 20;}
            public static int secondsToTicks(final int seconds) {return seconds * 20;}
        }

        public record DimensionCheck() {

            public static boolean isPlayerInLyoko(final @NotNull PlayerEntity player) {
                return isEntityInLyoko(player);
            }

            public static boolean isEntityInLyoko(final @NotNull Entity entity) {
                return entity.getWorld().getRegistryKey() == ModDimensions.forestSectorWorld || entity.getWorld()
                        .getRegistryKey() == ModDimensions.carthage || entity.getWorld()
                        .getRegistryKey() == ModDimensions.desertSectorWorld || entity.getWorld()
                        .getRegistryKey() == ModDimensions.iceSectorWorld
                        || entity.getWorld().getRegistryKey() == ModDimensions.mountainSectorWorld || entity.getWorld()
                        .getRegistryKey() == ModDimensions.volcanoWorld || entity.getWorld()
                        .getRegistryKey() == ModDimensions.digitalOceanWorld || entity.getWorld()
                        .getRegistryKey() == ModDimensions.frontierWorld;
            }

            public static boolean isWorldLyoko(final @NotNull World level) {
                return level.getRegistryKey() == ModDimensions.forestSectorWorld || level.getRegistryKey() == ModDimensions.carthage || level.getRegistryKey() == ModDimensions.desertSectorWorld || level.getRegistryKey() == ModDimensions.iceSectorWorld
                        || level.getRegistryKey() == ModDimensions.mountainSectorWorld || level.getRegistryKey() == ModDimensions.volcanoWorld || level.getRegistryKey() == ModDimensions.digitalOceanWorld || level.getRegistryKey() == ModDimensions.frontierWorld;


            }

            public static boolean playerInVanilla(final PlayerEntity player) {
                return player.getWorld().getRegistryKey() == World.OVERWORLD || player.getWorld()
                        .getRegistryKey() == World.NETHER || player.getWorld().getRegistryKey() == World.END;
            }

            public static boolean worldIsVanilla(final World level) {
                return level.getRegistryKey() == World.END || level.getRegistryKey() == World.OVERWORLD || level.getRegistryKey() == World.NETHER;
            }

            public static boolean worldIsVanilla(final RegistryKey<World> level) {
                return level == World.END || level == World.OVERWORLD || level == World.NETHER;
            }


        }
        public record HelperMethods()
        {
            public static void outputFluidToAllSides(final World world,final BlockPos pos, final SingleVariantStorage<FluidVariant> variantStorage)
            {
                for(final Direction dir : Direction.values())
                {

                    final Storage<FluidVariant> validStorageVariant = FluidStorage.SIDED.find(world,pos.offset(dir),dir);
                    if(validStorageVariant != null)
                    {
                        try(final Transaction transaction = Transaction.openOuter())
                        {
                            final long extractedAmount = variantStorage.extract(variantStorage.variant,10,transaction);
                            validStorageVariant.insert(variantStorage.variant,extractedAmount,transaction);
                            transaction.commit();
                        }
                    }
                }
            }
            public static void tryUseEnergy(final ItemStack stack, final EnergyStorage storage)
            {
                try(final Transaction transaction = Transaction.openOuter())
                {
                    final SimpleEnergyItem energyItem = (SimpleEnergyItem) stack.getItem();
                    if(energyItem != null)
                    {
                        final long energyItemCurrentEnergy = energyItem.getStoredEnergy(stack);
                        final long energyItemMaxInput = energyItem.getEnergyMaxInput(stack);
                        final long energyMaxCapacity = energyItem.getEnergyCapacity(stack);
                        final long extractedEnergy = storage.extract(energyItemMaxInput,transaction);
                        energyItem.setStoredEnergy(stack, Math.min(energyItemCurrentEnergy + extractedEnergy, energyMaxCapacity));
                        transaction.commit();
                    }
                }
            }
            public static void tryUseEnergy(final ItemStack stack, final EnergyStorage storage,final int energyScalar)
            {
                try(final Transaction transaction = Transaction.openOuter())
                {
                    final SimpleEnergyItem energyItem = (SimpleEnergyItem) stack.getItem();
                    if(energyItem != null)
                    {
                        final long energyItemCurrentEnergy = energyItem.getStoredEnergy(stack);
                        final long energyItemMaxInput = energyItem.getEnergyMaxInput(stack);
                        final long energyMaxCapacity = energyItem.getEnergyCapacity(stack);
                        final long extractedEnergy = storage.extract(energyItemMaxInput / energyScalar,transaction);
                        energyItem.setStoredEnergy(stack, Math.min(energyItemCurrentEnergy + extractedEnergy, energyMaxCapacity));
                        transaction.commit();
                    }
                }

            }

            public static BlockPos getValidPosition(final ServerWorld world, final float validAirHeight)
            {
                return getValidPosition(world,Math.round(validAirHeight));
            }
            public static BlockPos getValidPosition(final ServerWorld world, final float validAirHeight, final Direction direction,final int offset)
            {
                final BlockPos offsetPosition = getValidPosition(world,validAirHeight);
                if(offsetPosition != null)
                {
                    return offsetPosition.offset(direction,offset);
                }
                return null;
            }
            public static BlockPos getValidPosition(final ServerWorld world, final int validAirHeight, final Direction direction,final int offset)
            {
                final BlockPos offsetPosition = getValidPosition(world,validAirHeight);
                if(offsetPosition != null)
                {
                    return offsetPosition.offset(direction,offset);
                }
                return null;
            }
            private static BlockPos getValidPosition(final ServerWorld world, final int validAirHeight) {
                final BlockState digitalLavaDefaultState = ModBlocks.DIGITAL_LAVA_BLOCK.getDefaultState();
                final BlockState digitalOceanDefaultState = ModBlocks.DIGITAL_OCEAN_BLOCK.getDefaultState();
                final Random worldRandom = world.getRandom();
                for(int xPosition = 200; xPosition > -200; --xPosition) {
                    for(int zPosition = 200; zPosition > -200; --zPosition) {
                        for(int h = world.getHeight() >> 1; h > 0; --h) {
                            final BlockPos checkedPosition = new BlockPos(xPosition + worldRandom.nextInt(800),h,zPosition + worldRandom.nextInt(800));
                            final BlockState gottenBlock = world.getBlockState(checkedPosition);
                            final BlockState groundState = world.getBlockState(checkedPosition.down());
                            if(gottenBlock != digitalLavaDefaultState &&
                                    gottenBlock != digitalOceanDefaultState &&
                                    groundState!= Blocks.VOID_AIR.getDefaultState() &&
                                    groundState != Blocks.AIR.getDefaultState()) {
                                int blocksAbove = 0;
                                for(int check = 1; check <= validAirHeight; ++check) {
                                    final BlockState airPosition = world.getBlockState(checkedPosition.up(check));
                                    if(airPosition == Blocks.AIR.getDefaultState() || airPosition == Blocks.VOID_AIR.getDefaultState()) {
                                        blocksAbove++;
                                    }
                                }
                                if(blocksAbove == validAirHeight) {
                                    return checkedPosition;
                                }

                            }

                        }

                    }

                    }
                return null;
            }
        }


    }


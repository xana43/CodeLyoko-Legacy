package com.Ultra_Nerd.CodeLyokoLegacy.util;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.PacketHandlerCommon;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModDimensions;
import com.Ultra_Nerd.CodeLyokoLegacy.util.enums.TranslatedLocale;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.CriterionConditions;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.EnergyStorage;
import team.reborn.energy.api.base.SimpleEnergyItem;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public record MethodUtil() {
    public record ArmorMethods() {
        public static boolean isArmorSlot(final int slot) {
            return slot == EquipmentSlot.CHEST.getEntitySlotId() || slot == EquipmentSlot.LEGS.getEntitySlotId()
                    || slot == EquipmentSlot.FEET.getEntitySlotId() || slot == EquipmentSlot.HEAD.getEntitySlotId();
        }

    }
    public record AdvancementCreation()
    {
        private static final StringBuilder buffer = new StringBuilder();
        private static final Identifier DEFAULT_BACKGROUND = new Identifier("textures/gui/advancements/backgrounds" +
                "/adventure.png");
        public static Advancement create(final Advancement parent,
                final ItemConvertible itemConvertible,
                final Text name,
                final Text description,final AdvancementFrame frameType,
                final boolean showToast,final boolean announceToChat, final boolean hidden,
                final String criteriaName,final CriterionConditions conditions,final String location,
                final Consumer<Advancement> advancementConsumer)
        {
            return Advancement.Builder.create()
                    .parent(parent)
                    .display(itemConvertible,name,description,null,frameType,showToast,
                            announceToChat,hidden).criterion(criteriaName,conditions)
                    .build(advancementConsumer,convertToPath(location));
        }
        private static String convertToPath(final String location)
        {
            buffer.setLength(0);
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

        public static Advancement create(
                final ItemConvertible itemConvertible,
                final Text name,
                final Text description,@Nullable final Identifier background,final AdvancementFrame frameType,
                final boolean showToast,final boolean announceToChat, final boolean hidden,
                final String criteriaName,final CriterionConditions conditions,final String location,
                final Consumer<Advancement> advancementConsumer)
        {
            if(background == null || background.toString().isEmpty())
            {
                return Advancement.Builder.create()
                        .display(itemConvertible,name,description,DEFAULT_BACKGROUND,frameType,showToast,
                                announceToChat,hidden).criterion(criteriaName,conditions)
                        .build(advancementConsumer, convertToPath(location));
            }
            return Advancement.Builder.create()
                    .display(itemConvertible,name,description,background,frameType,showToast,
                            announceToChat,hidden).criterion(criteriaName,conditions)
                    .build(advancementConsumer, convertToPath(location));
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
                    if (!Objects.requireNonNull(blockEntity.getWorld()).isClient) {
                        final PacketByteBuf buf = PacketByteBufs.create();
                        buf.writeBlockPos(blockEntity.getPos());
                        buf.writeLong(getAmount());
                        FluidVariant.of(allowedVariant).toPacket(buf);
                        for (final ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) blockEntity.getWorld(), blockEntity.getPos())) {
                            ServerPlayNetworking.send(player, PacketHandlerCommon.FLUID_UPDATE, buf);
                        }
                    }
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
                    if (!Objects.requireNonNull(blockEntity.getWorld()).isClient) {
                        final PacketByteBuf buf = PacketByteBufs.create();
                        buf.writeBlockPos(blockEntity.getPos());
                        buf.writeLong(getAmount());
                        for (final Fluid fluid : allowedVariant) {
                            FluidVariant.of(fluid).toPacket(buf);
                        }

                        for (final ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) blockEntity.getWorld(), blockEntity.getPos())) {
                            ServerPlayNetworking.send(player, PacketHandlerCommon.FLUID_UPDATE, buf);
                        }

                    }
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
                    if (!Objects.requireNonNull(blockEntity.getWorld()).isClient) {
                        final PacketByteBuf buf = PacketByteBufs.create();
                        buf.writeBlockPos(blockEntity.getPos());
                        buf.writeLong(getAmount());
                        for (final ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) blockEntity.getWorld(), blockEntity.getPos())) {
                            ServerPlayNetworking.send(player, PacketHandlerCommon.FLUID_UPDATE, buf);
                        }
                    }
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
                    if (!blockEntity.getWorld().isClient) {
                        final PacketByteBuf buf = PacketByteBufs.create();
                        buf.writeBlockPos(blockEntity.getPos());
                        buf.writeLong(getAmount());
                        allowedVariant.toPacket(buf);
                        for (final ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) blockEntity.getWorld(), blockEntity.getPos())) {
                            ServerPlayNetworking.send(player, PacketHandlerCommon.FLUID_UPDATE, buf);
                        }
                    }
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
                    if (!Objects.requireNonNull(blockEntity.getWorld()).isClient) {
                        final PacketByteBuf buf = PacketByteBufs.create();
                        buf.writeBlockPos(blockEntity.getPos());
                        buf.writeLong(getAmount());
                        allowedVariant.toPacket(buf);
                        for (final ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) blockEntity.getWorld(), blockEntity.getPos())) {
                            ServerPlayNetworking.send(player, PacketHandlerCommon.FLUID_UPDATE, buf);
                        }

                    }
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
                    if (!Objects.requireNonNull(blockEntity.getWorld()).isClient) {
                        final PacketByteBuf buf = PacketByteBufs.create();
                        buf.writeBlockPos(blockEntity.getPos());
                        buf.writeLong(getAmount());
                        FluidVariant.of(allowedVariant).toPacket(buf);
                        for (final ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) blockEntity.getWorld(), blockEntity.getPos())) {
                            ServerPlayNetworking.send(player, PacketHandlerCommon.FLUID_UPDATE, buf);
                        }

                    }
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
                    return variant.equals(FluidVariant.of(allowedVariant, compound));
                }

                @Override
                protected void onFinalCommit() {
                    blockEntity.markDirty();
                    if (!blockEntity.getWorld().isClient) {
                        final PacketByteBuf buf = PacketByteBufs.create();
                        buf.writeBlockPos(blockEntity.getPos());
                        buf.writeLong(getAmount());
                        FluidVariant.of(allowedVariant, compound).toPacket(buf);
                        for (final ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) blockEntity.getWorld(), blockEntity.getPos())) {
                            ServerPlayNetworking.send(player, PacketHandlerCommon.FLUID_UPDATE, buf);
                        }

                    }
                }
            };
        }
    }
        public record TickConversion() {
            public static int tickToSeconds(final int ticks) {
                return ticks / 20;
            }

            public static int secondsToTicks(final int seconds) {
                return seconds * 20;
            }
        }

        public record DimensionCheck() {

            public static boolean playerNotInVanillaWorld(final @NotNull PlayerEntity player) {
                return player.getWorld().getRegistryKey() == ModDimensions.forestSectorWorld || player.getWorld()
                        .getRegistryKey() == ModDimensions.carthage || player.getWorld()
                        .getRegistryKey() == ModDimensions.desertSectorWorld || player.getWorld()
                        .getRegistryKey() == ModDimensions.iceSectorWorld
                        || player.getWorld().getRegistryKey() == ModDimensions.mountainSectorWorld || player.getWorld()
                        .getRegistryKey() == ModDimensions.volcanoWorld || player.getWorld()
                        .getRegistryKey() == ModDimensions.digitalOceanWorld || player.getWorld()
                        .getRegistryKey() == ModDimensions.frontierWorld;
            }

            public static boolean entityNotInVanillaWorld(final @NotNull Entity entity) {
                return entity.getWorld().getRegistryKey() == ModDimensions.forestSectorWorld || entity.getWorld()
                        .getRegistryKey() == ModDimensions.carthage || entity.getWorld()
                        .getRegistryKey() == ModDimensions.desertSectorWorld || entity.getWorld()
                        .getRegistryKey() == ModDimensions.iceSectorWorld
                        || entity.getWorld().getRegistryKey() == ModDimensions.mountainSectorWorld || entity.getWorld()
                        .getRegistryKey() == ModDimensions.volcanoWorld || entity.getWorld()
                        .getRegistryKey() == ModDimensions.digitalOceanWorld || entity.getWorld()
                        .getRegistryKey() == ModDimensions.frontierWorld;
            }

            public static boolean worldIsNotVanilla(final @NotNull World level) {
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
            
            public static <T> T testLocale(final T englishObject, final T frenchObject)
            {
                final MinecraftClient client = MinecraftClient.getInstance();
                if(client != null && client.getLanguageManager() != null) {
                    if (client.getLanguageManager().getLanguage().equals(TranslatedLocale.EN_US.toString())) {
                        return englishObject;
                    } else if (client.getLanguageManager().getLanguage().equals(TranslatedLocale.FR_FR.toString())) {
                        return frenchObject;
                    }
                }
                return null;
            }
        }


        public record TextUtil() {

            private static final StringVisitable[] pages = new StringVisitable[100];
            private static final Pattern splitPattern = Pattern.compile(">δ<");
            public static StringVisitable[] textArray(@NotNull final String textToDenote) {
                final String[] denoted = splitPattern.split(textToDenote);
                final int length = denoted.length;
                for (int i = 0; i < length; i++) {
                    pages[i] = Text.of(denoted[i]);
                }
                return pages.clone();
            }

            public static int textArrayLengthToPage(final @NotNull StringVisitable[]   formattedTexts) {
                int length = 0;
                    for (final StringVisitable formattedText : formattedTexts) {
                        length++;
                    }
                return length;
            }


        }
    }


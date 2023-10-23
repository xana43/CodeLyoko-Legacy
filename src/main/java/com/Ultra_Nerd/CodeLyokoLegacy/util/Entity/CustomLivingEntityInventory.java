package com.Ultra_Nerd.CodeLyokoLegacy.util.Entity;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Nameable;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.crash.CrashException;
import net.minecraft.util.crash.CrashReport;
import net.minecraft.util.crash.CrashReportSection;

import java.util.Iterator;
import java.util.List;

public final class CustomLivingEntityInventory implements Inventory, Nameable {
    public static final int ITEM_USAGE_COOLDOWN = 5;
    public static final int MAIN_SIZE = 36;
    private static final int HOTBAR_SIZE = 9;
    public static final int OFF_HAND_SLOT = 40;
    public static final int NOT_FOUND = -1;
    public static final int[] ARMOR_SLOTS = new int[]{0, 1, 2, 3};
    public static final int[] HELMET_SLOTS = new int[]{3};
    public final DefaultedList<ItemStack> main;
    public final DefaultedList<ItemStack> armor;
    public final DefaultedList<ItemStack> offHand;
    private final List<DefaultedList<ItemStack>> combinedInventory;
    public int selectedSlot;
    public final LivingEntity entity;
    private int changeCount;

    public CustomLivingEntityInventory(final LivingEntity entity) {
        this.main = DefaultedList.ofSize(36, ItemStack.EMPTY);
        this.armor = DefaultedList.ofSize(4, ItemStack.EMPTY);
        this.offHand = DefaultedList.ofSize(1, ItemStack.EMPTY);
        this.combinedInventory = ImmutableList.of(this.main, this.armor, this.offHand);
        this.entity = entity;
    }

    public ItemStack getMainHandStack() {
        return isValidHotbarIndex(this.selectedSlot) ? this.main.get(this.selectedSlot) : ItemStack.EMPTY;
    }

    public static int getHotbarSize() {
        return 9;
    }

    private boolean canStackAddMore(ItemStack existingStack, ItemStack stack) {
        return !existingStack.isEmpty() && ItemStack.canCombine(existingStack, stack) && existingStack.isStackable() && existingStack.getCount() < existingStack.getMaxCount() && existingStack.getCount() < this.getMaxCountPerStack();
    }

    public int getEmptySlot() {
        for(int i = 0; i < this.main.size(); ++i) {
            if (this.main.get(i).isEmpty()) {
                return i;
            }
        }

        return -1;
    }



    public void swapSlotWithHotbar(int slot) {
        this.selectedSlot = this.getSwappableHotbarSlot();
        ItemStack itemStack = this.main.get(this.selectedSlot);
        this.main.set(this.selectedSlot, this.main.get(slot));
        this.main.set(slot, itemStack);
    }

    public static boolean isValidHotbarIndex(int slot) {
        return slot >= 0 && slot < 9;
    }

    public int getSlotWithStack(ItemStack stack) {
        for(int i = 0; i < this.main.size(); ++i) {
            if (!this.main.get(i).isEmpty() && ItemStack.canCombine(stack, this.main.get(i))) {
                return i;
            }
        }

        return -1;
    }

    public int indexOf(ItemStack stack) {
        for(int i = 0; i < this.main.size(); ++i) {
            ItemStack itemStack = this.main.get(i);
            if (!this.main.get(i).isEmpty() && ItemStack.canCombine(stack, this.main.get(i)) && !this.main.get(i).isDamaged() && !itemStack.hasEnchantments() && !itemStack.hasCustomName()) {
                return i;
            }
        }

        return -1;
    }

    public int getSwappableHotbarSlot() {
        int i;
        int j;
        for(i = 0; i < 9; ++i) {
            j = (this.selectedSlot + i) % 9;
            if (this.main.get(j).isEmpty()) {
                return j;
            }
        }

        for(i = 0; i < 9; ++i) {
            j = (this.selectedSlot + i) % 9;
            if (!this.main.get(j).hasEnchantments()) {
                return j;
            }
        }

        return this.selectedSlot;
    }





    private int addStack(ItemStack stack) {
        int i = this.getOccupiedSlotWithRoomForStack(stack);
        if (i == -1) {
            i = this.getEmptySlot();
        }

        return i == -1 ? stack.getCount() : this.addStack(i, stack);
    }

    private int addStack(int slot, ItemStack stack) {
        Item item = stack.getItem();
        int i = stack.getCount();
        ItemStack itemStack = this.getStack(slot);
        if (itemStack.isEmpty()) {
            itemStack = new ItemStack(item, 0);
            if (stack.hasNbt()) {
                itemStack.setNbt(stack.getNbt().copy());
            }

            this.setStack(slot, itemStack);
        }

        int j = i;
        if (i > itemStack.getMaxCount() - itemStack.getCount()) {
            j = itemStack.getMaxCount() - itemStack.getCount();
        }

        if (j > this.getMaxCountPerStack() - itemStack.getCount()) {
            j = this.getMaxCountPerStack() - itemStack.getCount();
        }

        if (j == 0) {
            return i;
        } else {
            i -= j;
            itemStack.increment(j);
            itemStack.setBobbingAnimationTime(5);
            return i;
        }
    }

    public int getOccupiedSlotWithRoomForStack(ItemStack stack) {
        if (this.canStackAddMore(this.getStack(this.selectedSlot), stack)) {
            return this.selectedSlot;
        } else if (this.canStackAddMore(this.getStack(40), stack)) {
            return 40;
        } else {
            for(int i = 0; i < this.main.size(); ++i) {
                if (this.canStackAddMore(this.main.get(i), stack)) {
                    return i;
                }
            }

            return -1;
        }
    }

    public void updateItems() {

        for (final DefaultedList<ItemStack> itemStacks : this.combinedInventory) {

            for (int i = 0; i < itemStacks.size(); ++i) {
                if (!itemStacks.get(i).isEmpty()) {
                    itemStacks.get(i).inventoryTick(this.entity.getWorld(), this.entity, i, this.selectedSlot == i);
                }
            }
        }

    }

    public boolean insertStack(ItemStack stack) {
        return this.insertStack(-1, stack);
    }

    public boolean insertStack(int slot, ItemStack stack) {
        if (stack.isEmpty()) {
            return false;
        } else {
            try {
                if (stack.isDamaged()) {
                    if (slot == -1) {
                        slot = this.getEmptySlot();
                    }

                    if (slot >= 0) {
                        this.main.set(slot, stack.copyAndEmpty());
                        this.main.get(slot).setBobbingAnimationTime(5);
                        return true;
                    }
                    else {
                        return false;
                    }
                } else {
                    int i;
                    do {
                        i = stack.getCount();
                        if (slot == -1) {
                            stack.setCount(this.addStack(stack));
                        } else {
                            stack.setCount(this.addStack(slot, stack));
                        }
                    } while(!stack.isEmpty() && stack.getCount() < i);


                    return stack.getCount() < i;

                }
            } catch (Throwable var6) {
                CrashReport crashReport = CrashReport.create(var6, "Adding item to inventory");
                CrashReportSection crashReportSection = crashReport.addElement("Item being added");
                crashReportSection.add("Item ID", Item.getRawId(stack.getItem()));
                crashReportSection.add("Item data", stack.getDamage());
                crashReportSection.add("Item name", () -> {
                    return stack.getName().getString();
                });
                throw new CrashException(crashReport);
            }
        }
    }



    public ItemStack removeStack(int slot, int amount) {
        List<ItemStack> list = null;

        DefaultedList defaultedList;
        for(Iterator var4 = this.combinedInventory.iterator(); var4.hasNext(); slot -= defaultedList.size()) {
            defaultedList = (DefaultedList)var4.next();
            if (slot < defaultedList.size()) {
                list = defaultedList;
                break;
            }
        }

        return list != null && !((ItemStack)list.get(slot)).isEmpty() ? Inventories.splitStack(list, slot, amount) : ItemStack.EMPTY;
    }

    public void removeOne(ItemStack stack) {
        Iterator var2 = this.combinedInventory.iterator();

        while(true) {
            while(var2.hasNext()) {
                DefaultedList<ItemStack> defaultedList = (DefaultedList)var2.next();

                for(int i = 0; i < defaultedList.size(); ++i) {
                    if (defaultedList.get(i) == stack) {
                        defaultedList.set(i, ItemStack.EMPTY);
                        break;
                    }
                }
            }

            return;
        }
    }

    public ItemStack removeStack(int slot) {
        DefaultedList<ItemStack> defaultedList = null;

        DefaultedList defaultedList2;
        for(Iterator var3 = this.combinedInventory.iterator(); var3.hasNext(); slot -= defaultedList2.size()) {
            defaultedList2 = (DefaultedList)var3.next();
            if (slot < defaultedList2.size()) {
                defaultedList = defaultedList2;
                break;
            }
        }

        if (defaultedList != null && !defaultedList.get(slot).isEmpty()) {
            ItemStack itemStack = defaultedList.get(slot);
            defaultedList.set(slot, ItemStack.EMPTY);
            return itemStack;
        } else {
            return ItemStack.EMPTY;
        }
    }

    public void setStack(int slot, ItemStack stack) {
        DefaultedList<ItemStack> defaultedList = null;

        DefaultedList defaultedList2;
        for(Iterator var4 = this.combinedInventory.iterator(); var4.hasNext(); slot -= defaultedList2.size()) {
            defaultedList2 = (DefaultedList)var4.next();
            if (slot < defaultedList2.size()) {
                defaultedList = defaultedList2;
                break;
            }
        }

        if (defaultedList != null) {
            defaultedList.set(slot, stack);
        }

    }

    public float getBlockBreakingSpeed(BlockState block) {
        return this.main.get(this.selectedSlot).getMiningSpeedMultiplier(block);
    }

    public NbtList writeNbt(NbtList nbtList) {
        int i;
        NbtCompound nbtCompound;
        for(i = 0; i < this.main.size(); ++i) {
            if (!this.main.get(i).isEmpty()) {
                nbtCompound = new NbtCompound();
                nbtCompound.putByte("Slot", (byte)i);
                this.main.get(i).writeNbt(nbtCompound);
                nbtList.add(nbtCompound);
            }
        }

        for(i = 0; i < this.armor.size(); ++i) {
            if (!this.armor.get(i).isEmpty()) {
                nbtCompound = new NbtCompound();
                nbtCompound.putByte("Slot", (byte)(i + 100));
                this.armor.get(i).writeNbt(nbtCompound);
                nbtList.add(nbtCompound);
            }
        }

        for(i = 0; i < this.offHand.size(); ++i) {
            if (!this.offHand.get(i).isEmpty()) {
                nbtCompound = new NbtCompound();
                nbtCompound.putByte("Slot", (byte)(i + 150));
                this.offHand.get(i).writeNbt(nbtCompound);
                nbtList.add(nbtCompound);
            }
        }

        return nbtList;
    }

    public void readNbt(NbtList nbtList) {
        this.main.clear();
        this.armor.clear();
        this.offHand.clear();

        for(int i = 0; i < nbtList.size(); ++i) {
            NbtCompound nbtCompound = nbtList.getCompound(i);
            int j = nbtCompound.getByte("Slot") & 255;
            ItemStack itemStack = ItemStack.fromNbt(nbtCompound);
            if (!itemStack.isEmpty()) {
                if (j >= 0 && j < this.main.size()) {
                    this.main.set(j, itemStack);
                } else if (j >= 100 && j < this.armor.size() + 100) {
                    this.armor.set(j - 100, itemStack);
                } else if (j >= 150 && j < this.offHand.size() + 150) {
                    this.offHand.set(j - 150, itemStack);
                }
            }
        }

    }

    public int size() {
        return this.main.size() + this.armor.size() + this.offHand.size();
    }

    public boolean isEmpty() {
        Iterator var1 = this.main.iterator();

        ItemStack itemStack;
        do {
            if (!var1.hasNext()) {
                var1 = this.armor.iterator();

                do {
                    if (!var1.hasNext()) {
                        var1 = this.offHand.iterator();

                        do {
                            if (!var1.hasNext()) {
                                return true;
                            }

                            itemStack = (ItemStack)var1.next();
                        } while(itemStack.isEmpty());

                        return false;
                    }

                    itemStack = (ItemStack)var1.next();
                } while(itemStack.isEmpty());

                return false;
            }

            itemStack = (ItemStack)var1.next();
        } while(itemStack.isEmpty());

        return false;
    }

    public ItemStack getStack(int slot) {
        List<ItemStack> list = null;

        DefaultedList defaultedList;
        for(Iterator var3 = this.combinedInventory.iterator(); var3.hasNext(); slot -= defaultedList.size()) {
            defaultedList = (DefaultedList)var3.next();
            if (slot < defaultedList.size()) {
                list = defaultedList;
                break;
            }
        }

        return list == null ? ItemStack.EMPTY : (ItemStack)list.get(slot);
    }

    public Text getName() {
        return Text.translatable("container.inventory");
    }

    public ItemStack getArmorStack(int slot) {
        return (ItemStack)this.armor.get(slot);
    }

    public void damageArmor(DamageSource damageSource, float amount, int[] slots) {
        if (!(amount <= 0.0F)) {
            amount /= 4.0F;
            if (amount < 1.0F) {
                amount = 1.0F;
            }

            int[] var4 = slots;
            int var5 = slots.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                int i = var4[var6];
                ItemStack itemStack = this.armor.get(i);
                if ((!damageSource.isIn(DamageTypeTags.IS_FIRE) || !itemStack.getItem().isFireproof()) && itemStack.getItem() instanceof ArmorItem) {
                    itemStack.damage((int)amount, this.entity, (player) -> {
                        player.sendEquipmentBreakStatus(EquipmentSlot.fromTypeIndex(EquipmentSlot.Type.ARMOR, i));
                    });
                }
            }

        }
    }

    public void dropAll() {

        for (final DefaultedList<ItemStack> itemStacks : this.combinedInventory) {
            List<ItemStack> list =  itemStacks;

            for (int i = 0; i < list.size(); ++i) {
                ItemStack itemStack = list.get(i);
                if (!itemStack.isEmpty()) {
                    this.entity.dropStack(itemStack);
                    list.set(i, ItemStack.EMPTY);
                }
            }
        }

    }

    public void markDirty() {
        ++this.changeCount;
    }

    @Override
    public boolean canPlayerUse(final PlayerEntity player) {
        return false;
    }

    public int getChangeCount() {
        return this.changeCount;
    }



    public boolean contains(ItemStack stack) {

        for (final DefaultedList<ItemStack> itemStacks : this.combinedInventory) {
            List<ItemStack> list = itemStacks;

            for (final ItemStack itemStack : list) {
                if (!itemStack.isEmpty() && ItemStack.canCombine(itemStack, stack)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean contains(TagKey<Item> tag) {

        for (final DefaultedList<ItemStack> itemStacks : this.combinedInventory) {

            for (final ItemStack itemStack : itemStacks) {
                if (!itemStack.isEmpty() && itemStack.isIn(tag)) {
                    return true;
                }
            }
        }

        return false;
    }

    public void clone(PlayerInventory other) {
        for(int i = 0; i < this.size(); ++i) {
            this.setStack(i, other.getStack(i));
        }

        this.selectedSlot = other.selectedSlot;
    }

    public void clear() {

        for (final DefaultedList<ItemStack> itemStacks : this.combinedInventory) {
            ((List<ItemStack>) itemStacks).clear();
        }

    }



    public ItemStack dropSelectedItem(boolean entireStack) {
        ItemStack itemStack = this.getMainHandStack();
        return itemStack.isEmpty() ? ItemStack.EMPTY : this.removeStack(this.selectedSlot, entireStack ? itemStack.getCount() : 1);
    }
}

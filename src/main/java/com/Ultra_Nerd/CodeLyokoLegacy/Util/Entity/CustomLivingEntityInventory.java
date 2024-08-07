package com.Ultra_Nerd.CodeLyokoLegacy.Util.Entity;

import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectLists;
import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
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
        this.combinedInventory = ObjectLists.unmodifiable(ObjectList.of(this.main, this.armor, this.offHand));
        this.entity = entity;
    }

    public ItemStack getMainHandStack() {
        return isValidHotbarIndex(this.selectedSlot) ? this.main.get(this.selectedSlot) : ItemStack.EMPTY;
    }



    private boolean canStackAddMore(ItemStack existingStack, ItemStack stack) {
        return !existingStack.isEmpty() && ItemStack.areItemsEqual(existingStack, stack) && existingStack.isStackable() && existingStack.getCount() < existingStack.getMaxCount() && existingStack.getCount() < this.getMaxCountPerStack();
    }

    public int getEmptySlot() {
        for(int i = 0; i < this.main.size(); ++i) {
            if (this.main.get(i).isEmpty()) {
                return i;
            }
        }

        return -1;
    }


    public static boolean isValidHotbarIndex(int slot) {
        return slot >= 0 && slot < 9;
    }

    public int getSlotWithStack(ItemStack stack) {
        for(int i = 0; i < this.main.size(); ++i) {
            if (!this.main.get(i).isEmpty() && ItemStack.areItemsEqual(stack, this.main.get(i))) {
                return i;
            }
        }

        return -1;
    }

    public int indexOf(ItemStack stack) {
        for(int i = 0; i < this.main.size(); ++i) {
            ItemStack itemStack = (ItemStack)this.main.get(i);
            if (!((ItemStack)this.main.get(i)).isEmpty() && ItemStack.areItemsAndComponentsEqual(stack, (ItemStack)this.main.get(i)) && !((ItemStack)this.main.get(i)).isDamaged() && !itemStack.hasEnchantments() && !itemStack.contains(DataComponentTypes.CUSTOM_NAME)) {
                return i;
            }
        }

        return -1;
    }


    private int addStack(ItemStack stack) {
        int i = this.getOccupiedSlotWithRoomForStack(stack);
        if (i == -1) {
            i = this.getEmptySlot();
        }

        return i == -1 ? stack.getCount() : this.addStack(i, stack);
    }

    private int addStack(int slot, ItemStack stack) {
        int i = stack.getCount();
        ItemStack itemStack = this.getStack(slot);
        if (itemStack.isEmpty()) {
            itemStack = stack.copyWithCount(0);
            this.setStack(slot, itemStack);
        }

        int j = this.getMaxCount(itemStack) - itemStack.getCount();
        int k = Math.min(i, j);
        if (k != 0) {
            i -= k;
            itemStack.increment(k);
            itemStack.setBobbingAnimationTime(5);
        }
        return i;
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
                crashReportSection.add("Item name", () -> stack.getName().getString());
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

        return list != null && !list.get(slot).isEmpty() ? Inventories.splitStack(list, slot, amount) : ItemStack.EMPTY;
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
                this.main.get(i).set(DataComponentTypes.CUSTOM_DATA,NbtComponent.of(nbtCompound));
                nbtList.add(nbtCompound);
            }
        }

        for(i = 0; i < this.armor.size(); ++i) {
            if (!this.armor.get(i).isEmpty()) {
                nbtCompound = new NbtCompound();
                nbtCompound.putByte("Slot", (byte)(i + 100));
                this.armor.get(i).set(DataComponentTypes.CUSTOM_DATA,NbtComponent.of(nbtCompound));
                nbtList.add(nbtCompound);
            }
        }

        for(i = 0; i < this.offHand.size(); ++i) {
            if (!this.offHand.get(i).isEmpty()) {
                nbtCompound = new NbtCompound();
                nbtCompound.putByte("Slot", (byte)(i + 150));
                this.offHand.get(i).set(DataComponentTypes.CUSTOM_DATA,NbtComponent.of(nbtCompound));
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
            ItemStack itemStack = ItemStack.fromNbt(this.entity.getRegistryManager(), nbtCompound).orElse(ItemStack.EMPTY);
            if (j >= 0 && j < this.main.size()) {
                this.main.set(j, itemStack);
            } else if (j >= 100 && j < this.armor.size() + 100) {
                this.armor.set(j - 100, itemStack);
            } else if (j >= 150 && j < this.offHand.size() + 150) {
                this.offHand.set(j - 150, itemStack);
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

        return list == null ? ItemStack.EMPTY : list.get(slot);
    }

    public Text getName() {
        return Text.translatable("container.inventory");
    }

    public ItemStack getArmorStack(int slot) {
        return this.armor.get(slot);
    }



    public void dropAll() {

        for (final DefaultedList<ItemStack> itemStacks : this.combinedInventory) {

            for (int i = 0; i < ((List<ItemStack>) itemStacks).size(); ++i) {
                ItemStack itemStack = ((List<ItemStack>) itemStacks).get(i);
                if (!itemStack.isEmpty()) {
                    this.entity.dropStack(itemStack);
                    ((List<ItemStack>) itemStacks).set(i, ItemStack.EMPTY);
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

            for (final ItemStack itemStack : itemStacks) {
                if (!itemStack.isEmpty() && ItemStack.areItemsAndComponentsEqual(itemStack, stack)) {
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

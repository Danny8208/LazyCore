package danny8208.lazycore.api.container;

import danny8208.lazycore.api.block.tileentity.MachineTE;
import danny8208.lazycore.api.recipe.MachineRecipes;
import danny8208.lazycore.api.slot.SlotMachineFuel;
import danny8208.lazycore.api.slot.SlotMachineOutput;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class MachineContainer extends Container {
    private final MachineTE tileEntity;
    private int cookTime, currentBurnTime, burnTime, totalCookTime;

    public MachineContainer(InventoryPlayer player, MachineTE tileEntity) {
        this.tileEntity = tileEntity;

        this.addSlotToContainer(new Slot(tileEntity, 0, 26, 12));
        this.addSlotToContainer(new Slot(tileEntity, 1, 26, 59));
        this.addSlotToContainer(new SlotMachineFuel(tileEntity, 2, 7, 35));
        this.addSlotToContainer(new SlotMachineOutput(player.player, tileEntity, 3, 10, 20));

        for(int y = 0; y < 3; y++) {
            for(int x = 0; x < 9; x++) {
                this.addSlotToContainer(new Slot(player, x + y * 9 + 9, 8 * x * 18, 84 + y * 18));
            }
        }

        for(int x = 0; x < 9; x++) {
            this.addSlotToContainer(new Slot(player, x, 8 + x * 18, 142));
        }
    }

    @Override
    public void addListener(IContainerListener listener) {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, this.tileEntity);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for(int i = 0; i < this.listeners.size(); i++) {
            IContainerListener listener = (IContainerListener)this.listeners.get(i);

            if(this.cookTime != this.tileEntity.getField(2)) listener.sendWindowProperty(this, 2, this.tileEntity.getField(2));
            if(this.burnTime != this.tileEntity.getField(0)) listener.sendWindowProperty(this, 0, this.tileEntity.getField(0));
            if(this.currentBurnTime != this.tileEntity.getField(1)) listener.sendWindowProperty(this, 1, this.tileEntity.getField(1));
            if(this.totalCookTime != this.tileEntity.getField(3)) listener.sendWindowProperty(this, 3, this.tileEntity.getField(3));
        }

        this.cookTime = this.tileEntity.getField(2);
        this.burnTime = this.tileEntity.getField(0);
        this.currentBurnTime = this.tileEntity.getField(1);
        this.totalCookTime = this.tileEntity.getField(3);
    }

    @Override
    public void updateProgressBar(int id, int data) {
        this.tileEntity.setField(id, data);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return this.tileEntity.isUsableByPlayer(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = (Slot)this.inventorySlots.get(index);

        if(slot != null && slot.getHasStack()) {
            ItemStack stack1 = slot.getStack();
            stack = stack1.copy();

            if(index == 3) {
                if(!this.mergeItemStack(stack1, 4, 40, true)) return ItemStack.EMPTY;
                slot.onSlotChange(stack1, stack);
            }
            else if (index != 2 && index != 1 && index != 0) {
                Slot slot1 = (Slot)this.inventorySlots.get(index + 1);

                if(!MachineRecipes.getInstance().getResult(stack1, slot1.getStack()).isEmpty()) {
                    if(!this.mergeItemStack(stack1, 0, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                    else if(MachineTE.isItemFuel(stack1)) {
                        if(!this.mergeItemStack(stack1, 2, 3, false)) return ItemStack.EMPTY;
                    }
                    else if(MachineTE.isItemFuel(stack1)) {
                        if(!this.mergeItemStack(stack1, 2, 3, false)) return ItemStack.EMPTY;
                    }
                    else if(index >= 4 && index < 31) {
                        if(!this.mergeItemStack(stack1, 31, 40, false)) return ItemStack.EMPTY;
                    }
                    else if(index >= 31 && index < 40 && !this.mergeItemStack(stack1, 4, 31, false)) {
                        return ItemStack.EMPTY;
                    }
                }
                else if(!this.mergeItemStack(stack1, 4, 40, false)) {
                    return ItemStack.EMPTY;
                }
                if(stack1.isEmpty()) {
                    slot.putStack(ItemStack.EMPTY);
                }
                else {
                    slot.putStack(ItemStack.EMPTY);
                }
            }
        }
        return stack;
    }
}

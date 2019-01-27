package danny8208.lazycore.api.block.tileentity;

import danny8208.lazycore.api.block.MachineBase;
import danny8208.lazycore.api.recipe.MachineRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class MachineTE extends TileEntity implements IInventory, ITickable {
    private NonNullList<ItemStack> inventory = NonNullList.<ItemStack>withSize(4, ItemStack.EMPTY);
    private String customName;
    private int burnTime;
    private int currentBrunTime;
    private int cookTime;
    private int totalCookTime;

    @Override
    public String getName() {
        return this.hasCustomName() ? this.customName : "";
    }

    @Override
    public boolean hasCustomName() {
        return this.customName != null && !this.customName.isEmpty();
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    @Nullable
    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
    }

    @Override
    public int getSizeInventory() {
        return this.inventory.size();
    }

    @Override
    public boolean isEmpty() {
        for(ItemStack stack : this.inventory) {
            if(!stack.isEmpty()) return false;
        }
        return true;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return (ItemStack)this.inventory.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.inventory, index, count);
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.inventory, index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        ItemStack itemStack = (ItemStack)this.inventory.get(index);
        boolean flag = !stack.isEmpty() && stack.isItemEqual(itemStack) && ItemStack.areItemsEqual(stack, itemStack);
        this.inventory.set(index, stack);

        if(stack.getCount() > this.getInventoryStackLimit()) stack.setCount(this.getInventoryStackLimit());
        if(index == 0 && index + 1 == 1 && !flag) {
            ItemStack stack1 = (ItemStack)this.inventory.get(index + 1);
            this.totalCookTime = this.getCookTime(stack, stack1);
            this.cookTime = 0;
            this.markDirty();
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.inventory = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.inventory);
        this.burnTime = compound.getInteger("burnTime");
        this.cookTime = compound.getInteger("cookTime");
        this.totalCookTime = compound.getInteger("cookTimeTotal");

        this.currentBrunTime = getItemBurnTime((ItemStack)this.inventory.get(2));

        if(compound.hasKey("customName", 8)) this.setCustomName(compound.getString("customName"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("burnTime", (short)this.burnTime);
        compound.setInteger("cookTime", (short)this.cookTime);
        compound.setInteger("cookBurnTotal", (short)this.totalCookTime);
        ItemStackHelper.loadAllItems(compound, this.inventory);

        if(this.hasCustomName()) compound.setString("customName", this.customName);
        return compound;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    public boolean isBurning() {
        return this.burnTime > 0;
    }

    @SideOnly(Side.CLIENT)
    public static boolean isBurning(IInventory inventory) {
        return inventory.getField(0) > 0;
    }

    @Override
    public void update() {
        boolean flag = this.isBurning();
        boolean flag1 = false;

        if(this.isBurning()) --this.burnTime;

        if(!this.world.isRemote) {
            ItemStack stack = (ItemStack)this.inventory.get(2);

            if(this.isBurning() || !((((ItemStack)this.inventory.get(0)).isEmpty())) || ((ItemStack)this.inventory.get(1)).isEmpty()) {
                if(!this.isBurning() && this.canSmelt()) {
                    this.burnTime = getItemBurnTime(stack);
                    this.currentBrunTime = this.burnTime;

                    if(this.isBurning()) {
                        flag1 = true;

                        if(!stack.isEmpty()) {
                            Item item = stack.getItem();
                            stack.shrink(1);

                            if(stack.isEmpty()) {
                                ItemStack item1 = item.getContainerItem(stack);
                                this.inventory.set(2, item1);
                            }
                        }
                    }
                }
                if(this.isBurning() && this.canSmelt()) {
                    ++cookTime;

                    if(this.cookTime == totalCookTime) {
                        cookTime = 0;
                        this.totalCookTime = this.getCookTime((ItemStack)this.inventory.get(0), (ItemStack)this.inventory.get(1));
                        this.smeltItem();
                        flag1 = true;
                    }
                }
                else this.cookTime = 0;
            }
            else if(!this.isBurning() && this.cookTime > 0) {
                this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, totalCookTime);
            }
            if(flag != this.isBurning()) {
                flag1 = true;
                MachineBase.setState(this.isBurning(), this.world, this.pos);
            }
        }
        if(flag1) {
            this.markDirty();
        }
    }

    public int getCookTime(ItemStack input1, ItemStack input2) {
        return 200;
    }

    private boolean canSmelt() {
        ItemStack result = MachineRecipes.getInstance().getResult((ItemStack)this.inventory.get(0), (ItemStack)this.inventory.get(1));

        if(result.isEmpty()) return false;
        else {
            ItemStack output = (ItemStack)this.inventory.get(3);
            if(output.isEmpty()) return true;
            if(!output.isItemEqual(result)) return false;
            int res = output.getCount() + result.getCount();
            return res <= getInventoryStackLimit() && res <= output.getMaxStackSize();
        }
    }

    public void smeltItem() {
        if(this.canSmelt()) {
            ItemStack input1 = (ItemStack)this.inventory.get(0);
            ItemStack input2 = (ItemStack)this.inventory.get(1);
            ItemStack result = MachineRecipes.getInstance().getInstance().getResult(input1, input2);
            ItemStack output = (ItemStack)this.inventory.get(3);

            if(output.isEmpty()) this.inventory.set(3, result.copy());
            else if(output.getItem() == result.getItem()) output.grow(result.getCount());

            input1.shrink(1);
            input2.shrink(1);
        }
    }

    public static int getItemBurnTime(ItemStack fuel) {
        if(fuel.isEmpty()) return 0;
        else {
            Item item = fuel.getItem();

            if(item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR){
                Block block = Block.getBlockFromItem(item);

                if(block == Blocks.WOODEN_SLAB) return 150;
                if(block.getDefaultState().getMaterial() == Material.WOOD) return 300;
                if(block == Blocks.COAL_BLOCK) return 16000;
            }

            if(item instanceof ItemTool && "WOOD".equals(((ItemTool)item).getToolMaterialName())) return 200;
            if(item instanceof ItemSword && "WOOD".equals(((ItemSword)item).getToolMaterialName())) return 200;
            if(item instanceof ItemHoe && "WOOD".equals(((ItemHoe)item).getMaterialName())) return 200;

            if(item == Items.STICK) return 100;
            if(item == Items.COAL) return 1600;
            if(item == Items.LAVA_BUCKET) return 20000;
            if(item == Item.getItemFromBlock(Blocks.SAPLING)) return 100;
            if(item == Items.BLAZE_ROD) return 2400;

            return GameRegistry.getFuelValue(fuel);
        }
    }

    public static boolean isItemFuel(ItemStack fuel) {
        return getItemBurnTime(fuel) > 0;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return true;
    }

    @Override
    public void openInventory(EntityPlayer player) {}

    @Override
    public void closeInventory(EntityPlayer player) {}

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if(index == 3) return false;
        else if(index == 2) return true;
        else {
            return isItemFuel(stack);
        }
    }

    public String getGuiId() {
        return "modid:machine";
    }

    @Override
    public int getField(int id) {
        switch (id) {
            case 0:
                return this.burnTime;
            case 1:
                return this.currentBrunTime;
            case 2:
                return this.cookTime;
            case 3:
                return this.totalCookTime;
            default:
                return 0;
        }
    }

    @Override
    public void setField(int id, int value) {
        switch (id) {
            case 0:
                this.burnTime = value;
                break;
            case 1:
                this.currentBrunTime = value;
                break;
            case 2:
                this.cookTime = value;
                break;
            case 3:
                this.totalCookTime = value;
        }
    }

    @Override
    public int getFieldCount() {
        return 4;
    }

    @Override
    public void clear() {
        this.inventory.clear();
    }
}

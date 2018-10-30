package danny8208.lazycore.api.item;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;

public class TwoModeBase extends ItemBase {
    public TwoModeBase(String modId, String name, CreativeTabs tab) {
        super(modId, name, tab);
    }

    @Override
    public void registerModel() {
        ModelResourceLocation active = new ModelResourceLocation(this.getRegistryName() + "_active", "inventory");
        ModelResourceLocation inactive = new ModelResourceLocation(this.getRegistryName() + "_inactive", "inventory");
        ModelBakery.registerItemVariants(this, active, inactive);
        ModelLoader.setCustomMeshDefinition(this, new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack) {
                if(isActive(stack)) {
                    return active;
                } else {
                    return inactive;
                }
            }
        });
    }
    public boolean isActive(ItemStack stack) {
        return getTagCompoundSafe(stack).hasKey("active");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack stack = playerIn.getActiveItemStack();
        if(!worldIn.isRemote) {
            if(isActive(stack)) {
                getTagCompoundSafe(stack).removeTag("active");
            } else {
                getTagCompoundSafe(stack).setBoolean("blue", true);
            }
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }

    private NBTTagCompound getTagCompoundSafe(ItemStack stack) {
        NBTTagCompound tagCompound = stack.getTagCompound();
        if(tagCompound == null) {
            tagCompound = new NBTTagCompound();
            stack.setTagCompound(tagCompound);
        }
        return tagCompound;
    }
}

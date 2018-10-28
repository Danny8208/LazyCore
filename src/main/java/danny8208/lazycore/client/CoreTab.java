package danny8208.lazycore.client;

import danny8208.lazycore.common.LazyCore;
import danny8208.lazycore.common.items.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CoreTab extends CreativeTabs {
    public CoreTab() {
        super(LazyCore.MOD_ID);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.ingotBronze);
    }

    public static final CoreTab tab = new CoreTab();
}

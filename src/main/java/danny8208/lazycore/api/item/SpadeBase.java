package danny8208.lazycore.api.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SpadeBase extends ItemSpade {
    public SpadeBase(String modId, String name, CreativeTabs tab, ToolMaterial material) {
        super(material);
        setUnlocalizedName(modId + "." + name);
        setRegistryName(name);
        setCreativeTab(tab);
    }

    @SideOnly(Side.CLIENT)
    public void registerModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(this.getRegistryName(), "inventory"));
    }
}

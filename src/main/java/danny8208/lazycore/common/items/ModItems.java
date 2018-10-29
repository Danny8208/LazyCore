package danny8208.lazycore.common.items;

import danny8208.lazycore.common.LazyCore;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@GameRegistry.ObjectHolder(LazyCore.MOD_ID)
public class ModItems {
    @GameRegistry.ObjectHolder("bronze_ingot")
    public static IngotBronze ingotBronze = new IngotBronze();
    
    @GameRegistry.ObjectHolder("tin_ingot")
    public static IngotTin ingotTin = new IngotTin();
    
    @GameRegistry.ObjectHolder("copper_ingot")
    public static IngotCopper ingotCopper = new IngotCopper();

    @SideOnly(Side.CLIENT)
    public static void registerModels() {
        ingotBronze.registerModel();
        ingotTin.registerModel();
        ingotCopper.registerModel();
    }
}

package danny8208.lazycore.common;

import danny8208.lazycore.common.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

@Mod.EventBusSubscriber
public class CommonProxy {
    public static Configuration config;

    public void preInit(FMLPreInitializationEvent e) {
        File dir = e.getModConfigurationDirectory();
        config = new Configuration(new File(dir.getPath(), LazyCore.MOD_ID + ".cfg"));
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }

    @SubscribeEvent
    public static void initItems(RegistryEvent.Register<Item> event) {
        if(CoreConfig.enableBronzeIngot) event.getRegistry().register(ModItems.ingotBronze);
        if(CoreConfig.enableTinIngot) event.getRegistry().register(ModItems.ingotTin);
        if(CoreConfig.enableCopperIngot) event.getRegistry().register(ModItems.ingotCopper);
        if(CoreConfig.enableSteelIngot) event.getRegistry().register(ModItems.ingotSteel);
        if(CoreConfig.enableTungstenIngot) event.getRegistry().register(ModItems.ingotTungsten);

        if(CoreConfig.enableBronzeNugget) event.getRegistry().register(ModItems.nuggetBronze);
        if(CoreConfig.enableCopperNugget) event.getRegistry().register(ModItems.nuggetCopper);
        if(CoreConfig.enableTinNugget) event.getRegistry().register(ModItems.nuggetTin);
        if(CoreConfig.enableSteelNugget) event.getRegistry().register(ModItems.nuggetSteel);
        if(CoreConfig.enableTungstenNugget) event.getRegistry().register(ModItems.nuggetTungsten);
    }

    @SubscribeEvent
    public static void initBlocks(RegistryEvent.Register<Block> event) {

    }
}

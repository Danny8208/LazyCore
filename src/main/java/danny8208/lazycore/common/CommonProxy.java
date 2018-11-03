package danny8208.lazycore.common;

import danny8208.lazycore.common.block.ModBlocks;
import danny8208.lazycore.common.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
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
        CoreConfig.readConfig();
    }

    public void init(FMLInitializationEvent e) {
        OreDict.nuggetDict();
        OreDict.ingotDict();
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

        if(CoreConfig.enableBronzeBlock) event.getRegistry().register(new ItemBlock(ModBlocks.blockBronze).setRegistryName(ModBlocks.blockBronze.getRegistryName()));
        if(CoreConfig.enableTinBlock) event.getRegistry().register(new ItemBlock(ModBlocks.blockTin).setRegistryName(ModBlocks.blockTin.getRegistryName()));
        if(CoreConfig.enableCopperBlock) event.getRegistry().register(new ItemBlock(ModBlocks.blockCopper).setRegistryName(ModBlocks.blockCopper.getRegistryName()));
        if(CoreConfig.enableSteelBlock) event.getRegistry().register(new ItemBlock(ModBlocks.blockSteel).setRegistryName(ModBlocks.blockSteel.getRegistryName()));
        if(CoreConfig.enableTungstenBlock) event.getRegistry().register(new ItemBlock(ModBlocks.blockTungsten).setRegistryName(ModBlocks.blockTungsten.getRegistryName()));

        if(CoreConfig.enableCopperOre) event.getRegistry().register(new ItemBlock(ModBlocks.oreCopper).setRegistryName(ModBlocks.oreCopper.getRegistryName()));
        if(CoreConfig.enableTinOre) event.getRegistry().register(new ItemBlock(ModBlocks.oreTin).setRegistryName(ModBlocks.oreTin.getRegistryName()));
        if(CoreConfig.enableTungstenOre) event.getRegistry().register(new ItemBlock(ModBlocks.oreTungsten).setRegistryName(ModBlocks.oreTungsten.getRegistryName()));
    }

    @SubscribeEvent
    public static void initBlocks(RegistryEvent.Register<Block> event) {
        if(CoreConfig.enableBronzeBlock) event.getRegistry().register(ModBlocks.blockBronze);
        if(CoreConfig.enableTinBlock) event.getRegistry().register(ModBlocks.blockTin);
        if(CoreConfig.enableCopperBlock) event.getRegistry().register(ModBlocks.blockCopper);
        if(CoreConfig.enableSteelBlock) event.getRegistry().register(ModBlocks.blockSteel);
        if(CoreConfig.enableTungstenBlock) event.getRegistry().register(ModBlocks.blockTungsten);

        if(CoreConfig.enableCopperOre) event.getRegistry().register(ModBlocks.oreCopper);
        if(CoreConfig.enableTinOre) event.getRegistry().register(ModBlocks.oreTin);
        if(CoreConfig.enableTungstenOre) event.getRegistry().register(ModBlocks.oreTungsten);
    }
}

package danny8208.lazycore.client;

import danny8208.lazycore.common.CommonProxy;
import danny8208.lazycore.common.block.ModBlocks;
import danny8208.lazycore.common.items.ModItems;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @SubscribeEvent
    public static void initModels(ModelRegistryEvent event) {
        ModItems.registerModels();
        ModBlocks.registerModels();
    }
}

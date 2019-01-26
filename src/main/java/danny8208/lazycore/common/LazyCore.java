package danny8208.lazycore.common;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = LazyCore.MOD_ID,
        name = LazyCore.NAME,
        version = LazyCore.VERSION,
        dependencies = "required:forge@[" + LazyCore.FORGE + ",);"
)
public class LazyCore {
    public static final String MOD_ID = "lazycore";
    public static final String NAME = "LazyCore";
    public static final String VERSION = "1.0";
    public static final String FORGE = "14.23.5.2808";
    public static Logger logger;

    @Mod.Instance
    public static LazyCore instance;


    @SidedProxy(
            serverSide = "danny8208.lazycore.common.CommonProxy",
            clientSide = "danny8208.lazycore.client.ClientProxy"
    )
    public static CommonProxy proxy;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}

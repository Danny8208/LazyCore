package danny8208.lazycore.common;

import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

public class CoreConfig {
    public static boolean enableBronzeIngot = true;
    public static boolean enableTinIngot = true;
    public static boolean enableCopperIngot = true;
    public static boolean enableTungstenIngot = true;
    public static boolean enableSteelIngot = true;
    
    public static boolean enableBronzeNugget = true;
    public static boolean enableTinNugget = true;
    public static boolean enableCopperNugget = true;
    public static boolean enableTungstenNugget = true;
    public static boolean enableSteelNugget = true;
    
    public static boolean enableBronzeBlock = true;
    public static boolean enableTinBlock = true;
    public static boolean enableCopperBlock = true;
    public static boolean enableTungstenBlock = true;
    public static boolean enableSteelBlock = true;
    
    public static boolean enableCopperOre = true;
    public static boolean enableTinOre = true;
    public static boolean enableTungstenOre = true;

    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
        }   catch (Exception e1) {
            LazyCore.logger.log(Level.ERROR, "Problem with loading config file");
        } finally {
            if(cfg.hasChanged()) {
                cfg.load();
            }
        }
    }

    private static void enableItems(Configuration cfg) {}
}

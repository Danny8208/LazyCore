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

    public static float hardnessCopperOre = 3;
    public static float hardnessTinOre = 3;
    public static float hardnessTungstenOre = 3;

    public static float hardnessCopperBlock = 5;
    public static float hardnessTinBlock = 5;
    public static float hardnessBronzeBlock = 5;
    public static float hardnessSteelBlock = 5;
    public static float hardnessTungstenBlock = 5;

    public static float resistanceCopperOre = 15;
    public static float resistanceTinOre = 15;
    public static float resistanceTungstenOre = 15;

    public static float resistanceCopperBlock = 30;
    public static float resistanceTinBlock = 30;
    public static float resistanceBronzeBlock = 30;
    public static float resistanceSteelBlock = 30;
    public static float resistanceTungstenBlock = 30;

    public static int maxYCopper = 70;

    public static int minYCopper = 10;

    public static int chancesCopper = 10;

    public static int maxClumpCopper = 10;

    public static int minClumpCopper = 1;

    public static boolean enableCopperOreGen = true;

    public static int weightCopper = 3;

    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            enableItems(cfg);
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

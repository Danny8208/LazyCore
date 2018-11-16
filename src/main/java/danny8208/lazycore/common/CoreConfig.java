package danny8208.lazycore.common;

import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

public class CoreConfig {
    private static final String COMMENT_ENABLE = "Set to true in order to enable this";
    private static final String COMMENT_RESISTANCE = "The resistance of the block. You should only change if you feel like it";
    private static final String COMMENT_HARDNESS = "The hardness of the block. You should only change if you feel like it";
    private static final String COMMENT_WEIGHT = "The weight of the ore, or where it is most commonly found";

    private static final String CATEGORY_ENABLE_ITEMS = "item enable";
    private static final String CATEGORY_ENABLE_BLOCKS = "block enable";
    private static final String CATEGORY_ENABLE_ORES = "ore enable";
    private static final String CATEGORY_ENABLE_ORE_GEN = "ore gen enable";

    private static final String CATEGORY_HARDNESS_BLOCKS = "block hardness";
    private static final String CATEGORY_HARDNESS_ORES = "ore hardness";

    private static final String CATEGORY_RESISTANCE_BLOCKS = "block resistance";
    private static final String CATEGORY_RESISTANCE_ORES = "ore resistance";

    private static final String CATEGORY_WEIGHT_ORES = "ore weight";

    private static final int MIN_WEIGHT = 1;

    private static final int MAX_WEIGHT = 6;

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
    public static int maxYTin = 20;
    public static int maxYTungsten = 0;

    public static int minYCopper = 10;
    public static int minYTin = 55;
    public static int minYTungsten = 0;

    public static int chancesCopper = 10;
    public static int chancesTin = 5;
    public static int chancesTungsten = 0;

    public static int maxClumpCopper = 10;
    public static int maxClumpTin = 7;
    public static int maxClumpTungsten = 0;

    public static int minClumpCopper = 1;
    public static int minClumpTin = 1;
    public static int minClumpTungsten = 0;

    public static boolean enableCopperOreGen = true;
    public static boolean enableTinOreGen = true;
    public static boolean enableTungstenOreGen = false;

    public static int weightCopper = 3;
    public static int weightTin = 2;
    public static int weightTungsten = 0;

    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            enableItems(cfg);
            enableBlocks(cfg);
            enableOres(cfg);
            enableOreGen(cfg);
            hardnessBlocks(cfg);
            hardnessOre(cfg);
            resistanceBlocks(cfg);
            resistanceOre(cfg);
            oreWeight(cfg);
        }   catch (Exception e1) {
            LazyCore.logger.log(Level.ERROR, "Problem with loading config file");
        } finally {
            if(cfg.hasChanged()) {
                cfg.load();
            }
        }
    }

    private static void enableItems(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_ENABLE_ITEMS, COMMENT_ENABLE);
    }
    private static void enableBlocks(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_ENABLE_BLOCKS, COMMENT_ENABLE);
    }
    private static void enableOres(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_ENABLE_ORES, COMMENT_ENABLE);
    }
    private static void enableOreGen(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_ENABLE_ORE_GEN, COMMENT_ENABLE);
    }

    private static void hardnessBlocks(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_HARDNESS_BLOCKS, COMMENT_HARDNESS);
    }
    private static void hardnessOre(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_HARDNESS_ORES, COMMENT_HARDNESS);
    }

    private static void resistanceBlocks(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_RESISTANCE_BLOCKS, COMMENT_RESISTANCE);
    }
    private static void resistanceOre(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_RESISTANCE_ORES, COMMENT_RESISTANCE);
    }

    private static void oreWeight(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_WEIGHT_ORES, "where you can change the weight of ores that generate");
        weightCopper = cfg.getInt("copper weight", CATEGORY_WEIGHT_ORES, weightCopper, MIN_WEIGHT, MAX_WEIGHT, COMMENT_WEIGHT);
        weightTin = cfg.getInt("tin weight", CATEGORY_WEIGHT_ORES, weightTin, MIN_WEIGHT, MAX_WEIGHT, COMMENT_WEIGHT);
    }
}

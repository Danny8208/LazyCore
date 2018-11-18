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
    public static int maxYTin = 55;
    public static int maxYTungsten = 0;

    public static int minYCopper = 10;
    public static int minYTin = 20;
    public static int minYTungsten = 0;

    public static int chancesCopper = 10;
    public static int chancesTin = 1;
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
    public static int weightTungsten = 1;

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
            LazyCore.logger.log(Level.ERROR, "Problem with loading config file", e1);
        } finally {
            if(cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void enableItems(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_ENABLE_ITEMS, "where you can enable items");
        enableCopperIngot = cfg.getBoolean("copper ingot", CATEGORY_ENABLE_ITEMS, enableCopperIngot, COMMENT_ENABLE);
        enableTinIngot = cfg.getBoolean("tin ingot", CATEGORY_ENABLE_ITEMS, enableTinIngot, COMMENT_ENABLE);
        enableBronzeIngot = cfg.getBoolean("bronze ingot", CATEGORY_ENABLE_ITEMS, enableBronzeIngot, COMMENT_ENABLE);
        enableSteelIngot = cfg.getBoolean("steel ingot", CATEGORY_ENABLE_ITEMS, enableSteelIngot, COMMENT_ENABLE);
        enableTungstenIngot = cfg.getBoolean("tungsten ingot", CATEGORY_ENABLE_ITEMS, enableTungstenIngot, COMMENT_ENABLE);

        enableCopperNugget = cfg.getBoolean("copper nugget", CATEGORY_ENABLE_ITEMS, enableCopperNugget, COMMENT_ENABLE);
        enableTinNugget = cfg.getBoolean("tin nugget", CATEGORY_ENABLE_ITEMS, enableTinNugget, COMMENT_ENABLE);
        enableBronzeNugget = cfg.getBoolean("bronze nugget", CATEGORY_ENABLE_ITEMS, enableCopperIngot, COMMENT_ENABLE);
        enableSteelNugget = cfg.getBoolean("steel nugget", CATEGORY_ENABLE_ITEMS, enableSteelNugget, COMMENT_ENABLE);
        enableTungstenNugget = cfg.getBoolean("tungsten nugget", CATEGORY_ENABLE_ITEMS, enableTungstenNugget, COMMENT_ENABLE);
    }
    private static void enableBlocks(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_ENABLE_BLOCKS, "where you can enable blocks");
        enableCopperBlock = cfg.getBoolean("copper block", CATEGORY_ENABLE_BLOCKS, enableCopperBlock, COMMENT_ENABLE);
        enableTinBlock = cfg.getBoolean("tin block", CATEGORY_ENABLE_BLOCKS, enableTinBlock, COMMENT_ENABLE);
        enableBronzeBlock = cfg.getBoolean("bronze block", CATEGORY_ENABLE_BLOCKS, enableBronzeBlock, COMMENT_ENABLE);
        enableSteelBlock = cfg.getBoolean("steel block", CATEGORY_ENABLE_BLOCKS, enableSteelBlock, COMMENT_ENABLE);
        enableTungstenBlock = cfg.getBoolean("tungsten block", CATEGORY_ENABLE_BLOCKS, enableTungstenBlock, COMMENT_ENABLE);
    }
    private static void enableOres(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_ENABLE_ORES, "where you can enable ores");
        enableCopperOre = cfg.getBoolean("copper ore", CATEGORY_ENABLE_ORES, enableCopperOre, COMMENT_ENABLE);
        enableTinOre = cfg.getBoolean("tin ore", CATEGORY_ENABLE_ORES, enableTinOre, COMMENT_ENABLE);
        enableTungstenOre = cfg.getBoolean("tungsten ore", CATEGORY_ENABLE_ORES, enableTungstenOre, COMMENT_ENABLE);
    }
    private static void enableOreGen(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_ENABLE_ORE_GEN, "where you can enable ore gen");
        enableCopperOreGen = cfg.getBoolean("copper ore gen", CATEGORY_ENABLE_ORE_GEN, enableCopperOreGen, COMMENT_ENABLE);
        enableTinOreGen = cfg.getBoolean("tin ore gen", CATEGORY_ENABLE_ORE_GEN, enableTinOreGen, COMMENT_ENABLE);
        enableTungstenOreGen = cfg.getBoolean("tungsten ore gen", CATEGORY_ENABLE_ORE_GEN, enableTungstenOreGen, COMMENT_ENABLE);
    }

    private static void hardnessBlocks(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_HARDNESS_BLOCKS, "where you can change hardness of blocks");
        hardnessCopperBlock = cfg.getFloat("copper block hardness", CATEGORY_HARDNESS_BLOCKS, hardnessCopperBlock, Integer.MIN_VALUE, Integer.MAX_VALUE, COMMENT_HARDNESS);
        hardnessTinBlock = cfg.getFloat("tin block hardness", CATEGORY_HARDNESS_BLOCKS, hardnessTinBlock, Integer.MIN_VALUE, Integer.MAX_VALUE, COMMENT_HARDNESS);
        hardnessBronzeBlock = cfg.getFloat("bronze block hardness", CATEGORY_HARDNESS_BLOCKS, hardnessBronzeBlock, Integer.MIN_VALUE, Integer.MAX_VALUE, COMMENT_HARDNESS);
        hardnessSteelBlock = cfg.getFloat("steel block hardness", CATEGORY_HARDNESS_BLOCKS, hardnessSteelBlock, Integer.MIN_VALUE, Integer.MAX_VALUE, COMMENT_HARDNESS);
        hardnessTungstenBlock = cfg.getFloat("tungsten block hardness", CATEGORY_HARDNESS_BLOCKS, hardnessTungstenBlock, Integer.MIN_VALUE, Integer.MAX_VALUE, COMMENT_HARDNESS);
    }
    private static void hardnessOre(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_HARDNESS_ORES, "where you can change hardness of ores");
        hardnessCopperOre = cfg.getFloat("copper ore hardness", CATEGORY_HARDNESS_ORES, hardnessCopperOre, Integer.MIN_VALUE, Integer.MAX_VALUE, COMMENT_HARDNESS);
        hardnessTinOre = cfg.getFloat("tin ore hardness", CATEGORY_HARDNESS_ORES, hardnessTinOre, Integer.MIN_VALUE, Integer.MAX_VALUE, COMMENT_HARDNESS);
        hardnessTungstenOre = cfg.getFloat("tungsten ore hardness", CATEGORY_HARDNESS_ORES, hardnessTungstenOre, Integer.MIN_VALUE, Integer.MAX_VALUE, COMMENT_HARDNESS);
    }

    private static void resistanceBlocks(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_RESISTANCE_BLOCKS, "where you can change resistance of blocks");
        resistanceCopperBlock = cfg.getFloat("copper ore resistance", CATEGORY_RESISTANCE_BLOCKS, resistanceCopperBlock, Integer.MIN_VALUE, Integer.MAX_VALUE, COMMENT_RESISTANCE);
        resistanceTinBlock = cfg.getFloat("tin block resistance", CATEGORY_RESISTANCE_BLOCKS, resistanceTinBlock, Integer.MIN_VALUE, Integer.MAX_VALUE, COMMENT_RESISTANCE);
        resistanceBronzeBlock = cfg.getFloat("bronze block resistance", CATEGORY_RESISTANCE_BLOCKS, resistanceBronzeBlock, Integer.MIN_VALUE, Integer.MAX_VALUE, COMMENT_RESISTANCE);
        resistanceSteelBlock = cfg.getFloat("steel block resistance", CATEGORY_RESISTANCE_BLOCKS, resistanceSteelBlock, Integer.MIN_VALUE, Integer.MAX_VALUE, COMMENT_RESISTANCE);
        resistanceTungstenBlock = cfg.getFloat("tungsten block resistance", CATEGORY_RESISTANCE_BLOCKS, resistanceTungstenBlock, Integer.MIN_VALUE, Integer.MAX_VALUE, COMMENT_RESISTANCE);
    }
    private static void resistanceOre(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_RESISTANCE_ORES, "where you can change resistance of ores");
        resistanceCopperOre = cfg.getFloat("copper ore resistance", CATEGORY_RESISTANCE_ORES, resistanceCopperOre, Integer.MIN_VALUE, Integer.MAX_VALUE, COMMENT_RESISTANCE);
        resistanceTinOre = cfg.getFloat("tin ore resistance", CATEGORY_RESISTANCE_ORES, resistanceTinOre, Integer.MIN_VALUE, Integer.MAX_VALUE, COMMENT_RESISTANCE);
        resistanceTungstenOre = cfg.getFloat("tungsten ore resistance", CATEGORY_RESISTANCE_ORES, resistanceTungstenOre, Integer.MIN_VALUE, Integer.MAX_VALUE, COMMENT_RESISTANCE);

    }

    private static void oreWeight(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_WEIGHT_ORES, "where you can change the weight of ores that generate");
        weightCopper = cfg.getInt("copper ore weight", CATEGORY_WEIGHT_ORES, weightCopper, MIN_WEIGHT, MAX_WEIGHT, COMMENT_WEIGHT);
        weightTin = cfg.getInt("tin ore weight", CATEGORY_WEIGHT_ORES, weightTin, MIN_WEIGHT, MAX_WEIGHT, COMMENT_WEIGHT);
        weightTungsten = cfg.getInt("tungsten ore weight", CATEGORY_WEIGHT_ORES, weightTungsten, MIN_WEIGHT, MAX_WEIGHT, COMMENT_WEIGHT);
    }
}

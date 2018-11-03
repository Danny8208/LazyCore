package danny8208.lazycore.common;

import danny8208.lazycore.common.items.ModItems;
import net.minecraftforge.oredict.OreDictionary;

public class OreDict {
    public static void ingotDict() {
        OreDictionary.registerOre("ingotBronze", ModItems.ingotBronze);
        OreDictionary.registerOre("ingotCopper", ModItems.ingotCopper);
        OreDictionary.registerOre("ingotTin", ModItems.ingotTin);
        OreDictionary.registerOre("ingotSteel", ModItems.ingotSteel);
        OreDictionary.registerOre("ingotTungsten", ModItems.ingotTungsten);
    }

    public static void nuggetDict() {
        OreDictionary.registerOre("nuggetBronze", ModItems.nuggetBronze);
        OreDictionary.registerOre("nuggetCopper", ModItems.nuggetCopper);
        OreDictionary.registerOre("nuggetTin", ModItems.nuggetTin);
        OreDictionary.registerOre("nuggetSteel", ModItems.nuggetSteel);
        OreDictionary.registerOre("nuggetTungsten", ModItems.nuggetTungsten);
    }
}

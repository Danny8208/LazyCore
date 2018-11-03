package danny8208.lazycore.common.block;

import danny8208.lazycore.common.LazyCore;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(LazyCore.MOD_ID)
public class ModBlocks {
    @GameRegistry.ObjectHolder("bronze_block")
    public static BlockBronze blockBronze = new BlockBronze();

    @GameRegistry.ObjectHolder("copper_block")
    public static BlockCopper blockCopper = new BlockCopper();

    @GameRegistry.ObjectHolder("tin_block")
    public static BlockTin blockTin = new BlockTin();

    @GameRegistry.ObjectHolder("steel_block")
    public static BlockSteel blockSteel = new BlockSteel();

    @GameRegistry.ObjectHolder("tungsten_block")
    public static BlockTungsten blockTungsten = new BlockTungsten();

    @GameRegistry.ObjectHolder("copper_ore")
    public static OreCopper oreCopper = new OreCopper();

    @GameRegistry.ObjectHolder("tin_ore")
    public static OreTin oreTin = new OreTin();

    @GameRegistry.ObjectHolder("tungsten_ore")
    public static OreTungsten oreTungsten = new OreTungsten();

    public static void registerModels() {
        blockBronze.registerModel();
        blockCopper.registerModel();
        blockTin.registerModel();
        blockSteel.registerModel();
        blockTungsten.registerModel();

        oreCopper.registerModel();
        oreTin.registerModel();
        oreTungsten.registerModel();
    }
}

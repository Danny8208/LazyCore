package danny8208.lazycore.common.block;

import danny8208.lazycore.api.block.BlockBase;
import danny8208.lazycore.client.CoreTab;
import danny8208.lazycore.common.CoreConfig;
import danny8208.lazycore.common.LazyCore;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class OreCopper extends BlockBase {
    public OreCopper() {
        super(LazyCore.MOD_ID, "copper_ore", CoreTab.tab, Material.ROCK);
        setSoundType(SoundType.STONE);
        setResistance(CoreConfig.resistanceCopperOre);
        setHardness(CoreConfig.hardnessCopperOre);
    }
}

package danny8208.lazycore.common.blocks;

import danny8208.lazycore.api.block.BlockBase;
import danny8208.lazycore.client.CoreTab;
import danny8208.lazycore.common.CoreConfig;
import danny8208.lazycore.common.LazyCore;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockBronze extends BlockBase {
    public BlockBronze() {
        super(LazyCore.MOD_ID, "bronze_block", CoreTab.tab, Material.ROCK);
        setSoundType(SoundType.STONE);
        setResistance(CoreConfig.resistanceBronzeBlock);
        setHardness(CoreConfig.hardnessBronzeBlock);
    }
}

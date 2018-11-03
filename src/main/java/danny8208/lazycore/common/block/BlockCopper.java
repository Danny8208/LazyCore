package danny8208.lazycore.common.block;

import danny8208.lazycore.api.block.BlockBase;
import danny8208.lazycore.client.CoreTab;
import danny8208.lazycore.common.CoreConfig;
import danny8208.lazycore.common.LazyCore;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockCopper extends BlockBase {
    public BlockCopper() {
        super(LazyCore.MOD_ID, "copper_block", CoreTab.tab, Material.ROCK);
        setSoundType(SoundType.STONE);
        setResistance(CoreConfig.resistanceCopperBlock);
        setHardness(CoreConfig.hardnessCopperBlock);
    }
}

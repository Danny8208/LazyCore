package danny8208.lazycore.common.block;

import danny8208.lazycore.api.block.BlockBase;
import danny8208.lazycore.client.CoreTab;
import danny8208.lazycore.common.CoreConfig;
import danny8208.lazycore.common.LazyCore;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockTungsten extends BlockBase {
    public BlockTungsten() {
        super(LazyCore.MOD_ID, "tungsten_block", CoreTab.tab, Material.ROCK);
        setSoundType(SoundType.STONE);
        setResistance(CoreConfig.resistanceTungstenBlock);
        setHardness(CoreConfig.hardnessTungstenBlock);
    }
}

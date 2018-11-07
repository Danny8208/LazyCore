package danny8208.lazycore.common.world;

import danny8208.lazycore.api.world.CustomOreGen;
import danny8208.lazycore.common.CoreConfig;
import danny8208.lazycore.common.block.ModBlocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;

import java.util.Random;

public class CopperGen extends CustomOreGen {
    @Override
    protected void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        generateOre(ModBlocks.oreCopper.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, CoreConfig.minYCopper, CoreConfig.maxYCopper, CoreConfig.minClumpCopper + random.nextInt(CoreConfig.maxClumpCopper - CoreConfig.minClumpCopper), CoreConfig.chancesCopper);
    }
}

package danny8208.lazycore.api.block.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class TickSpeedTE extends TileEntity implements ITickable {
    private boolean canWork;
    private boolean wait;
    private int range;
    private int tickWait;

    public TickSpeedTE(boolean canWork, boolean wait, int range, int tickWait) {
        this.canWork = canWork;
        this.wait = wait;
        this.range = range + 1;
        this.tickWait = tickWait;
    }

    @Override
    public void update() {
        if (world.isRemote) return;
        if (canWork && !wait) {
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            Block block;

            for (int x2 = x - range; x2 <= x + range; x2++) {
                for (int z2 = z - range; z2 <= z + range; z2++) {
                    for (int y2 = y - 2; y2 < y + 2; y2++) {
                        BlockPos targetPos = new BlockPos(new Vec3d(x2, y2, z2));
                        IBlockState targetBlockState = world.getBlockState(targetPos);
                        block = targetBlockState.getBlock();

                        if (block != null) {
                            block.updateTick(world, targetPos, targetBlockState, world.rand);
                            block = null;
                        }
                    }
                }
            }
        }
        if(canWork && wait) {
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            int curWaitTick = 0;
            Block block;

            for (int x2 = x - range; x2 <= x + range; x2++) {
                for (int z2 = z - range; z2 <= z + range; z2++) {
                    for (int y2 = y - 2; y2 < y + 2; y2++) {
                        BlockPos targetPos = new BlockPos(new Vec3d(x2, y2, z2));
                        IBlockState targetBlockState = world.getBlockState(targetPos);
                        block = targetBlockState.getBlock();

                        if (curWaitTick == tickWait) {
                            block.updateTick(world, targetPos, targetBlockState, world.rand);
                        } else {
                            curWaitTick++;
                        }
                    }
                }
            }
        }
    }
}

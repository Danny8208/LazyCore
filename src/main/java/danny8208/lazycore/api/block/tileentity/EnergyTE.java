package danny8208.lazycore.api.block.tileentity;

import danny8208.lazycore.api.energy.EnergyStorageBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;

import javax.annotation.Nullable;

public class EnergyTE extends TileEntity implements ITickable {
    private int energy;
    private int extract;
    private int receive;
    private EnergyStorageBase storage = new EnergyStorageBase(energy);

    public EnergyTE(int maxStorage, int maxExtract, int maxReceive) {
        this.energy = maxStorage;
        this.extract = maxExtract;
        this.receive = maxReceive;
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        if(capability == CapabilityEnergy.ENERGY) return (T)this.storage;
        return super.getCapability(capability, facing);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        if(capability== CapabilityEnergy.ENERGY) return true;
        else return super.hasCapability(capability, facing);
    }

    @Override
    public void update() {
        this.storage.receiveEnergy(receive, false);
        this.storage.extractEnergy(extract, false);
    }

}

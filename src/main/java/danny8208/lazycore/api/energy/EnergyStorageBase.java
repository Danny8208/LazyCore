package danny8208.lazycore.api.energy;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.energy.EnergyStorage;

public class EnergyStorageBase extends EnergyStorage {
    public EnergyStorageBase(int capacity) {
        super(capacity, capacity, capacity, 0);
    }

    public EnergyStorageBase(int capacity, int maxTransfer) {
        super(capacity, maxTransfer, maxTransfer, 0);
    }

    public EnergyStorageBase(int capacity, int maxReceive, int maxExtract) {
        super(capacity, maxReceive, maxExtract);
    }

    public EnergyStorageBase(int capacity, int maxReceive, int maxExtract, int energy) {
        super(capacity, maxReceive, maxExtract, energy);
    }
        @Override
        public int receiveEnergy(int maxReceive, boolean simulate) {
            return super.receiveEnergy(maxReceive, simulate);
        }

        @Override
        public int extractEnergy(int maxExtract, boolean simulate) {
            return super.extractEnergy(maxExtract, simulate);
        }

        @Override
        public int getEnergyStored() {
            return super.getEnergyStored();
        }

        @Override
        public int getMaxEnergyStored() {
            return super.getMaxEnergyStored();
        }

        @Override
        public boolean canExtract() {
            return super.canExtract();
        }

        @Override
        public boolean canReceive() {
            return super.canReceive();
        }

        public void readFromNBT(NBTTagCompound compound) {
            this.energy = compound.getInteger("Energy");
            this.capacity = compound.getInteger("Capacity");
            this.maxExtract = compound.getInteger("MaxExtract");
            this.maxReceive = compound.getInteger("MaxReceive");
        }

        public void writeToNBT(NBTTagCompound compound) {
            compound.setInteger("Energy", this.energy);
            compound.setInteger("Capacity", this.capacity);
            compound.setInteger("MaxExtract", this.maxExtract);
            compound.setInteger("MaxReceive", this.maxReceive);
        }
}

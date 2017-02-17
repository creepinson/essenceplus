package me.creepinson.entities;
import me.creepinson.handlers.BlockHandler;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
public class TileEntityMobChamberStructure extends TileEntity
{
	public int xCoord;
	public int yCoord;
	public int zCoord;

public boolean checkMultiBlockForm() {
    int i = 0;
    // Scan a 3x3x3 area, starting with the bottom left corner
    for (int x = xCoord - 1; x < xCoord + 2; x++)
        for (int y = yCoord; y < yCoord + 3; y++)
            for (int z = zCoord - 1; z < zCoord + 2; z++) {
            	BlockPos pos = new BlockPos(x, y, z);
                 TileEntity tile = worldObj.getTileEntity(pos);
                 // Make sure tile isn't null, is an instance of the same Tile, and isn't already a part of a multiblock
                 if (tile != null && (tile instanceof TileEntityMobChamberStructure)) {
                     if (this.isMaster()) {
                         if (((TileEntityMobChamberStructure)tile).hasMaster())
                             i++;
                     } else if (!((TileEntityMobChamberStructure)tile).hasMaster())
                         i++;
                 }
             }
    BlockPos center = new BlockPos(xCoord, yCoord + 1, zCoord); 
    // check if there are 26 blocks present ((3*3*3) - 1) and check that center block is empty
     return i > 25 && worldObj.getBlockState(center) == BlockHandler.BlockMobChamberCore;
}
	    private boolean hasMaster, isMaster;
	    private int masterX, masterY, masterZ;
	    public void setupStructure() {
	        for (int x = xCoord - 1; x < xCoord + 2; x++)
	            for (int y = yCoord; y < yCoord + 3; y++)
	                for (int z = zCoord - 1; z < zCoord + 2; z++) {
	                    TileEntity tile = worldObj.getTileEntity(pos);
	                    // Check if block is bottom center block
	                    boolean master = (x == xCoord && y == yCoord && z == zCoord);
	                    if (tile != null && (tile instanceof TileEntityMobChamberStructure)) {
	                        ((TileEntityMobChamberStructure) tile).setMasterCoords(xCoord, yCoord, zCoord);
	                        ((TileEntityMobChamberStructure) tile).setHasMaster(true);
	                        ((TileEntityMobChamberStructure) tile).setIsMaster(master);
	                    }
	                }
	    }
	    public void reset() {
	        masterX = 0;
	        masterY = 0;
	        masterZ = 0;
	      
	        hasMaster = false;
	        isMaster = false;
	    }
	    BlockPos blockpos = new BlockPos(masterX, masterY, masterZ);
	    public boolean checkForMaster() {
	        TileEntity tile = worldObj.getTileEntity(blockpos);
	        return (tile != null && (tile instanceof TileEntityMobChamberStructure));
	    }
	    public void resetStructure() {
	        for (int x = xCoord - 1; x < xCoord + 2; x++)
	            for (int y = yCoord; y < yCoord + 3; y++)
	                for (int z = zCoord - 1; z < zCoord + 2; z++) {
	                    TileEntity tile = worldObj.getTileEntity(pos);
	                    if (tile != null && (tile instanceof TileEntityMobChamberStructure))
	                        ((TileEntityMobChamberStructure) tile).reset();
	                }
	    }
	    public void updateEntity() {
	    	  
	    	    if (!worldObj.isRemote) {
	    	        if (hasMaster()) { 
	    	            if (isMaster()) {
	    	                // Put stuff you want the multiblock to do here!
	    	            }
	    	        } else {
	    	            // Constantly check if structure is formed until it is.
	    	            if (checkMultiBlockForm())
	    	                setupStructure();
	    	        }
	    	    }
	    }

	    @Override
	    public NBTTagCompound writeToNBT(NBTTagCompound data) {
	        super.writeToNBT(data);
	        data.setInteger("masterX", masterX);
	        data.setInteger("masterY", masterY);
	        data.setInteger("masterZ", masterZ);
	        data.setBoolean("hasMaster", hasMaster);
	        data.setBoolean("isMaster", isMaster);
	        if (hasMaster() && isMaster()) {
	            // Any other values should ONLY BE SAVED TO THE MASTER
	        }
			return data;
	    }

	    @Override
	    public void readFromNBT(NBTTagCompound data) {
	        super.readFromNBT(data);
	        masterX = data.getInteger("masterX");
	        masterY = data.getInteger("masterY");
	        masterZ = data.getInteger("masterZ");
	        hasMaster = data.getBoolean("hasMaster");
	        isMaster = data.getBoolean("isMaster");
	        if (hasMaster() && isMaster()) {
	            // Any other values should ONLY BE READ BY THE MASTER
	        }
	    }

	    public boolean hasMaster() {
	        return hasMaster;
	    }

	    public boolean isMaster() {
	        return isMaster;
	    }

	    public int getMasterX() {
	        return masterX;
	    }

	    public int getMasterY() {
	        return masterY;
	    }

	    public int getMasterZ() {
	        return masterZ;
	    }

	    public void setHasMaster(boolean bool) {
	        hasMaster = bool;
	    }

	    public void setIsMaster(boolean bool) {
	        isMaster = bool;
	    }

	    public void setMasterCoords(int x, int y, int z) {
	        masterX = x;
	        masterY = y;
	        masterZ = z;
	    }
}

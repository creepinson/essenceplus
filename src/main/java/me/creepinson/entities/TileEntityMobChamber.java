package me.creepinson.entities;

import me.creepinson.handlers.BlockHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityMobChamber extends TileEntity implements ITickable, ICapabilityProvider, IInventory{
public ItemStack[] items = new ItemStack[9];
private ItemStack anItemStack;
private ItemStackHandler handler;	
private boolean isFormed = false;
	public TileEntityMobChamber() {
		

	}
	@Override
	public void update() {
		
		   //Check once per second
        if(worldObj.getTotalWorldTime()%20 == 0 && isFormed && !checkStructure())
        {
            isFormed = false;
            System.out.println("Structure broken!");
            if(!worldObj.isRemote)
                worldObj.playSound(null, pos, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.BLOCKS, 1f, 1f);
        }
    }
		
	 public boolean formStructure()
	    {
	        return isFormed = checkStructure();
	    }

	    public boolean isFormed()
	    {
	        return isFormed;
	    }

	    /**
	     * Checks if the blocks around this block resembles a valid structure
	     */
	    private boolean checkStructure()
	    {
	        //Check a hollow 3x3 with this block at the bottom center
	        for(int x = pos.getX() - 1; x <= pos.getX() + 1; x++)
	            for(int y = pos.getY(); y <= pos.getY() + 2; y++)
	                for(int z = pos.getZ() - 1; z <= pos.getZ() + 1; z++)
	                {
	                    //Don't need to check this block!
	                    if(x == pos.getX() && y == pos.getY() && z == pos.getZ())
	                        continue;
	                    IBlockState state = worldObj.getBlockState(new BlockPos(x, y, z));
	                    Block block = state.getBlock();
	                    //Middle block must be MobChamberCore!
	                    if(x == pos.getX() && y == pos.getY() + 1 && z == pos.getZ())
	                    {
	                        if(state.getBlock() == BlockHandler.BlockMobChamberCore)
	                            return false;
	                    }
	                    //Check if the block is a stone block
	                    else if(block != Blocks.STONE)
	                        return false;
	                }

	        //If it got this far, the structure must be good!
	        return true;
	    }

	    @Override
	    public void readFromNBT(NBTTagCompound nbt)
	    {
	        super.readFromNBT(nbt);
	        isFormed = nbt.getBoolean("formed");
	    }

	    @Override
	    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
	    {
	        nbt.setBoolean("formed", isFormed);
	        return super.writeToNBT(nbt);
	    }

	    @Override
	    public SPacketUpdateTileEntity getUpdatePacket()
	    {
	        NBTTagCompound nbt = new NBTTagCompound();
	        writeToNBT(nbt);
	        return new SPacketUpdateTileEntity(pos, 0, nbt);
	    }

	    @Override
	    public void onDataPacket(net.minecraft.network.NetworkManager net, net.minecraft.network.play.server.SPacketUpdateTileEntity pkt)
	    {
	        readFromNBT(pkt.getNbtCompound());
	    }
		@Override
		public String getName() {
			
			return null;
		}
		@Override
		public boolean hasCustomName() {
		
			return false;
		}
		@Override
		public int getSizeInventory() {
			
			return 9;
		}
		
		@Override
		public ItemStack getStackInSlot(int index) {
		
			  if (index < 0 || index >= this.getSizeInventory())
		            return null;
		        return this.items[index];
		}
		@Override
		public ItemStack decrStackSize(int index, int count) {
		     ItemStack itemstack;
		     if (this.getStackInSlot(index) != null) {
	            if (this.getStackInSlot(index).stackSize <= count) {
	            	anItemStack = this.getStackInSlot(index);
	                this.setInventorySlotContents(index, null);
	                this.markDirty();
	                return anItemStack;
	            } else {
	            	anItemStack = this.getStackInSlot(index).splitStack(count);

	                if (this.getStackInSlot(index).stackSize <= 0) {
	                    this.setInventorySlotContents(index, null);
	                } else {
	                    //Just to show that changes happened
	                    this.setInventorySlotContents(index, this.getStackInSlot(index));
	                }
	            
	            }    
	            this.markDirty();
		     }
	                return anItemStack;
	            
		     
		
		}
		@Override
		public ItemStack removeStackFromSlot(int index) {
	
			return null;
		}
		@Override
		public void setInventorySlotContents(int index, ItemStack stack) {
			  if (index < 0 || index >= this.getSizeInventory())
		            return;

		        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
		            stack.stackSize = this.getInventoryStackLimit();

		        if (stack != null && stack.stackSize == 0)
		            stack = null;

		        this.items[index] = stack;
		        this.markDirty();
		}
		@Override
		public int getInventoryStackLimit() {
		
			return 64;
		}
		@Override
		public boolean isUseableByPlayer(EntityPlayer player) {
			 return worldObj.getTileEntity(pos) == this && player.getDistanceSq((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D) <= 64.0D;
			
		}
		@Override
		public void openInventory(EntityPlayer player) {
		
			
		}
		@Override
		public void closeInventory(EntityPlayer player) {

			
		}
		@Override
		public boolean isItemValidForSlot(int index, ItemStack stack) {
		
			return true;
		}
		@Override
		public int getField(int id) {
	
			return 0;
		}
		@Override
		public void setField(int id, int value) {
		
			
		}
		@Override
		public int getFieldCount() {
		
			return 0;
		}
		   @Override
		    public void clear(){
		        for (int i = 0; i < this.getSizeInventory(); i++)
		            this.setInventorySlotContents(i, null);
		    }
	}

	

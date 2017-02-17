package me.creepinson.container;

import me.creepinson.entities.TileEntityMobChamber;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerMobChamber extends Container{

	private TileEntityMobChamber te;

	public ContainerMobChamber(IInventory playersinv, TileEntityMobChamber te){
	
		this.te = te;
		IItemHandler handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
	this.addSlotToContainer(new Slot(te, 0, 62, 17));
	this.addSlotToContainer(new Slot(te, 1, 80, 17));
	this.addSlotToContainer(new Slot(te, 2, 98, 17));
	this.addSlotToContainer(new Slot(te, 3, 62, 35));
	this.addSlotToContainer(new Slot(te, 4, 80, 35));
	this.addSlotToContainer(new Slot(te, 5, 98, 35));
	this.addSlotToContainer(new Slot(te, 6, 62, 53));
	this.addSlotToContainer(new Slot(te, 7, 80, 53));
	this.addSlotToContainer(new Slot(te, 8, 98, 53));
		
		int xPos = 8;
		int yPos = 84;
				
		
		
		for (int y = 0; y < 3; ++y) {
			for (int x = 0; x < 9; ++x) {
				this.addSlotToContainer(new Slot(playersinv, x + y * 9 + 9, xPos + x * 18, yPos + y * 18));
			}
		}
				
		for (int x = 0; x < 9; ++x) {
			this.addSlotToContainer(new Slot(playersinv, x, xPos + x * 18, yPos + 58));
		}
}
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
	te.isUseableByPlayer(playerIn);
		return te.isUseableByPlayer(playerIn);
	}

	
	
}

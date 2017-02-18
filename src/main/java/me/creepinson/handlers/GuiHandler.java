package me.creepinson.handlers;

import me.creepinson.container.ContainerMobChamber;
import me.creepinson.entities.TileEntityMobChamber;

import me.creepinson.gui.GuiUtils1;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	public static final int UTILS_1 = 0;
	
	
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	if(ID == UTILS_1){
		return new GuiUtils1();
	}
	return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == UTILS_1){
			return new GuiUtils1();
		}
	return null;
	
	}
	

	
	
	
}

package me.creepinson.handlers;

import me.creepinson.container.ContainerMobChamber;
import me.creepinson.entities.TileEntityMobChamber;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	public static final int MOB_CHAMBER = 0;
	
	
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	if(ID == MOB_CHAMBER){
		return new ContainerMobChamber(player.inventory, (TileEntityMobChamber) world.getTileEntity(new BlockPos(x, y, z)));
	}
	return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == MOB_CHAMBER){
			return new ContainerMobChamber(player.inventory, (TileEntityMobChamber) world.getTileEntity(new BlockPos(x, y, z)));
		}
	return null;
	
	}
	

	
	
	
}

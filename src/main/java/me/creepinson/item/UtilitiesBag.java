package me.creepinson.item;

import me.creepinson.Main.Main;
import me.creepinson.handlers.GuiHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class UtilitiesBag extends ModItems{

	public UtilitiesBag(String name, CreativeTabs tab) {
		super(name, tab);
		
	}
	public ActionResult<ItemStack> onItemRightClick(ItemStack item, World world, EntityPlayer user, EnumHand hand)

	{
	 
		 
			 user.openGui(Main.instance, GuiHandler.UTILS_1, world, (int) user.posX,  (int) user.posY,  (int) user.posZ);
		 
		
		
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
		
	}
}
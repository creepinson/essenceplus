package me.creepinson.item;

import me.creepinson.handlers.ItemHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Syringe extends ModItems{
	private Minecraft mc = Minecraft.getMinecraft();
	public Syringe(String name, CreativeTabs tab) {
		super(name, tab);
		
	}
	public ActionResult<ItemStack> onItemRightClick(ItemStack item, World world, EntityPlayer user, EnumHand hand)

	{
		
	user.inventory.deleteStack(item);
		user.inventory.addItemStackToInventory(new ItemStack(ItemHandler.Syringe_Full_Player, 1));
	return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
	}
}



package me.creepinson.item;

import java.util.List;

import me.creepinson.handlers.ItemHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Syringe_Full_Zombie extends ModItems{

	private Minecraft mc = Minecraft.getMinecraft();
	public Syringe_Full_Zombie(String name, CreativeTabs tab) {
		super(name, tab);
		   setHasSubtypes(true); // This allows the item to be marked as a metadata item.
	        setMaxDamage(0);
	}
	  @Override
	    @SideOnly(Side.CLIENT)
	    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
	    {
	       
		  
		tooltip.add("Testing");

	    
	}
	@Override
public ActionResult<ItemStack> onItemRightClick(ItemStack item, World world, EntityPlayer user, EnumHand hand)

{ 
		RayTraceResult raytrace = user.rayTrace(10, 30);
		
	
	return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
}
}
package me.creepinson.item;

import java.util.List;

import javax.swing.Icon;
import me.creepinson.handlers.EnumHandler.SyringeTypes;
import me.creepinson.handlers.EnumHandler;
import me.creepinson.handlers.ItemHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Syringe extends ModItems{

	public Syringe(String name, CreativeTabs tab) {
		super(name, tab);
		this.setHasSubtypes(true);
		
	}
	

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> items) {
for(int i = 0; i < SyringeTypes.values().length; i++)
	items.add(new ItemStack(item, 1, i));

	
	super.getSubItems(item, tab, items);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		for(int i = 0; i < SyringeTypes.values().length; i++)
		{
		if(stack.getItemDamage() == i)	{
		return this.getUnlocalizedName() + "." + EnumHandler.SyringeTypes.values()[i].getName();
		}
		
		else{
			continue;
		}
		
	
		}
		return this.getUnlocalizedName() + "." + EnumHandler.SyringeTypes.Empty.getName();
	
	}
	public boolean itemInteractionForEntity(ItemStack item, EntityPlayer user, EntityLivingBase target, EnumHand hand)
    {
  if(item.getItemDamage() == 0)
  {
	  if (target instanceof EntityZombie)
  
        {
        	 user.inventory.deleteStack(user.getHeldItem(hand));
				user.inventory.addItemStackToInventory(new ItemStack(ItemHandler.Syringe_Full_Zombie, 1));
		    
            return true;
        }
  }
  else
  {
            return super.itemInteractionForEntity(item, user, target, hand);
        
	  }
  return super.itemInteractionForEntity(item, user, target, hand);
    }

	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack item, World world, EntityPlayer user, EnumHand hand)

	{
		
				RayTraceResult raytrace = ForgeHooks.rayTraceEyes(user, 5);
			    
			   
			    	
			    	user.inventory.deleteStack(item);
					user.inventory.addItemStackToInventory(new ItemStack(ItemHandler.Syringe_Full_Player, 1));
			    
					return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
			    }
			 
			}
		
		
		



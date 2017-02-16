package me.creepinson.item;

import me.creepinson.handlers.ItemHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
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

public class Syringe extends ModItems{

	public Syringe(String name, CreativeTabs tab) {
		super(name, tab);
		
	}
	public boolean itemInteractionForEntity(ItemStack item, EntityPlayer user, EntityLivingBase target, EnumHand hand)
    {
    
         if (target instanceof EntityZombie)
        {
        	 user.inventory.deleteStack(user.getHeldItem(hand));
				user.inventory.addItemStackToInventory(new ItemStack(ItemHandler.Syringe_Full_Zombie, 1));
		    
            return true;
        }
        else
        {
            return super.itemInteractionForEntity(item, user, target, hand);
        }
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
		
		
		



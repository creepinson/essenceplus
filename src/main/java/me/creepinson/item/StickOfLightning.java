package me.creepinson.item;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiScreenEvent.PotionShiftEvent;

public class StickOfLightning extends ModItems{
	private Minecraft mc = Minecraft.getMinecraft();
	public StickOfLightning(String name, CreativeTabs tab) {
		super(name, tab);
		
	}
	public ActionResult<ItemStack> onItemRightClick(ItemStack item, World world, EntityPlayer user, EnumHand hand)

	{
		if(!world.isRemote){
			RayTraceResult pos = user.rayTrace(100, 20);
			double x = pos.getBlockPos().getX();
			double y = pos.getBlockPos().getY();
			double z = pos.getBlockPos().getZ();

			world.addWeatherEffect(new EntityLightningBolt(world, x, y, z, bFull3D));
		       user.setHealth(13);
		       return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
		}
	
		else{
		    return new ActionResult(EnumActionResult.FAIL, new ItemStack(this));
		}
	
	}
}


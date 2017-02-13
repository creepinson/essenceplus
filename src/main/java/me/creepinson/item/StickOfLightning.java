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
	Vec3d meeper = Minecraft.getMinecraft().objectMouseOver.hitVec;

		world.addWeatherEffect(new EntityLightningBolt(world, meeper.xCoord, meeper.yCoord, meeper.zCoord, bFull3D));
       user.setHealth(13);
	return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
	}
}


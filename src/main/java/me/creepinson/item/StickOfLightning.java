package me.creepinson.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class StickOfLightning extends ModItems{

	public StickOfLightning(String name, CreativeTabs tab) {
		super(name, tab);
		
	}
	public ActionResult<ItemStack> onItemRightClick(ItemStack item, World world, EntityPlayer player, EnumHand hand)
	{      BlockPos vec3 = player.getPosition();
    ++vec3.yCoord;
    Vec3d lookVec = player.getLook(1.0F);
    Vec3d addedVector = vec3.addVector(lookVec.xCoord * 50.0D, lookVec.yCoord * 50.0D, lookVec.zCoord * 50.0D);
    MovingObjectPosition movingObjPos = world.clip(vec3, addedVector);
    		//world.func_147447_a(vec3, addedVector, true, true, false);
		
		
		if (movingObjPos != null && movingObjPos.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
	
	
    {
    	System.out.println("made it");
        int blockX = movingObjPos.blockX;
        int blockY = movingObjPos.blockY;
        int blockZ = movingObjPos.blockZ;
    
		world.addWeatherEffect(new EntityLightningBolt(world, maxDamage, maxDamage, maxDamage, bFull3D));
    }
		if (movingObjPos != null && movingObjPos.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
          {
          	System.out.println(movingObjPos.typeOfHit);
          }
	return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
	}
}


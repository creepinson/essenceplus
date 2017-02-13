package me.creepinson.handlers;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MobDropsHandler extends Item
{
    @SubscribeEvent
    public void onMobDrops(LivingDropsEvent event)
    {
        if (event.getEntity() instanceof EntityBlaze)
        {

 
          ItemStack stack = new ItemStack(ItemHandler.FireEssence);
            EntityItem drop = new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, stack);
 
            event.getDrops().add(drop);
        }
    }
}
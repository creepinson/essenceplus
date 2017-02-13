package me.creepinson.handlers;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MobDropsHandler
{
    @SubscribeEvent
    public void onMobDrops(LivingDropsEvent event)
    {
        if (event.getEntity() instanceof EntityBlaze)
        {

 
          
          int temp = (Math.random() <= 0.5) ? 1 : 2;
          int temp2 = (Math.random() <= 0.5) ? 2 : 4;
          ItemStack stack = new ItemStack(ItemHandler.FireEssence, temp2);
          ItemStack blazepowd = new ItemStack(Items.BLAZE_ROD, temp);
            EntityItem drop = new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, stack);
            EntityItem blaze = new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, blazepowd);
            
            event.getDrops().add(drop);
            event.getDrops().add(blaze);
            
        }
    }
}
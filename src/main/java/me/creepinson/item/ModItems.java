package me.creepinson.item;


import me.creepinson.lib.RefStrings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems extends Item {
public static void Main(){

}


public ModItems(String name, CreativeTabs tab){
	setUnlocalizedName(name);
    setRegistryName(name);
    setCreativeTab(tab);
	 }
	 
	 public ModItems(String name, CreativeTabs tab, int stacksize){
	setUnlocalizedName(name);
	setRegistryName(name);
	setCreativeTab(tab);
    setMaxStackSize(stacksize);
	 }
}

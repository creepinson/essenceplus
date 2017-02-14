package me.creepinson.handlers;

import me.creepinson.item.BloodEssence;
import me.creepinson.item.FireCore;
import me.creepinson.item.FireEssence;
import me.creepinson.item.StickOfLightning;
import me.creepinson.item.Syringe_Full_Player;
import me.creepinson.item.Syringe_Full_Zombie;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemHandler {
	public static Item StickOfLightning;
	public static Item FireCore;
	public static Item FireEssence;
	public static Item Syringe;
	public static Item Syringe_Full_Player;
	public static Item Syringe_Full_Zombie;
	public static Item BloodEssence;
	 public static void init(){


		 StickOfLightning = new StickOfLightning("StickOfLightning", CreativeTabs.MATERIALS);
		 FireCore = new FireCore("FireCore", CreativeTabs.MATERIALS);
		 FireEssence = new FireEssence("FireEssence", CreativeTabs.MATERIALS);
		 Syringe = new me.creepinson.item.Syringe("Syringe", CreativeTabs.MATERIALS).setMaxStackSize(1);
		 Syringe_Full_Player = new Syringe_Full_Player("Syringe_Full_Player", CreativeTabs.MATERIALS).setMaxStackSize(1);
		 Syringe_Full_Zombie = new Syringe_Full_Zombie("Syringe_Full_Zombie", CreativeTabs.MATERIALS).setMaxStackSize(1);
		 BloodEssence = new BloodEssence("BloodEssence", CreativeTabs.MATERIALS);
	 }
	 
	 public static void register(){
	  
		 
		 GameRegistry.register(FireCore);
		 GameRegistry.register(FireEssence);
		 GameRegistry.register(StickOfLightning);
		 GameRegistry.register(Syringe);
		 GameRegistry.register(Syringe_Full_Player);
		 GameRegistry.register(BloodEssence);
		 GameRegistry.register(Syringe_Full_Zombie);
	 
	 }
	 
	 public static void registerRenders(){
      registerRender(StickOfLightning);
      registerRender(FireCore);
      registerRender(FireEssence);
      registerRender(Syringe);
	  registerRender(Syringe_Full_Player);
	  registerRender(Syringe_Full_Zombie);
      registerRender(BloodEssence);     
      
	 }
	 
	 public static void registerRender(Item item){
			
		 Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));

	 }
}

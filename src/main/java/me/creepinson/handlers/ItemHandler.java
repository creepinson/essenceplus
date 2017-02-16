package me.creepinson.handlers;

import me.creepinson.handlers.EnumHandler.SyringeTypes;
import me.creepinson.item.BloodEssence;
import me.creepinson.item.FireCore;
import me.creepinson.item.FireEssence;
import me.creepinson.item.StickOfLightning;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemHandler {
	public static Item StickOfLightning;
	public static Item FireCore;
	public static Item FireEssence;
	public static Item Syringe;
	public static Item BloodEssence;
	 public static void init(){


		 StickOfLightning = new StickOfLightning("StickOfLightning", CreativeTabs.MATERIALS);
		 FireCore = new FireCore("FireCore", CreativeTabs.MATERIALS);
		 FireEssence = new FireEssence("FireEssence", CreativeTabs.MATERIALS);
		 Syringe = new me.creepinson.item.Syringe("Syringe_Empty", CreativeTabs.MATERIALS).setMaxStackSize(1);
		 BloodEssence = new BloodEssence("BloodEssence", CreativeTabs.MATERIALS);
	 }
	 
	 public static void register(){
	  
		 
		 GameRegistry.register(FireCore);
		 GameRegistry.register(FireEssence);
		 GameRegistry.register(StickOfLightning);
		 GameRegistry.register(Syringe);
		 GameRegistry.register(BloodEssence);
	 
	 }
	 
	 public static void registerRenders(){
      registerRender(StickOfLightning);
      registerRender(FireCore);
      registerRender(FireEssence);

      registerRender(BloodEssence);     
      for(int i = 0; i < SyringeTypes.values().length; i++)
		{
    	  registerRender(Syringe, i, "Syringe_" + EnumHandler.SyringeTypes.values()[i].getName());
		}
	 }
	 
	 public static void registerRender(Item item, int meta, String fileName){
			
		 ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName().toString() + "_" + EnumHandler.SyringeTypes.values()[meta].getName(), "inventory"));

	 }

	 
	 public static void registerRender(Item item){
			
		 ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));

	 }
}

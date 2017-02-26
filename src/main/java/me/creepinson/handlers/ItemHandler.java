package me.creepinson.handlers;

import me.creepinson.handlers.EnumHandler.Cores;
import me.creepinson.handlers.EnumHandler.Essences;
import me.creepinson.handlers.EnumHandler.SyringeTypes;
import me.creepinson.item.BloodEssence;
import me.creepinson.item.Core;
import me.creepinson.item.Essence;
import me.creepinson.item.Large_Bone;
import me.creepinson.item.StickOfLightning;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemHandler {
	public static Item StickOfLightning;
	

	
	public static Item boneLarge;
	public static Item Syringe;
	public static Item BloodEssence;
	public static Item UtilitiesBag;
	
	public static Item EnergyTablet;
	public static Item CPU;
	public static Item StorageComponent;
	public static Item HardDrive;
	public static Item Monitor;
	public static Item Chip;
	
	
	
	public static Item Core;
	public static Item Essence;
	

	public static void init(){


		 StickOfLightning = new StickOfLightning("StickOfLightning", CreativeTabs.MATERIALS).setMaxStackSize(1);
		 
		 Essence = new Essence("Essence", CreativeTabs.MATERIALS);
		 Core = new Core("Core", CreativeTabs.MATERIALS);
		 
		 Syringe = new me.creepinson.item.Syringe("Syringe", CreativeTabs.MATERIALS).setMaxStackSize(1);
		 BloodEssence = new BloodEssence("BloodEssence", CreativeTabs.MATERIALS);
		 UtilitiesBag = new me.creepinson.item.UtilitiesBag("UtilitiesBag", CreativeTabs.MATERIALS);
		 boneLarge = new Large_Bone("Large_Bone", CreativeTabs.MATERIALS);
		 
	
	}
	 
	 public static void register(){
	  
		 
		 GameRegistry.register(Core);
		 GameRegistry.register(UtilitiesBag);
		 GameRegistry.register(Essence);
		 GameRegistry.register(StickOfLightning);
		 GameRegistry.register(Syringe);

		 GameRegistry.register(BloodEssence);
		 GameRegistry.register(boneLarge);
		 
	 }
	 
	 public static void registerRenders(){
      registerRender(StickOfLightning);
      registerRender(UtilitiesBag);
      registerRender(BloodEssence); 
      registerRender(boneLarge); 
      for(int i = 0; i < SyringeTypes.values().length; i++)
		{
    	  registerRender(Syringe, i, "Syringe_" + EnumHandler.SyringeTypes.values()[i].getName());
		}
      for(int i = 0; i < Cores.values().length; i++)
 		{
     	  registerRender(Core, i, EnumHandler.Cores.values()[i].getName() + "Core");
 		}
      for(int i = 0; i < Essences.values().length; i++)
 		{
     	  registerRender(Essence, i, EnumHandler.Essences.values()[i].getName() + "Essence");
 		}
	 }
	 
	 public static void registerRender(Item item, int meta, String fileName){
			
		 ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(fileName, "inventory"));

	 }

	 
	 public static void registerRender(Item item){
			
		 ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));

	 }
}

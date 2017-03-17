package me.creepinson.handlers;

import me.creepinson.handlers.EnumHandler.Cores;
import me.creepinson.handlers.EnumHandler.Essences;
import me.creepinson.handlers.EnumHandler.SyringeTypes;
import me.creepinson.item.BloodEssence;
import me.creepinson.item.Core;
import me.creepinson.item.Essence;
import me.creepinson.item.Large_Bone;
import me.creepinson.item.StickOfLightning;
import me.creepinson.lib.RefStrings;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemHandler {
	public static Item StickOfLightning;
	

	
	public static Item boneLarge;
	public static Item Syringe;
	
	public static Item EnergyTablet;
	public static Item Battery;
	public static Item CPU;
	public static Item StorageComponent;
	public static Item HardDrive;
	public static Item Monitor;
	public static Item Chip;
	
	
	
	public static Item Core;
	public static Item Essence;
	

	public static void init(){


		 StickOfLightning = new StickOfLightning("StickOfLightning", CreativeTabHandler.ESSENCEPLUS_BASE).setMaxStackSize(1);
		 
		 Essence = new Essence("essence", CreativeTabHandler.ESSENCEPLUS_BASE);
		 Core = new Core("core", CreativeTabs.MATERIALS);
		 
		 Syringe = new me.creepinson.item.Syringe("Syringe", CreativeTabHandler.ESSENCEPLUS_BASE).setMaxStackSize(1);
		 
		 boneLarge = new Large_Bone("Large_Bone", CreativeTabHandler.ESSENCEPLUS_BASE);
		 
	
	}
	 
	 public static void register(){
	  
		 
		 GameRegistry.register(Core);

		 GameRegistry.register(Essence);
		 GameRegistry.register(StickOfLightning);
		 GameRegistry.register(Syringe);


		 GameRegistry.register(boneLarge);
		 
	 }
	 
	 public static void registerRenders(){
      registerRender(StickOfLightning);
      registerRender(boneLarge); 
      for(int i = 0; i < SyringeTypes.values().length; i++)
		{
    	  registerRender(Syringe, i, "Syringe_" + EnumHandler.SyringeTypes.values()[i].getName());
		}
      for(int i = 0; i < Cores.values().length; i++)
 		{
     	  registerRender(Core, i, EnumHandler.Cores.values()[i].getName() + "core");
 		}
      for(int i = 0; i < Essences.values().length; i++)
 		{
     	  registerRender(Essence, i, EnumHandler.Essences.values()[i].getName() + "essence");
 		}
	 }
	 
	 public static void registerRender(Item item, int meta, String fileName){
			
		 ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(RefStrings.MODID + ":" + fileName, "inventory"));

	 }

	 
	 public static void registerRender(Item item){
			
		 ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));

	 }
}

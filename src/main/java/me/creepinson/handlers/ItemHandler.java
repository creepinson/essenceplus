package me.creepinson.handlers;

import me.creepinson.handlers.EnumHandler.Chips;
import me.creepinson.handlers.EnumHandler.Cores;
import me.creepinson.handlers.EnumHandler.Essences;
import me.creepinson.handlers.EnumHandler.SyringeTypes;
import me.creepinson.handlers.EnumHandler.Wires;
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
	public static Item Wire;
	
	
	public static Item Core;
	public static Item Essence;
	public static Item CopperIngot;
	

	public static void init(){
		//INITIALIZE ITEMS
		
         //NON-METADATA ITEMS - INIT START 
		 StickOfLightning = new StickOfLightning("StickOfLightning", CreativeTabHandler.ESSENCEPLUS_BASE).setMaxStackSize(1);
		 boneLarge = new Large_Bone("Large_Bone", CreativeTabHandler.ESSENCEPLUS_BASE);
		 CopperIngot = new me.creepinson.item.CopperIngot("ingotCopper", CreativeTabHandler.ESSENCEPLUS_TECH);
			 
		 
		//NON-METADATA ITEMS - INIT END 
		 
/*------------------------------------------------------------------*/
		 
		//METADATA ITEMS - INIT START 
		 Essence = new Essence("essence", CreativeTabHandler.ESSENCEPLUS_BASE);
		 Core = new Core("core", CreativeTabHandler.ESSENCEPLUS_BASE);
		 Chip = new me.creepinson.item.Chip("chip", CreativeTabHandler.ESSENCEPLUS_TECH);
		 Wire = new me.creepinson.item.Wire("wire", CreativeTabHandler.ESSENCEPLUS_TECH);
		 
		 Syringe = new me.creepinson.item.Syringe("Syringe", CreativeTabHandler.ESSENCEPLUS_BASE).setMaxStackSize(1);
		
		 //METADATA ITEMS - INIT END 
	
	}
	 
	 public static void register(){
	  
		 
		 GameRegistry.register(Core);
		 GameRegistry.register(Chip);
		 GameRegistry.register(Wire);
		 GameRegistry.register(Essence);
		 GameRegistry.register(Syringe);

		 GameRegistry.register(StickOfLightning);
		 GameRegistry.register(boneLarge);
		 GameRegistry.register(CopperIngot);
		 
	 }
	 
	 public static void registerRenders(){
      registerRender(StickOfLightning);
      registerRender(boneLarge); 
      registerRender(CopperIngot); 
      
      
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
      
      for(int i = 0; i < Chips.values().length; i++)
		{
   	  registerRender(Chip, i, "chip" + EnumHandler.Chips.values()[i].getName());
		}
      
      
      for(int i = 0; i < Wires.values().length; i++)
		{
 	  registerRender(Wire, i, "wire" + EnumHandler.Wires.values()[i].getName());
		}
      
      
      
	 }
	 
	 public static void registerRender(Item item, int meta, String fileName){
			
		 ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(RefStrings.MODID + ":" + fileName, "inventory"));

	 }

	 
	 public static void registerRender(Item item){
			
		 ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));

	 }
}

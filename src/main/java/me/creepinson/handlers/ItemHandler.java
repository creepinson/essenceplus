package me.creepinson.handlers;

import me.creepinson.item.FireCore;
import me.creepinson.item.FireEssence;
import me.creepinson.item.StickOfLightning;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemHandler {
	public static Item StickOfLightning;
	public static Item FireCore;
	public static Item FireEssence;
	 public static void init(){


		 StickOfLightning = new StickOfLightning("StickOfLightning", CreativeTabs.MATERIALS);
		 FireCore = new FireCore("FireCore", CreativeTabs.MATERIALS);
		 FireEssence = new FireEssence("FireEssence", CreativeTabs.MATERIALS);
		 
		 
	 }
	 
	 public static void register(){
	  
		 
		 GameRegistry.register(FireCore);
		 GameRegistry.register(FireEssence);
		 GameRegistry.register(StickOfLightning);
		 
	 }
	 
	 public static void registerRenders(){
      registerRender(StickOfLightning);
      registerRender(FireCore);
      registerRender(FireEssence);
      
      
	 }
	 
	 public static void registerRender(Item item){
			
		 Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));

	 }
}

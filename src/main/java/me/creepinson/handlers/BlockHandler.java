package me.creepinson.handlers;

import me.creepinson.blocks.BlockMobChamber;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockHandler {
	public static Block BlockMobChamberCore;
	public static ItemBlock MobChamberCore;
	public static Block BlockMobChamber;
	public static ItemBlock MobChamber;
	
	
	public static void init(){
	 
		BlockMobChamber = new BlockMobChamber(Material.ROCK, "MobChamber", CreativeTabs.BUILDING_BLOCKS, 5F, 15F, 3, "MobChamber");
		  
	    MobChamber = (ItemBlock) new ItemBlock(BlockMobChamber);
	   
	    BlockMobChamberCore = new me.creepinson.blocks.BlockMobChamberCore(Material.ROCK, "MobChamberCore", CreativeTabs.BUILDING_BLOCKS, 5F, 15F, 3, "pickaxe");
		  
	    MobChamberCore = (ItemBlock) new ItemBlock(BlockMobChamberCore);
	
	    
	}
	 
	 public static void register(){
	
		 GameRegistry.register(BlockMobChamber);
		  GameRegistry.register(MobChamber, BlockMobChamber.getRegistryName());
		  GameRegistry.register(BlockMobChamberCore);
		  GameRegistry.register(MobChamberCore, BlockMobChamberCore.getRegistryName());
	 
	 }
	 
	 public static void registerRenders(){
	 
		 registerRender(BlockMobChamber);
		 registerRender(BlockMobChamberCore);
		 
	 }
	 
	 public static void registerRender(Block block){
	 
Item item = Item.getItemFromBlock(block);
ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	 
	 }
	 
	 
}

package me.creepinson.handlers;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingHandler {

	public static void init(){
	
		GameRegistry.addRecipe(new ItemStack(ItemHandler.FireCore, 2), " B ", "BXB", " B ", 'X', ItemHandler.FireEssence, 'B', Items.IRON_INGOT);
		GameRegistry.addRecipe(new ItemStack(ItemHandler.StickOfLightning, 1), " F ", " R ", " R ", 'F', ItemHandler.FireCore, 'R', Items.STICK);

		
		
	}
	
	
	
}

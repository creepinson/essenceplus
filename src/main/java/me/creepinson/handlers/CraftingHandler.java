package me.creepinson.handlers;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingHandler {

	public static void init(){
	
		GameRegistry.addRecipe(new ItemStack(ItemHandler.Core, 2, 0), " B ", "BXB", " B ", 'X', new ItemStack(ItemHandler.Essence, 1, 0), 'B', Items.IRON_INGOT);
		GameRegistry.addRecipe(new ItemStack(ItemHandler.StickOfLightning, 1), " F ", " R ", " R ", 'F', new ItemStack(ItemHandler.Core, 1, 0), 'R', Items.STICK);

		
		
	}
	
	
	
}

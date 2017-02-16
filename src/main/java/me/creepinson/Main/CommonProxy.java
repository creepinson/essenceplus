package me.creepinson.Main;

import me.creepinson.handlers.CraftingHandler;
import me.creepinson.handlers.ItemHandler;
import me.creepinson.lib.IProxy;
import me.creepinson.lib.RefStrings;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.util.ResourceLocation;

public class CommonProxy implements IProxy{

	@Override
	public void preInit() {
	
		 ItemHandler.init();
		  ItemHandler.register();
		  
	}

	@Override
	public void init() {
	
		CommonProxy.registerModelBakeryVarients();
		
	}

	@Override
	public void postInit() {
		
	CraftingHandler.init();
		
	}
	
	public static void registerModelBakeryVarients(){

		ModelBakery.registerItemVariants(ItemHandler.Syringe, new ResourceLocation(RefStrings.MODID, "Syringe_Empty"), new ResourceLocation(RefStrings.MODID, "Syringe_Full_Zombie"), new ResourceLocation(RefStrings.MODID, "Syringe_Full_Player"));
		
}
}
package me.creepinson.Main;

import me.creepinson.entities.TileEntityMobChamber;
import me.creepinson.handlers.BlockHandler;
import me.creepinson.handlers.CraftingHandler;
import me.creepinson.handlers.ItemHandler;
import me.creepinson.lib.IProxy;
import me.creepinson.lib.RefStrings;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy implements IProxy{

	@Override
	public void preInit() {
		BlockHandler.init();
		  BlockHandler.register();

		 ItemHandler.init();
		  ItemHandler.register();
		  
	}

	@Override
	public void init() {
	
		GameRegistry.registerTileEntity(TileEntityMobChamber.class, RefStrings.MODID + ":"+ "mobchamber");
		
		
	}

	@Override
	public void postInit() {
		
	CraftingHandler.init();
		
	}
	
	public static void registerModelBakeryVarients(){

		ModelBakery.registerItemVariants(ItemHandler.Syringe, new ResourceLocation(RefStrings.MODID, "Syringe_Empty"), new ResourceLocation(RefStrings.MODID, "Syringe_Full_Zombie"), new ResourceLocation(RefStrings.MODID, "Syringe_Full_Player"));
		
}
}
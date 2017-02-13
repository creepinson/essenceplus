package me.creepinson.Main;

import me.creepinson.handlers.CraftingHandler;
import me.creepinson.handlers.ItemHandler;
import me.creepinson.lib.IProxy;

public class CommonProxy implements IProxy{

	@Override
	public void preInit() {
	
		 ItemHandler.init();
		  ItemHandler.register();
		  
	}

	@Override
	public void init() {
	
    
		
	}

	@Override
	public void postInit() {
		
	CraftingHandler.init();
		
	}

}

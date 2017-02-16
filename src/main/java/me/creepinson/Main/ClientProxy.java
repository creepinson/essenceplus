package me.creepinson.Main;

import me.creepinson.handlers.ItemHandler;

public class ClientProxy extends CommonProxy {
	@Override
	public void init() {
		  ItemHandler.registerRenders();
			
	}
	
	
}

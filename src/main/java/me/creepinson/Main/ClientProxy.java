package me.creepinson.Main;

import me.creepinson.handlers.BlockHandler;
import me.creepinson.handlers.ItemHandler;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInit() {
		  super.preInit();
		ItemHandler.registerRenders();
		BlockHandler.registerRenders();
	
	}

	
	
}

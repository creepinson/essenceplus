package me.creepinson.Main;

import me.creepinson.handlers.ItemHandler;

public class ClientProxy extends CommonProxy {
	public void init() {
		  ItemHandler.registerRenders();
		 }
	
	
}

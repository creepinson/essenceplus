package me.creepinson.Main;

import me.creepinson.handlers.BlockHandler;
import me.creepinson.handlers.GuiHandler;
import me.creepinson.handlers.ItemHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInit() {
		  super.preInit();
		ItemHandler.registerRenders();
		BlockHandler.registerRenders();

	}

	public void init() {
		  super.init();
		
NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
	}

	
}

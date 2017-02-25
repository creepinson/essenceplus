package me.creepinson.main;

import me.creepinson.entities.TESRPedastal_Magic;
import me.creepinson.entities.TileEntityPedastal_Magic;
import me.creepinson.handlers.BlockHandler;
import me.creepinson.handlers.GuiHandler;
import me.creepinson.handlers.ItemHandler;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void preInit() {
		  super.preInit();
		ItemHandler.registerRenders();
		BlockHandler.registerRenders();
		 ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPedastal_Magic.class, new TESRPedastal_Magic());
		 
	}

	public void init() {
		  super.init();
		
NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
	}

	
}

package me.creepinson.Main;


import jline.internal.Log;
import me.creepinson.handlers.EventHandlerMOD;
import me.creepinson.handlers.ItemHandler;
import me.creepinson.item.FireCore;
import me.creepinson.item.FireEssence;
import me.creepinson.lib.IProxy;
import me.creepinson.lib.RefStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@net.minecraftforge.fml.common.Mod(modid = me.creepinson.lib.RefStrings.MODID, version =  me.creepinson.lib.RefStrings.VERSION)
public class Main {
	@net.minecraftforge.fml.common.SidedProxy(clientSide = RefStrings.CLIENTSIDE, serverSide = RefStrings.SERVERSIDE)

public static IProxy proxy;

    //INITS
    @net.minecraftforge.fml.common.Mod.EventHandler
    public void preInit(FMLPreInitializationEvent PreEvent)
    {
 
		proxy.preInit();
	
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	 
		proxy.init();
    	MinecraftForge.EVENT_BUS.register(new EventHandlerMOD());
    	
    	Log.info("MeepersPlus Mod Initialized...");
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent PostEvent)
    {
		
		proxy.postInit();	
    	
    }
	
    
    
    
    
}

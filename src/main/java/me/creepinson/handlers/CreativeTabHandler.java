package me.creepinson.handlers;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabHandler {
	
	
	public static final CreativeTabs ESSENCEPLUS_CREEPOLA = new CreativeTabs("Creepola"){
	    @Override public Item getTabIconItem() {
	        return ItemHandler.Syringe;
	    }
	};

	public static final CreativeTabs ESSENCEPLUS_BASE = new CreativeTabs("Creepola"){
	    @Override public Item getTabIconItem() {
	        return ItemHandler.Essence;
	    }
	};
}

package me.creepinson.events;

import me.creepinson.handlers.EnumHandler;
import me.creepinson.handlers.EnumHandler.SwordLevels;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

@Cancelable
public class ItemSwordLevelEvent extends Event{

	

	
	/**
	 * Event that is fired whenever a player tosses (Q) an item or drag-n-drops a
	 * stack of items outside the inventory GUI screens. Canceling the event will
	 * stop the items from entering the world, but will not prevent them being
	 * removed from the inventory - and thus removed from the system.
	 */
        public SwordLevels swordLevels;
	    private final EntityPlayer player;
	    private boolean leveled;
	    private final ItemStack item;
	    /**
	     * Creates a new event for EntityItems tossed by a player.
	     * 
	     * @param entityItem The EntityItem being tossed.
	     * @param player The player tossing the item.
	     */
	    public ItemSwordLevelEvent(ItemStack item, EntityPlayer player, Boolean leveled)
	    {
	        super();
	        this.player = player;
	    this.leveled = leveled;
	    this.item = item;
	    
	    }

	    /**
	     * The player that leveled the item.
	     */
	    public EntityPlayer getPlayer()
	    {
	        return player;
	    }
	    public ItemStack getItemStack()
	    {
	        return item;
	    }
	    
	    public boolean isLeveled()
	    {
	        return leveled;
	    }
	    public void setLeveled(boolean leveled)
	    {
	        
	    	this.leveled = leveled; 
	    	
	    }
	
	    
}

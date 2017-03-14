package me.creepinson.gui;

import java.io.IOException;

import baubles.api.BaublesApi;
import baubles.api.cap.BaublesCapabilities;
import baubles.api.cap.BaublesContainer;
import baubles.api.cap.BaublesContainerProvider;
import baubles.api.inv.BaublesInventoryWrapper;
import baubles.client.gui.BaublesGuiFactory;
import baubles.common.Baubles;
import me.creepinson.container.ContainerMobChamber;
import me.creepinson.entities.TileEntityMobChamber;
import me.creepinson.handlers.GuiHandler;
import me.creepinson.main.Main;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GuiMenu extends GuiScreen
{
	  
    public GuiMenu(){
		
		
		
		this.width = 176;
		this.height = 166;
	
		
	}

	final int SKILLS = 0;
	private GuiButton skills;

    public void initGui()
    {
    this.skills = this.addButton(new GuiButton(0, 0, 0, "Skills"));
    

    
    }
    public static void spawnParticleNote(EntityPlayer player) {
  
    	
     	World world = player.worldObj ;
    	BlockPos pos;
    	
    	 ItemStack testStack = new ItemStack(Items.CHICKEN);
 player.inventory.addItemStackToInventory(testStack);

    }
   
    	//if(te != null && te instanceof TileEntityChest){
    	  //  for (int i = 0; i < ((TileEntityChest) te).getSizeInventory(); ++i){
    	    //    System.out.println(((TileEntityChest) te).getStackInSlot(i));
    	  //      System.out.println("testing...");
         //   	-- temb.items[0].stackSize;
         //   -- temb.items[1].stackSize;
           // -- temb.items[2].stackSize;
               
             
            //}
            // else{
            //	 player.addChatComponentMessage(new TextComponentString(TextFormatting.RED + "Invalid Recipe/No Recipe/No Chest!"));
            	//
            // }
    
    	    
   


    protected void actionPerformed(GuiButton button) throws IOException
    {
  EntityPlayer player = mc.thePlayer;
            if (button.id == 0)
            {
           
            	player.openGui(Main.instance, GuiHandler.SKILLS, mc.theWorld, player.posX, player.posY, player.posZ);
           //  if(ItemStack.areItemsEqual(te.items[0], new ItemStack(ItemHandler.FireCore)) && ItemStack.areItemsEqual(te.items[1], new ItemStack(Items.EGG))){
           
            }
            
             
            }
  

	
	
}

package me.creepinson.gui;

import java.io.IOException;

import me.creepinson.container.ContainerMobChamber;
import me.creepinson.entities.TileEntityMobChamber;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GuiUtils1 extends GuiScreen
{

	private TileEntityMobChamber te; 
	private IInventory playerInv;
    private GuiButton particle1;

    private ContainerMobChamber cmb;
    public void initGui()
    {
    this.particle1 = this.addButton(new GuiButton(0, 0, 0, "Particles 1"));
    
this.te = new TileEntityMobChamber();
    
    }
    public static void spawnParticleNote(EntityPlayer player) {
  
    	
     	World world = player.worldObj ;
    	BlockPos pos;
    	
    	world.spawnParticle(EnumParticleTypes.NOTE,player.posX,player.posY, player.posZ, 5, 5, 5);
    	
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
    }
    	    
   


    protected void actionPerformed(GuiButton button) throws IOException
    {
  EntityPlayer player = mc.thePlayer;
            if (button.id == 0)
            {
            	this.spawnParticleNote(player);
            	
           //  if(ItemStack.areItemsEqual(te.items[0], new ItemStack(ItemHandler.FireCore)) && ItemStack.areItemsEqual(te.items[1], new ItemStack(Items.EGG))){
           
            }
            
             
            }
    
    public GuiUtils1(){
		
		
		
		this.width = 176;
		this.height = 166;
	
		
	}

	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		
		
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		
	  
	}
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String s = I18n.format("gui.utils1"); //Gets the formatted name for the block breaker from the language file - NOTE ADD "container.block_breaker=Block Breaker" to the language file (without quotes) and then delete this note
		this.mc.fontRendererObj.drawString(s, this.width / 2 - this.mc.fontRendererObj.getStringWidth(s) / 2, 6, 4210752); //Draws the block breaker name in the center on the top of the gui
		
	}
	
	
}

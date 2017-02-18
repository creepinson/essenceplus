package me.creepinson.gui;

import java.io.IOException;

import me.creepinson.blocks.BlockMobChamber;
import me.creepinson.container.ContainerMobChamber;
import me.creepinson.entities.TileEntityMobChamber;
import me.creepinson.handlers.ItemHandler;
import me.creepinson.lib.RefStrings;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class GuiMobChamber extends GuiScreen
{

	private TileEntityMobChamber te; 
	private IInventory playerInv;
    private GuiButton startButton;
    private ContainerMobChamber cmb;
    public void initGui()
    {
    this.startButton = this.addButton(new GuiButton(0, 128, 128, "Build Mob"));
    
this.te = new TileEntityMobChamber();
    
    }
    
    protected void actionPerformed(GuiButton button) throws IOException
    {
    	
      EntityPlayer player = Minecraft.getMinecraft().thePlayer;
            if (button.id == 0)
            {
            	BlockMobChamber.buildMob();
            	
           //  if(ItemStack.areItemsEqual(te.items[0], new ItemStack(ItemHandler.FireCore)) && ItemStack.areItemsEqual(te.items[1], new ItemStack(Items.EGG))){
           
            }
            
             
            }
    
    public GuiMobChamber(){
		
		
		
		this.width = 176;
		this.height = 166;
	
		
	}

	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		
		
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		
	  
	}
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String s = I18n.format("gui.mobchamber"); //Gets the formatted name for the block breaker from the language file - NOTE ADD "container.block_breaker=Block Breaker" to the language file (without quotes) and then delete this note
		this.mc.fontRendererObj.drawString(s, this.width / 2 - this.mc.fontRendererObj.getStringWidth(s) / 2, 6, 4210752); //Draws the block breaker name in the center on the top of the gui
		
	}
	
	
}

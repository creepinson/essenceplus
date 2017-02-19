package me.creepinson.gui;

import java.io.IOException;
import java.util.ArrayList;

import me.creepinson.Main.CommonProxy;
import me.creepinson.blocks.BlockMobChamber;
import me.creepinson.container.ContainerMobChamber;
import me.creepinson.entities.TileEntityMobChamber;
import me.creepinson.packet.CustomPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GuiMobChamber extends GuiScreen
{

	private TileEntityMobChamber te; 
	private IInventory playerInv;
    private GuiButton buildMob;

    private ContainerMobChamber cmb;
    public void initGui()
    {
    this.buildMob = this.addButton(new GuiButton(0, 0, 50, "Build Mob"));
    
this.te = new TileEntityMobChamber();
    }
            //	 player.addChatComponentMessage(new TextComponentString(TextFormatting.RED + "Invalid Recipe/No Recipe/No Chest!"));
            	//
            // }
    
    	    
   
    ItemStack meep;
protected void actionPerformed(GuiButton button) throws IOException
    {
	ArrayList<ItemStack> mutantzombie_4l = new ArrayList<ItemStack>();

            if (button.id == 0)
            {
            	BlockMobChamber.check(mutantzombie_4l, meep);
            	
           //  if(ItemStack.areItemsEqual(te.items[0], new ItemStack(ItemHandler.FireCore)) && ItemStack.areItemsEqual(te.items[1], new ItemStack(Items.EGG))){
           
            }
            
             
            }

@Override
public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    drawDefaultBackground();
    GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    super.drawScreen(mouseX, mouseY, partialTicks);
    GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    drawGuiContainerForegroundLayer(mouseX, mouseY);
	super.drawScreen(mouseX, mouseY, partialTicks);
}
    BlockPos posy;
    public GuiMobChamber(BlockPos pos){
		
		this.posy = pos;
		
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

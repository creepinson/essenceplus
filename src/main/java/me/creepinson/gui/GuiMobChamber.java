package me.creepinson.gui;

import java.io.IOException;

import me.creepinson.container.ContainerMobChamber;
import me.creepinson.entities.TileEntityMobChamber;
import me.creepinson.handlers.ItemHandler;
import me.creepinson.lib.RefStrings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiBeacon;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.CommandBlockBaseLogic;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

public class GuiMobChamber extends GuiContainer
{

	private TileEntityMobChamber te; 
	private IInventory playerInv;
    private GuiButton startButton;
    private ContainerMobChamber cmb;
    public void initGui()
    {
    this.startButton = this.addButton(new GuiButton(0, 5, 10, "Start"));
    
    
    }
    
    protected void actionPerformed(GuiButton button) throws IOException
    {
      EntityPlayer player = Minecraft.getMinecraft().thePlayer;
            if (button.id == 0)
            {
             if(ItemStack.areItemsEqual(te.items[0], new ItemStack(ItemHandler.FireCore)) && ItemStack.areItemsEqual(te.items[1], new ItemStack(Items.EGG))){
            	 -- te.items[0].stackSize;
               	 -- te.items[1].stackSize;
               	 -- te.items[2].stackSize;
             }
             else{
            	 player.addChatComponentMessage(new TextComponentString(TextFormatting.RED + "Invalid Recipe/No Recipe!"));
             }
               
            }
    }
    public GuiMobChamber(IInventory playerInv, TileEntityMobChamber te){
		
		
		super(new ContainerMobChamber(playerInv, te));
		
		this.xSize = 176;
		this.ySize = 166;
		this.playerInv = playerInv;
		this.te = te;
		
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		
		
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(RefStrings.MODID, "textures/gui/container/MobChamber.png"));
	    this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	
	
	}
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String s = I18n.format("container.mobchamber"); //Gets the formatted name for the block breaker from the language file - NOTE ADD "container.block_breaker=Block Breaker" to the language file (without quotes) and then delete this note
		this.mc.fontRendererObj.drawString(s, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s) / 2, 6, 4210752); //Draws the block breaker name in the center on the top of the gui
		this.mc.fontRendererObj.drawString(this.playerInv.getDisplayName().getFormattedText(), 8, 72, 4210752); //The player's inventory name
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
	}
	
	
}

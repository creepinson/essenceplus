package me.creepinson.blocks;

import java.awt.Robot;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Nullable;

import me.creepinson.entities.TileEntityPedastal_Magic;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class BlockMagicalCore extends ModBlocks {

	public BlockMagicalCore(Material mat, String name, CreativeTabs tab, float hardness, float resistance, int harvest, String tool) {
		  super(mat, name, tab, hardness, resistance, harvest, tool);
		 }
	  private Timer timer = new Timer();
	    private TimerTask waitTimerTask1;	
	    private class WaitTimerTask1 extends TimerTask
	    {
	   
	    World world;
	    	
	    int x;
	    int y;
	    int z;
	      

	        /**
	         * Helper class whose purpose is to release right click and set our status to not eating.
	         */
	        WaitTimerTask1(World worldIn, int x, int y, int z){
	      		  
	          
	     
	      		  this.x = x;
	      		  this.y = y;
	      		  this.z = z;
	      		this.world = worldIn;
	      		
	        }


			@Override
			public void run() {
				
				}
	    }
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
	{
	
	  
	   
	  
	  if(!worldIn.isRemote){
		  BlockPos topRight = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1);
		  BlockPos topLeft = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() + 1);
		  BlockPos bottomRight = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() - 1);
		  BlockPos bottomLeft = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1);
			
		  TileEntity te1 = worldIn.getTileEntity(topRight);
		  TileEntity te2 = worldIn.getTileEntity(topLeft);
		  TileEntity te3 = worldIn.getTileEntity(bottomRight);
		  TileEntity te4 = worldIn.getTileEntity(bottomLeft);
		  
		  if(te1 instanceof TileEntityPedastal_Magic		 && te2 instanceof TileEntityPedastal_Magic && te3 instanceof TileEntityPedastal_Magic && te4 instanceof TileEntityPedastal_Magic){
           if(((TileEntityPedastal_Magic) te1).getStack().getItem() == Items.BONE && ((TileEntityPedastal_Magic) te2).getStack().getItem() == Items.BONE && ((TileEntityPedastal_Magic) te3).getStack().getItem() == Items.BONE && ((TileEntityPedastal_Magic) te4).getStack().getItem() == Items.BONE){
        	    
				 ((TileEntityPedastal_Magic) te1).setStack(null);
				((TileEntityPedastal_Magic) te2).setStack(null);
				((TileEntityPedastal_Magic) te3).setStack(null);
				((TileEntityPedastal_Magic) te4).setStack(null);
			
               
               EntityItem itemResult1 = new EntityItem(worldIn, pos.getX(), pos.getY() + 1, pos.getZ(), new ItemStack(me.creepinson.handlers.ItemHandler.boneLarge, 1));
               worldIn.spawnParticle(EnumParticleTypes.CLOUD, pos.getX(), pos.getY() + 1, pos.getZ(), 0.0D, 0.0D, 0.0D);
         	  
     		  worldIn.spawnEntityInWorld(itemResult1);
     		 
           }
           else{
  			 playerIn.addChatComponentMessage(new TextComponentTranslation(TextFormatting.RED + "Invalid Recipe!"));
           }
		  }
           else{
        	   playerIn.addChatComponentMessage(new TextComponentTranslation(TextFormatting.RED + "No Pedastals Found!"));
           }
		  }
		
		  
		  return true;
	}
}

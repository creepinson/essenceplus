package me.creepinson.blocks;

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
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
	{
	
	  worldIn.spawnParticle(EnumParticleTypes.CLOUD, pos.getX(), pos.getY() + 1, pos.getZ(), 0.0D, 0.0D, 0.0D);
	  
	   
	  
	  if(!worldIn.isRemote){
		  BlockPos topRight = new BlockPos(hitX - 1, hitY, hitZ - 1);
		  BlockPos topLeft = new BlockPos(hitX - 1, hitY, hitZ + 1);
		  BlockPos bottomRight = new BlockPos(hitX + 1, hitY, hitZ - 1);
		  BlockPos bottomLeft = new BlockPos(hitX + 1, hitY, hitZ + 1);
			
		  TileEntity te1 = worldIn.getTileEntity(topRight);
		  TileEntity te2 = worldIn.getTileEntity(topLeft);
		  TileEntity te3 = worldIn.getTileEntity(bottomRight);
		  TileEntity te4 = worldIn.getTileEntity(bottomLeft);
		  
		  if(te1 instanceof TileEntityPedastal_Magic && te2 instanceof TileEntityPedastal_Magic && te3 instanceof TileEntityPedastal_Magic && te4 instanceof TileEntityPedastal_Magic){
           if(((TileEntityPedastal_Magic) te1).getStack().getItem() == Items.BONE && ((TileEntityPedastal_Magic) te2).getStack().getItem() == Items.BONE && ((TileEntityPedastal_Magic) te3).getStack().getItem() == Items.BONE && ((TileEntityPedastal_Magic) te4).getStack().getItem() == Items.BONE){
			  EntityItem itemResult1 = new EntityItem(worldIn, pos.getX(), pos.getY() + 2, pos.getZ(), new ItemStack(me.creepinson.handlers.ItemHandler.FireCore, 1));
		   worldIn.spawnEntityInWorld(itemResult1);
  
           }
           else{
  			 playerIn.addChatComponentMessage(new TextComponentTranslation(TextFormatting.RED + "Invalid Recipe!"));
           }
			 playerIn.addChatComponentMessage(new TextComponentTranslation(TextFormatting.RED + "No Pedastals Found!"));
		  }
		  else{
			 playerIn.addChatComponentMessage(new TextComponentTranslation(TextFormatting.RED + "World is NOT Remote!"));
		  }
	  }
	 
	    return true;
	}
}

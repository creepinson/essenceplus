package me.creepinson.blocks;

import javax.annotation.Nullable;
import javax.swing.plaf.basic.BasicComboBoxUI.ItemHandler;

import me.creepinson.entities.TileEntityMobChamber;
import me.creepinson.entities.TileEntityPedastal_Magic;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockMagicalCore extends ModBlocks {

	public BlockMagicalCore(Material mat, String name, CreativeTabs tab, float hardness, float resistance, int harvest, String tool) {
		  super(mat, name, tab, hardness, resistance, harvest, tool);
		 }
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
	{
	 TileEntityPedastal_Magic te = (TileEntityPedastal_Magic) worldIn.getTileEntity(pos);
	  worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, pos.getX(), pos.getY() + 1, pos.getZ(), 0.0D, 0.0D, 0.0D);
	  if(!worldIn.isRemote){
	  EntityItem itemResult1 = new EntityItem(worldIn, hitZ, hitZ, hitZ, new ItemStack(me.creepinson.handlers.ItemHandler.BloodEssence, 1));
	   worldIn.spawnEntityInWorld(itemResult1);
	    itemResult1.setPosition(pos.getX(), pos.getY() + 2, pos.getZ());
	  }
	 
	    return true;
	}
}

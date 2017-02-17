package me.creepinson.blocks;

import javax.annotation.Nullable;

import me.creepinson.entities.TileEntityMobChamber;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockMobChamberCore extends ModBlocks {

	public BlockMobChamberCore(Material mat, String name, CreativeTabs tab, float hardness, float resistance, int harvest, String tool) {
		  super(mat, name, tab, hardness, resistance, harvest, tool);
		 }
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
	{
	 TileEntityMobChamber te = (TileEntityMobChamber) worldIn.getTileEntity(pos);
	    if(te != null && te.formStructure())
	    {
	    	 System.out.println("Structure formed!");

	        //Play sound when forms
	        
	        worldIn.playSound(null, pos, SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.BLOCKS, 1f, 1f);
	    }
	    return true;
	}
}

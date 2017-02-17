package me.creepinson.lib;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class Utils {

	public static Logger logger;
	public static Logger getLogger() {
		if(logger == null){
			logger = LogManager.getFormatterLogger("MeepersPlus");
		}
		return logger;
	}
	public static boolean isBlockAt(World world, BlockPos pos, Block b, int meta)
	{
		return blockstateMatches(world.getBlockState(pos), b, meta);
	}
	public static boolean blockstateMatches(IBlockState state, Block b, int meta)
	{
		if(state.getBlock().equals(b))
			return meta<0||meta==OreDictionary.WILDCARD_VALUE || state.getBlock().getMetaFromState(state)==meta;
		return false;
	}
}

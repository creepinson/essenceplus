package me.creepinson.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import me.creepinson.entities.*;
import me.creepinson.entities.TileEntityMobChamberStructure;
public class BlockMobChamber extends ModBlocks implements ITileEntityProvider

{
	TileEntityMobChamberStructure instance = new TileEntityMobChamberStructure();
	public BlockMobChamber(Material mat, String name, CreativeTabs tab, float hardness, float resistance, int harvest, String tool) {
		 
		super(mat, tool, tab, resistance, resistance);
		 this.setUnlocalizedName("MobChamber");
	        this.setHardness(2.0f);
	        this.setResistance(6.0f);

	
		 }

    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
    BlockPos posy = new BlockPos(x, y, z);
    	TileEntity tile = world.getTileEntity(posy);
        if (tile != null && tile instanceof TileEntityMobChamberStructure) {
        	TileEntityMobChamberStructure multiBlock = (TileEntityMobChamberStructure) tile;
            if (multiBlock.hasMaster()) {
                if (multiBlock.isMaster()) {
                    if (!multiBlock.checkMultiBlockForm())
                        multiBlock.resetStructure();
                } else {
                    if (!multiBlock.checkForMaster()) {
                        multiBlock.reset();
                        world.markBlockRangeForRenderUpdate(posy, posy);
                    }
                }
            }
        }
      
    }

    public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityMobChamberStructure();
     
    }
}


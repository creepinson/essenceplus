package me.creepinson.blocks;

import me.creepinson.entities.TESRPedastal_Magic;
import me.creepinson.entities.TileEntityPedastal_Magic;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Pedastal_Magic extends ModBlocks implements ITileEntityProvider {

	public Pedastal_Magic(Material mat, String name, CreativeTabs tab, float hardness, float resistance, int harvest, String tool) {
		  super(mat, name, tab, hardness, resistance, harvest, tool);
		 }

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
	
		return new TileEntityPedastal_Magic();
	}
	@Override
	public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity te,
			ItemStack stack) {
		
		if(!world.isRemote){

			TileEntity te2 = world.getTileEntity(pos);
			EntityItem itemDropped = new EntityItem(world, pos.getX(), pos.getY() + 1, pos.getZ(), stack);
				world.spawnEntityInWorld(itemDropped);
				stack.stackSize = 0;
		super.harvestBlock(world, player, pos, state, te, stack);
	
		}
		}
	
	
	
    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
        // Bind our TESR to our tile entity
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPedastal_Magic.class, new TESRPedastal_Magic());
    }

  

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
        return false;
    }

    @Override
    public boolean isBlockNormalCube(IBlockState blockState) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState blockState) {
        return false;
    }

    private TileEntityPedastal_Magic getTE(World world, BlockPos pos) {
        return (TileEntityPedastal_Magic) world.getTileEntity(pos);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player,
                    EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileEntityPedastal_Magic te = getTE(world, pos);
            if (te.getStack() == null) {
                if (player.getHeldItem(hand) != null) {
                    // There is no item in the pedestal and the player is holding an item. We move that item
                    // to the pedestal
                    te.setStack(player.getHeldItem(hand));
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    // Make sure the client knows about the changes in the player inventory
                    player.openContainer.detectAndSendChanges();
                }
            } else {
                // There is a stack in the pedestal. In this case we remove it and try to put it in the
                // players inventory if there is room
                ItemStack stack = te.getStack();
                te.setStack(null);
                if (!player.inventory.addItemStackToInventory(stack)) {
                    // Not possible. Throw item in the world
                    EntityItem entityItem = new EntityItem(world, pos.getX(), pos.getY()+1, pos.getZ(), stack);
                    world.spawnEntityInWorld(entityItem);
                } else {
                    player.openContainer.detectAndSendChanges();
                }
            }
        }

        // Return true also on the client to make sure that MC knows we handled this and will not try to place
        // a block on the client
        return true;
    }
}
	

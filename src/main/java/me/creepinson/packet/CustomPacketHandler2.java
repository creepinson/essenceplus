package me.creepinson.packet;

import java.util.ArrayList;

import me.creepinson.blocks.BlockMobChamber;
import me.creepinson.entities.TileEntityPedastal_Magic;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class CustomPacketHandler2 implements IMessageHandler<CustomPacket2, IMessage>{

	

	@Override
	public IMessage onMessage(CustomPacket2 message, MessageContext ctx) {

		EntityPlayerMP serverPlayer = ctx.getServerHandler().playerEntity;
		
		return null;
	}

}

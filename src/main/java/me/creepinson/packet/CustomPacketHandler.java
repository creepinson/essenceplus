package me.creepinson.packet;

import java.util.ArrayList;

import me.creepinson.blocks.BlockMobChamber;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class CustomPacketHandler implements IMessageHandler<CustomPacket, IMessage>{

	

	@Override
	public IMessage onMessage(CustomPacket message, MessageContext ctx) {

		EntityPlayerMP serverPlayer = ctx.getServerHandler().playerEntity;
		BlockMobChamber bmc;
		ItemStack meep;
		 ArrayList<ItemStack> mutantzombie_4l = new ArrayList<ItemStack>();

		

		return null;
	}

}

package me.creepinson.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class CustomPacket2 implements IMessage{
	
	public static World world;
	

	public static BlockPos pos;
	// A default constructor is always required
	  public CustomPacket2(World worldIn, BlockPos pos){
	      this.pos = pos;
		
		this.world = worldIn;
	  }
	 
	
	  
	  public CustomPacket2() {
	    
	   
	  }

	  @Override public void toBytes(ByteBuf buf) {
	

	    buf.writeLong(pos.toLong());
	  
	  }

	  @Override public void fromBytes(ByteBuf buf) {
	    // Reads the int back from the buf. Note that if you have multiple values, you must read in the same order you wrote.
	
		
		
		  pos = BlockPos.fromLong(buf.readLong());
		  
	  }
	}




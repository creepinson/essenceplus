package me.creepinson.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class CustomPacket2 implements IMessage{
	
	public static World world;
	
	public static int x;
	public static int y;
	public static int z;
	public static BlockPos pos;
	// A default constructor is always required
	  public CustomPacket2(World worldIn, BlockPos pos, int x, int y, int z){
	      this.pos = pos;
		  this.x = x;
		  this.y = y;
		  this.z = z;
		this.world = worldIn;
	  }
	 
	
	  
	  public CustomPacket2() {
	    
	   
	  }

	  @Override public void toBytes(ByteBuf buf) {
	

	    buf.writeInt(x);
	    buf.writeInt(y);
	    buf.writeInt(z);
	    
	    buf.writeLong(pos.toLong());
	  
	  }

	  @Override public void fromBytes(ByteBuf buf) {
	    // Reads the int back from the buf. Note that if you have multiple values, you must read in the same order you wrote.
	
		
		  x = buf.readInt();
		  y = buf.readInt();
		  z = buf.readInt();
		  
		  pos = BlockPos.fromLong(buf.readLong());
		  
	  }
	}




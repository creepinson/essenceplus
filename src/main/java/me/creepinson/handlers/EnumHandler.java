package me.creepinson.handlers;

import net.minecraft.util.IStringSerializable;

public class EnumHandler {

	
	
	
public static enum SyringeTypes implements IStringSerializable
{
	
	Empty("Empty", 0),
	Full_Zombie("Full_Zombie", 1),
	Full_Player("Full_Player", 2);
	
	
	private int ID;
	private String name;
	
	private SyringeTypes(String name, int ID){
		
		this.ID = ID;
		this.name = name;
		
	}

	@Override
	public String getName() {
		
		return this.name();
	}


	
	public int getID() {
		
		return ID;
	}

	@Override
	public String toString() {
		
		return super.toString();
	}

	
	
	
}


}

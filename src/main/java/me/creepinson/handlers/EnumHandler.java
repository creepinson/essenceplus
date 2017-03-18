package me.creepinson.handlers;

import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

public class EnumHandler {
	
	
	public static enum Wires implements IStringSerializable
	{
		copper("copper", 0);

		
		private int ID;
		private String name;
		
		private Wires(String name, int ID){
			
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
		
	}
	
	
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
public static enum Cores implements IStringSerializable
{
	
	fire("fire", 0),
	friendly("friendly", 1),
	life("life", 2);
	
	private int ID;
	private String name;
	
	private Cores(String name, int ID){
		
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



public static enum Chips implements IStringSerializable
{

base("base", 0),
redstone("redstone", 1),
advanced("advanced", 2);
private int ID;
private String name;

private Chips(String name, int ID){
	
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


public static enum Essences implements IStringSerializable
{

fire("fire", 0),
blood("blood", 1),
life("life", 2);
private int ID;
private String name;

private Essences(String name, int ID){
	
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

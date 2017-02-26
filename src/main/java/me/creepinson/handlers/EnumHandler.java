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
public static enum Cores implements IStringSerializable
{
	
	Fire("Fire", 0),
	Friendly("Friendly", 1),
	Life("Life", 2);
	
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



public static enum Essences implements IStringSerializable
{

Fire("Fire", 0),
Blood("Blood", 1),
Life("Life", 2);
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

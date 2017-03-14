package me.creepinson.handlers;

import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

public class EnumHandler {
	public static enum SwordLevels implements IStringSerializable
	{
		beginner("Beginner"),
		redstoneGenius("Redstone Genius"),
		ironSmelter("Iron Smelter"),
		goldenHero("Golden Hero"),
		diamondMiner("Diamond Miner"),
		fightingFury("Fighting Fury"),
		swordmaster("Sword Master");
		
		private String levelName;
		
		private SwordLevels(String levelName){
			
		this.levelName = levelName;
			
		}
		
		@Override
		public String getName() {
			
			return levelName;
		}

		public void setLevel(String level, ItemStack item){
		
			
			 item.getTagCompound().setString("level", level);
			
	    
			
			
		}
	public String getLevel(ItemStack item){
		
			
			return item.getTagCompound().getString("level");
			
	    
			
			
		}
	}
	
	public static enum PickLevels implements IStringSerializable
	{
		beginner("Beginner"),
		redstoneGenius("Redstone Genius"),
		ironSmelter("Iron Smelter"),
		goldenHero("Golden Hero"),
		diamondMiner("Diamond Miner"),
		meepingMiner("Meeping Miner"),
		miningMaster("Mining Master");
		
		private String levelName;
		
		private PickLevels(String levelName){
			
		this.levelName = levelName;
			
		}
		
		@Override
		public String getName() {
			
			return levelName;
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

package me.creepinson.main;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class NBTHelper {
	public static NBTTagCompound loadStackNBT(ItemStack stack)
	{
		return stack.hasTagCompound() ? stack.getTagCompound() : new NBTTagCompound();
	}

	public static void saveStackNBT(ItemStack stack, NBTTagCompound nbt)
	{
		
			stack.setTagCompound(nbt);
		
	}
}

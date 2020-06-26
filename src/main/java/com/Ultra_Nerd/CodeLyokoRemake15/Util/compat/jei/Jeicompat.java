package com.Ultra_Nerd.CodeLyokoRemake15.Util.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.util.text.translation.I18n;

import java.util.IllegalFormatException;

@JEIPlugin
public class Jeicompat implements IModPlugin{

	
	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		// TODO Auto-generated method stub
		IModPlugin.super.registerCategories(registry);
	}
	
	@Override
	public void register(IModRegistry registry) {
		// TODO Auto-generated method stub
		IModPlugin.super.register(registry);
	}
	
	public static String trantoloc(String key)
	{
		if(I18n.canTranslate(key)) return I18n.translateToLocal(key);
		else return I18n.translateToFallback(key);
	}
	
	public static String transtolocform(String key, Object... format)
	{
		String s = trantoloc(key);
		try
		{
			return String.format(s,format);
		} catch(IllegalFormatException e)
		{
			return "Format error: " + s;
		}
	}
	
}

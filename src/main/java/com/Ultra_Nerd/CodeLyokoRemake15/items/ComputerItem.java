package com.Ultra_Nerd.CodeLyokoRemake15.items;

import com.Ultra_Nerd.CodeLyokoRemake15.Util.KeyBoardAccess;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;


public class ComputerItem extends Item
{


	public ComputerItem(Properties properties) {
		super(properties);
	}



	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);

		if(KeyBoardAccess.shift())
		{
			tooltip.add(new StringTextComponent("a part for a computer" + "\n" + "there are a bunch of tiers" + "\n" + "the color of the item indicates it's tier"));
		}
		else
		{
			tooltip.add(new StringTextComponent("Hold " + "\u00A7e" + "Shift " + "\u00A77" + "For more details"));
		}
	}


}

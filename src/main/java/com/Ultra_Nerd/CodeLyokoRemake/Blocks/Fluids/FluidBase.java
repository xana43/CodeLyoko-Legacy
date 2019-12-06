import com.Ultra_Nerd.CodeLyokoRemake.Base;
import com.Ultra_Nerd.CodeLyokoRemake.Util.IHasModel;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModFluids;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.main.Main;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidBase extends Fluid implements IHasModel
{
    static
    {
        FluidRegistry.enableUniversalBucket();
    }
    public FluidBase(String name, Material material)
    {
        this(name, material, new ResourceLocation("fluid/"+ name + "_still"), new ResourceLocation("fluid/" + name + "_flowing"));
    }
    
    public FluidBase(String name, Material material, ResourceLocation still, ResourceLocation flowing)
    {
        super(name, still, flowing);
        block = new BlockFluidClassic(this, material);
        block.setUnlocalizedName(name);
        block.setRegistryName("fluid " + name);
        Item item = new ItemBlock(block);
        item.setRegistryName(name);
        ModFluids.BLOCKSFLUID.add(this);
        Modblocks.BLOCKS.add(block);
        ModItems.Items.add(item);
    }
    
    @Override
    public void registerModels()
    {
        Base.proxy.registerFluidModel(Item.getItemFromBlock(this.getBlock()), this.getBlock(), this.getName());
    }
}
  
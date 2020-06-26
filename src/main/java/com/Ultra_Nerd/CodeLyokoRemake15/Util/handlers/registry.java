package com.Ultra_Nerd.CodeLyokoRemake15.Util.handlers;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.init.LyokoTiers;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.InterfaceTileEntity;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class registry 
{
	
	
	
	
	public static void init()
	{
		
        Tiles.register(FMLJavaModLoadingContext.get().getModEventBus());
        
        
        Containers.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	public static final DeferredRegister<TileEntityType<?>> Tiles = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, Base.MOD_ID);
	public static final DeferredRegister<ContainerType<?>> Containers = new DeferredRegister<>(ForgeRegistries.CONTAINERS, Base.MOD_ID);
	
    
    
   
   
	
	
	  
	  
	//for tileentities
	 //public static final RegistryObject<TileEntityType<InterfaceTileEntity>> TOWERINTERFACE = Tiles.register("tower_interface", () -> TileEntityType.Builder.create(InterfaceTileEntity::new, TOWER_INTERFACE.get()).build(null));
	
	
	 

	 
	 
	
}



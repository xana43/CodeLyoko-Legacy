package com.Ultra_Nerd.CodeLyokoRemake15.Util.handlers;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.Abunta;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.AutuniteOre;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.COOL;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.CableBlock;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.CarontiteOre;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.CoffiniteOre;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.CompFrame;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.CompScreen;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.DIO;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.DigialGrass;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.DigitalIce;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.DigitalRock;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.Dsand;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.FlouriteBlock;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.FlouriteOre;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.GummiteOre;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.Holo;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.HoloPro;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.MTree;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.Marabunta;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.QuantSteel;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.QuantumBlock;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.QuantumCore;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.SaleeiteOre;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.SilicaSand;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.Titanium;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.TorberniteOre;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.TowerBase;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.TowerBlockBlue;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.TowerBlockNonSolid;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.TowerBlockWhite;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.TowerInterface;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.Trans;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.TyuyamuniteOre;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.UniversalEnergyBlock;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.UraniniteOre;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.UraniumBlock;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.UraniumReactor;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.sector5block;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.tree;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.tt;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.machine.flouride.ElectricFlourideInfuser;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.machine.flouride.FlourideInfuser;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModFluids;
import com.Ultra_Nerd.CodeLyokoRemake15.items.ItemBase;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class registry 
{
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Base.MOD_ID);
	
	public static void init()
	{
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Base.MOD_ID);
	
	//for items
	 public static final RegistryObject<Item> SOLID_QUANTUM = ITEMS.register("solid_quantum", ItemBase::new);

	 public static final RegistryObject<Item>  SILICON_WAFER = ITEMS.register("silicon_wafer", ItemBase::new);

	 public static final RegistryObject<Item>  URANIUM_SILACATE = ITEMS.register("uranium_silicate", ItemBase::new);

	 public static final RegistryObject<Item>  URANIUM_DIOXIDE = ITEMS.register("uranium_dioxide", ItemBase::new);

	 public static final RegistryObject<Item>  URANIUM_MELT = ITEMS.register("uranium_melt", ItemBase::new);

	 public static final RegistryObject<Item>  URANIUM_ISOTOPE238 = ITEMS.register("uranium_isotope238", ItemBase::new);

	 public static final RegistryObject<Item>  URANIUM_ISOTOPE235 = ITEMS.register("uranium_isotope235", ItemBase::new);

	 public static final RegistryObject<Item>  RAW_SILICADUST = ITEMS.register("raw_silicadust", ItemBase::new);

	 public static final RegistryObject<Item>  TRIURANIUM_OCTAOXIDE = ITEMS.register("triuranium_octaoxide", ItemBase::new);

	 public static final RegistryObject<Item>  FLOURIDE = ITEMS.register("flouride", ItemBase::new);

	 public static final RegistryObject<Item>  BIT = ITEMS.register("bit", ItemBase::new);

	 public static final RegistryObject<Item>  BYTE = ITEMS.register("byte", ItemBase::new);

	 public static final RegistryObject<Item>  MEGABIT = ITEMS.register("megabit", ItemBase::new);

	 public static final RegistryObject<Item>  MEGABYTE = ITEMS.register("MegaByte", ItemBase::new);

	 public static final RegistryObject<Item>  GIGABIT = ITEMS.register("gigabit", ItemBase::new);

	 public static final RegistryObject<Item>  GIGABYTE = ITEMS.register("GigaByte", ItemBase::new);

	 public static final RegistryObject<Item>  TERABIT = ITEMS.register("terabit", ItemBase::new);

	 public static final RegistryObject<Item>  TERABYTE = ITEMS.register("TeraByte", ItemBase::new);

	 public static final RegistryObject<Item>  PETABIT = ITEMS.register("petabit", ItemBase::new);

	 public static final RegistryObject<Item>  PETABYTE = ITEMS.register("PetaByte", ItemBase::new);

	 public static final RegistryObject<Item>  QUBIT = ITEMS.register("qubit", ItemBase::new);

	 public static final RegistryObject<Item>  QUBYTE = ITEMS.register("QuByte", ItemBase::new);

	 public static final RegistryObject<Item>  TITANIUMI = ITEMS.register("titanium", ItemBase::new);

	//for blocks
	  public static final RegistryObject<Block> QUANTUM_BLOCK = BLOCKS.register("quantum_block",QuantumBlock::new);
	  public static final RegistryObject<Block> QUANTUM_CORE = BLOCKS.register("quantum_core",QuantumCore::new);
	  public static final RegistryObject<Block> COMPUTER_FRAME = BLOCKS.register("computer_frame",CompFrame::new);
	  public static final RegistryObject<Block> COMPUTER_SCREEN = BLOCKS.register("computer_screen",CompScreen::new);
	  public static final RegistryObject<Block> URANINITE_ORE = BLOCKS.register("uraninite_ore",UraniniteOre::new);
	  public static final RegistryObject<Block> CABLE_BLOCK = BLOCKS.register("cable_block",CableBlock::new);
	  public static final RegistryObject<Block> TOWER_INTERFACE = BLOCKS.register("tower_interface",TowerInterface::new);
	  public static final RegistryObject<Block> SCANNER_BASE = BLOCKS.register("scanner_base", Virtualization::new);
	  public static final RegistryObject<Block> ELECTRICFLOURIDE_INFUSER = BLOCKS.register("electric_flouride_infuser",ElectricFlourideInfuser::new);
	  public static final RegistryObject<Block> FLOURIDE_INFUSER = BLOCKS.register("floride_infuser",FlourideInfuser::new);
	  public static final RegistryObject<Block> FLOURITE_ORE = new FlouriteOre("flourite_ore", Material.ROCK);
	  public static final RegistryObject<Block> FLOURITE_BLOCK = new FlouriteBlock("flourite_block", Material.ROCK);
	  public static final RegistryObject<Block> TOWER_BASE = new TowerBase("tower_base", Material.DRAGON_EGG);
	  public static final RegistryObject<Block> TT = new tt("tt");
	  public static final RegistryObject<Block> DIGITAL_ICE = new DigitalIce("digital_ice", Material.PACKED_ICE);
	  public static final RegistryObject<Block> TOWER_WHITE = new TowerBlockWhite("tower_white",Material.CIRCUITS);
	  public static final RegistryObject<Block> TOWER_BLUE = new TowerBlockBlue("tower_blue",Material.CIRCUITS);
	  public static final RegistryObject<Block> URANUM_REACTOR = new UraniumReactor("computer_reactor", Material.CIRCUITS);
	  public static final RegistryObject<Block> CARNOTITE_ORE = new CarontiteOre("carnotite_ore", Material.ROCK);
	  public static final RegistryObject<Block> TYUYAMUNITE_ORE = new TyuyamuniteOre("tyuyamunite_ore", Material.ROCK);
	  public static final RegistryObject<Block> TORBERNITE_ORE = new TorberniteOre("torbernite_ore", Material.ROCK);
	  public static final RegistryObject<Block> AUTUNITE_ORE = new AutuniteOre("autunite_ore", Material.ROCK);
	  public static final RegistryObject<Block> GUMMITE_ORE = new GummiteOre("gummite_ore", Material.ROCK);
	  public static final RegistryObject<Block> SALEEITE_ORE = new SaleeiteOre("saleeite_ore", Material.ROCK);
	  public static final RegistryObject<Block> COFFINITE_ORE = new CoffiniteOre("coffinite_ore", Material.ROCK);
	  public static final RegistryObject<Block> TOWER_ENTER = new TowerBlockNonSolid("tower_enter", Material.CIRCUITS);
	  public static final RegistryObject<Block> MARABUNTA = new Marabunta("marabunta",Material.DRAGON_EGG);
	  public static final RegistryObject<Block> TITANIUM = BLOCKS.register("titanium",Titanium::new);
	  public static final RegistryObject<Block> DIGITA_SAND = new Dsand("digital_sand", Material.SAND);
	  public static final RegistryObject<Block> ANTI_MARABUNTA = new Abunta("anti_marabunta", Material.DRAGON_EGG);
	  public static final RegistryObject<Block> HOLO = new Holo("holo", Material.DRAGON_EGG);
	  public static final RegistryObject<Block> HOLOPROJECTOR = new HoloPro("holoprojector", Material.IRON);
	  public static final RegistryObject<Block> Storage = new UniversalEnergyBlock("universal", Material.IRON);
	  public static final RegistryObject<Block> TRANSPARENT = new Trans("transparent", Material.STRUCTURE_VOID);
	  public static final RegistryObject<Block> QUANTUM_STEEL = new QuantSteel("quantum_steel", Material.IRON);
	  public static final RegistryObject<Block> URANIUM_BLOCK = new UraniumBlock("uranium_block", Material.IRON);
	  public static final RegistryObject<Block> SECTOR_5 = new sector5block("sector5ground", Material.BARRIER);
	  //public static final RegistryObject<Block> URANOPHANE_ORE
	  //public static final RegistryObject<Block> SKLODOWSKITE_ORE
	  public static final RegistryObject<Block> SILICA_SAND = new SilicaSand("silica_sand", Material.SAND);
	  public static final RegistryObject<Block> DIGITAL_BLOCK = BLOCKS.register("digital_block",DigialGrass::new);
	  public static final RegistryObject<Block> DIGITAL_ROCK = new DigitalRock("digital_rock", Material.ROCK);
	  public static final RegistryObject<Block> FOREST_TREE = new tree("digital_tree", Material.WOOD);
	  public static final RegistryObject<Block> MOUNTAIN_TREE = new MTree("mountain_tree", Material.WOOD);
	  public static final RegistryObject<Block> DIGITAL_OCEAN = new DIO("digital_ocean", ModFluids.DIGITAL_SEA, Material.WATER);
	  public static final RegistryObject<Block> COOLANT_BLOCK = new COOL("coolant_block", ModFluids.COOLANT_FLUID, Material.WATER);
	  //for block Items
	  public static final RegistryObject<Item> DIGITAL_BLOCK_ITEM = ITEMS.register("digital_block",() -> new BlockItem(DIGITAL_BLOCK.get(), new Item.Properties()
			  		.group(ItemGroup.BUILDING_BLOCKS))
			  	
			  );
}



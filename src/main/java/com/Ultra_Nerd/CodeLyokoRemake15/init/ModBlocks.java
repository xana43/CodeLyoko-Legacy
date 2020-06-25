package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.AntiMarabunta;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.AutuniteOre;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.CableBlock;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.CarontiteOre;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.CoffiniteOre;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.ComputerFrame;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.ComputerScreen;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.DigitalGrass;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.DigitalIce;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.DigitalRock;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.DigitalSand;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.FlouriteBlock;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.FlouriteOre;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.GummiteOre;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.HologramBlock;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.HologramProjectorBlock;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.MountainTreeBlock;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.Marabunta;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.QuantSteelBlock;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.QuantumBlock;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.QuantumCore;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.SaleeiteOre;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.SilicaSand;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.Titanium;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.TorberniteOre;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.TowerBase;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.TowerBlockBlue;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.TowerBlockNonSolid;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.TowerBlockWhite;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.TowerInterface;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.TransparentBlock;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.TyuyamuniteOre;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.UniversalEnergyBlock;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.UraniniteOre;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.UraniumBlock;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.UraniumReactor;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.Virutalization;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.SectorFiveBlock;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.Tree;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.TowerWall;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.flouride.ElectricFlourideInfuser;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.flouride.FlourideInfuser;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
		
		public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Base.MOD_ID);
	//for blocks
		 public static final RegistryObject<Block> ANTI_MARABUNTA = BLOCKS.register("anti_marabunta", AntiMarabunta::new);
		 public static final RegistryObject<Block> AUTUNITE_ORE = BLOCKS.register("autunite_ore",AutuniteOre::new);
		 public static final RegistryObject<Block> COMPUTER_FRAME = BLOCKS.register("computer_frame", ComputerFrame::new);
		 public static final RegistryObject<Block> COMPUTER_SCREEN = BLOCKS.register("computer_screen", ComputerScreen::new);
		 public static final RegistryObject<Block> COFFINITE_ORE = BLOCKS.register("coffinite_ore", CoffiniteOre::new) ;
		
		 public static final RegistryObject<Block> CARNOTITE_ORE = BLOCKS.register("carnotite_ore",CarontiteOre::new);
		 public static final RegistryObject<Block> CABLE_BLOCK = BLOCKS.register("cable_block",CableBlock::new);
		 public static final RegistryObject<Block> DIGITAL_BLOCK = BLOCKS.register("digital_block", DigitalGrass::new);
		 public static final RegistryObject<Block> DIGITAL_ROCK = BLOCKS.register("digital_rock", DigitalRock::new);
		 public static final RegistryObject<Block> DIGITAL_ICE = BLOCKS.register("digital_ice", DigitalIce::new);
		
		 public static final RegistryObject<Block> DIGITAL_SAND = BLOCKS.register("digital_sand", DigitalSand::new);
		 public static final RegistryObject<Block> ELECTRICFLOURIDE_INFUSER = BLOCKS.register("electric_flouride_infuser",ElectricFlourideInfuser::new);
		 public static final RegistryObject<Block> FLOURIDE_INFUSER = BLOCKS.register("floride_infuser",FlourideInfuser::new);
		 public static final RegistryObject<Block> FLOURITE_ORE = BLOCKS.register("flourite_ore",FlouriteOre::new);
		 public static final RegistryObject<Block> FLOURITE_BLOCK = BLOCKS.register("flourite_block",FlouriteBlock::new);
		 public static final RegistryObject<Block> FOREST_TREE = BLOCKS.register("digital_tree", Tree::new);
		 public static final RegistryObject<Block> GUMMITE_ORE = BLOCKS.register("gummite_ore",GummiteOre::new);
		 public static final RegistryObject<Block> HOLO = BLOCKS.register("holo", HologramBlock::new);
		 public static final RegistryObject<Block> HOLOPROJECTOR = BLOCKS.register("holoprojector", HologramProjectorBlock::new);
		 public static final RegistryObject<Block> MARABUNTA = BLOCKS.register("marabunta",Marabunta::new);
		 public static final RegistryObject<Block> MOUNTAIN_TREE = BLOCKS.register("mountain_tree", MountainTreeBlock::new);
		 public static final RegistryObject<Block> QUANTUM_BLOCK = BLOCKS.register("quantum_block",QuantumBlock::new);
		 public static final RegistryObject<Block> QUANTUM_CORE = BLOCKS.register("quantum_core",QuantumCore::new);
		 public static final RegistryObject<Block> QUANTUM_STEEL = BLOCKS.register("quantum_steel", QuantSteelBlock::new);
		 public static final RegistryObject<Block> SALEEITE_ORE = BLOCKS.register("saleeite_ore", SaleeiteOre::new);
		 public static final RegistryObject<Block> SECTOR_5 = BLOCKS.register("sector5ground", SectorFiveBlock::new);
		 public static final RegistryObject<Block> SCANNER_BASE = BLOCKS.register("scanner_base", Virutalization::new);
		 public static final RegistryObject<Block> Storage = BLOCKS.register("universal", UniversalEnergyBlock::new);
		//public static final RegistryObject<Block> SKLODOWSKITE_ORE
		 public static final RegistryObject<Block> SILICA_SAND = BLOCKS.register("silica_sand",SilicaSand::new);
		 public static final RegistryObject<Block> TOWER_WHITE = BLOCKS.register("tower_white", TowerBlockWhite::new);
		 public static final RegistryObject<Block> TOWER_INTERFACE = BLOCKS.register("tower_interface",TowerInterface::new);
		 public static final RegistryObject<Block> TOWER_BASE = BLOCKS.register("tower_base", TowerBase::new);
		 public static final RegistryObject<Block> TT = BLOCKS.register("tt", TowerWall::new);
		 public static final RegistryObject<Block> TOWER_BLUE = BLOCKS.register("tower_blue", TowerBlockBlue::new);
		 public static final RegistryObject<Block> TYUYAMUNITE_ORE = BLOCKS.register("tyuyamunite_ore",TyuyamuniteOre::new);
		 public static final RegistryObject<Block> TORBERNITE_ORE = BLOCKS.register("torbernite_ore",TorberniteOre::new);
		 public static final RegistryObject<Block> TOWER_ENTER = BLOCKS.register("tower_enter", TowerBlockNonSolid::new);
		 public static final RegistryObject<Block> TITANIUM = BLOCKS.register("titanium",Titanium::new);
		 public static final RegistryObject<Block> TRANSPARENT = BLOCKS.register("transparent", TransparentBlock::new);
		 public static final RegistryObject<Block> URANUM_REACTOR = BLOCKS.register("computer_reactor",UraniumReactor::new);
		 public static final RegistryObject<Block> URANINITE_ORE = BLOCKS.register("uraninite_ore",UraniniteOre::new);
		 public static final RegistryObject<Block> URANIUM_BLOCK = BLOCKS.register("uranium_block",UraniumBlock::new);
		//public static final RegistryObject<Block> URANOPHANE_ORE =  Blocks.register("uranophane_ore", UranophaneOre::new);
}

package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.Abunta;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.AutuniteOre;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.CableBlock;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.CarontiteOre;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.CoffiniteOre;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.CompFrame;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.CompScreen;
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
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.Virutalization;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.sector5block;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.tree;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.tt;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.machine.flouride.ElectricFlourideInfuser;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.machine.flouride.FlourideInfuser;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
		
		public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Base.MOD_ID);
	//for blocks
		 public static final RegistryObject<Block> ANTI_MARABUNTA = BLOCKS.register("anti_marabunta", Abunta::new);
		 public static final RegistryObject<Block> AUTUNITE_ORE = BLOCKS.register("autunite_ore",AutuniteOre::new);
		 public static final RegistryObject<Block> COMPUTER_FRAME = BLOCKS.register("computer_frame",CompFrame::new);
		 public static final RegistryObject<Block> COMPUTER_SCREEN = BLOCKS.register("computer_screen",CompScreen::new);
		 public static final RegistryObject<Block> COFFINITE_ORE = BLOCKS.register("coffinite_ore", CoffiniteOre::new) ;
		
		 public static final RegistryObject<Block> CARNOTITE_ORE = BLOCKS.register("carnotite_ore",CarontiteOre::new);
		 public static final RegistryObject<Block> CABLE_BLOCK = BLOCKS.register("cable_block",CableBlock::new);
		 public static final RegistryObject<Block> DIGITAL_BLOCK = BLOCKS.register("digital_block",DigialGrass::new);
		 public static final RegistryObject<Block> DIGITAL_ROCK = BLOCKS.register("digital_rock", DigitalRock::new);
		 public static final RegistryObject<Block> DIGITAL_ICE = BLOCKS.register("digital_ice", DigitalIce::new);
		
		 public static final RegistryObject<Block> DIGITAL_SAND = BLOCKS.register("digital_sand",Dsand::new);
		 public static final RegistryObject<Block> ELECTRICFLOURIDE_INFUSER = BLOCKS.register("electric_flouride_infuser",ElectricFlourideInfuser::new);
		 public static final RegistryObject<Block> FLOURIDE_INFUSER = BLOCKS.register("floride_infuser",FlourideInfuser::new);
		 public static final RegistryObject<Block> FLOURITE_ORE = BLOCKS.register("flourite_ore",FlouriteOre::new);
		 public static final RegistryObject<Block> FLOURITE_BLOCK = BLOCKS.register("flourite_block",FlouriteBlock::new);
		 public static final RegistryObject<Block> FOREST_TREE = BLOCKS.register("digital_tree",tree::new);
		 public static final RegistryObject<Block> GUMMITE_ORE = BLOCKS.register("gummite_ore",GummiteOre::new);
		 public static final RegistryObject<Block> HOLO = BLOCKS.register("holo", Holo::new);
		 public static final RegistryObject<Block> HOLOPROJECTOR = BLOCKS.register("holoprojector", HoloPro::new);
		 public static final RegistryObject<Block> MARABUNTA = BLOCKS.register("marabunta",Marabunta::new);
		 public static final RegistryObject<Block> MOUNTAIN_TREE = BLOCKS.register("mountain_tree",MTree::new);
		 public static final RegistryObject<Block> QUANTUM_BLOCK = BLOCKS.register("quantum_block",QuantumBlock::new);
		 public static final RegistryObject<Block> QUANTUM_CORE = BLOCKS.register("quantum_core",QuantumCore::new);
		 public static final RegistryObject<Block> QUANTUM_STEEL = BLOCKS.register("quantum_steel",QuantSteel::new);
		 public static final RegistryObject<Block> SALEEITE_ORE = BLOCKS.register("saleeite_ore", SaleeiteOre::new);
		 public static final RegistryObject<Block> SECTOR_5 = BLOCKS.register("sector5ground",sector5block::new);
		 public static final RegistryObject<Block> SCANNER_BASE = BLOCKS.register("scanner_base", Virutalization::new);
		 public static final RegistryObject<Block> Storage = BLOCKS.register("universal", UniversalEnergyBlock::new);
		//public static final RegistryObject<Block> SKLODOWSKITE_ORE
		 public static final RegistryObject<Block> SILICA_SAND = BLOCKS.register("silica_sand",SilicaSand::new);
		 public static final RegistryObject<Block> TOWER_WHITE = BLOCKS.register("tower_white", TowerBlockWhite::new);
		 public static final RegistryObject<Block> TOWER_INTERFACE = BLOCKS.register("tower_interface",TowerInterface::new);
		 public static final RegistryObject<Block> TOWER_BASE = BLOCKS.register("tower_base", TowerBase::new);
		 public static final RegistryObject<Block> TT = BLOCKS.register("tt",tt::new);
		 public static final RegistryObject<Block> TOWER_BLUE = BLOCKS.register("tower_blue", TowerBlockBlue::new);
		 public static final RegistryObject<Block> TYUYAMUNITE_ORE = BLOCKS.register("tyuyamunite_ore",TyuyamuniteOre::new);
		 public static final RegistryObject<Block> TORBERNITE_ORE = BLOCKS.register("torbernite_ore",TorberniteOre::new);
		 public static final RegistryObject<Block> TOWER_ENTER = BLOCKS.register("tower_enter", TowerBlockNonSolid::new);
		 public static final RegistryObject<Block> TITANIUM = BLOCKS.register("titanium",Titanium::new);
		 public static final RegistryObject<Block> TRANSPARENT = BLOCKS.register("transparent",Trans::new);
		 public static final RegistryObject<Block> URANUM_REACTOR = BLOCKS.register("computer_reactor",UraniumReactor::new);
		 public static final RegistryObject<Block> URANINITE_ORE = BLOCKS.register("uraninite_ore",UraniniteOre::new);
		 public static final RegistryObject<Block> URANIUM_BLOCK = BLOCKS.register("uranium_block",UraniumBlock::new);
		//public static final RegistryObject<Block> URANOPHANE_ORE =  Blocks.register("uranophane_ore", UranophaneOre::new);
}

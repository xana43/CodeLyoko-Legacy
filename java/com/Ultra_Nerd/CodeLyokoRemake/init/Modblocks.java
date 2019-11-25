package com.Ultra_Nerd.CodeLyokoRemake.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.Ultra_Nerd.CodeLyokoRemake.Blocks.CableBlock;
import com.Ultra_Nerd.CodeLyokoRemake.Blocks.CoffiniteOre;
import com.Ultra_Nerd.CodeLyokoRemake.Blocks.CompFrame;
import com.Ultra_Nerd.CodeLyokoRemake.Blocks.CompScreen;
import com.Ultra_Nerd.CodeLyokoRemake.Blocks.DigialGrass;
import com.Ultra_Nerd.CodeLyokoRemake.Blocks.FlouriteBlock;
import com.Ultra_Nerd.CodeLyokoRemake.Blocks.FlouriteOre;
import com.Ultra_Nerd.CodeLyokoRemake.Blocks.QuantumBlock;
import com.Ultra_Nerd.CodeLyokoRemake.Blocks.QuantumCore;
import com.Ultra_Nerd.CodeLyokoRemake.Blocks.SilicaSand;
import com.Ultra_Nerd.CodeLyokoRemake.Blocks.UraniniteOre;
import com.Ultra_Nerd.CodeLyokoRemake.Blocks.Virutalization;
import com.Ultra_Nerd.CodeLyokoRemake.Blocks.blockBase;
import com.Ultra_Nerd.CodeLyokoRemake.Blocks.machine.flouride.FlourideInfuser;
public class Modblocks 
{
  public static final List<Block> BLOCKS = new ArrayList<Block>();
  
  public static final Block QUANTUM_BLOCK = new QuantumBlock("quantum_block", Material.IRON);
  public static final Block QUANTUM_CORE = new QuantumCore("quantum_core", Material.REDSTONE_LIGHT);
  public static final Block COMPUTER_FRAME = new CompFrame("computer_frame", Material.REDSTONE_LIGHT);
  public static final Block COMPUTER_SCREEN = new CompScreen("computer_screen", Material.GLASS);
  public static final Block URANINITE_ORE = new UraniniteOre("uraninite_ore", Material.ROCK);
  public static final Block CABLE_BLOCK = new CableBlock("cable_block", Material.CIRCUITS);
  public static final Block SCANNER_BASE = new Virutalization("scanner_base", Material.CIRCUITS);
  public static final Block FLOURIDE_INFUSER = new FlourideInfuser("flouride_infuser", Material.IRON);
  public static final Block FLOURITE_ORE = new FlouriteOre("flourite_ore", Material.ROCK);
  public static final Block FLOURITE_BLOCK = new FlouriteBlock("flourite_block", Material.ROCK);
  //public static final Block CARNOTITE_ORE
  //public static final Block TYUTAMUNITE_ORE
  //public static final Block TORBERNITE_ORE
  //public static final Block AUTUNITE_ORE
  //public static final Block GUMMITE_ORE
  //public static final Block SALEEITE_ORE
  public static final Block COFFINITE_ORE = new CoffiniteOre("coffinite_ore", Material.ROCK);
  //public static final Block URANOPHANE_ORE
  //public static final Block SKLODOWSKITE_ORE
  public static final Block SILICA_SAND = new SilicaSand("silica_sand", Material.SAND);
 // public static final Block TEST_CORE = new TileBlockBase("computer_test");
  public static final Block DIGITAL_BLOCK = new DigialGrass("digital_block", Material.GROUND);
}

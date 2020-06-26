package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.*;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.flouride.ElectricFlourideInfuser;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.flouride.FlourideInfuser;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {


	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Base.MOD_ID);

	//for blocks
	public static final RegistryObject<Block> ANTI_MARABUNTA = BLOCKS.register("anti_marabunta", AntiMarabunta::new);
	public static final RegistryObject<Block> AUTUNITE_ORE = BLOCKS.register("autunite_ore",() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3, 2).sound(SoundType.STONE).lightValue(0).harvestLevel(2).harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> COMPUTER_FRAME = BLOCKS.register("computer_frame", () -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1, 20).sound(SoundType.METAL).lightValue(0).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> COMPUTER_SCREEN = BLOCKS.register("computer_screen", () -> new Block(Block.Properties.create(Material.GLASS).hardnessAndResistance(1, 20).sound(SoundType.GLASS).lightValue(1).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> COFFINITE_ORE = BLOCKS.register("coffinite_ore", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(6, 10).sound(SoundType.STONE).lightValue(1).harvestLevel(2).harvestTool(ToolType.PICKAXE))) ;

	public static final RegistryObject<Block> CARNOTITE_ORE = BLOCKS.register("carnotite_ore",() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(6, 10).sound(SoundType.STONE).lightValue(1).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> DIGITAL_GRASS = BLOCKS.register("digital_grass", () -> new Block(Block.Properties.create(Material.EARTH).harvestTool(ToolType.SHOVEL).hardnessAndResistance(4,20).lightValue(0).harvestLevel(20).sound(SoundType.GROUND)));
	public static final RegistryObject<Block> DIGITAL_ROCK = BLOCKS.register("digital_rock", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(4, 20).sound(SoundType.STONE).lightValue(0).harvestLevel(20).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> DIGITAL_ICE = BLOCKS.register("digital_ice", () -> new Block(Block.Properties.create(Material.ICE).hardnessAndResistance(40, 10).sound(SoundType.GLASS).lightValue(0)));
	public static final RegistryObject<Block> DIGITAL_SAND = BLOCKS.register("digital_sand", () -> new Block(Block.Properties.create(Material.SAND).hardnessAndResistance(20, 10).sound(SoundType.SAND).lightValue(0).harvestLevel(20).harvestTool(ToolType.SHOVEL)));
	public static final RegistryObject<Block> ELECTRICFLOURIDE_INFUSER = BLOCKS.register("electric_flouride_infuser",ElectricFlourideInfuser::new);
	public static final RegistryObject<Block> FLOURIDE_INFUSER = BLOCKS.register("floride_infuser",FlourideInfuser::new);
	public static final RegistryObject<Block> FLOURITE_BLOCK = BLOCKS.register("flourite_block",() -> new Block(Block.Properties.create(Material.SAND).hardnessAndResistance(-1, 10).sound(SoundType.SAND).lightValue(0).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> FLOURITE_ORE = BLOCKS.register("flourite_ore",() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(6, 10).sound(SoundType.STONE).lightValue(1).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> HOLOPROJECTOR = BLOCKS.register("holoprojector", HologramProjectorBlock::new);
	public static final RegistryObject<Block> HOLOPROJECTOR_PROJECTION = BLOCKS.register("holo", () -> new Block(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(-1,-1).lightValue(3)));
	public static final RegistryObject<Block> MARABUNTA = BLOCKS.register("marabunta",Marabunta::new);
	public static final RegistryObject<Block> MOUNTAIN_TREE = BLOCKS.register("mountain_tree", MountainTreeBlock::new);
	public static final RegistryObject<Block> QUANTUM_BLOCK = BLOCKS.register("quantum_block",() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(6, 20).sound(SoundType.METAL).lightValue(0).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> QUANTUM_CORE = BLOCKS.register("quantum_core",() -> new Block(Block.Properties.create(Material.REDSTONE_LIGHT).hardnessAndResistance(1, 20).sound(SoundType.GLASS).lightValue(1).harvestLevel(0)));
	public static final RegistryObject<Block> QUANTUM_STEEL = BLOCKS.register("quantum_steel", QuantSteelBlock::new);
	public static final RegistryObject<Block> SALEEITE_ORE = BLOCKS.register("saleeite_ore", SaleeiteOre::new);
	public static final RegistryObject<Block> SECTOR_5 = BLOCKS.register("sector5ground", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(-1, -1).sound(SoundType.GLASS).lightValue(4)));
	public static final RegistryObject<Block> SCANNER_BASE = BLOCKS.register("scanner_base", Virutalization::new);
	public static final RegistryObject<Block> Storage = BLOCKS.register("universal", UniversalEnergyBlock::new);
	//public static final RegistryObject<Block> SKLODOWSKITE_ORE
	public static final RegistryObject<Block> SILICA_SAND = BLOCKS.register("silica_sand",() -> new Block(Block.Properties.create(Material.SAND).hardnessAndResistance(6, 10).sound(SoundType.SAND).lightValue(1).harvestLevel(1).harvestTool(ToolType.SHOVEL)));
	public static final RegistryObject<Block> TOWER_WHITE = BLOCKS.register("tower_white", () -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(20, 20).sound(SoundType.GLASS).lightValue(4).harvestLevel(20).harvestTool(ToolType.SHOVEL)));
	public static final RegistryObject<Block> TOWER_INTERFACE = BLOCKS.register("tower_interface",TowerInterface::new);
	public static final RegistryObject<Block> TOWER_BASE = BLOCKS.register("tower_base", () -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(20, 20).sound(SoundType.GLASS).lightValue(0).harvestLevel(20).harvestTool(ToolType.SHOVEL)));
	public static final RegistryObject<Block> TOWER_WALL = BLOCKS.register("tower_wall", TowerWall::new);
	public static final RegistryObject<Block> TOWER_BLUE = BLOCKS.register("tower_blue", () -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(20, 20).sound(SoundType.GLASS).lightValue(4).harvestLevel(20).harvestTool(ToolType.SHOVEL)));
	public static final RegistryObject<Block> TYUYAMUNITE_ORE = BLOCKS.register("tyuyamunite_ore",TyuyamuniteOre::new);
	public static final RegistryObject<Block> TORBERNITE_ORE = BLOCKS.register("torbernite_ore",TorberniteOre::new);
	public static final RegistryObject<Block> TOWER_ENTER = BLOCKS.register("tower_enter", () -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(20, 20).sound(SoundType.GLASS).lightValue(0).harvestLevel(20).harvestTool(ToolType.SHOVEL).doesNotBlockMovement()));
	public static final RegistryObject<Block> TITANIUM = BLOCKS.register("titanium_block",() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(6, 10).sound(SoundType.METAL).lightValue(1).harvestLevel(3).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> TRANSPARENT = BLOCKS.register("transparent", TransparentBlock::new);
	public static final RegistryObject<Block> URANUM_REACTOR = BLOCKS.register("computer_reactor",UraniumReactor::new);
	public static final RegistryObject<Block> URANINITE_ORE = BLOCKS.register("uraninite_ore",() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(6, 10).sound(SoundType.STONE).lightValue(1).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> URANIUM_BLOCK = BLOCKS.register("uranium_block",() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(6, 20).sound(SoundType.METAL).lightValue(0).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
			//public static final RegistryObject<Block> URANOPHANE_ORE =  Blocks.register("uranophane_ore", UranophaneOre::new);
		}
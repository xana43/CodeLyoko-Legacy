package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.*;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.flouride.ElectricFlourideInfuser;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.flouride.FlourideInfuser;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
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
    public static final RegistryObject<Block> AUTUNITE_ORE = BLOCKS.register("autunite_ore", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3, 2).sound(SoundType.STONE).lightValue(0).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> COMPUTER_FRAME = BLOCKS.register("computer_frame", ComputerFrame::new);
    public static final RegistryObject<Block> COMPUTER_SCREEN = BLOCKS.register("computer_screen", ComputerScreen::new);
    public static final RegistryObject<Block> COFFINITE_ORE = BLOCKS.register("coffinite_ore", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(6, 10).sound(SoundType.STONE).lightValue(1).harvestLevel(2).harvestTool(ToolType.PICKAXE)));

    public static final RegistryObject<Block> CARNOTITE_ORE = BLOCKS.register("carnotite_ore", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(6, 10).sound(SoundType.STONE).lightValue(1).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> CABLE_BLOCK = BLOCKS.register("cable_block", CableBlock::new);
    public static final RegistryObject<Block> DIGITAL_GRASS = BLOCKS.register("digital_block", () -> new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(40, 10).sound(SoundType.GROUND).lightValue(0).harvestLevel(3).harvestTool(ToolType.SHOVEL)));
    public static final RegistryObject<Block> DIGITAL_ROCK = BLOCKS.register("digital_rock", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(4, 20).sound(SoundType.STONE).lightValue(0).harvestLevel(20).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> DIGITAL_ICE = BLOCKS.register("digital_ice", () -> new Block(Block.Properties.create(Material.ICE).hardnessAndResistance(40, 10).sound(SoundType.GLASS).lightValue(0)));

    public static final RegistryObject<Block> DIGITAL_SAND = BLOCKS.register("digital_sand", () -> new Block(Block.Properties.create(Material.SAND).hardnessAndResistance(20, 10).sound(SoundType.SAND).lightValue(0).harvestLevel(20).harvestTool(ToolType.SHOVEL)));
    public static final RegistryObject<Block> ELECTRICFLOURIDE_INFUSER = BLOCKS.register("electric_flouride_infuser", ElectricFlourideInfuser::new);
    public static final RegistryObject<Block> FLOURIDE_INFUSER = BLOCKS.register("flouride_infuser", FlourideInfuser::new);
    public static final RegistryObject<Block> FLOURITE_ORE = BLOCKS.register("flourite_ore", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(6, 10).sound(SoundType.STONE).lightValue(1).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> FLOURITE_BLOCK = BLOCKS.register("flourite_block", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(-1, 10).sound(SoundType.SAND).lightValue(0).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> FOREST_TREE = BLOCKS.register("digital_tree", () -> new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(-1, -1).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> GUMMITE_ORE = BLOCKS.register("gummite_ore", GummiteOre::new);
    public static final RegistryObject<Block> HOLO = BLOCKS.register("holo", HologramBlock::new);
    public static final RegistryObject<Block> HOLOPROJECTOR = BLOCKS.register("holoprojector", HologramProjectorBlock::new);
    public static final RegistryObject<Block> MARABUNTA = BLOCKS.register("marabunta", Marabunta::new);
    public static final RegistryObject<Block> MOUNTAIN_TREE = BLOCKS.register("mountain_tree", MountainTreeBlock::new);
    public static final RegistryObject<Block> QUANTUM_BLOCK = BLOCKS.register("quantum_block", QuantumBlock::new);
    public static final RegistryObject<Block> QUANTUM_CORE = BLOCKS.register("quantum_core", QuantumCore::new);
    public static final RegistryObject<Block> QUANTUM_STEEL = BLOCKS.register("quantum_steel", QuantSteelBlock::new);
    public static final RegistryObject<Block> SALEEITE_ORE = BLOCKS.register("saleeite_ore", SaleeiteOre::new);
    public static final RegistryObject<Block> SECTOR_5 = BLOCKS.register("sector5ground", SectorFiveBlock::new);
    public static final RegistryObject<Block> SCANNER_BASE = BLOCKS.register("scanner_base", Virutalization::new);
    public static final RegistryObject<Block> Storage = BLOCKS.register("universal", UniversalEnergyBlock::new);
    //public static final RegistryObject<Block> SKLODOWSKITE_ORE
    public static final RegistryObject<Block> SILICA_SAND = BLOCKS.register("silica_sand", SilicaSand::new);
    public static final RegistryObject<Block> TOWER_WHITE = BLOCKS.register("tower_white", TowerBlockWhite::new);
    public static final RegistryObject<Block> TOWER_INTERFACE = BLOCKS.register("tower_interface", TowerInterface::new);
    public static final RegistryObject<Block> TOWER_BASE = BLOCKS.register("tower_base", TowerBase::new);
    public static final RegistryObject<Block> TOWER_WALL = BLOCKS.register("tower_wall", TowerWall::new);
    public static final RegistryObject<Block> TOWER_BLUE = BLOCKS.register("tower_blue", TowerBlockBlue::new);
    public static final RegistryObject<Block> TYUYAMUNITE_ORE = BLOCKS.register("tyuyamunite_ore", TyuyamuniteOre::new);
    public static final RegistryObject<Block> TORBERNITE_ORE = BLOCKS.register("torbernite_ore", TorberniteOre::new);
    public static final RegistryObject<Block> TOWER_ENTER = BLOCKS.register("tower_enter", TowerBlockNonSolid::new);
    public static final RegistryObject<Block> TITANIUM = BLOCKS.register("titanium", Titanium::new);
    public static final RegistryObject<Block> TRANSPARENT = BLOCKS.register("transparent", TransparentBlock::new);
    public static final RegistryObject<Block> URANUM_REACTOR = BLOCKS.register("computer_reactor", UraniumReactor::new);
    public static final RegistryObject<Block> URANINITE_ORE = BLOCKS.register("uraninite_ore", UraniniteOre::new);
    public static final RegistryObject<Block> URANIUM_BLOCK = BLOCKS.register("uranium_block", UraniumBlock::new);
    //public static final RegistryObject<Block> URANOPHANE_ORE =  Blocks.register("uranophane_ore", UranophaneOre::new);
}

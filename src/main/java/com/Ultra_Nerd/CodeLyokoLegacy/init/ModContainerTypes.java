package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.containers.*;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModContainerTypes {
    public static final DeferredRegister<MenuType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, CodeLyokoMain.MOD_ID);

   // public static final RegistryObject<MenuType<ContainerInfusing>> CONTAINER_INFUSING = CONTAINER_TYPES
     //       .register("container_infusing", () -> IForgeMenuType.create(ContainerInfusing::new));
    public static final RegistryObject<MenuType<TowerInterfaceContainer>> TOWER_INTERFACE_CONTAINER = CONTAINER_TYPES
            .register("tower_interface_container", () -> IForgeMenuType.create(TowerInterfaceContainer::new));
    public static final RegistryObject<MenuType<ContainerElectricInfusing>> CONTAINER_ELECTRIC_INFUSING = CONTAINER_TYPES
            .register("container_electric_infusing", () -> IForgeMenuType.create(ContainerElectricInfusing::new));
    //public static final RegistryObject<MenuType<HologramContainer>> HOLOGRAM_CONTAINER = CONTAINER_TYPES
      //      .register("hologram_container", () -> IForgeMenuType.create(HologramContainer::new));
    //public static final RegistryObject<MenuType<ReactorContainer>> COMPUTER_REACTOR_CONTAINER = CONTAINER_TYPES
      //      .register("computer_reactor_container",() -> IForgeMenuType.create(ReactorContainer::new));
    public static final RegistryObject<MenuType<QuantumChipletContainer>> QUANTUM_CHIPLET_CONTAINER = CONTAINER_TYPES.register(
            "quantum_chiplet_container", () -> IForgeMenuType.create(QuantumChipletContainer::new));
    //public static final RegistryObject<MenuType<ContainerElectroplate>> ELECTROPLATING_CONTAINER = CONTAINER_TYPES
      //      .register("electroplating_container", () -> IForgeMenuType.create(ContainerElectroplate::new));
    public static final RegistryObject<MenuType<ComputerControlPanelContainer>> COMPUTER_CONTROL_PANEL_CONTAINER = CONTAINER_TYPES.register(
            "computer_control_panel_container", () -> IForgeMenuType.create(ComputerControlPanelContainer::new));
    public static final RegistryObject<MenuType<ComputerInterfaceContainer>> COMPUTER_INTERFACE_CONTAINER = CONTAINER_TYPES.register(
            "computer_interface_container",() -> IForgeMenuType.create(ComputerInterfaceContainer::new)
    );
    public static final RegistryObject<MenuType<DataTransferInterfaceContainer>> DATA_TRANSFER_INTERFACE_CONTAINER = CONTAINER_TYPES.register(
            "data_transfer_interface_container", () -> IForgeMenuType.create(DataTransferInterfaceContainer::new)
    );



}

package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.*;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModContainerTypes {
    public static final DeferredRegister<MenuType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, Base.MOD_ID);

    public static final RegistryObject<MenuType<ContainerInfusing>> CONTAINER_INFUSING = CONTAINER_TYPES
            .register("container_infusing", () -> new MenuType<>(ContainerInfusing::new));
    public static final RegistryObject<MenuType<TowerInterfaceContainer>> TOWER_INTERFACE_CONTAINER = CONTAINER_TYPES
            .register("tower_interface_container", () -> new MenuType<>(TowerInterfaceContainer::new));
    public static final RegistryObject<MenuType<ContainerElectricInfusing>> CONTAINER_ELECTRIC_INFUSING = CONTAINER_TYPES
            .register("container_electric_infusing", () -> new MenuType<>(ContainerElectricInfusing::new));
    public static final RegistryObject<ContainerType<HologramContainer>> HOLOGRAM_CONTAINER = CONTAINER_TYPES
            .register("hologram_container", () -> new MenuType<>(HologramContainer::new));
    //public static final RegistryObject<ContainerType<ReactorContainer>> COMPUTER_REACTOR_CONTAINER = CONTAINER_TYPES
    //        .register("computer_reactor_container",() -> IForgeContainerType.create(ReactorContainer::new));
    public static final RegistryObject<ContainerType<QuantumChipletContainer>> QUANTUM_CHIPLET_CONTAINER = CONTAINER_TYPES.register(
            "quantum_chiplet_container", () -> IForgeContainerType.create(QuantumChipletContainer::new));
    public static final RegistryObject<ContainerType<ContainerElectroplate>> ELECTROPLATING_CONTAINER = CONTAINER_TYPES
            .register("electroplating_container", () -> IForgeContainerType.create(ContainerElectroplate::new));
    public static final RegistryObject<ContainerType<ComputerControlPanelContainer>> COMPUTER_CONTROL_PANEL_CONTAINER = CONTAINER_TYPES.register(
            "computer_control_panel_container", () -> IForgeContainerType.create(ComputerControlPanelContainer::new));
    public static final RegistryObject<ContainerType<ComputerInterfaceContainer>> COMPUTER_INTERFACE_CONTAINER = CONTAINER_TYPES.register(
            "computer_interface_container",() -> IForgeContainerType.create(ComputerInterfaceContainer::new)
    );
    public static final RegistryObject<ContainerType<DataTransferInterfaceContainer>> DATA_TRANSFER_INTERFACE_CONTAINER = CONTAINER_TYPES.register(
            "data_transfer_interface_container", () -> IForgeContainerType.create(DataTransferInterfaceContainer::new)
    );

}

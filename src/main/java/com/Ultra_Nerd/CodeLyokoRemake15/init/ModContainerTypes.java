package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.*;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes {
    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, Base.MOD_ID);

    public static final RegistryObject<ContainerType<ContainerInfusing>> CONTAINER_INFUSING = CONTAINER_TYPES
            .register("container_infusing", () -> IForgeContainerType.create(ContainerInfusing::new));
    public static final RegistryObject<ContainerType<TowerInterfaceContainer>> TOWER_INTERFACE_CONTAINER = CONTAINER_TYPES
            .register("tower_interface_container", () -> IForgeContainerType.create(TowerInterfaceContainer::new));
    public static final RegistryObject<ContainerType<ContainerElectricInfusing>> CONTAINER_ELECTRIC_INFUSING = CONTAINER_TYPES
            .register("container_electric_infusing", () -> IForgeContainerType.create(ContainerElectricInfusing::new));
    public static final RegistryObject<ContainerType<HologramContainer>> HOLOGRAM_CONTAINER = CONTAINER_TYPES
            .register("hologram_container", () -> IForgeContainerType.create(HologramContainer::new));
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

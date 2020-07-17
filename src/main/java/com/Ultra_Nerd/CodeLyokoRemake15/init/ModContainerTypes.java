package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.ContainerInfusing;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.HologramContainer;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.TowerInterfaceContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes {
    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(ForgeRegistries.CONTAINERS, Base.MOD_ID);

    public static final RegistryObject<ContainerType<ContainerInfusing>> CONTAINER_INFUSING = CONTAINER_TYPES
            .register("container_infusing", ()-> IForgeContainerType.create(ContainerInfusing::new));
    public static final RegistryObject<ContainerType<TowerInterfaceContainer>> TOWER_INTERFACE_CONTAINER = CONTAINER_TYPES
            .register("tower_interface_container",() -> IForgeContainerType.create(TowerInterfaceContainer::new));
    public static final RegistryObject<ContainerType<HologramContainer>> HOLOGRAM_CONTAINER = CONTAINER_TYPES
            .register("hologram_container", () -> IForgeContainerType.create(HologramContainer::new));
    //public static final RegistryObject<ContainerType<ReactorContainer>>COMPUTER_REACTOR_CONTAINER = CONTAINER_TYPES
     //       .register("computer_reactor_container",() -> IForgeContainerType.create(ReactorContainer::new));
}

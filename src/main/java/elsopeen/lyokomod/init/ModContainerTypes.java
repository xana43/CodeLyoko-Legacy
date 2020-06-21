package elsopeen.lyokomod.init;

import elsopeen.lyokomod.LyokoMod;
import elsopeen.lyokomod.container.InterfaceContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Container registries
 */
public final class ModContainerTypes {

    private static final Logger LOGGER = LogManager.getLogger(LyokoMod.MOD_ID + " Mod Container Types register");

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, LyokoMod.MOD_ID);

    public static final RegistryObject<ContainerType<InterfaceContainer>> INTERFACE_CONTAINER =
            CONTAINER_TYPES.register("interface_container",
            () -> IForgeContainerType.create(InterfaceContainer::new));


}

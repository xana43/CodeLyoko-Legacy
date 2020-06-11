import elsopeen.lyokomod.LyokoMod;
import elsopeen.lyokomod.init.ModContainerTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class ModContainerTypesTest {
    LyokoMod lm;

    @BeforeEach
    void setUp(){
        lm=new LyokoMod();
    }

    @Test
    void testInterfaceContainerGet() {
        assertNotNull(ModContainerTypes.INTERFACE_CONTAINER.get());
    }
}

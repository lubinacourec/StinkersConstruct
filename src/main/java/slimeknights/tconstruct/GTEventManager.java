package slimeknights.tconstruct;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.Util;
import gregtech.api.unification.material.event.MaterialEvent;
import gregtech.api.unification.material.event.PostMaterialEvent;
import slimeknights.tconstruct.shared.GTIntegration.TiCMaterialHandler;

@Mod.EventBusSubscriber(modid = Util.MODID)
public class GTEventManager {
       @SubscribeEvent
    public static void onMaterialsInit(MaterialEvent event) { // Must be called during construction to be registered in time for MaterialEvents.
        TiCMaterialHandler.onMaterialsInit();
    }

    @SubscribeEvent
    public static void onMaterialsPostInit(PostMaterialEvent event) {
        TiCMaterialHandler.onMaterialsPostInit();
//        TiCMaterialHandler.fixMoltenFluidTextures(); //throws NPE
    }
}

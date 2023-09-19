package slimeknights.tconstruct.shared.GTIntegration;


import gregtech.api.unification.material.Materials;
import slimeknights.tconstruct.library.Util;

public class TiCMaterialHandler {
    public static void onMaterialsInit() {
        //add flags to gt materials (mostly just GENERATE_ROD?).
    }

    public static void onMaterialsPostInit() {
        // do stuff post material init
    }
    public static void fixMoltenFluidTextures() {
        // make molten iron red
        Util.getLogger("GTIntegration").info("Making Molten Iron red");
        Materials.Iron.getFluid().setColor(0xa81212);
    }
}

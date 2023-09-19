package slimeknights.tconstruct.shared.GTIntegration;

import gregtech.api.GTValues;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.Element;
import gregtech.api.unification.Elements;
import gregtech.api.fluids.fluidType.FluidType;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.materials.MaterialFlagAddition;
import gregtech.api.unification.material.properties.IMaterialProperty;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.material.info.MaterialFlags;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GTIntegration {
    // 27000-27500 (temp)
    public static final Element elementalArdite = new Element(125,150, -1, null, "Ardite", "Ai", true);
    public static final Material Ardite = new Material.Builder(27000, tconId("ardite"))
            .color(0xd14210)
            .iconSet(MaterialIconSet.METALLIC)
            .ore().ingot().dust()
            .fluid(FluidTypes.LIQUID, false).fluidTemp(860)
            .element(elementalArdite)
            .blastTemp(860)
            .flags(MaterialFlags.DISABLE_DECOMPOSITION)
            .build();

    public static final Material Manyullyn = new Material.Builder(27001, tconId("manyullyn"))
            .color(0xa15cf8)
            .iconSet(MaterialIconSet.METALLIC)
            .ingot().dust()
            .fluid(FluidTypes.LIQUID, false).fluidTemp(1000)
            .blastTemp(1000) // fluid/blast temperature to be revisited
//            .components(Ardite, 1, Materials.Cobalt, 1) // components can't be set here, as gregtech's materials (cobalt) aren't registered when this is first called.
            .flags(MaterialFlags.DECOMPOSITION_BY_CENTRIFUGING)
            .build();

    public static final Material Knightslime = new Material.Builder(27002, tconId("knightslime"))
            .color(0xf18ff0)
            .iconSet(MaterialIconSet.GEM_VERTICAL)
            .ingot().dust()
            .fluid(FluidTypes.LIQUID, false).fluidTemp(1500)
            .blastTemp(1500) // fluid/blast temperature to be revisited
//            .components() //uncomment this line when decided on components.
            .flags(MaterialFlags.NO_UNIFICATION)
            .build();

    public static final Material AluminiumBrass = new Material.Builder(27003, tconId("alubrass"))
            .color(0xa15cf8)
            .iconSet(MaterialIconSet.METALLIC)
            .ingot().dust()
            .fluid(FluidTypes.LIQUID, false).fluidTemp(400)
            .blastTemp(400) // fluid/blast temperature to be revisited
//            .components(Materials.Aluminium, 1, Materials.Copper, 2) // components can't be set here, as gregtech's materials (aluminium/copper) aren't registered when this is first called.
            .flags(MaterialFlags.DECOMPOSITION_BY_CENTRIFUGING)
            .build();

    public static ItemStack getIngotByID(int materialID) {
        Item GTMetaIngot = Item.getByNameOrId("gregtech:meta_ingot");
        return new ItemStack(GTMetaIngot, 1, materialID); //quite possibly the worst way to do this.
    }

    public static ResourceLocation tconId(String path) {
        return new ResourceLocation(GTValues.MODID, path);
    }
}

package slimeknights.tconstruct.shared;

import gregtech.api.GTValues;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.Element;
import gregtech.api.unification.Elements;
import gregtech.api.fluids.fluidType.FluidType;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.info.MaterialIconSet;
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
            .fluid(FluidTypes.LIQUID, true).fluidTemp(860)
            .element(elementalArdite)
            .blastTemp(860)
            .flags(MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.GENERATE_PLATE)
            .build();


    public static ItemStack getIngotByID(int materialID) {
        Item GTMetaIngot = Item.getByNameOrId("gregtech:meta_ingot");
        return new ItemStack(GTMetaIngot, 1, materialID); //quite possibly the worst way to do this.
    }

    public static ResourceLocation tconId(String path) {
        return new ResourceLocation(GTValues.MODID, path);
    }
}

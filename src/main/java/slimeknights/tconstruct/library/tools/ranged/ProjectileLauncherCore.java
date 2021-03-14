package slimeknights.tconstruct.library.tools.ranged;

import java.util.List;

import net.minecraft.item.ItemStack;

import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.ProjectileLauncherNBT;
import slimeknights.tconstruct.library.tools.TinkerToolCore;

public abstract class ProjectileLauncherCore extends TinkerToolCore
{

    public ProjectileLauncherCore(PartMaterialType... requiredComponents)
    {
        super(requiredComponents);
    }

    @Override
    public abstract ProjectileLauncherNBT buildTagData(List<Material> materials);

    protected ProjectileLauncherNBT getData(ItemStack stack)
    {
        return ProjectileLauncherNBT.from(stack);
    }
}

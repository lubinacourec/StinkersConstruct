package slimeknights.tconstruct.library.events;

import javax.annotation.Nonnull;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.event.entity.ProjectileImpactEvent;

public class TinkerProjectileImpactEvent extends ProjectileImpactEvent
{

    @Nonnull
    private final ItemStack tool;

    public TinkerProjectileImpactEvent(Entity entity, RayTraceResult ray, @Nonnull ItemStack tool)
    {
        super(entity, ray);
        this.tool = tool.copy();
    }

    @Nonnull
    public ItemStack getTool()
    {
        return tool;
    }
}

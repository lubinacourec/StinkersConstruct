package slimeknights.tconstruct.library.capability.projectile;

import java.util.Optional;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CapabilityTinkerProjectile implements Capability.IStorage<ITinkerProjectile>
{

    private static final CapabilityTinkerProjectile INSTANCE = new CapabilityTinkerProjectile();
    @CapabilityInject(ITinkerProjectile.class)
    public static Capability<ITinkerProjectile> PROJECTILE_CAPABILITY = null;

    public static Optional<ITinkerProjectile> getTinkerProjectile(DamageSource source)
    {
        if (source.isProjectile())
        {
            return getTinkerProjectile(source.getImmediateSource());
        }
        return Optional.empty();
    }

    public static Optional<ITinkerProjectile> getTinkerProjectile(Entity entity)
    {
        ITinkerProjectile capability = null;
        if (entity != null && entity.hasCapability(CapabilityTinkerProjectile.PROJECTILE_CAPABILITY, null))
        {
            capability = entity.getCapability(CapabilityTinkerProjectile.PROJECTILE_CAPABILITY, null);
        }
        return Optional.ofNullable(capability);
    }

    public static void register()
    {
        CapabilityManager.INSTANCE.register(ITinkerProjectile.class, INSTANCE, TinkerProjectileHandler::new);
    }

    private CapabilityTinkerProjectile()
    {
    }

    @Override
    public NBTBase writeNBT(Capability<ITinkerProjectile> capability, ITinkerProjectile instance, EnumFacing side)
    {
        return null;
    }

    @Override
    public void readNBT(Capability<ITinkerProjectile> capability, ITinkerProjectile instance, EnumFacing side, NBTBase nbt)
    {

    }
}

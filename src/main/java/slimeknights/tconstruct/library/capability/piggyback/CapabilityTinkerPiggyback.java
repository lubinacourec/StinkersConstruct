package slimeknights.tconstruct.library.capability.piggyback;

import java.util.concurrent.Callable;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CapabilityTinkerPiggyback implements Capability.IStorage<ITinkerPiggyback>
{

    private static final CapabilityTinkerPiggyback INSTANCE = new CapabilityTinkerPiggyback();
    @CapabilityInject(ITinkerPiggyback.class)
    public static Capability<ITinkerPiggyback> PIGGYBACK = null;

    public static void register()
    {
        CapabilityManager.INSTANCE.register(ITinkerPiggyback.class, INSTANCE, new Callable<ITinkerPiggyback>()
        {
            @Override
            public ITinkerPiggyback call() throws Exception
            {
                return new TinkerPiggybackHandler();
            }
        });
    }

    private CapabilityTinkerPiggyback()
    {
    }

    @Override
    public NBTBase writeNBT(Capability<ITinkerPiggyback> capability, ITinkerPiggyback instance, EnumFacing side)
    {
        return null;
    }

    @Override
    public void readNBT(Capability<ITinkerPiggyback> capability, ITinkerPiggyback instance, EnumFacing side, NBTBase nbt)
    {

    }
}

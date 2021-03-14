package slimeknights.tconstruct.common;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.Packet;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import slimeknights.mantle.network.AbstractPacket;
import slimeknights.mantle.network.NetworkWrapper;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.common.config.ConfigSyncPacket;
import slimeknights.tconstruct.common.network.SpawnParticlePacket;
import slimeknights.tconstruct.smeltery.network.*;
import slimeknights.tconstruct.tools.common.network.*;

public class TinkerNetwork extends NetworkWrapper
{

    public static TinkerNetwork instance = new TinkerNetwork();

    public static void sendPacket(Entity player, Packet<?> packet)
    {
        if (player instanceof EntityPlayerMP && ((EntityPlayerMP) player).connection != null)
        {
            ((EntityPlayerMP) player).connection.sendPacket(packet);
        }
    }

    public static void sendToAll(AbstractPacket packet)
    {
        instance.network.sendToAll(packet);
    }

    public static void sendTo(AbstractPacket packet, EntityPlayerMP player)
    {
        instance.network.sendTo(packet, player);
    }

    public static void sendToAllAround(AbstractPacket packet, NetworkRegistry.TargetPoint point)
    {
        instance.network.sendToAllAround(packet, point);
    }

    public static void sendToDimension(AbstractPacket packet, int dimensionId)
    {
        instance.network.sendToDimension(packet, dimensionId);
    }

    public static void sendToServer(AbstractPacket packet)
    {
        instance.network.sendToServer(packet);
    }

    public static void sendToClients(WorldServer world, BlockPos pos, AbstractPacket packet)
    {
        Chunk chunk = world.getChunkFromBlockCoords(pos);
        for (EntityPlayer player : world.playerEntities)
        {
            // only send to relevant players
            if (!(player instanceof EntityPlayerMP))
            {
                continue;
            }
            EntityPlayerMP playerMP = (EntityPlayerMP) player;
            if (world.getPlayerChunkMap().isPlayerWatchingChunk(playerMP, chunk.x, chunk.z))
            {
                TinkerNetwork.sendTo(packet, playerMP);
            }
        }
    }

    public TinkerNetwork()
    {
        super(TConstruct.modID);
    }

    public void setup()
    {
        // register all the packets
        registerPacketClient(ConfigSyncPacket.class);
        registerPacketClient(SpawnParticlePacket.class);

        // TOOLS
        registerPacket(StencilTableSelectionPacket.class);
        registerPacket(PartCrafterSelectionPacket.class);
        registerPacket(ToolStationSelectionPacket.class);
        registerPacket(ToolStationTextPacket.class);
        registerPacketServer(TinkerStationTabPacket.class);
        registerPacketServer(InventoryCraftingSyncPacket.class);
        registerPacketClient(InventorySlotSyncPacket.class);
        registerPacketClient(EntityMovementChangePacket.class);
        registerPacketClient(ToolBreakAnimationPacket.class);

        // SMELTERY
        registerPacketClient(SmelteryFluidUpdatePacket.class);
        registerPacketClient(HeatingStructureFuelUpdatePacket.class);
        registerPacketClient(SmelteryInventoryUpdatePacket.class);
        registerPacketServer(SmelteryFluidClicked.class);
        registerPacketClient(FluidUpdatePacket.class);
        registerPacketClient(FaucetActivationPacket.class);
        registerPacketClient(ChannelConnectionPacket.class);
        registerPacketClient(ChannelFlowPacket.class);

        // OTHER STUFF
        registerPacketServer(BouncedPacket.class);
        registerPacketClient(LastRecipeMessage.class);
    }
}

package slimeknights.tconstruct.tools.common.inventory;

import java.util.Set;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.SoundEvents;

import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.common.Sounds;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.tools.common.tileentity.TileToolStation;

public class ContainerToolForge extends ContainerToolStation
{

    public ContainerToolForge(InventoryPlayer playerInventory, TileToolStation tile)
    {
        super(playerInventory, tile);
    }

    @Override
    protected void playCraftSound(EntityPlayer player)
    {
        Sounds.playSoundForAll(player, SoundEvents.BLOCK_ANVIL_USE, 0.9f, 0.95f + 0.2f * TConstruct.random.nextFloat());
    }

    @Override
    protected Set<ToolCore> getBuildableTools()
    {
        return TinkerRegistry.getToolForgeCrafting();
    }
}

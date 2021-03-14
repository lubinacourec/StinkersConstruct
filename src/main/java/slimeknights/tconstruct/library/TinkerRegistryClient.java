package slimeknights.tconstruct.library;

import java.util.Map;

import com.google.common.collect.Maps;
import org.apache.logging.log4j.Logger;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import slimeknights.tconstruct.library.client.ToolBuildGuiInfo;
import slimeknights.tconstruct.library.client.texture.AbstractColoredTexture;

@SideOnly(Side.CLIENT)
public final class TinkerRegistryClient
{

    // the logger for the library
    public static final Logger log = Util.getLogger("API-Client");
    /*---------------------------------------------------------------------------
    | GUI & CRAFTING                                                            |
    ---------------------------------------------------------------------------*/
    private static final Map<Item, ToolBuildGuiInfo> toolBuildInfo = Maps.newLinkedHashMap();
    /*---------------------------------------------------------------------------
    | MATERIAL TEXTURE CREATION                                                 |
    ---------------------------------------------------------------------------*/
    private static final Map<String, AbstractColoredTexture> textureProcessors = Maps.newHashMap();

    public static void addToolBuilding(ToolBuildGuiInfo info)
    {
        toolBuildInfo.put(info.tool.getItem(), info);
    }

    public static ToolBuildGuiInfo getToolBuildInfoForTool(Item tool)
    {
        return toolBuildInfo.get(tool);
    }

    public static void clear()
    {
        toolBuildInfo.clear();
    }

    private TinkerRegistryClient()
    {
    }

}

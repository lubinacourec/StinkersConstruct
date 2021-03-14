package slimeknights.tconstruct.library.tinkering;

import java.util.List;

import net.minecraft.item.ItemStack;

/**
 * All classes implementing this interface represent a item that has tinkers data. Usually also used for modifiers to
 * access the data.
 */
public interface ITinkerable
{

    /**
     * The default tooltip for the item
     */
    void getTooltip(ItemStack stack, List<String> tooltips);

    /**
     * Detailed info about the tool. Displayed when Shift is held
     */
    void getTooltipDetailed(ItemStack stack, List<String> tooltips);

    /**
     * What the tool is made out of. Displayed whet Ctrl is held
     */
    void getTooltipComponents(ItemStack stack, List<String> tooltips);
}

package slimeknights.tconstruct.plugin.jei.drying;

import java.util.List;
import javax.annotation.Nonnull;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.*;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.library.Util;

public class DryingRecipeCategory implements IRecipeCategory<DryingRecipeWrapper>
{

    public static String CATEGORY = Util.prefix("dryingrack");
    public static ResourceLocation background_loc = Util.getResource("textures/gui/jei/dryingrack.png");

    private final IDrawable background;
    private final IDrawableAnimated arrow;

    public DryingRecipeCategory(IGuiHelper guiHelper)
    {
        background = guiHelper.createDrawable(background_loc, 0, 0, 160, 60, 0, 0, 0, 0);

        IDrawableStatic arrowDrawable = guiHelper.createDrawable(background_loc, 160, 0, 24, 17);
        arrow = guiHelper.createAnimatedDrawable(arrowDrawable, 200, IDrawableAnimated.StartDirection.LEFT, false);
    }

    @Nonnull
    @Override
    public String getUid()
    {
        return CATEGORY;
    }

    @Nonnull
    @Override
    public String getTitle()
    {
        return Util.translate("gui.jei.drying.title");
    }

    @Override
    public String getModName()
    {
        return TConstruct.modName;
    }

    @Nonnull
    @Override
    public IDrawable getBackground()
    {
        return background;
    }

    @Override
    public IDrawable getIcon()
    {
        // use the default icon
        return null;
    }

    @Override
    public void drawExtras(@Nonnull Minecraft minecraft)
    {
        arrow.draw(minecraft, 67, 18);
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, DryingRecipeWrapper recipeWrapper, IIngredients ingredients)
    {
        IGuiItemStackGroup items = recipeLayout.getItemStacks();

        items.init(0, true, 43, 17);
        items.set(ingredients);

        items.init(1, false, 97, 17);
        items.set(ingredients);
    }

    @Override
    public List<String> getTooltipStrings(int mouseX, int mouseY)
    {
        return ImmutableList.of();
    }

}

package slimeknights.tconstruct.library.tools;

import javax.annotation.Nonnull;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public interface IAmmoUser
{

    @Nonnull
    ItemStack findAmmo(@Nonnull ItemStack weapon, EntityLivingBase player);

    @Nonnull
    ItemStack getAmmoToRender(@Nonnull ItemStack weapon, EntityLivingBase player);
}

package slimeknights.tconstruct.library.tools.ranged;

import javax.annotation.Nullable;

import com.google.common.collect.Multimap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.ItemStack;

public interface ILauncher
{

    void modifyProjectileAttributes(Multimap<String, AttributeModifier> projectileAttributes, @Nullable ItemStack launcher, ItemStack projectile, float power);
}

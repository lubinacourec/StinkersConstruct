package slimeknights.tconstruct.library.capability.projectile;

import java.util.List;
import javax.annotation.Nonnull;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

import slimeknights.tconstruct.library.traits.IProjectileTrait;

public interface ITinkerProjectile extends INBTSerializable<NBTTagCompound>
{

    /**
     * The itemstack that represents the projectile
     */
    @Nonnull
    ItemStack getItemStack();

    void setItemStack(@Nonnull ItemStack stack);

    /**
     * The itemstack the projectile has been launched with
     */
    @Nonnull
    ItemStack getLaunchingStack();

    void setLaunchingStack(@Nonnull ItemStack launchingStack);

    List<IProjectileTrait> getProjectileTraits();

    boolean pickup(EntityLivingBase entity, boolean simulate);

    /**
     * This basically represents how far the bow was drawn back, or equivalent for other things
     */
    float getPower();

    void setPower(float power);
}

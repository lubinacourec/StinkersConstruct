package slimeknights.tconstruct.shared.block;

import java.util.Random;
import javax.annotation.Nonnull;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import slimeknights.mantle.block.BlockConnectedTexture;
import slimeknights.tconstruct.common.config.Config;
import slimeknights.tconstruct.library.TinkerRegistry;

public class BlockClearGlass extends BlockConnectedTexture
{

    public BlockClearGlass()
    {
        super(Material.GLASS);

        this.setHardness(0.3f);
        setHarvestLevel("pickaxe", -1);
        this.setSoundType(SoundType.GLASS);

        this.setCreativeTab(TinkerRegistry.tabGeneral);
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public int quantityDropped(Random random)
    {
        if (Config.clearGlassSilkTouch)
            return 0;
        else return 1;
    }

    @Nonnull
    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    protected boolean canSilkHarvest()
    {
        return Config.clearGlassSilkTouch;
    }
}
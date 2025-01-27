package slimeknights.tconstruct.shared;

import com.google.common.eventbus.Subscribe;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import org.apache.logging.log4j.Logger;

import slimeknights.mantle.pulsar.pulse.Pulse;
import slimeknights.tconstruct.common.CommonProxy;
import slimeknights.tconstruct.common.TinkerPulse;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.fluid.FluidColored;
import slimeknights.tconstruct.library.fluid.FluidMolten;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.shared.GTIntegration.GTIntegration;
import slimeknights.tconstruct.shared.block.BlockLiquidSlime;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;
import slimeknights.tconstruct.smeltery.block.BlockMolten;
import slimeknights.tconstruct.smeltery.block.BlockTinkerFluid;

@Pulse(id = TinkerFluids.PulseId, pulsesRequired = TinkerSmeltery.PulseId, forced = true)
public class TinkerFluids extends TinkerPulse {

  public static final String PulseId = "TinkerFluids";
  static final Logger log = Util.getLogger(PulseId);

  @SidedProxy(clientSide = "slimeknights.tconstruct.shared.FluidsClientProxy", serverSide = "slimeknights.tconstruct.common.CommonProxy")
  public static CommonProxy proxy;

  // The fluids. Note that just because they exist doesn't mean that they're registered!
  public static FluidMolten searedStone;
  public static FluidMolten clay;
  public static FluidMolten dirt;
  public static Fluid ardite = GTIntegration.Ardite.getFluid();
  public static Fluid manyullyn = GTIntegration.Manyullyn.getFluid();
  public static Fluid knightslime = GTIntegration.Knightslime.getFluid();
  public static FluidMolten emerald;
  public static FluidMolten glass;
  public static FluidColored blood;
  public static FluidColored milk;
  public static FluidColored blueslime;
  public static FluidColored purpleSlime;

  public static Fluid alubrass = GTIntegration.AluminiumBrass.getFluid();

  // Mod Integration fluids

  static {
    setupFluids();
  }

  public static void setupFluids() {
    // buuuuckeeeeet
    FluidRegistry.enableUniversalBucket();

    /*
   Fluids for integration, getting registered by TinkerIntegration
    ardite.setTemperature(860);
    ardite.setRarity(EnumRarity.RARE);
  */

/*
    manyullyn = fluidMetal(TinkerMaterials.manyullyn);
    manyullyn.setTemperature(1000);
    manyullyn.setRarity(EnumRarity.RARE);

    knightslime = fluidMetal(TinkerMaterials.knightslime);
    knightslime.setTemperature(520);
    knightslime.setRarity(EnumRarity.EPIC);
*/
//
//      alubrass = fluidMetal("aluminium_brass", 0xece347);
//    alubrass.setTemperature(500);

    // Mod Integration fluids

  }

  @SubscribeEvent
  public void registerBlocks(Register<Block> event) {
    IForgeRegistry<Block> registry = event.getRegistry();

    if(isSmelteryLoaded()) {
      searedStone = fluidStone("stone", 0x777777);
      searedStone.setTemperature(800);
      registerMoltenBlock(registry, searedStone);

      clay = fluidStone("clay", 0xc67453);
      clay.setTemperature(700);
      registerMoltenBlock(registry, clay);

      dirt = fluidStone("dirt", 0xa68564);
      dirt.setTemperature(500);
      registerMoltenBlock(registry, dirt);

      emerald = fluidMetal("emerald", 0x58e78e);
      emerald.setTemperature(999);
      registerMoltenBlock(registry, emerald);

      glass = fluidMetal("glass", 0xc0f5fe);
      glass.setTemperature(625);
      registerMoltenBlock(registry, glass);

      // blood for the blood god
      blood = fluidClassic("blood", 0x540000);
      blood.setTemperature(336);
      registerClassicBlock(registry, blood);
    }

    milk = fluidMilk("milk", 0xffffff);
    milk.setTemperature(320);
    registerClassicBlock(registry, milk);

    if(isWorldLoaded()) {
      blueslime = fluidClassic("blueslime", 0xef67f0f5);
      blueslime.setTemperature(310);
      blueslime.setViscosity(1500);
      blueslime.setDensity(1500);
      registerBlock(registry, new BlockLiquidSlime(blueslime, net.minecraft.block.material.Material.WATER), blueslime.getName());
    }

    if(isWorldLoaded() || isSmelteryLoaded()) {
      purpleSlime = fluidClassic("purpleslime", 0xefd236ff);
      purpleSlime.setTemperature(370);
      purpleSlime.setViscosity(1600);
      purpleSlime.setDensity(1600);
      registerBlock(registry, new BlockLiquidSlime(purpleSlime, net.minecraft.block.material.Material.WATER), purpleSlime.getName());
    }
  }

  @SubscribeEvent
  public void registerItems(Register<Item> event) {
    IForgeRegistry<Item> registry = event.getRegistry();

    if(isSmelteryLoaded()) {
      FluidRegistry.addBucketForFluid(searedStone);

      FluidRegistry.addBucketForFluid(clay);

      FluidRegistry.addBucketForFluid(dirt);

      FluidRegistry.addBucketForFluid(emerald);

      FluidRegistry.addBucketForFluid(glass);

      // blood for the blood god
      FluidRegistry.addBucketForFluid(blood);
    }

    if(isWorldLoaded()) {
      FluidRegistry.addBucketForFluid(blueslime);
    }

    if(isWorldLoaded() || isSmelteryLoaded()) {
      FluidRegistry.addBucketForFluid(purpleSlime);
    }
  }

  @SubscribeEvent
  public void registerModels(ModelRegistryEvent event) {
    proxy.registerModels();
  }

  @Subscribe
  public void preInit(FMLPreInitializationEvent event) {
    proxy.preInit();
  }

  @Subscribe
  public void init(FMLInitializationEvent event) {
    proxy.init();
  }

  @Subscribe
  public void postInit(FMLPostInitializationEvent event) {
    proxy.postInit();
  }

  private static FluidMolten fluidMetal(Material material) {
    return fluidMetal(material.getIdentifier(), material.materialTextColor);
  }

  private static FluidMolten fluidMetal(String name, int color) {
    FluidMolten fluid = new FluidMolten(name, color);
    return registerFluid(fluid);
  }

  private static FluidMolten fluidLiquid(String name, int color) {
    FluidMolten fluid = new FluidMolten(name, color, FluidMolten.ICON_LiquidStill, FluidMolten.ICON_LiquidFlowing);
    return registerFluid(fluid);
  }

  private static FluidMolten fluidStone(String name, int color) {
    FluidMolten fluid = new FluidMolten(name, color, FluidColored.ICON_StoneStill, FluidColored.ICON_StoneFlowing);

    return registerFluid(fluid);
  }

  private static FluidColored fluidClassic(String name, int color) {
    FluidColored fluid = new FluidColored(name, color, FluidColored.ICON_LiquidStill, FluidColored.ICON_LiquidFlowing);

    return registerFluid(fluid);
  }

  private static FluidColored fluidMilk(String name, int color) {
    FluidColored fluid = new FluidColored(name, color, FluidColored.ICON_MilkStill, FluidColored.ICON_MilkFlowing);
    return registerFluid(fluid);
  }

  protected static <T extends Fluid> T registerFluid(T fluid) {
    fluid.setUnlocalizedName(Util.prefix(fluid.getName()));
    FluidRegistry.registerFluid(fluid);

    return fluid;
  }

  /** Registers a non-burning water based block for the fluid */
  public static BlockFluidBase registerClassicBlock(IForgeRegistry<Block> registry, Fluid fluid) {
    return registerBlock(registry, new BlockTinkerFluid(fluid, net.minecraft.block.material.Material.WATER), fluid.getName());
  }

  /** Registers a hot lava-based block for the fluid, prefix with molten_ */
  public static BlockMolten registerMoltenBlock(IForgeRegistry<Block> registry, Fluid fluid) {
    return registerBlock(registry, new BlockMolten(fluid), "molten_" + fluid.getName()); // molten_foobar prefix
  }
}

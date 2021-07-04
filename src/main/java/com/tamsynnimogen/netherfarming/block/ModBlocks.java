package com.tamsynnimogen.netherfarming.block;

import com.tamsynnimogen.netherfarming.NetherFarming;
import com.tamsynnimogen.netherfarming.compat.ModStrippedBlock;
import com.tamsynnimogen.netherfarming.compat.ModTilledBlock;
import com.tamsynnimogen.netherfarming.util.Registration;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks
{

    public static final RegistryObject<Block> TILLED_SOUL_SOIL = register("tilled_soul_soil",
            () -> new NetherFarmland(AbstractBlock.Properties.from(Blocks.FARMLAND)));

    public static final RegistryObject<Block> FERTILE_SOUL_SOIL = register("fertile_soul_soil",
            ()-> new ModTilledBlock(TILLED_SOUL_SOIL.get().getDefaultState(),
                    AbstractBlock.Properties.create(Material.EARTH)
                            .hardnessAndResistance(0.5f,0.5f)
                            .harvestTool(ToolType.HOE)
                            .harvestLevel(0)));

    public static final RegistryObject<Block> BLOODBARK_BUTTON =
            register("bloodbark_button", () -> new WoodButtonBlock(AbstractBlock.Properties.from(Blocks.ACACIA_BUTTON)));

    public static final RegistryObject<Block> BLOODBARK_DOOR =
            register("bloodbark_door", () -> new DoorBlock(AbstractBlock.Properties.from(Blocks.ACACIA_DOOR)));

    public static final RegistryObject<Block> BLOODBARK_FENCE =
            register("bloodbark_fence", () -> new FenceBlock(AbstractBlock.Properties.from(Blocks.ACACIA_FENCE)));

    public static final RegistryObject<Block> BLOODBARK_FENCE_GATE =
            register("bloodbark_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.from(Blocks.ACACIA_FENCE_GATE)));

    public static final RegistryObject<Block> BLOODBARK_PLANKS = register("bloodbark_planks",
            () -> new Block(AbstractBlock.Properties.from(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> BLOODBARK_PRESSURE_PLATE =
            register("bloodbark_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    AbstractBlock.Properties.from(Blocks.ACACIA_PRESSURE_PLATE)));

    public static final RegistryObject<Block> BLOODBARK_STAIRS =
            register("bloodbark_stairs", () -> new StairsBlock(() -> ModBlocks.BLOODBARK_PLANKS.get().getDefaultState(),
                    AbstractBlock.Properties.from(Blocks.ACACIA_STAIRS)));

    public static final RegistryObject<Block> BLOODBARK_SLAB =
            register("bloodbark_slab", () -> new SlabBlock(AbstractBlock.Properties.from(Blocks.ACACIA_SLAB)));

    public static final RegistryObject<Block> STRIPPED_BLOODBARK_STEM = register("stripped_bloodbark_stem",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.WARPED_STEM)));

    public static final RegistryObject<Block> BLOODBARK_STEM = register("bloodbark_stem",
            ()-> new ModStrippedBlock(STRIPPED_BLOODBARK_STEM.get().getDefaultState(),
                    AbstractBlock.Properties.create(Material.NETHER_WOOD)
                            .hardnessAndResistance(0.5f,2.0f)
                            .harvestTool(ToolType.AXE)
                            .harvestLevel(0)));

    public static final RegistryObject<Block> BLOODBARK_WART_BLOCK = register("bloodbark_wart_block",
            () -> new Block(AbstractBlock.Properties.from(Blocks.WARPED_WART_BLOCK)));

    public static final RegistryObject<Block> BLOODBARK_FUNGUS = register("bloodbark_fungus",
           () -> new ModFungusBlock(AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.CYAN)
                   .zeroHardnessAndResistance().doesNotBlockMovement().sound(SoundType.PLANT), () -> {
               return ModFeatures.BLOODBARK_FUNGUS_PLANTED;
           }));

/*
    public static final RegistryObject<Block> BLOODBARK_SIGN =
            register("bloodbark_sign", () -> new StandingSignBlock(AbstractBlock.Properties.from(Blocks.DARK_OAK_SIGN)));


    public static final RegistryObject<Block> BLOODBARK_WALL_SIGN =
            register("bloodbark_wall_sign", () -> new WallSignBlock(AbstractBlock.Properties.from(Blocks.DARK_OAK_WALL_SIGN)));

*/

    public static final RegistryObject<Block> BLOODBARK_TRAPDOOR =
        register("bloodbark_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.create(Material.WOOD).notSolid()));

    public static final RegistryObject<Block> STRIPPED_BLOODBARK_HYPHAE = register("stripped_bloodbark_hyphae",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.STRIPPED_WARPED_HYPHAE)));

    public static final RegistryObject<Block> BLOODBARK_HYPHAE = register("bloodbark_hyphae",
            ()-> new ModStrippedBlock(STRIPPED_BLOODBARK_HYPHAE.get().getDefaultState(),
                    AbstractBlock.Properties.create(Material.NETHER_WOOD)
                            .hardnessAndResistance(0.5f,2.0f)
                            .harvestTool(ToolType.AXE)
                            .harvestLevel(0)));

    public static final RegistryObject<Block> CINDER_WHEAT_CROP =
            Registration.BLOCKS.register("cinder_wheat_crop",
                    () -> new CinderWheatCrop(AbstractBlock.Properties.from(Blocks.WHEAT)));

    public static final RegistryObject<Block> CINDER_HAY_BLOCK =
            Registration.BLOCKS.register("cinder_hay_block",
                    () -> new HayBlock(AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.RED).hardnessAndResistance(0.5F)
                            .sound(SoundType.PLANT)));

    public static final RegistryObject<Block> SOUL_ROOTS =
            Registration.BLOCKS.register("soul_roots",
                    () -> new NetherRootsBlock(AbstractBlock.Properties.create(Material.NETHER_PLANTS, MaterialColor.BROWN)
                            .doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.ROOT)));

    public static final RegistryObject<Block> GLOWBERRY_CROP =
            Registration.BLOCKS.register("glowberry_crop",
                    () -> new GlowberryCrop(AbstractBlock.Properties.from(Blocks.WHEAT).setLightLevel((state) -> { return 14;})));

    public static final RegistryObject<Block> POTTED_BLOODBARK_FUNGUS =
            register("potted_bloodbark_fungus", () -> new FlowerPotBlock(ModBlocks.BLOODBARK_FUNGUS.get(), AbstractBlock
                    .Properties.from(Blocks.POTTED_CRIMSON_FUNGUS)));

    public static final RegistryObject<Block> POTTED_SOUL_ROOTS =
            register("potted_soul_roots", () -> new FlowerPotBlock(ModBlocks.SOUL_ROOTS.get(), AbstractBlock
                    .Properties.from(Blocks.POTTED_CRIMSON_ROOTS)));

        public static final RegistryObject<Block> GLOOM_SQUASH =
            register("gloom_squash",
                    () -> new GloomSquashBlock(AbstractBlock.Properties.create(Material.GOURD,
                            MaterialColor.BLUE)
                            .hardnessAndResistance(1.0F)
                            .sound(SoundType.WOOD)));

    public static final RegistryObject<Block> HELLKIN =
            register("hellkin",
                    () -> new HellkinBlock(AbstractBlock.Properties.create(Material.GOURD,
                            MaterialColor.RED)
                            .hardnessAndResistance(1.0F)
                            .sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ATTACHED_GLOOM_SQUASH_STEM =
            Registration.BLOCKS.register("attached_gloom_squash_stem",
                    () -> new ModAttachedStemBlock(((ModStemGrownBlock)GLOOM_SQUASH.get()),
                            AbstractBlock.Properties.create(Material.PLANTS)
                                    .doesNotBlockMovement()
                                    .zeroHardnessAndResistance()
                                    .sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ATTACHED_HELLKIN_STEM =
            Registration.BLOCKS.register("attached_hellkin_stem",
                    () -> new ModAttachedStemBlock((ModStemGrownBlock)HELLKIN.get(),
                            AbstractBlock.Properties.create(Material.PLANTS)
                                    .doesNotBlockMovement()
                                    .zeroHardnessAndResistance()
                                    .sound(SoundType.WOOD)));

    public static final RegistryObject<Block> GLOOM_SQUASH_STEM =
            Registration.BLOCKS.register("gloom_squash_stem",
                    () -> new ModStemBlock((ModStemGrownBlock)GLOOM_SQUASH.get(),
                            AbstractBlock.Properties.create(Material.PLANTS)
                                    .doesNotBlockMovement()
                                    .tickRandomly()
                                    .zeroHardnessAndResistance()
                                    .sound(SoundType.STEM)));

    public static final RegistryObject<Block> HELLKIN_STEM =
            Registration.BLOCKS.register("hellkin_stem",
                    () -> new ModStemBlock((ModStemGrownBlock)HELLKIN.get(),
                            AbstractBlock.Properties.create(Material.PLANTS)
                                    .doesNotBlockMovement()
                                    .tickRandomly()
                                    .zeroHardnessAndResistance()
                                    .sound(SoundType.STEM)));

    public static void register() { }

    private static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().group(NetherFarming.CREATIVETAB)));
        return toReturn;
    }
}
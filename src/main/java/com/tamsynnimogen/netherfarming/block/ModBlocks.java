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

import static net.minecraft.block.Blocks.DARK_OAK_LOG;
import static net.minecraft.block.Blocks.DARK_OAK_SIGN;

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
            register("bloodbark_button", () -> new StoneButtonBlock(AbstractBlock.Properties.create(Material.WOOD)));

    public static final RegistryObject<Block> BLOODBARK_DOOR =
            register("bloodbark_door", () -> new DoorBlock(AbstractBlock.Properties.create(Material.WOOD).notSolid()));

    public static final RegistryObject<Block> BLOODBARK_FENCE =
            register("bloodbark_fence", () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD)));

    public static final RegistryObject<Block> BLOODBARK_FENCE_GATE =
            register("bloodbark_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD)));

    public static final RegistryObject<Block> BLOODBARK_PLANKS = register("bloodbark_planks",
            () -> new Block(AbstractBlock.Properties.from(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> BLOODBARK_PRESSURE_PLATE =
            register("bloodbark_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    AbstractBlock.Properties.create(Material.WOOD)));



    public static final RegistryObject<Block> BLOODBARK_STAIRS =
            register("bloodbark_stairs", () -> new StairsBlock(() -> ModBlocks.BLOODBARK_PLANKS.get().getDefaultState(),
                    AbstractBlock.Properties.create(Material.WOOD)));

    public static final RegistryObject<Block> BLOODBARK_SLAB =
            register("bloodbark_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD)));

    public static final RegistryObject<Block> STRIPPED_BLOODBARK_LOG = register("stripped_bloodbark_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<Block> BLOODBARK_LOG = register("bloodbark_log",
            ()-> new ModStrippedBlock(STRIPPED_BLOODBARK_LOG.get().getDefaultState(),
                    AbstractBlock.Properties.create(Material.WOOD)
                            .hardnessAndResistance(0.5f,2.0f)
                            .harvestTool(ToolType.AXE)
                            .harvestLevel(0)));

    public static final RegistryObject<Block> BLOODBARK_SIGN =
            register("bloodbark_sign", () -> new StandingSignBlock(AbstractBlock.Properties.create(Material.WOOD,
                    ModBlocks.BLOODBARK_LOG.get().getMaterialColor()).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), WoodType.DARK_OAK));

    public static final RegistryObject<Block> BLOODBARK_LEAVES = register("bloodbark_leaves",
            () -> new ModLeavesBlock(AbstractBlock.Properties.from(Blocks.OAK_LEAVES)));

   public static final RegistryObject<Block> BLOODBARK_SAPLING = register("bloodbark_sapling",
           () -> new ModFungusBlock(AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.CYAN)
                   .zeroHardnessAndResistance().doesNotBlockMovement().sound(SoundType.PLANT), () -> {
               return ModFeatures.BLOODBARK_SAPLING_PLANTED;
           }));

    public static final RegistryObject<Block> BLOODBARK_WALL_SIGN =
            register("bloodbark_wall_sign", () -> new WallSignBlock(AbstractBlock.Properties.create(Material.WOOD,
                    DARK_OAK_LOG.getMaterialColor()).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD)
                    .lootFrom(ModBlocks.BLOODBARK_SIGN.get()), WoodType.DARK_OAK));

public static final RegistryObject<Block> BLOODBARK_TRAPDOOR =
        register("bloodbark_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.create(Material.WOOD).notSolid()));

    public static final RegistryObject<Block> STRIPPED_BLOODBARK_WOOD = register("stripped_bloodbark_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> BLOODBARK_WOOD = register("bloodbark_wood",
            ()-> new ModStrippedBlock(STRIPPED_BLOODBARK_WOOD.get().getDefaultState(),
                    AbstractBlock.Properties.create(Material.WOOD)
                            .hardnessAndResistance(0.5f,2.0f)
                            .harvestTool(ToolType.AXE)
                            .harvestLevel(0)));

    public static final RegistryObject<Block> CINDER_WHEAT_CROP =
            Registration.BLOCKS.register("cinder_wheat_crop",
                    () -> new CinderWheatCrop(AbstractBlock.Properties.from(Blocks.WHEAT)));

    public static final RegistryObject<Block> GLOWBERRY_CROP =
            Registration.BLOCKS.register("glowberry_crop",
                    () -> new GlowberryCrop(AbstractBlock.Properties.from(Blocks.WHEAT).setLightLevel((state) -> { return 14;})));

    public static void register() { }

    private static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().group(NetherFarming.CREATIVETAB)));
        return toReturn;
    }
}
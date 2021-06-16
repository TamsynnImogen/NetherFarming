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

    public static final RegistryObject<Block> BLOODBARK_PLANK = register("bloodbark_planks",
            () -> new Block(AbstractBlock.Properties.from(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> STRIPPED_BLOODBARK_LOG = register("stripped_bloodbark_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<Block> BLOODBARK_LOG = register("bloodbark_log",
            ()-> new ModStrippedBlock(STRIPPED_BLOODBARK_LOG.get().getDefaultState(),
                    AbstractBlock.Properties.create(Material.WOOD)
                            .hardnessAndResistance(0.5f,2.0f)
                            .harvestTool(ToolType.AXE)
                            .harvestLevel(0)));

    public static final RegistryObject<Block> BLOODBARK_LEAVES = register("bloodbark_leaves",
            () -> new ModLeavesBlock(AbstractBlock.Properties.from(Blocks.OAK_LEAVES)));
/*
       public static final RegistryObject<Block> BLOODBARK_SAPLING = register("bloodbark_sapling",
               () -> new SaplingBlock(new BloodbarkTree(), AbstractBlock.Properties
               .create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
*/

   public static final RegistryObject<Block> BLOODBARK_SAPLING = register("bloodbark_sapling",
           () -> new ModFungusBlock(AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.CYAN)
                   .zeroHardnessAndResistance().doesNotBlockMovement().sound(SoundType.PLANT), () -> {
               return ModFeatures.BLOODBARK_SAPLING_PLANTED;
           }));

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
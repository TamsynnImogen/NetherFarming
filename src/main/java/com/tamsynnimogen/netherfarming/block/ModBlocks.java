package com.tamsynnimogen.netherfarming.block;

import com.tamsynnimogen.netherfarming.NetherFarming;
import com.tamsynnimogen.netherfarming.compat.ModTilledBlock;
import com.tamsynnimogen.netherfarming.util.Registration;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
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
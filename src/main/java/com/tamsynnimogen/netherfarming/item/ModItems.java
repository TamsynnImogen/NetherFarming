package com.tamsynnimogen.netherfarming.item;

import com.tamsynnimogen.netherfarming.NetherFarming;
import com.tamsynnimogen.netherfarming.block.ModBlocks;
import com.tamsynnimogen.netherfarming.util.Registration;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;

public class ModItems
{
    public static final RegistryObject<Item> NETHER_FARMING_ICON =
            Registration.ITEMS.register("nether_farming_icon",
                    () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CINDER_WHEAT =
            Registration.ITEMS.register("cinder_wheat",
                    () -> new Item(new Item.Properties().group(NetherFarming.CREATIVETAB)));

    public static final RegistryObject<Item> CINDER_WHEAT_DOUGH =
            Registration.ITEMS.register("cinder_wheat_dough",
                    () -> new Item(new Item.Properties().group(NetherFarming.CREATIVETAB)));

    public static final RegistryObject<Item> GLOWBERRY =
            Registration.ITEMS.register("glowberry",
                    () -> new BlockNamedItem(ModBlocks.GLOWBERRY_CROP.get(), (new Item.Properties()).group(NetherFarming.CREATIVETAB).food(ModFood.GLOWBERRY)));

    public static final RegistryObject<Item> CINDER_BREAD =
            Registration.ITEMS.register("cinder_bread",
                    () -> new Item((new Item.Properties()).group(NetherFarming.CREATIVETAB).food(ModFood.CINDER_BREAD)));


    public static final RegistryObject<Item> CINDER_WHEAT_SEEDS =
            Registration.ITEMS.register("cinder_wheat_seeds",
                    () -> new BlockItem(ModBlocks.CINDER_WHEAT_CROP.get(), new Item.Properties().group(NetherFarming.CREATIVETAB)));

    public static void register() { }

}
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

    public static final RegistryObject<Item> SOUL_ROOTS =
            Registration.ITEMS.register("soul_roots",
                    () -> new BlockNamedItem(ModBlocks.SOUL_ROOTS.get(), (new Item.Properties()).group(NetherFarming.CREATIVETAB)));

    public static final RegistryObject<Item> CINDER_BREAD =
            Registration.ITEMS.register("cinder_bread",
                    () -> new Item((new Item.Properties()).group(NetherFarming.CREATIVETAB).food(ModFood.CINDER_BREAD)));

    public static final RegistryObject<Item> CINDER_WHEAT_SEEDS =
            Registration.ITEMS.register("cinder_wheat_seeds",
                    () -> new BlockItem(ModBlocks.CINDER_WHEAT_CROP.get(), new Item.Properties().group(NetherFarming.CREATIVETAB)));

    public static final RegistryObject<Item> GLOOM_SQUASH_SEEDS =
            Registration.ITEMS.register("gloom_squash_seeds",
                    () -> new BlockNamedItem(ModBlocks.GLOOM_SQUASH_STEM.get(), new Item.Properties().group(NetherFarming.CREATIVETAB)));

    public static final RegistryObject<Item> HELLKIN_SEEDS =
            Registration.ITEMS.register("hellkin_seeds",
                    () -> new BlockNamedItem(ModBlocks.HELLKIN_STEM.get(), new Item.Properties().group(NetherFarming.CREATIVETAB)));

    public static final RegistryObject<Item> HELLKIN_BLOOD_CURRY =
            Registration.ITEMS.register("hellkin_blood_curry",
                    () -> new Item((new Item.Properties()).group(NetherFarming.CREATIVETAB).food(ModFood.HELLKIN_BLOOD_CURRY)));

    public static final RegistryObject<Item> COOKED_GLOOM_SQUASH =
            Registration.ITEMS.register("cooked_gloom_squash",
                    () -> new Item((new Item.Properties()).group(NetherFarming.CREATIVETAB).food(ModFood.COOKED_GLOOM_SQUASH)));

    public static void register() { }

}
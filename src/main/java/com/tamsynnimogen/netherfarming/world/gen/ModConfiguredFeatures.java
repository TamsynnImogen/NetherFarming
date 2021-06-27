package com.tamsynnimogen.netherfarming.world.gen;

import com.tamsynnimogen.netherfarming.block.ModHugeFungusConfig;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpreadConfig;
import net.minecraft.world.gen.placement.Placement;

public class ModConfiguredFeatures {

    public static final ConfiguredFeature<?, ?> BLOODBARK_CONFIGURED_FEATURE =
            Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "bloodbark_fungus",
                    Feature.HUGE_FUNGUS.withConfiguration(ModHugeFungusConfig.BLOODBARK_FUNGUS)
                            .withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(8))));
}

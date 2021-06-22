package com.tamsynnimogen.netherfarming.block;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.*;

public class ModFeatures {

    public static final ConfiguredFeature<HugeFungusConfig, ?> BLOODBARK_FUNGUS_PLANTED = register(
            "bloodbark_fungi_planted", Feature.HUGE_FUNGUS.withConfiguration(ModHugeFungusConfig.BLOODBARK_FUNGUS_PLANTED));

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }



}
